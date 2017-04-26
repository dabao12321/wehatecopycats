public class Cleaner {

  public static String cleanXML(String input) {
    String output = input.replaceAll("<.*>", "");
    return output;
  }

  public static String cleanWhiteSpace(String input) {
    String output = input.replaceAll("   *", " ");
    output = output.replaceAll("\t", "");
    output = output.replaceAll("\n", " ");
    return output;
  }

  public static String cleanFull(String input) {
    String output = cleanWhiteSpace(input);
    output = 
  }
}
