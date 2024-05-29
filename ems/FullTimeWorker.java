package ems;
import java.io.*;
import java.io.Serializable;

public class FullTimeWorker extends Worker implements Serializable {
  private static final long serialVersionUID = 6963351245032407569L;
  private final int paidLeaveDays = 5;
  private final int HOURLY_WAGE = 300;
  public FullTimeWorker(WorkerInfo wi, EDate hiredDate) {
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
  public int getRemaingingPaidLeaveDays() {
    return 0;
  }
}