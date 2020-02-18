package flyweight;

public class TreeModel {

  Mesh mesh;
  Texture bark;
  Texture leaves;

  public TreeModel() {
    mesh = new Mesh();
    bark = new Texture("bark");
    leaves = new Texture("leaves");

  }
}
