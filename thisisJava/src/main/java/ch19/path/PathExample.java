package ch19.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

  public static void main(String[] args) {
    Path path = Paths.get("ch19/path/PathExample.java");
    System.out.println(path.getFileName());
    System.out.println(path.getParent().getFileName());
  }

}
