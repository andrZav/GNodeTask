package test.cisco.java.challenge;

import cisco.java.challenge.GNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DoWorkGNode {
  public List<GNode> walkGraph(GNode gNode) {
    List<List<GNode>> list = paths(gNode);
    Set<GNode> set = new TreeSet<>();
    for (List<GNode> nList : list) {
      set.addAll(nList);
    }
    return new ArrayList<>(set);
  }

  public List<List<GNode>> paths(GNode gNode) {
    List<List<GNode>> pathsAll = new ArrayList<>();
    for (GNode child : gNode.getChildren()) {
      try {
        List<GNode> path;
        if (child.getChildren().length > 0) {
          for (int j = 0; j < child.getChildren().length; j++) {
            path = new ArrayList<>();
            path.add(gNode);
            path.add(child); // child node
            path.add(child.getChildren()[j]);
            pathsAll.add(path);
          }
        } else {
          path = new ArrayList<>();
          path.add(gNode);
          path.add(child); // child node
          pathsAll.add(path);
        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return pathsAll;
  }
}
