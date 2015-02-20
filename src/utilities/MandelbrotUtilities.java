package utilities;

import resources.ComplexNumber;

/**
 * Created by Phil on 2/18/2015.
 */
public class MandelbrotUtilities {

    private static final int MANDELBROT_ATTEMPTS = 1000;

    /**
     * Runs iterations from Z(0) -> Z(n) to see if the absolute value of Z(i) ever
     * exceeds 2.  If it does, it can be proven that the sequence grows to infinity,
     * and is not in the Mandelbrot Set.
     *
     * We always start with complex number Z(0) = 0 = 0+i0.
     * It holds that Z(i) = Z(i-1)^2 + C, where C is a complex number made up of a real unit and
     * an imaginary unit.
     *
     * It follows that Z(1) = Z(0)^2 + C, Z(2) = Z(1)^2 + C, Z(3) = Z(2)^2 + C, etc, etc...
     *
     * @param c - the complex number representing C
     * @returns the number of iterations it takes to prove that the value of C is not in
     * the Mandelbrot Set, or Zero if C *is* in the Mandelbrot Set.
     **/
    public static int iterationsToExcludeFromMandelbrotSet(ComplexNumber c) {
        // initialize z as z(0)
        ComplexNumber z = new ComplexNumber(0,0);

        for(int i = 0; i < MANDELBROT_ATTEMPTS; i++) {
            if(ComplexNumberUtilities.absoluteValue(z) > 2) {
                return i;
            }
            // z(n+1)=z(n)^2 + c
            z = ComplexNumberUtilities.add(ComplexNumberUtilities.multiply(z,z),c);
        }

        return 0;
    }
}
