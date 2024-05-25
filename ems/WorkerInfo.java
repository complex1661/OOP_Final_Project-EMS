package ems;
import java.util.*;
import java.io.*;

public class WorkerInfo implements Serializable{
  private static final long serialVersionUID = 1L;
  
  private ArrayList<Worker> workerList;
  private String name;
  private int id;
  private String position;
  public WorkerInfo(ArrayList<Worker> w, String n, int id, String p) {
    workerList = w;
    setName(n);
    setId(id);
    position = p;
  }
  
  public void setName(String n) throws IllegalArgumentException{
    if (n != null && n.length() < 10) {
      name = n;
    } else {
      throw new IllegalArgumentException("錯誤: 無效姓名。");
    }
  }
  
  public void setId(int id) {
    for (Worker worker : workerList) {
      if (worker.getId() == id) {
        throw new IllegalArgumentException("錯誤: 已有此 id。");
      }
    }
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public int getId() {
    return id;
  }
  
  public String getPosition() {
    return position;
  }
}