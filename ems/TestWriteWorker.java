package ems;
import java.util.*;
public class TestWriteWorker{
  public static void main(String[] args){
    ArrayList<Worker> workers = new ArrayList<Worker>();
    Worker w1 = new FullTimeWorker( new WorkerInfo(workers,"Howard",11205024, "工讀生"), new EDate());
    workers.add(w1);
    Worker w2 = new ParttimeWorker( new WorkerInfo(workers,"Ken",1088552, "企劃部員工"), new EDate());
    workers.add(w2);
    Worker w3 = new Supervisor(new WorkerInfo(workers,"Lina",1000624, "企劃部部長"), new EDate());
    workers.add(w3);
    SaveWorker output = new SaveWorker();
    for (Worker worker : workers) {
      output.saveFileAs("ems\\workers", worker);
    }
  }
}