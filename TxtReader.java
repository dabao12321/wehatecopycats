/* Project Title: TxtReader class
* Description: Reads a .txt file
*
* Created by: Amanda Li, Herbie Turner
* Date: 5/1/17
*/

public class TxtReader implements Reader{
  String fileName;
  public TxtReader(String file){
    fileName = file;
  }
  public String readFile(){
    String output = "";
    if(fileName.contains(".txt")){
      EasyReader reading = new EasyReader(fileName);
      while(!reading.eof()){
        output+= reading.readLine();
      }
    }
    return output;
  }
}
