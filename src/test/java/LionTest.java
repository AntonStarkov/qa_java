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
    public void lionsGetFoodMethodTest() throws Exception {
        Lion lion = new Lion(predator);
        lion.getFood();
        Mockito.verify(predator).getFood("Хищник");
    }
    @Test
    public void lionsGetKittensMethodTest() {
        Lion lion = new Lion(predator);
        lion.getKittens();
        Mockito.verify(predator).getKittens();
    }
    @Test
    public void lionsDoesHaveManeMethodTest() throws Exception {
        Assert.assertEquals(expectedMane, new Lion(expectedSex).doesHaveMane());
    }
    @Test
    public void lionsThrowExceptionTest() {
        Assert.assertThrows(Exception.class, () -> {new Lion("");});
    }
    @Test
    public void lionsThrowExceptionTextTest() {
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", (Assert.assertThrows(Exception.class, () -> {
            new Lion("");}).getMessage()));
    }
}
