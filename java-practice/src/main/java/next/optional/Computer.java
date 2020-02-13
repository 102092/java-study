package next.optional;

import java.util.Optional;

public class Computer {

  private Soundcard soundcard;

  public Computer(Soundcard soundcard) {
    this.soundcard = soundcard;
  }

  public Optional<Soundcard> getSoundcard() {
    return Optional.ofNullable(soundcard);
  }

  public static class Soundcard {

    private USB usb;

    public Soundcard(USB usb) {
      super();
      this.usb = usb;
    }

    public Optional<USB> getUsb() {
      return Optional.ofNullable(usb);
    }
  }

  public static class USB {

    private String version;

    public USB(String version) {
      super();
      this.version = version;
    }

    public String getVersion() {
      return this.version;
    }
  }
}
