import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class NoDriverTest {

    @Test
    public void testPass() {

        Assert.assertTrue(true);
    }

    @Ignore
    @Test
    public void testFail() {

        Assert.assertTrue(false);
    }
}
