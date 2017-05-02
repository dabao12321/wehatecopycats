/* Project Title: Cleaner class
* Description: 'Static' class with methods to clean strings in various methods.
*
* Created by: Amanda Li, Herbie Turner
* Date: 5/1/17
*/

public class Cleaner {

  // Removes XML tags
  public static String cleanXML(String input) {
    String output = input.replaceAll("<.*?>", "");
    return output;
  }

  // Removes all whitespace except for single spaces
  public static String cleanWhiteSpace(String input) {
    String output = input.replaceAll("   *", " ");
    String tabs = output.replaceAll("\t", "");
    String newlines = tabs.replaceAll("\n", " ");
    if (!output.equals(tabs) || !output.equals(newlines)) {
      output = cleanWhiteSpace(newlines);
    }
    return output;
  }

  // Removes all tags, whitespace, and changes to lowercase
  public static String cleanFull(String input) {
    String output = cleanWhiteSpace(cleanXML(input)).toLowerCase();
    output = output.replaceAll("\\W", "");
    return output;
  }

  // Testing
  public static void main(String[] args) {
    System.out.println(cleanXML("<lk;sajf> lksdjflakj l;jk sj < asldkfja;lsdfj> gjhkgjkh"));
    System.out.println(cleanWhiteSpace("jl;kasd a \n klasjdflskad    kd   al;iej  ksldaow    "));
    System.out.println(cleanFull("<alksjdfhg>lkajfd \t aksjdfh\n lkjasiw<lkdjs>"));
  }
}
