package ems;
import java.io.*;

public class FullTimeWorker extends Worker{
  
  private final int paidLeaveDays = 5;
  public FullTimeWorker(WorkerInfo wi, EDate hiredDate) {
    super(wi, hiredDate);
  }
  public int calculateSalary() {
    return 0;
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