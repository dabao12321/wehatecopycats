/* Project Title: PairReport class
* Description: Allows two files to be cleaned and compared using both detectors
* and by implementing the comparable interface.
*
* Created by: Amanda Li, Herbie Turner
* Date: 5/1/17
*/

import java.util.*;

public class PairReport implements Comparable<PairReport> {

  private String file1;
  private String file2;
  private String cleanerFile1;
  private String cleanerFile2;
  private Detector detector;

  public PairReport(String s1, String s2, String cf1, String cf2) {
    file1 = s1;
    file2 = s2;
    cleanerFile1 = cf1;
    cleanerFile2 = cf2;
    DocXReader one = new DocXReader(file1);
    DocXReader two = new DocXReader(file2);
    detector = new Detector(Cleaner.cleanFull(one.readFile()), Cleaner.cleanFull(two.readFile()));
  }

  public String getf1() {
    return file1;
  }

  public String getf2() {
    return file2;
  }

  public String getcf1() {
    return cleanerFile1;
  }

  public String getcf2() {
    return cleanerFile2;
  }

  public Detector getDetector() {
    return detector;
  }

  public String getDetectors1() {
    return detector.getString1();
  }

  public String getDetectors2() {
    return detector.getString2();
  }

  public double getSimilarityScore() {
    return detector.getSimilarityScore();
  }

  public ArrayList<String> getCList() {
    return detector.getCList();
  }

  public int compareTo(PairReport other) {
    if (this.getSimilarityScore() == other.getSimilarityScore()) {
      return 0;
    }
    else if (this.getSimilarityScore() > other.getSimilarityScore()) {
      return 1;
    }
    else {
      return -1;
    }
  }

  public String toString() {
    String output = "File 1: " + file1 + "\nFile2: " + file2 + "\nSimilarity score: "
                               + getSimilarityScore() + "\nLength of CList: " + getCList().size()
                               + "\nLongest similar substring: " + getCList().get(0);
    return output;
  }

}
