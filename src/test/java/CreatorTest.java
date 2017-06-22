import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Oleg_Dudar on 22-Jun-17.
 */
public class CreatorTest {
    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("Setup");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("Teardown");
    }

    @Test
    public void testCreateJson() throws Exception {
        System.out.println("Test");
        //TODO please remove this!!!
        Assert.assertTrue(true);

    }

}