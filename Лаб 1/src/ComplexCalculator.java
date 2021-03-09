public class ComplexCalculator extends CalculationLogic<ComplexCalculator> implements Calculation<ComplexCalculator> {

    private ComplexCalculator result;
    private ComplexCalculator number;

    private double real, imaginary;
    boolean isNull = true;

    public ComplexCalculator getNumber() { return number; }

    public void setNumber(String result) {
        String[] parts = result.split(" ");
        double[] nums = new double [2];
        for(int n = 0; n < 2; n++) {
            nums[n] = Double.parseDouble(parts[n]);
        }
        number.real = nums[0];
        number.imaginary = nums[1];
    }

    public ComplexCalculator getResult() { return result; }
    public void setResult(ComplexCalculator res) { this.result = res; }

    public double getReal() { return real; }
    public void setReal(double real) { this.real = real; }

    public double getImaginary() { return imaginary; }
    public void setImaginary(double imaginary) { this.imaginary = imaginary; }

    public ComplexCalculator(double real , double imaginary )
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexCalculator plus(ComplexCalculator first, ComplexCalculator second) {
        return new ComplexCalculator(first.real + second.real, first.imaginary + second.imaginary);
    }

    public ComplexCalculator minus(ComplexCalculator first, ComplexCalculator second) {
        return new ComplexCalculator(first.real - second.real, first.imaginary - second.imaginary);
    }

    public ComplexCalculator multiply(ComplexCalculator first, ComplexCalculator second) {
        double one = first.real * second.real - first.imaginary * second.imaginary;
        double two = first.real * second.imaginary + first.imaginary * second.real;
        return new ComplexCalculator(one, two);
    }

    public ComplexCalculator divide(ComplexCalculator first, ComplexCalculator second) {
        ComplexCalculator output = multiply(first,second.conjugate());
        double div = Math.pow(second.mod(),2);
        return new ComplexCalculator(output.real/div, output.imaginary/div);
    }

    public ComplexCalculator conjugate()
    {
        return new ComplexCalculator(this.real,-this.imaginary);
    }

    public double mod()
    {
        return Math.sqrt(Math.pow(this.real,2) + Math.pow(this.imaginary,2));
    }

    @Override
    public String toString(){
        if (isNull){
            result = new ComplexCalculator(0,0);
            number = new ComplexCalculator(0,0);
            isNull = false;
        }
        return (result.getImaginary() < 0)
                ? result.getReal() + " - " + Math.abs(result.getImaginary()) + "i"
                : result.getReal() + " + " + result.getImaginary() + "i";
    }
}