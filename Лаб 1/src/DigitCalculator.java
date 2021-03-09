public class DigitCalculator extends CalculationLogic<Double> implements Calculation<Double>{

    private Double result = 0.0;
    private Double number = 0.0;

    public Double getResult() { return result; }
    public void setResult(Double result) { this.result = result; }

    public Double getNumber() { return number; }

    public void setNumber(String result) { this.number = Double.parseDouble(result); }

    public Double plus(Double first, Double second) { return first + second; }
    public Double minus(Double first, Double second) { return first - second; }
    public Double multiply(Double first, Double second) { return first * second; }
    public Double divide(Double first, Double second) {
        if (second == 0.0)
        {
            throw new ArithmeticException();
        }
        else
        {
            return first/second;
        }
    }

    @Override
    public String toString(){
        return getResult() + "";
    }
}
