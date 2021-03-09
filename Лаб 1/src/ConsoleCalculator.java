import java.util.Scanner;

public class ConsoleCalculator {

    private CalculationLogic res = null;
    private char action;

    public char getAction() { return action; }
    public void setAction(char action) { this.action = action; }

    public ConsoleCalculator() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Choose calculator (1 - digital; 2 - complex): ");
        byte choice = in.nextByte();

        switch (choice) {
            case 1 -> res = new DigitCalculator();
            case 2 -> res = new ComplexCalculator(0, 0);
            default -> System.exit(0);
        }

        while (true){
            System.out.println(res.toString());
            setAction(in.next().charAt(0));

            if (!res.checkAction(getAction())){
                throw new Exception("No such operation");
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
