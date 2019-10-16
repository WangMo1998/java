package lab1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class divTest {
    Calculator divide;
    @BeforeMethod
    public void setUps(){
        divide = new Calculator();
    }

    @Test
    public void divTestCase() {
        Assert.assertEquals(divide.div(100.0, 5.0), 20.0, 0.0001);
    }
}
