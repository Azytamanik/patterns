import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import static java.lang.System.out;

public class WorkerDepartment {

    public static class SingletonHolder {
        public static final WorkerDepartment HOLDER_INSTANCE = new WorkerDepartment();
    }

    public static WorkerDepartment getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    File file = new File("output.txt");
    List<Worker> workers = new ArrayList<>();
    Worker worker;
    private boolean toContinue = true;

    private WorkerDepartment() {
        if (file.length() != 0){
            FileManagement.reader(file, workers);

            Worker lastID = workers.stream().max(Comparator.comparing(Worker::getId)).orElseThrow();
            Worker.memoryDeserialize(lastID.getId());
        }
        while (toContinue) {
            addWorker();
        }
        out.println("Unsorted list:");
        listPrint();
        listSort();
        out.println("Sorted list:");
        listPrint();
        fiveNames();
        threeIds();
        FileManagement.writer(file, workers);
    }

    public void addWorker() {
        Scanner in = new Scanner(System.in);
        out.print("Worker's name: ");
        String name = in.nextLine();
        out.print("Does worker has fixed (1) or hourly (2) salary: ");
        byte choice = in.nextByte();

        switch (choice) {
            case 1 -> {
                worker = new Fixed(name);
                out.print("Print a fixed salary: ");
            }
            case 2 -> {
                worker = new Hourly(name);
                out.print("Print a salary per hour: ");
            }
            default -> {
                out.println("Wrong input");
                System.exit(0);
            }
        }

        double wage_rate = in.nextDouble();
        worker.salaryCalculation(wage_rate);

        workers.add(worker);

        out.println("Do you wanna add another worker? (yes or no)");
        String nextChoice = in.next();

        if (nextChoice.equalsIgnoreCase("yes")) {
            toContinue = true;
        } else if (nextChoice.equalsIgnoreCase("no")) {
            toContinue = false;
        } else {
            System.exit(0);
        }
    }

    public void listPrint() {
        for (Worker w : workers) {
            System.out.println("Id: " + w.getId() + "   Name: " + w.getName()
                    + "   Salary: " + w.getSalary() + w.workerInfo());
        }
    }

    public void listSort() {
        workers = workers.stream()
                .sorted(Comparator.comparing(Worker::getSalary).reversed().thenComparing(Worker::getName))
                .collect(Collectors.toList());
    }

    public void fiveNames() {
        int j = 0;

        if ((workers.size() < 5)) {
            out.printf("There are only %d workers!\n", workers.size());
        } else {
            out.println("First five names:");
        }

        for (Worker w : workers) {
            out.println(w.getName());
            j++;
            if (j == 5) {
                break;
            }
        }
    }

    public void threeIds() {
        if ((workers.size() < 3)) {
            out.printf("There are only %d workers!\n", workers.size());
        } else {
            out.println("Last three id values:");
        }

        List<Worker> lastWorkers = workers.subList(Math.max(workers.size() - 3, 0), workers.size());

        for (Worker w : lastWorkers) {
            out.println(w.getId());
        }
    }
}