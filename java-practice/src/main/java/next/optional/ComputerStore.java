package next.optional;

import java.util.Optional;
import next.optional.Computer.Soundcard;
import next.optional.Computer.USB;

public class ComputerStore {

  public static final String UNKNOWN_VERSION = "UNKNOWN";

  public static String getVersion(Computer computer) {
    return Optional.ofNullable(computer)
        .flatMap(Computer::getSoundcard)
        .flatMap(Soundcard::getUsb)
        .orElse(new USB(UNKNOWN_VERSION))
        .getVersion();
  }

  public static String getVersionOptional(Computer computer) {
    return Optional.ofNullable(computer)
        .flatMap(Computer::getSoundcard)
        .flatMap(Soundcard::getUsb)
        .orElse(new USB(UNKNOWN_VERSION))
        .getVersion();

  }
}
