package lab1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class multTest {
    Calculator multiply;
    @BeforeMethod
    public void setUps(){
        multiply = new Calculator();
    }

    @Test
    public void multTestCase() {
        Assert.assertEquals(multiply.mult(100.0, 5.0), 500.0, 0.0001);
    }
}
