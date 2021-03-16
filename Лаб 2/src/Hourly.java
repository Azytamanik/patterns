import java.io.Serializable;

public class Hourly extends Worker implements Serializable {

    public Hourly(String name){
        super(name);
    }

    public void salaryCalculation(double wage_rate) {
        setSalary(5 * 4 * 8 * wage_rate);
    }

    public String workerInfo() {
        return "\t- hourly payment";
    }
}