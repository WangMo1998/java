package HomeWork1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubTest {
    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void longSubTest(){
        long result = calculator.sub(0, 100);
        assertEquals(result, -100);
    }

    @Test
    public void doubleSubTest(){
        double result = calculator.sub(0, 100.0);
        assertEquals(result, -100.0);
    }
}
