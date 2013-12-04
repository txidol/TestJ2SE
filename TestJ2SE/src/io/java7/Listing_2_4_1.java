package io.java7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


/**
 * Code for Listing 2_4 - You'll need to change the hardcoded path.
 */
public class Listing_2_4_1 {

  public static void main(String[] args) {
   
    
    
    Path old = Paths.get("E:\\java\\test.txt");

    Path target = Paths.get("E:\\java\\test\\test1.txt");
    Path target2 = Paths.get("E:\\java\\test1\\test2.txt");
    try {
    	if(Files.exists(old)){
    		Files.copy(old, target, StandardCopyOption.REPLACE_EXISTING);
    		Files.move(old, target2,StandardCopyOption.REPLACE_EXISTING);
    	}

    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
