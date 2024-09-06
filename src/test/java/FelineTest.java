import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline;
    @Test
    public void felinesGetFamilyMethodTest() throws Exception {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void felinesEatMeatMethodTest() throws Exception {
        Assert.assertEquals(feline.getFood("Хищник"), feline.eatMeat());
    }
    @Test
    public void felinesGetFoodMethodTest() throws Exception {
        Assert.assertEquals(null, feline.getFood("Хищник"));
    }
    @Test
    public void felinesGetKittensMethodWithParameterTest() throws Exception {
        Assert.assertEquals(4, feline.getKittens(4));
    }
    @Test
    public void felinesGetKittensMethodWithoutParameterTest() throws Exception {
        feline.getKittens();
        Mockito.verify(feline).getKittens(1);
    }
}
