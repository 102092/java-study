package singleton4;

public class TestPattern1 {

  public static void main(String[] args) {
    LogWriter logger;

    logger = LogWriter.getInstance();
    logger.log("하이루");

    logger = LogWriter.getInstance();
    logger.log("만들어졌을까?");
  }
}
