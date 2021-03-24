public class ComplexNumber {
    private double real, imaginary;

    public double getReal() { return real; }
    public void setReal(double real) { this.real = real; }

    public double getImaginary() { return imaginary; }
    public void setImaginary(double imaginary) { this.imaginary = imaginary; }

    ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
}
