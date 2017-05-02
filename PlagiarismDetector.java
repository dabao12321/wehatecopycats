/* Project Title: PlagiarismDetector class
* Description: Detects for plagiarism between a group of files.
*
* Created by: Amanda Li, Herbie Turner
* Date: 5/1/17
*/

import java.util.*;

public class PlagiarismDetector {
  private String submissions;
  private String sources;
  private static final double PLAGIARISM_THRESHOLD = 0.1;
  private ArrayList<PairReport> reports;

  public PlagiarismDetector(String sub, String srcs) {
    submissions = sub;
    sources = srcs;
    // may need to add stuff for report ArrayList
  }



}
