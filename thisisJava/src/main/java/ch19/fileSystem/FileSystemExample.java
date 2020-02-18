package ch19.fileSystem;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class FileSystemExample {

  public static void main(String[] args) throws IOException {
    FileSystem fileSystem = FileSystems.getDefault();

    for (FileStore store : fileSystem.getFileStores()) {
      System.out.println(store.name());
      System.out.println(store.type());
      System.out.println(store.getTotalSpace());
    }
  }

}
