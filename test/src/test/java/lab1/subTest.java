package lab1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class subTest {
    Calculator subtract;
    @BeforeMethod
    public void setUps(){
        subtract = new Calculator();
    }

    @Test
    public void subTestCase() {
        Assert.assertEquals(subtract.sub(10.0, 5.0), 5.0, 0.0001);
    }
}
