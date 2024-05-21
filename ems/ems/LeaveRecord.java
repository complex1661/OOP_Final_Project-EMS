package ems;
public class LeaveRecord extends AbsentRecord {
  private String leaveType;
  public LeaveRecord(String leaveType, Message txt, EDate sd, EDate ed) {
    super(txt, sd, ed);
    setLeaveType(leaveType); 
  }
  public void setLeaveType(String s) throws IllegalArgumentException {
    if (s != null) {
      leaveType = s;
    } else {
      throw new IllegalArgumentException("請假種類不可為空。");
    }
  }
  public String getLeaveType() {
    return leaveType;
  }
}