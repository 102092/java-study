package observer;

public class TestPattern {

  public static void main(String[] args) {
    PlayController playController = new PlayController();
    MyClassA myClassA = new MyClassA(playController);
    MyClassB myClassB = new MyClassB(playController);

    System.out.println("모든 클래스 정지");
    playController.setFlag(false);

    System.out.println();

    System.out.println("모든 틀래스 다시 시작");
    playController.setFlag(true);

  }
}
