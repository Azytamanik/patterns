public abstract class Worker {
    private static int id = 0;
    private final String name;
    private double salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Worker(String name){
        id = ++id;
        this.name = name;
    }

    public abstract void salaryCalculation(double wage_rate);
}