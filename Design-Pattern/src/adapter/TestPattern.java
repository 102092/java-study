package adapter;

public class TestPattern {

  public static void main(String[] args) {
      Aplayer aplayer = new AplayerImpl();
      aplayer.play("aaa.mp3");

      Bplayer bplayer = new BplayerImpl();
      bplayer.playFile("bbb.mp3");

      aplayer = new BToAAdapter(new BplayerImpl());
      aplayer.play("cc.mp3");
  }

}
