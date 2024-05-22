package ems;
import java.util.*;
public class Record {
    private ArrayList<AttendanceRecord> attendanceRecords;
    private ArrayList<AbsentRecord> absentRecords;
    private ArrayList<LeaveRecord> leaveRecords;
    private TreeMap<EDate, TreeMap<EDate, Double>> overTimeHours;
    private EDate hiredDate;
    public Record (EDate hiredDate) {
      this.hiredDate = hiredDate;
      attendanceRecords = new ArrayList<>();
      absentRecords = new ArrayList<>();
      leaveRecords = new ArrayList<>();
      overTimeHours = new TreeMap<>();
    }
    
    private boolean isValidMonth(int month) {
      return month > 0 && month < 13;
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
        for (LeaveRecord leaveRecord : leaveRecords) {
          if (leaveRecord.getYear() == year && leaveRecord.getMonth() == month) {
            leaveDays += leaveRecord.getDurationWorkdays();
          }
        }
      }
      return leaveDays;
    }
    
    public int getLeaveDaysThisYear(int year) {
      int leaveDays = 0;
      if (isValidYear(year)) {
        for (LeaveRecord leaveRecord : leaveRecords) {
          if (leaveRecord.getYear() == year) {
            leaveDays += leaveRecord.getDurationWorkdays();
          }
        }
      }
      return leaveDays;
    }
    
    public int getAttendanceDaysThisMonth(int year, int month) {
      int attendanceDays = 0;
      if (isValidYear(year) && isValidMonth(month)) {
        for (AttendanceRecord attendanceRecord : attendanceRecords) {
          if (attendanceRecord.getYear() == year && attendanceRecord.getMonth() == month) {
            attendanceDays++;
          }
        }
      }
      return attendanceDays;
    }
    
    public void addAttendanceRecord(AttendanceRecord r) {
      boolean found = false;
      int i = 0;
      for (AttendanceRecord record : attendanceRecords) {
        if (record.getYear() == r.getYear() && 
        record.getMonth() == record.getMonth() && record.getDate() == r.getDate()) { 
          found = true;
          throw new IllegalArgumentException("此日已經有出席紀錄");
        } 
      }
      if (!found) attendanceRecords.add(r);
    } 
    
    public void addLeaveRecord(LeaveRecord r) {
      leaveRecords.add(r);
    } 
    
    public void addAbsentRecord(AbsentRecord r) {
      absentRecords.add(r);
    }
    
    public void removeAttendanceRecord(AttendanceRecord r) {
      boolean found = false;
      for (AttendanceRecord record : attendanceRecords) {
        if (record.getYear() == r.getYear() && 
            record.getMonth() == record.getMonth() && record.getDate() == r.getDate()) {
          found = true;
          attendanceRecords.remove(record);
        }
      }
      if (!found) throw new IllegalArgumentException("無此出席紀錄"); 
    }
    
    public void removeLeaveRecord(LeaveRecord r) {
      boolean found = false;
      for (LeaveRecord record : leaveRecords) {
        if (record.getYear() == r.getYear() && 
            record.getMonth() == record.getMonth() && record.getDate() == r.getDate()) {
          found = true;
          leaveRecords.remove(record);
        }
      }
      if (!found) throw new IllegalArgumentException("無此請假紀錄"); 
    }
    
    public void removeAbsentRecord(AbsentRecord r) {
      boolean found = false;
      for (AbsentRecord record : absentRecords) {
        if (record.getYear() == r.getYear() && 
            record.getMonth() == record.getMonth() && record.getDate() == r.getDate()) {
          found = true;
          absentRecords.remove(record);
        }
      }
      if (!found) throw new IllegalArgumentException("無此缺勤紀錄"); 
    }

} 