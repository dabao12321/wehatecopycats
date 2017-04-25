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
