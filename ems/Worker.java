package ems;
import java.util.*; 
public abstract class Worker {
    protected static final long serialVersionUID = 1L;
    
    private String name;
    private int id;
    private String position;
    private EDate hiredDate;
    private int salary;
    private int usedPaidLeaveDays;
    protected abstract int calculateSalary();
    protected abstract int calculateOvertimePay();
    protected abstract int calculateBonus();
    protected abstract int getRemaingingPaidLeaveDays();
    private Record records;

    public Worker(String name, int id, String position, EDate hiredDate) {
        setName(name);
        setId(id);
        setPosition(position);
        this.hiredDate = hiredDate;
        records = new Record(hiredDate);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
      if (name == null || name.length() > 10) {
        throw new IllegalArgumentException("無效的名字。");
      } 
      else this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id == 0) throw new IllegalArgumentException("無效的名字。");
        else this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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