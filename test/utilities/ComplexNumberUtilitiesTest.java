package utilities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import resources.ComplexNumber;

/**
 * Created by Phil on 2/18/2015.
 */
public class ComplexNumberUtilitiesTest {

    ComplexNumber zero,eightSix,negEightNegFifteen,fiveThree;

    @Before
    public void init() {
        zero = new ComplexNumber(0,0);
        eightSix = new ComplexNumber(8,6);
        negEightNegFifteen = new ComplexNumber(-8,-15);
        fiveThree = new ComplexNumber(5,3);
    }

    @Test
    public void test_absoluteValue_returnsProperValue() {
        Assert.assertEquals("Incorrect absolute value - (0+0i)", ComplexNumberUtilities.absoluteValue(zero), 0, 0);
        Assert.assertEquals("Incorrect absolute value - (8+6i)", ComplexNumberUtilities.absoluteValue(eightSix), 10, 0);
        Assert.assertEquals("Incorrect absolute value - (-8-15i)", ComplexNumberUtilities.absoluteValue(negEightNegFifteen), 17, 0);
    }

    @Test
    public void test_multiplication_returnsProperValue() {
        ComplexNumber fiveThreeSquared = ComplexNumberUtilities.multiply(fiveThree,fiveThree);
        Assert.assertEquals("Incorrect multiplication value - (5+3i) * (5+3i) - real component", fiveThreeSquared.getRealComponent(), 16, 0);
        Assert.assertEquals("Incorrect multiplication value - (5+3i) * (5+3i) - imaginary component", fiveThreeSquared.getImaginaryComponent(), 30, 0);

        ComplexNumber zeroTimesEightSix = ComplexNumberUtilities.multiply(zero,eightSix);
        Assert.assertEquals("Incorrect multiplication value - (0+0i) * (8+6i) - real component", zeroTimesEightSix.getRealComponent(), 0, 0);
        Assert.assertEquals("Incorrect multiplication value - (0+0i) * (8+6i) - imaginary component", zeroTimesEightSix.getImaginaryComponent(), 0, 0);

        ComplexNumber negEightNegFifteenTimesFiveThree = ComplexNumberUtilities.multiply(negEightNegFifteen,fiveThree);
        Assert.assertEquals("Incorrect multiplication value - (-8-15i) * (5+3i) - real component", negEightNegFifteenTimesFiveThree.getRealComponent(), 5, 0);
        Assert.assertEquals("Incorrect multiplication value - (-8-15i) * (5+3i) - imaginary component", negEightNegFifteenTimesFiveThree.getImaginaryComponent(), -99, 0);
    }

    @Test
    public void test_addition_returnsProperValue() {
        ComplexNumber fiveThreePlusZero = ComplexNumberUtilities.add(fiveThree,zero);
        Assert.assertEquals("Incorrect addition value - (5+3i) + (0+0i) - real component", fiveThreePlusZero.getRealComponent(), 5, 0);
        Assert.assertEquals("Incorrect addition value - (5+3i) + (0+0i) - imaginary component", fiveThreePlusZero.getImaginaryComponent(), 3, 0);

        ComplexNumber eightSixPlusNegEightNegFifteen = ComplexNumberUtilities.add(eightSix,negEightNegFifteen);
        Assert.assertEquals("Incorrect addition value - (8+6i) + (-8-15i) - real component", eightSixPlusNegEightNegFifteen.getRealComponent(), 0, 0);
        Assert.assertEquals("Incorrect addition value - (8+6i) + (-8-15i) - imaginary component", eightSixPlusNegEightNegFifteen.getImaginaryComponent(), -9, 0);

        ComplexNumber fiveThreePlusFiveThree = ComplexNumberUtilities.add(fiveThree,fiveThree);
        Assert.assertEquals("Incorrect addition value - (5+3i) + (5+3i) - real component", fiveThreePlusFiveThree.getRealComponent(), 10, 0);
        Assert.assertEquals("Incorrect addition value - (5+3i) + (5+3i) - imaginary component", fiveThreePlusFiveThree.getImaginaryComponent(), 6, 0);
    }
}
