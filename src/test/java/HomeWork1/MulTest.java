package HomeWork1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MulTest {
    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void longMulTest(){
        long result = calculator.mult(0, 100);
        assertEquals(result, 0);
    }

    @Test
    public void doubleMulTest(){
        double result = calculator.mult(0, 100.0);
        assertEquals(result, 0.0);
    }
}
