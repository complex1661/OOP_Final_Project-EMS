package ems;
public class ParttimeWorker extends Worker{
  private final int paidLeaveDays = 3;
  public ParttimeWorker(String name, int id, String position, EDate hiredDate) {
    super(name, id, position, hiredDate);
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