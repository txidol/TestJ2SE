package io.java7;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Code for Listing 2_2 - You'll need to change the hardcoded path.
 */
public class Listing_2_2 {

  public static void main(String[] args) {

    //查找目录�? 文件
    Path dir = Paths.get("E:\\Learn\\Java7\\trunk");
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir,
        "*.properties")) {
      for (Path entry : stream) {
        System.out.println(entry.getFileName());
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
