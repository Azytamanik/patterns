import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

public class ConsoleWorker {

    List<Worker> workers = new ArrayList<>();
    Worker worker;
    private boolean toContinue = true;

    public ConsoleWorker(){
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
    }

    public void addWorker(){
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
        }
        else if (nextChoice.equalsIgnoreCase("no")){
            toContinue = false;
        }
        else {
            System.exit(0);
        }
    }

    public void listPrint(){
        for (Worker w: workers) {
            System.out.println("Id: " + w.getId() + "   Name: " + w.getName() + "   Salary: " + w.getSalary());
        }
    }

    public void listSort(){
        for (int i = 0; i < workers.size() - 1; i++){
            Worker max = workers.get(i);
            int iMax = i;
            for (int j = i; j < workers.size(); j++){
                if (max.getSalary() < workers.get(j).getSalary()){
                    max = workers.get(j);
                    iMax = j;
                } else if (max.getSalary() == workers.get(j).getSalary()){
                    int lexicographic = max.getName().compareTo(workers.get(j).getName());
                    if (lexicographic > 0){
                        max = workers.get(j);
                        iMax = j;
                    }
                }
            }
            workers.remove(iMax);
            workers.add(i, max);
        }
    }

    public void fiveNames(){
        if ((workers.size() < 5)) {
            out.printf("There are only %d workers!\n", workers.size());
        } else {
            out.println("First five names:");
        }
        for (Worker w: workers) {
            out.println(w.getName());
            if (w.getId() == 4){
                break;
            }
        }
    }

    public void threeIds(){
        out.printf("Last %d id values: \n", Math.max(workers.size() - 3, 0));
        List<Worker> lastWorkers = workers.subList(Math.max(workers.size() - 3, 0), workers.size());
        for (Worker w: lastWorkers) {
            out.println(w.getId());
        }
    }
}