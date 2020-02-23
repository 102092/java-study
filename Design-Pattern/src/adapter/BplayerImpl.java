package adapter;

public class BplayerImpl implements Bplayer {

  @Override
  public void playFile(String fileName) {
    System.out.println("B " +fileName);
  }

  @Override
  public void stopFile() {

  }
}
