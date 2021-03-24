public class ComplexCalculator extends CalculationLogic<ComplexNumber> implements Calculation<ComplexNumber> {

    private ComplexNumber result;
    private ComplexNumber number;

    boolean isNull = true;

    public ComplexNumber getNumber() { return number; }
    public void setNumber(String result) {
        String[] parts = result.split(" ");
        double[] nums = new double [2];
        for(int n = 0; n < 2; n++) {
            nums[n] = Double.parseDouble(parts[n]);
        }
        number.setReal(nums[0]);
        number.setImaginary(nums[1]);
    }

    public ComplexNumber getResult() { return result; }
    public void setResult(ComplexNumber res) { this.result = res; }

    public ComplexNumber plus(ComplexNumber first, ComplexNumber second) {
        return new ComplexNumber(first.getReal() + second.getReal(), first.getImaginary() + second.getImaginary());
    }

    public ComplexNumber minus(ComplexNumber first, ComplexNumber second) {
        return new ComplexNumber(first.getReal() - second.getReal(), first.getImaginary() - second.getImaginary());
    }

    public ComplexNumber multiply(ComplexNumber first, ComplexNumber second) {
        double one = first.getReal() * second.getReal() - first.getImaginary() * second.getImaginary();
        double two = first.getReal() * second.getImaginary() + first.getImaginary() * second.getReal();
        return new ComplexNumber(one, two);
    }

    public ComplexNumber divide(ComplexNumber first, ComplexNumber second) {
        ComplexNumber output = multiply(first,conjugate(second));
        double div = Math.pow(mod(second),2);
        return new ComplexNumber(output.getReal()/div, output.getImaginary()/div);
    }

    public double mod(ComplexNumber num)
    {
        return Math.sqrt(Math.pow(num.getReal(),2) + Math.pow(num.getImaginary(),2));
    }

    public ComplexNumber conjugate(ComplexNumber num)
    {
        return new ComplexNumber(num.getReal(),-num.getImaginary());
    }

    @Override
    public String toString(){
        if (isNull){
            result = new ComplexNumber(0,0);
            number = new ComplexNumber(0,0);
            isNull = false;
        }
        return (result.getImaginary() < 0)
                ? result.getReal() + " - " + Math.abs(result.getImaginary()) + "i"
                : result.getReal() + " + " + result.getImaginary() + "i";
    }
}