package ems;
import java.util.Calendar;
public class Time {
  private int hour;
  private int minute;
  public Time () {
    Calendar c = Calendar.getInstance();
    hour = c.get(Calendar.HOUR_OF_DAY);
    minute = c.get(Calendar.MINUTE);
  }
  public Time (int h, int m) {
    setHour(h);
    setMinute(m);
  }
  public void setHour(int h) throws IllegalArgumentException{
    if (h >= 0 && h <= 24) {
      hour = h;
    } else {
      throw new IllegalArgumentException("無效的時數。");
    }
  } 
  public void setMinute(int m) throws IllegalArgumentException {
    if (m >= 0 && m <= 59) {
      minute = m;
    } else {
      throw new IllegalArgumentException("無效的時數。");
    }
  }
  
  public int getHour() {
    return hour;
  }
  
  public int getMinute() {
    return minute;
  }
  public String toString() {
    String temp = "";
    int thour = hour;
    if (hour >= 12 && hour <= 23) {
      temp = "PM ";
      if (hour > 12 && hour <= 23) {
        thour -= 12;
      }
    } else {
      if (hour == 24) thour = 12; 
      temp = "AM ";
    }
    return temp +thour + ":00 " + minute + "分";
  } 
  
  public int toMinute() {
    return hour * 60 + minute;
  }
}