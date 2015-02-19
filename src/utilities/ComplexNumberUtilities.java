package utilities;

import resources.ComplexNumber;

/**
 * Created by Phil on 2/18/2015.
 */
public class ComplexNumberUtilities {

    /**
     * Absolute value of a complex number: 	|(a+ib)| = sqrt(a^2+b^2)
     * @param number - a ComplexNumber
     * @return the absolute value of the given number
     */
    public static double absoluteValue(ComplexNumber number) {
        return Math.sqrt(number.getRealComponent()*number.getRealComponent()
                + number.getImaginaryComponent()*number.getImaginaryComponent());
    }

    /**
     * Multiplication of two complex numbers: 	(a+ib)*(c+id) = (ac-bd)+i(ad+bc)
     * @param num1 - a ComplexNumber
     * @param num2 - a ComplexNumber
     * @return the product of num1*num2
     */
    public static ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        float realComponent, imaginaryComponent;

        realComponent = num1.getRealComponent()*num2.getRealComponent() - num1.getImaginaryComponent()*num2.getImaginaryComponent();
        imaginaryComponent = num1.getRealComponent()*num2.getImaginaryComponent() + num1.getImaginaryComponent()*num2.getRealComponent();

        return new ComplexNumber(realComponent, imaginaryComponent);
    }

    /**
     * Addition of two complex numbers: 	(a+ib)+(c+id) = (a+c)+i(b+d)
     * @param num1 - a ComplexNumber
     * @param num2 - a ComplexNumber
     * @return the sum of num1+num2
     */
    public static ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        float realComponent, imaginaryComponent;

        realComponent = num1.getRealComponent() + num2.getRealComponent();
        imaginaryComponent = num1.getImaginaryComponent() + num2.getImaginaryComponent();

        return new ComplexNumber(realComponent, imaginaryComponent);
    }
}
