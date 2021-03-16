import java.io.Serializable;

public class Fixed extends Worker implements Serializable {

    public Fixed(String name){
        super(name);
    }

    public void salaryCalculation(double wage_rate) {
        setSalary(wage_rate);
    }

    public String workerInfo() {
        return "\t- fixed payment";
    }

}