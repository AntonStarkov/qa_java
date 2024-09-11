import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionWithParameterizedTest {
    boolean expectedMane;
    String expectedSex;
    @Mock
    Feline feline;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
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
        Assert.assertEquals(expectedMane, new Lion(expectedSex, feline).doesHaveMane());
    }
}
