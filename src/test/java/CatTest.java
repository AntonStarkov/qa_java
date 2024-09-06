import com.example.Cat;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Predator predator;
    @Test
    public void catsGetFoodMethodTest() throws Exception {
        Cat cat = new Cat(predator);
        cat.getFood();
        Mockito.verify(predator).eatMeat();
    }
    @Test
    public void catsGetSoundMethodTest() throws Exception {
        Cat cat = new Cat(predator);
        Assert.assertEquals(cat.getSound(), "Мяу");
    }
}
