import java.io.Serializable;

public abstract class Worker implements Serializable {

    private static int memoryId = 0;
    private final int personalId;
    private final String name;
    private double salary;

    public int getId() { return personalId; }

    public String getName() { return name; }

    public double getSalary() { return salary; }

    public void setSalary(double salary) { this.salary = salary; }

    public static void memoryDeserialize(int lastId){
        memoryId = lastId;
    }

    public Worker(String name){
        this.personalId = ++memoryId;
        this.name = name;
    }

    public abstract void salaryCalculation(double wage_rate);
    public abstract String workerInfo();
}