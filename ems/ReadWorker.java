package ems;
import java.io.*;
import java.util.*;

public class ReadWorker extends ReadFile{
  
  public ArrayList<Worker> readFileFrom(String dirPath) throws Exception{
    
    ArrayList<Worker> workerList = new ArrayList<Worker>();
    File dir = new File(dirPath);
    if (dir.exists() && dir.isDirectory()){
      File[] files = dir.listFiles();
      
      if (files != null) {
        for (File file : files) {
          if (file.isFile() && file.getName().endsWith(".dat")) {
            Worker worker = getWorker(file);
            if (worker != null) {
              workerList.add(worker);
            }
          }
        }
        return workerList;
          
      } else {
        throw new Exception("目錄中沒有檔案");
      }
      
    } else {
      throw new Exception("目錄不存在");
    }
  }
  private Worker getWorker(File file){
    
    try(FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream input = new ObjectInputStream(fileIn)) {
          return (Worker)input.readObject();
          
    } catch (IOException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}