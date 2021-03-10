public class Fixed extends Worker{

    public Fixed(String name){
        super(name);
    }

    public void salaryCalculation(double wage_rate) {
        setSalary(wage_rate);
    }
}