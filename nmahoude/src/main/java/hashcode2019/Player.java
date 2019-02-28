package hashcode2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Player {
  static final String RESOURCES_FOLDER = "d:\\tmp\\hashcode2019\\";
  
  public static void main(String[] args) {
    String basename = "a_example.txt"; // 16_750_973
    File inputFile = new File(RESOURCES_FOLDER + basename);

    try (Scanner sc = new Scanner(inputFile)) {
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
