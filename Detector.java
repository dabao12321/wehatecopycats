import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Detector{
  private final String string1;
  private final String string2;
  private final double similarityScore;
  private ArrayList<String> cList;
  public Detector(String one, String two){
    string1 = one;
    string2 = two;
    cList = new ArrayList<String>();
    similarityScore = setSimilarityScore();
  }
  public String getString1(){
    return string1;
  }
  public String getString2(){
    return string2;
  }
  public ArrayList<String> getCList(){
    return cList;
  }
  public double getSimilarityScore(){
    return similarityScore;
  }
  private double setSimilarityScore(){
    return scoreHelper(string1, string2)/(string1.length() + string2.length());
  }
  private double scoreHelper(String one, String two){
    int score = 0;
    int maxi = 0;
    int maxj = 0;
    int index = 0;
    int maxlength = 0;
    for(int i = 0; i < one.length(); i++){
      for(int j = one.length(); j > i; j--){
        if(two.contains(one.substring(i,j))){
          if(one.substring(i,j).length()>maxlength){
            maxi = i;
            maxj = j;
            index = two.indexOf(one.substring(i,j));
            maxlength = one.substring(i,j).length();
          }
        }
      }
    }
    if(maxlength==0)
      return 0;
    score+= 2*maxlength;
    cList.add(one.substring(maxi,maxj));
    if(maxi > 0 && index > 0){
      score+= scoreHelper(one.substring(0,maxi),two.substring(0,index));
    }
    if(maxj < one.length() && index + maxlength < two.length()){
      score += scoreHelper(one.substring(maxj),two.substring(index+maxlength));
    }
    return score;
  }
  public static void main(String[] args) {
    Detector test = new Detector("sotestwaseasy", "testingsoeasy");
    System.out.println(test.similarityScore);
    System.out.println(test.cList);
    Detector test2 = new Detector("Pennsylvania", "Pencilvaneya");
    System.out.println(test2.similarityScore);
    System.out.println(test2.cList);
  }
}

// if((i==0 && j==one.length()) || two.length()== j - i){
//   cList.add(one.substring(i,j));
//   return 2*one.substring(i,j).length();
// }
// cList.add(one.substring(i,j));
// score+= 2* one.substring(i,j).length();
// if(i!=0){
//   if(two.indexOf(one.substring(i,j))!=0)
//   {
//     cList.add(one.substring(i,j));
//     score+=scoreHelper(one.substring(0,i), two.substring(0,two.indexOf(one.substring(i,j))));
//   }
// }
// if(j!= one.length()){
//   if(two.indexOf(one.substring(i,j))+one.substring(i,j).length() < two.length()){
//     cList.add(one.substring(i,j));
//     score+=scoreHelper(one.substring(j), two.substring(two.indexOf(one.substring(i,j))));
//   }
// }
// return score;
