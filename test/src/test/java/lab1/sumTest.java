package lab1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sumTest {
    Calculator summ;
    @BeforeMethod
    public void setUps(){
        summ = new Calculator();
    }

    @Test
    public void sumTestCase() {
        Assert.assertEquals(summ.sum(10.0, 5.0), 15.0, 0.0001);
    }
}

