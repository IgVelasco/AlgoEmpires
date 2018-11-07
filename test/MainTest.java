import org.junit.Assert;
import org.junit.Test;

public class MainTest {
  
  @Test
  public void testLaFuncionDevuelveLoIndicado() {
    Main main = new Main();
    
    Assert.assertEquals("Test", main.test());
  }
  
}
