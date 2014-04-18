package io.java7;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Code for Listing 2_8 - You'll need to change the hardcoded path.
 */
public class Listing_2_8_1 {

  public static void main(String[] args) {
    try {
      Path file = Paths.get("E:\\java\\test.txt");

      FileChannel channel = FileChannel.open(file);

      ByteBuffer buffer = ByteBuffer.allocate(1024);
      channel.read(buffer, channel.size() -13);
     
	System.out.println((char)buffer.array()[0]);
  
     
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }


}
