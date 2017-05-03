/* Project Title: PlagiarismDetector class
* Description: Detects for plagiarism between a group of files.
*
* Created by: Amanda Li, Herbie Turner
* Date: 5/1/17
*/

import java.util.*;
import java.io.File;
public class PlagiarismDetector {
  private String submissions;
  private String sources;
  private static final double PLAGIARISM_THRESHOLD = 0.05;
  private ArrayList<PairReport> reports;

  public PlagiarismDetector(String sub, String srcs) {
    submissions = sub;
    sources = srcs;
    reports = new ArrayList<PairReport>();
  }

  private void generateReports(){
    File sub = new File(submissions);
    File[] submissionsListing = sub.listFiles();
    File sou = new File(sources);
    File[] sourcesListing = sou.listFiles();
    for(File file : submissionsListing){
      for(File file2 : sourcesListing){
        reports.add(new PairReport(file.getName(),file2.getName(),"cleanFull","cleanFull"));
      }
    }
  }
  public ArrayList<PairReport> getAllPotentialOffenders(){
    ArrayList<PairReport> Plagiarized = new ArrayList<PairReport>();
    for(PairReport report : reports){
      if(report.getSimilarityScore()>PLAGIARISM_THRESHOLD){
        Plagiarized.add(report);
      }
    }
    return Plagiarized;
  }
  public void printReports(){
    Collections.sort(reports);
    for(PairReport report : reports)
      System.out.println(report);
  }
  public static void main(String[] args) {
    PlagiarismDetector test = new PlagiarismDetector("wehatecopycats","wehatecopycats");
    test.printReports();
  }
}
