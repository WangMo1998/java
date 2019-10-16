package HomeWork1;

import org.testng.annotations.BeforeMethod;
import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AddTest {
    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void longAddTest(){
        long result = calculator.sum(0, 100);
        assertEquals(result, 100);
    }

    @Test
    public void doubleAddTest(){
        double result = calculator.sum(0, 100.0);
        assertEquals(result, 100.0);
    }

}
