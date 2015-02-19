package resources;

/**
 * Created by Phil on 2/18/2015.
 */
public class ComplexNumber {
    private float real;
    private float imaginary;

    public ComplexNumber(float real, float imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = (float)real;
        this.imaginary = (float)imaginary;
    }

    public float getRealComponent() {
        return this.real;
    }

    public float getImaginaryComponent() {
        return this.imaginary;
    }
}