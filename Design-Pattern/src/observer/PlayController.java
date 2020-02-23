package observer;

import java.util.Observable;

public class PlayController extends Observable {

  private boolean bPlay;

  public PlayController() {
  }

  public void setFlag(boolean bPlay) {
    this.bPlay = bPlay;
    setChanged();
    notifyObservers();
  }

  public boolean getFlag() {
    return bPlay;
  }
}
