package HomeWork1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivTest {
    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void longDivTest(){
        long result = calculator.div(0, 100);
        assertEquals(result, 0);
    }

    @Test
    public void doubleDivTest(){
        double result = calculator.div(0, 100.0);
        assertEquals(result, 0.0);
    }
}
