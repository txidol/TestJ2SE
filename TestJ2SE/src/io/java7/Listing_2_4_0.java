package io.java7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * Code for Listing 2_4 - You'll need to change the hardcoded path.
 */
public class Listing_2_4_0 {

  public static void main(String[] args) {
    try {
      Path zip = Paths.get("E:\\java\\test");
      //Path zip = Paths.get("E:\\java\\测试.rar");
      System.out.println(zip.toAbsolutePath().toString());
      System.out.println(Files.getLastModifiedTime(zip));
      System.out.println(Files.size(zip));
      System.out.println(Files.isSymbolicLink(zip));
      System.out.println(Files.isDirectory(zip));
      System.out.println(Files.readAttributes(zip, "*"));
    } catch (IOException ex) {
      System.out.println("Exception" + ex.getMessage());
    }
    
    
    Path target = Paths.get("E:\\java\\test1.txt");
//    try {
//		Files.delete(target);
//	} catch (IOException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
    
    Set<PosixFilePermission> perms = 
    		PosixFilePermissions.fromString("rw-rw-rw-");
    
    //FileAttribute<Set<PosixFilePermission>> attr = 
    		PosixFilePermissions.asFileAttribute(perms);
    
    try {
    	if(Files.notExists(target)){
    		Files.createFile(target);
    	}
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
    
  }
}
