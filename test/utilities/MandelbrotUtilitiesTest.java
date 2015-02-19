package utilities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import resources.ComplexNumber;

/**
 * Created by Phil on 2/19/2015.
 */
public class MandelbrotUtilitiesTest {

    ComplexNumber zero,negOneOne,oneNegThree,twoNegOne,oneOne,negOneZero,negPointZeroFivePointSevenFive;

    @Before
    public void init() {
        zero = new ComplexNumber(0,0);
        negOneOne = new ComplexNumber(-1,1);
        oneNegThree = new ComplexNumber(1,-3);
        twoNegOne = new ComplexNumber(2,-1);
        oneOne = new ComplexNumber(1,1);
        negOneZero = new ComplexNumber(-1,0);
        negPointZeroFivePointSevenFive = new ComplexNumber(-.05,.75);
    }

    @Test
    public void test_iterationsToExcludeFromMandelbrotSet_returnsReasonableValue() {
        Assert.assertTrue("(0+0i) is in the Mandelbrot Set", MandelbrotUtilities.iterationsToExcludeFromMandelbrotSet(zero) == 0);
        Assert.assertTrue("(-1+0i) is in the Mandelbrot Set", MandelbrotUtilities.iterationsToExcludeFromMandelbrotSet(negOneZero) == 0);
        Assert.assertTrue("(-.05+.75i) is in the Mandelbrot Set", MandelbrotUtilities.iterationsToExcludeFromMandelbrotSet(negPointFivePointSevenFive) == 0);

        Assert.assertFalse("(-1+1i) is not in the Mandelbrot Set", MandelbrotUtilities.iterationsToExcludeFromMandelbrotSet(negOneOne) == 0);
        Assert.assertFalse("(1-3i) is not in the Mandelbrot Set", MandelbrotUtilities.iterationsToExcludeFromMandelbrotSet(oneNegThree) == 0);
        Assert.assertFalse("(2-1i) is not in the Mandelbrot Set", MandelbrotUtilities.iterationsToExcludeFromMandelbrotSet(twoNegOne) == 0);
        Assert.assertFalse("(1+1i) is not in the Mandelbrot Set", MandelbrotUtilities.iterationsToExcludeFromMandelbrotSet(oneOne) == 0);
    }
}
