package adapter;

public class AplayerImpl implements Aplayer {

  @Override
  public void play(String fileName) {
    System.out.println("A " +fileName);
  }

  @Override
  public void stop() {

  }
}
