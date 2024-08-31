import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Spy
    Feline felineGetKittensWithParameter;
    @Spy
    Feline felineGetKittensWithoutParameter;
    @Spy
    Feline feline;
    @Test
    public void felinesMethodsTest() throws Exception {
        Assert.assertEquals("Кошачьи", feline.getFamily());
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
        feline.getFamily();
        Assert.assertEquals("Кошачьи", feline.getFamily());
        feline.getFood();
        Mockito.verify(feline).getFood();
    }
    @Test
    public void felinesGetKittensMethodWithParameterTest() throws Exception {
        felineGetKittensWithParameter.getKittens(4);
        Mockito.verify(felineGetKittensWithParameter).getKittens(4);
    }
    @Test
    public void felinesGetKittensMethodWithoutParameterTest() throws Exception {
        felineGetKittensWithoutParameter.getKittens();
        Mockito.verify(felineGetKittensWithoutParameter).getKittens(1);
    }
}
