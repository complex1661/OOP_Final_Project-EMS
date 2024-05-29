package ems;
import java.util.*;

public class TestReadFile{
  public static void main(String[] args){
    
    ReadWorker readWorker = new ReadWorker();
    try {
      ArrayList<Worker> workers = readWorker.readFileFrom("ems\\workers");
      int i = 0;
      for (Worker worker : workers) {
        i ++;
        System.out.println("worker" + i + "¡G" +  worker.toString() + ":" + worker.getId() + ", Salary:" + worker.calculateSalary(2024,5));
      }
    } catch (Exception e){
      System.out.println(e);
    }
  }
}