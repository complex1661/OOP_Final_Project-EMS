package ems;
import java.util.Calendar;
import java.io.*;

public class EDate implements Serializable{
  private static final long serialVersionUID = 1L;
  
    private int year;
    private int month;
    private int date;
    public EDate() {
      Calendar c = Calendar.getInstance();
      year = c.get(Calendar.YEAR);
      month = c.get(Calendar.MONTH);
      date = c.get(Calendar.DATE);
    } 
    public EDate(int y, int m, int d) {
      setDate(y, m, d);
    }
    
    public void setDate(int year, int month, int date) throws IllegalArgumentException{
      if (isValidDate(year, month, date)) {
        this.year = year; 
        this.month = month;
        this.date = date;
      } else {
        throw new IllegalArgumentException("無效的日期。");
      }
    }
    
    public int getYear() {
      return year;
    }
    public int getMonth() {
      return month;
    }
    public int getDate() {
      return date;
    }
    
    private int getMaxDaysInMonth(int year, int month) {
    int maxDaysInMonth = 0;

    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
        maxDaysInMonth = 31;
    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
        maxDaysInMonth = 30;
    } else if (month == 2) {
        maxDaysInMonth = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
    }

    return maxDaysInMonth;
    }
    
    private boolean isValidDate(int year, int month, int date) {
      Calendar cd = Calendar.getInstance();
      int curr_year = cd.get(Calendar.YEAR);
      if (year < 0 || month < 1 || month > 12 || date < 1 || year > curr_year) {
        return false;
      }
      int maxDaysInMonth = getMaxDaysInMonth(year, month);
      return date <= maxDaysInMonth;
    }
    
    public String toString() {
      return year + " 年 " + month + " 月 " + date + " 日";
    }
    
    public String toDateString() {
      String s = year + "-";
      String m = month + "-";
      if (month < 10) m = "0" + m;
      String d = Integer.toString(date);
      if (date < 10) d = "0" + d;
      s = s + m + d;
      return s;
    }
    
    public Calendar createDate() {
      Calendar cal = Calendar.getInstance();
      cal.set(year, month - 1, date);
      return cal;
    }
}

