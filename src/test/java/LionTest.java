import com.example.Feline;
import com.example.Lion;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;
    @Test
    public void lionsGetFoodMethodTest() throws Exception {
        Lion lion = new Lion(feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
    @Test
    public void lionsGetKittensMethodTest() {
        Lion lion = new Lion(feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }
    @Test
    public void lionsThrowExceptionTest() {
        Assert.assertThrows(Exception.class, () -> {new Lion("", feline);});
    }
    @Test
    public void lionsThrowExceptionTextTest() {
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", (Assert.assertThrows(Exception.class, () -> {
            new Lion("", feline);}).getMessage()));
    }
}

