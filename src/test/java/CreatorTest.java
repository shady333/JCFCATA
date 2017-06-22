import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import org.apache.log4j.Logger;

/**
 * Created by Oleg_Dudar on 22-Jun-17.
 */
public class CreatorTest {

    final static Logger logger = Logger.getLogger(CreatorTest.class);

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

        logger.warn("This is warn");
        logger.error("This is error");
        logger.fatal("This is fatal");


        //TODO please remove this!!!
        Assert.assertTrue(true);

    }

}