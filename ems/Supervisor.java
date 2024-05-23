package ems;
public class Supervisor extends Worker{
  private final int paidLeaveDays = 7;
  public Supervisor(String name, int id, String position, EDate hiredDate) {
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