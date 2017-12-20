package javial.cert.sx
import static org.junit.Assert.*;

/**
 * Created by mak on 9/13/14.
 */
class AutoboxMathTest extends GroovyTestCase {

  void testAdditionViaAutoBoxCalculation() {
    Integer age = 1;
    Integer[] Operand = new Integer[2];
    Operand[0] = 3 ;
    Operand[1] = 4 ; // dont know why groovy objects to = { 3, 4 } but not = {3}
    age = new Integer(2) + new Integer(4);
    assertTrue("2 + 4 = 6", 6 == age )
    age = new Integer(2) * new Integer(4);
    assertTrue("2 * 4 = 8", 8 == age )
    assertTrue("3 == Operand[0]", 3 == Operand[0])
    age = Operand[0] * Operand[1];
    assertTrue("3 * 4 = 12", 12 == age )
  }
}
