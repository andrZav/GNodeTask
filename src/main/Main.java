package main;

import cisco.java.challenge.GNode;
import cisco.java.challenge.Impl.GNodeImpl;
import test.cisco.java.challenge.DoWorkGNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    GNode gNodeA = new GNodeImpl("A");
    GNode gNodeB = new GNodeImpl("B");
    GNode gNodeE = new GNodeImpl("E");
    GNode gNodeF = new GNodeImpl("F");

    GNode gNodeC = new GNodeImpl("C");
    GNode gNodeG = new GNodeImpl("G");
    GNode gNodeH = new GNodeImpl("H");
    GNode gNodeI = new GNodeImpl("I");

    GNode gNodeD = new GNodeImpl("D");

    // Nodes A -> B -> EF
    gNodeA.addChild(gNodeB);
    gNodeB.addChild(gNodeE);
    gNodeB.addChild(gNodeF);

    // Nodes A -> C -> GHI
    gNodeA.addChild(gNodeC);
    gNodeC.addChild(gNodeG);
    gNodeC.addChild(gNodeH);
    gNodeC.addChild(gNodeI);

    // Nodes A -> D
    gNodeA.addChild(gNodeD);

    DoWorkGNode doWorkGNode = new DoWorkGNode();
    // get path from starting Node
    List<List<GNode>> pathsResult = doWorkGNode.paths(gNodeA);
    System.out.println(pathsResult);

    List<GNode> walkResult = doWorkGNode.walkGraph(gNodeB);
    System.out.println(walkResult);
  }
}
