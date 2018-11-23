package cisco.java.challenge.Impl;

import cisco.java.challenge.GNode;

import java.util.Arrays;

public class GNodeImpl implements GNode, Comparable<GNode> {
  private String name;
  private GNode[] child = new GNode[0];

  public GNodeImpl(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void addChild(GNode gNode) {
    child = Arrays.copyOf(child, child.length + 1);
    child[child.length - 1] = gNode;
  }

  @Override
  public GNode[] getChildren() {
    return child;
  }

  @Override
  public String toString() {
    return getName();
  }

  @Override
  public int compareTo(GNode o) {
    return this.getName().compareToIgnoreCase(o.getName());
  }



}
