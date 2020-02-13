import java.awt.Button;
import java.awt.Frame;

public class Main {

  public static void main(String[] args) {
    Frame f = new Frame("Hello world");
    f.setSize(600, 400);
    f.setLayout(null);
    Button b = new Button("확인");
    b.setSize(100, 30);
    b.setLocation(250, 175);
    f.add(b);
    f.setVisible(true);

  }


}
