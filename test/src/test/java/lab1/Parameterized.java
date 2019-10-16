package lab1;
import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Parameterized {

    private Calculator calculator;

    @BeforeMethod
    public void setUps() {
        calculator = new Calculator();
    }

    @Test
    @Parameters(value = "positiveValue")
    public void testPositiveSign(long positiveValue){
        boolean result = calculator.isPositive(positiveValue);
        assertTrue(result);
    }

    @Test
    @Parameters(value = "negativeValue")
    public void testNegativeSign(long negativeValue){
        boolean result = calculator.isNegative(negativeValue);
        assertTrue(result);
    }
}
