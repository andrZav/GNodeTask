package test.cisco.java.challenge;

import cisco.java.challenge.GNode;
import cisco.java.challenge.Impl.GNodeImpl;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GNodeImplTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void addChild() throws Exception {
    GNode gNodeA = new GNodeImpl("A");
    GNode gNodeB = new GNodeImpl("B");
    GNode gNodeC = new GNodeImpl("C");

    gNodeA.addChild(gNodeB);
    gNodeA.addChild(gNodeC);
    assertEquals(gNodeB, gNodeA.getChildren()[0]);
    assertEquals(2, gNodeA.getChildren().length);
  }

}