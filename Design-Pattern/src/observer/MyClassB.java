package observer;

import java.util.Observable;
import java.util.Observer;

public class MyClassB implements Observer {

  Observable observable;
  private boolean bPlay;

  public MyClassB(Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {
    //notifyObservers() 메서드가 실행되면 이부분이 실행됨.
    if (o instanceof PlayController) {
      PlayController myControl = (PlayController) o;
      this.bPlay = myControl.getFlag();
      myActControl();
    }
  }

  private void myActControl() {
    if (bPlay) {
      System.out.println("myclass B 동작 시작");
    } else {
      System.out.println("myclass B 동작 정지");
      observable.deleteObserver(this);
    }
  }
}
