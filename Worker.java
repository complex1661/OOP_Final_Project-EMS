package ems;
import java.util.*; 
public abstract class Worker {
    private String name;
    private int id;
    private String position;
    private EDate hiredDate;
    private int salary;
    private int paidLeaveDays = 0;
    protected abstract int calculateSalary();
    protected abstract int calculateOvertimePay();
    protected abstract int calculateBonus();
    private ArrayList<AttendanceRecord> attendanceRecords;
    private ArrayList<AbsentRecord> absentRecords;
    private ArrayList<LeaveRecord> leaveRecords;
    private TreeMap<Date, TreeMap<Date, Double>> overTimeHours;

    public Worker(String name, int id, String position, EDate hiredDate) {
        setName(name);
        setId(id);
        setPosition(position);
        setHiredDate(hiredDate);
        this.attendanceRecords = new ArrayList<>();
        this.absentRecords = new ArrayList<>();
        this.leaveRecords = new ArrayList<>();
        this.overTimeHours = new TreeMap<>();
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

    public void setHiredDate(EDate hiredDate) {
        this.hiredDate = hiredDate;
    }
    
    private boolean isValidMonth(int month) {
      if (month > 1 && month < 12) {
        return true;
      } else {
        return false;
      }
    }
    
    private boolean isValidYear(int year) {
      Calendar cd = Calendar.getInstance();
      if (year > hiredDate.getYear() && year < cd.get(Calendar.YEAR)) {
        return true;
      } else {
        return false;
      }
    }
    
    public int getLeaveDaysThisMonth(int year, int month) {
      int leaveDays = 0;
      if (isValidYear(year) && isValidMonth(month)) {
        for (int i = 0; i < leaveRecords.size(); i++) {
          if (leaveRecords.get(i).getYear() == year && leaveRecords.get(i).getMonth() == month) {
            leaveDays += leaveRecords.get(i).getDurationWorkdays();
          }
        }
      }
      return leaveDays;
    }
    
    public int getLeaveDaysThisYear(int year) {
      int leaveDays = 0;
      if (isValidYear(year)) {
        for (int i = 0; i < leaveRecords.size(); i++) {
          if (leaveRecords.get(i).getYear() == year) {
            leaveDays += leaveRecords.get(i).getDurationWorkdays();
          }
        }
      }
      return leaveDays;
    }
    
    public int getAttendanceDaysThisMonth(int year, int month) {
      int attendanceDays = 0;
      if (isValidYear(year) && isValidMonth(month)) {
        for (int i = 0; i < attendanceRecords.size(); i++) {
          if (attendanceRecords.get(i).getYear() == year && attendanceRecords.get(i).getMonth() == month) {
            attendanceDays++;
          }
        }
      }
      return attendanceDays;
    }
}