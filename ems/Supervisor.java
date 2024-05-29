package ems;
import java.io.Serializable;

public class Supervisor extends Worker implements Serializable {
  private static final long serialVersionUID = 850907973944035666L;
  private final int paidLeaveDays = 7;
  private final int HOURLY_WAGE = 500;
  
  public Supervisor(WorkerInfo wi, EDate hiredDate) {
    super(wi, hiredDate);
  }
  
  public int calculateSalary(int year, int month) {
    int attendanceHours = getAttendanceHoursThisMonth(year, month);
    return attendanceHours * HOURLY_WAGE;
  }
  
  public int calculateOvertimePay() {
    return 0;
  }
  
  public int calculateBonus() {
    return 0;
  }
  
  public int getRemaingingPaidLeaveDays() {
    return 0;
  }
}