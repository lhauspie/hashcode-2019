package hashcode2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Player {
  static final String RESOURCES_FOLDER = "d:\\tmp\\hashcode2019\\";
  
  public static void main(String[] args) {
    String basename = "c_no_hurry"; // 16_750_973
    File inputFile = new File(RESOURCES_FOLDER + basename + ".in");

    try (Scanner sc = new Scanner(inputFile)) {

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
