package ems;
public class TestWriteWorker{
  public static void main(String[] args){
    
    
    FullTimeWorker[ ] array= {
    new FullTimeWorker("A",1,"None",new EDate() ),
    new FullTimeWorker("B",2,"None",new EDate() ),
    new FullTimeWorker("C",3,"None",new EDate() )};
  
  SaveWorker output = new SaveWorker();
  for (int i = 0; i < array.length; i++) {
    output.saveFileAs("workers",array[ i]  );
  }
}
}
