package ems; 
import java.util.Calendar;
public class AttendanceRecord {
  private EDate attendanceDate;
  private boolean isLate;
  private double hoursWorked;
  private Time start;
  private Time end;
  public AttendanceRecord(EDate date, boolean late, Time start, Time end) {
    setDate(date);
    isLate = late;
    setTime(start, end);
  }
  public void setDate(EDate date) throws IllegalArgumentException {
    Calendar c = Calendar.getInstance();
    if (c.get(Calendar.YEAR) >= date.getYear() && c.get(Calendar.MONTH) >= date.getMonth() && c.get(Calendar.DATE) >= date.getDate()) {
      attendanceDate = date;
    } else {
      throw new IllegalArgumentException("出席的日期不可大於現在的日期。");
    }
  }
  public int getYear () {
    return attendanceDate.getYear();
  }
  public int getMonth() {
    return attendanceDate.getMonth();
  }
  public int getDate() {
    return attendanceDate.getDate();
  }
  public void setTime(Time start, Time end) throws IllegalArgumentException {
    if (start.getHour() >= end.getHour() && start.getMinute() > end.getMinute()) {
      this.start = start;
      this.end = end;
    } else {
      throw new IllegalArgumentException("下班時間不可大於上班時間。");
    }
  }
  public boolean getIsLate() {
    return isLate;
  }
  public static double minuteToHour(int m) {
    double hours = (double) m / 60;
    return Math.ceil(hours * 10) / 10;
  }
  public double getHoursWorked() {
    int m1 = start.toMinute();
    int m2 = end.toMinute();
    int diff = m2 - m1;
    return minuteToHour(diff);
  } 
}