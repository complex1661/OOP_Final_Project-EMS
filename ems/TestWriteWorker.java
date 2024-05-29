package ems;
import java.util.*;
public class TestWriteWorker{
  public static void main(String[] args){
    ArrayList<Worker> workers = new ArrayList<Worker>();
    Worker w1 = new FullTimeWorker( new WorkerInfo(workers,"Howard",11205024, "工讀生"), new EDate());
    workers.add(w1);
    AttendanceRecord attend = new AttendanceRecord(new EDate(2024,5,1), false, new Time(8,0), new Time(17,0));
    AttendanceRecord attend2 = new AttendanceRecord(new EDate(2024,5,2), false, new Time(8,0), new Time(17,0));
    AttendanceRecord attend3 = new AttendanceRecord(new EDate(2024,5,3), false, new Time(8,0), new Time(17,0));
    AttendanceRecord attend4 = new AttendanceRecord(new EDate(2024,5,4), false, new Time(8,0), new Time(17,0));
    AttendanceRecord attend5 = new AttendanceRecord(new EDate(2024,5,5), false, new Time(8,0), new Time(17,0));
    w1.addAttendanceRecord(attend);
    w1.addAttendanceRecord(attend2);
    w1.addAttendanceRecord(attend3);
    w1.addAttendanceRecord(attend4);
    w1.addAttendanceRecord(attend5);
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