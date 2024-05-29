package ems;
import java.util.*; 
import java.io.*;
public abstract class Worker implements Serializable{
    protected static final long serialVersionUID = 1L;
    
    private String name;
    private int id;
    private String position;
    private WorkerInfo workerInfo;
    private EDate hiredDate;
    private int usedPaidLeaveDays;
    private int hourlyWage;
    public abstract int calculateSalary(int year, int month);
    public abstract int calculateOvertimePay();
    public abstract int calculateBonus();
    public abstract int getRemaingingPaidLeaveDays();
    private Record records;

    public Worker(WorkerInfo wi, EDate hiredDate) {
        workerInfo = wi;
        this.hiredDate = hiredDate;
        records = new Record(hiredDate);
    }
    
    public String getName() {
        return workerInfo.getName();
    }

    public int getId() {
        return workerInfo.getId();
    }

    public String getPosition() {
        return workerInfo.getPosition();
    }
    
    public String getHiredDate() {
        return hiredDate.toString();
    }
    
    public int getLeaveDaysThisMonth(int year, int month) {
      return records.getLeaveDaysThisMonth(year, month);
    }
    
    public int getLeaveDaysThisYear(int year) {
      return records.getLeaveDaysThisYear(year);
    }
    
    public int getAttendanceHoursThisMonth(int year, int month) {
      return records.getAttendanceHoursThisMonth(year, month);
    }
    
    public int getAttendanceDaysThisMonth(int year, int month) {
      return records.getAttendanceDaysThisMonth(year, month);
    }
    
    public void addAttendanceRecord(AttendanceRecord r) {
      records.addAttendanceRecord(r);
    }
    
    public void addLeaveRecord(LeaveRecord r) {
      records.addLeaveRecord(r);
    }
    
    public void addAbsentRecord(LeaveRecord r) {
      records.addAbsentRecord(r);
    }
    
    public void removeAttendanceRecord(AttendanceRecord r) {
      records.removeAttendanceRecord(r);
    }
    
    public void removeLeaveRecord(LeaveRecord r) {
      records.removeLeaveRecord(r);
    } 
    
    public void removeAbsentRecord(AbsentRecord r) {
      records.removeAbsentRecord(r);
    }

}