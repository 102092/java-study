package flyweight;

public class TreeFactory {

  private static final TreeModel sharedTreeModel = new TreeModel();

  //이 부분이 공유 부분 가지고 객체를 만드는 부분
  static public Tree create(Position position, double height, double thickness) {
    Tree tree = new Tree();
    tree.setPosition(position);
    tree.setHeight(height);
    tree.setThickness(thickness);
    tree.setTreeModel(sharedTreeModel);
    return tree;
  }

}
