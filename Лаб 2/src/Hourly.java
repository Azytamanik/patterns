public class Hourly extends Worker{
    public Hourly(String name){
        super(name);
    }

    public void salaryCalculation(double wage_rate) {
        setSalary(5 * 4 * 8 * wage_rate);
    }
}
