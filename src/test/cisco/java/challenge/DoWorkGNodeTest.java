package test.cisco.java.challenge;

import cisco.java.challenge.GNode;
import cisco.java.challenge.Impl.GNodeImpl;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DoWorkGNodeTest {
  private GNode gNodeA;
  private GNode gNodeB;
  private GNode gNodeC;
  private GNode gNodeD;

  private DoWorkGNode doWorkGNode;

  public DoWorkGNodeTest() {
    doWorkGNode = new DoWorkGNode();
  }

  @Before
  public void setUp() throws Exception {
    gNodeA = new GNodeImpl("A");
    gNodeB = new GNodeImpl("B");
    gNodeC = new GNodeImpl("C");
    gNodeD = new GNodeImpl("D");

    gNodeA.addChild(gNodeB);
    gNodeA.addChild(gNodeC);
    gNodeA.addChild(gNodeD);
  }

  @Test
  public void paths() throws Exception {
    List<List<GNode>> list = doWorkGNode.paths(gNodeA);
    assertEquals(3, list.size());
    assertEquals("A", list.get(0).get(0).getName());
    assertEquals("B", list.get(0).get(1).getName());
    assertEquals("C", list.get(1).get(1).getName());
    assertEquals("A", list.get(2).get(0).getName());
    assertEquals("D", list.get(2).get(1).getName());
  }

  @Test
  public void walkGraph() throws Exception {
    List<GNode> list = doWorkGNode.walkGraph(gNodeA);
    assertEquals("A", list.get(0).getName());
    assertEquals("B", list.get(1).getName());
    assertEquals("C", list.get(2).getName());
    assertEquals("D", list.get(3).getName());

    assertEquals(4, list.size());
  }
}