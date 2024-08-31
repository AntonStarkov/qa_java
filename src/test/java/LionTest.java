import com.example.Lion;
import com.example.Predator;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionTest {
    boolean expectedMane;
    String expectedSex;
    public LionTest (boolean expectedMane, String expectedSex){
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
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Predator predator;
    @Test
    public void lionsMethodsTest() throws Exception {
        Lion lion = new Lion(predator);
        lion.getFood();
        Mockito.verify(predator).getFood();
        lion.getKittens();
        Mockito.verify(predator).getKittens(1);
        lion.getKittens(5);
        Mockito.verify(predator).getKittens(5);
        Assert.assertEquals(expectedMane, new Lion(expectedSex).doesHaveMane());
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", (Assert.assertThrows(Exception.class, () -> {
            new Lion("");}).getMessage()));
        Assert.assertThrows(Exception.class, () -> {new Lion("");});
    }
}
