public class CalculatorFactory {
    public static CalculationLogic create(CalculatorTypeEnum type){
        return switch (type) {
            case Digit -> new DigitCalculator();
            case Complex -> new ComplexCalculator();
        };
    }
}
