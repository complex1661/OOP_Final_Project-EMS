package ems;
import java.util.*;
import java.io.Serializable;

public class ParttimeWorker extends Worker implements Serializable {
  private static final long serialVersionUID = 1L; 
  private final int paidLeaveDays = 3;
  private final int HOURLY_WAGE = 200;
  public ParttimeWorker(WorkerInfo wi, EDate hiredDate) {
    super(wi, hiredDate);
  }
  
  public int calculateSalary(int year, int month) {
      int attendanceHours = getAttendanceHoursThisMonth(year, month);
      return attendanceHours * HOURLY_WAGE;
  }
  
  @Override
  public int calculateOvertimePay() {
    return 0;
  }
  
  @Override
  public int calculateBonus() {
    return 0;
  }
  
  @Override
  public int getRemaingingPaidLeaveDays() {
    return 0;
  }
}