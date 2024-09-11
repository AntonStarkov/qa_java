import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionWithParameterizedTest {
    boolean expectedMane;
    String expectedSex;
    public LionWithParameterizedTest(boolean expectedMane, String expectedSex){
        this.expectedMane = expectedMane;
        this.expectedSex = expectedSex;
    }
    @Parameterized.Parameters
    public static Object[][] getMane(){
        return new Object[][] {
                {true, "Самец"},
                {false, "Самка"},
        };
    }
    @Test
    public void lionsDoesHaveManeMethodTest() throws Exception {
        Assert.assertEquals(expectedMane, new Lion(expectedSex).doesHaveMane());
    }
}
