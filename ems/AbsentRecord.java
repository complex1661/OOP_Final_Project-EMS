package ems;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.time.*;
public class AbsentRecord {
  private Message detail;
  private EDate startDate;
  private EDate endDate;
  public AbsentRecord (Message txt, EDate sd, EDate ed) throws IllegalArgumentException{
    detail = txt;
    if (isValidDates(sd, ed)) {
      startDate = sd;
      endDate = ed;
    } else {
      throw new IllegalArgumentException("錯誤的開始結束區間。");
    }
  }
  
  public boolean isValidDates(EDate start, EDate end) {
    if (start.getYear() <= end.getYear() && start.getMonth() <= end.getMonth() && start.getDate() <= end.getDate()) {
      return true;
    }
    else return false;
  }
  
  public String getDetail() {
    return detail.getDetail();
  }
  public int getYear() {
    return startDate.getYear();
  }
  public int getMonth() {
    return startDate.getMonth();
  }
  public int getDate() {
    return startDate.getDate();
  }
  
  public int getDurationWorkdays() {
    Calendar start = startDate.createDate();
    Calendar end = endDate.createDate(); 
    int workdays = 0;
    if (start.getTimeInMillis() == end.getTimeInMillis()) {
        return 0;
    }
    do {
      start.add(Calendar.DAY_OF_MONTH, 1);
      if (start.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && start.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
        ++workdays;
      } 
    }
    while (start.getTimeInMillis() < end.getTimeInMillis());
    return workdays; 
  }
}