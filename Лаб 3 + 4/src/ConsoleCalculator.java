import java.util.Scanner;

public class ConsoleCalculator {

    public static class SingletonHolder {
        public static final ConsoleCalculator HOLDER_INSTANCE = new ConsoleCalculator();
    }

    public static ConsoleCalculator getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    private CalculationLogic res = null;
    private char action;

    public char getAction() { return action; }
    public void setAction(char action) { this.action = action; }

    private ConsoleCalculator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Choose calculator (1 - digital; 2 - complex): ");
        byte choice = in.nextByte();

        switch (choice) {
            case 1 -> res = CalculatorFactory.create(CalculatorTypeEnum.Digit);
            case 2 -> res = CalculatorFactory.create(CalculatorTypeEnum.Complex);
            default -> System.exit(0);
        }

        while (true){
            System.out.println(res.toString());
            setAction(in.next().charAt(0));

            if (!res.checkAction(getAction())){
                System.out.println("No such operation");
                System.exit(0);
            }
            else {
                if (action == '='){
                    System.out.println(res.toString());
                    System.exit(0);
                }
                in.nextLine();
                res.setNumber(in.nextLine());
                res.setResult(res.calculate(res.getResult(), res.getNumber(), action));
            }
        }
    }
}
