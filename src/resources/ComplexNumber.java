package resources;

/**
 * Created by Phil on 2/18/2015.
 */
public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getRealComponent() {
        return this.real;
    }

    public double getImaginaryComponent() {
        return this.imaginary;
    }
}