package io.java7;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Code for Listing 2_9 - You'll need to change the hardcoded path.
 */
public class Listing_2_9 {
  //回调式  
	public static void main(String[] args) {
    try {
      Path file = Paths.get("E:\\java\\test.txt");
      AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);

      ByteBuffer buffer = ByteBuffer.allocate(100_000);

      channel.read(buffer, 0, buffer,
          new CompletionHandler<Integer, ByteBuffer>() {

            public void completed(Integer result, ByteBuffer attachment) {
            	//System.out.println("read");
            	System.out.println("Bytes read [" + result + "]");
            	
            }

            public void failed(Throwable exception, ByteBuffer attachment) {
              System.out.println(exception.getMessage());
            }
          });
     // System.out.println("test");
      Thread.sleep(1000);
      
    } catch (IOException | InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}
