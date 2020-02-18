package flyweight;

public class Tree {

  TreeModel treeModel;
  double height;
  double thickness;
  Position position;

  public Tree() {
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public void setTreeModel(TreeModel treeModel) {
    this.treeModel = treeModel;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public void setThickness(double thickness) {
    this.thickness = thickness;
  }
}
