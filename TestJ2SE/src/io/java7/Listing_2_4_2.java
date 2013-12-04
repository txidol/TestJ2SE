package io.java7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Code for Listing 2_4 - You'll need to change the hardcoded path.
 */
public class Listing_2_4_2 {

  public static void main(String[] args) {
   
    
    
    Path old = Paths.get("E:\\java\\test.txt");

    Path target = Paths.get("E:\\java\\test\\test1.txt");

    
    try (BufferedReader reader = Files.newBufferedReader(old, StandardCharsets.UTF_8)){
		String line ;
		while((line = reader.readLine())!=null){
			System.out.println(line);
		}
	} catch (IOException e) {
		
	}
    
    try(BufferedWriter writer = 
    		Files.newBufferedWriter(target, StandardCharsets.UTF_8, StandardOpenOption.WRITE)){
    	writer.write("hello");
    } catch (IOException e) {
	
		e.printStackTrace();
	}
    
    
    try {
		@SuppressWarnings("unused")
		List<String> lines = Files.readAllLines(old, StandardCharsets.UTF_8);
		@SuppressWarnings("unused")
		byte[] bytes = Files.readAllBytes(old);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
    
  }
}
