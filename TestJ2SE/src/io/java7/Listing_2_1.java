package io.java7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Code for Listing 2_1 - You'll need to change the hardcoded path.
 */
public class Listing_2_1 {

  public static void main(String[] args) throws IOException {

    Path listing = Paths.get("/usr/bin/zip");

    System.out.println("File Name [" + listing.getFileName() + "]");
    System.out.println("Number of Name Elements in the Path ["
        + listing.getNameCount() + "]");
    System.out.println("Parent Path [" + listing.getParent() + "]");
    System.out.println("Root of Path [" + listing.getRoot() + "]");
    System.out.println("Subpath from Root, 2 elements deep ["
        + listing.subpath(0, 2) + "]");
    
    Path listing2 = Paths.get("e:/logs/bin/zip");

    System.out.println("File Name [" + listing2.getFileName() + "]");
    System.out.println("Number of Name Elements in the Path ["
        + listing2.getNameCount() + "]");
    System.out.println("Parent Path [" + listing2.getParent() + "]");
    System.out.println("Root of Path [" + listing2.getRoot() + "]");
    System.out.println("Subpath from Root, 2 elements deep ["
        + listing2.subpath(0, 2) + "]");
   
    File file = new File(".//src//main//java//com//java7developer//chapter2//Listing_2_1.java");
    Path listing3 = file.toPath();
//    System.out.println("File Name [" + listing3.getFileName() + "]");
//    System.out.println("Number of Name Elements in the Path ["
//            + listing3.getNameCount() + "]");
//    System.out.println("Parent Path [" + listing3.getParent() + "]");
    listing3.toRealPath();
    listing3.toAbsolutePath().normalize();
    System.out.println("Root of Path [" + listing3.getRoot()+ "]");
    System.out.println("Parent Path [" + listing3.getParent()+ "]");
    file = listing3.toFile();
    
  }
}
