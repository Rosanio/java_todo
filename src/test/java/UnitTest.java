import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

  @Test
  public void Task_instantiatesCorrectly_true() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(true, myTask instanceof Task);
  }

  @Test
  public void task_instantiatesWithDescription_true() {
    Task myTask = new Task("Mow the lawn");
    assertEquals("Mow the lawn", myTask.getDescription());
  }


/*
@Test
public void giveChange_25cents_1quarter() {
  App testApp = new App();
  assertEquals("{Nickels=0, Dimes=0, Quarters=1, Pennies=0}", testApp.giveChange(25).toString());
}
*/

}
