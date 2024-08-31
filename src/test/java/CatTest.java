import com.example.Cat;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Predator predator;
    @Test
    public void catsMethodsTest() throws Exception {
        Cat cat = new Cat(predator);
        cat.getFood();
        Mockito.verify(predator).eatMeat();
        Assert.assertEquals(cat.getSound(), "Мяу");
    }
}
