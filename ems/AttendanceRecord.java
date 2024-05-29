package ems;

import java.io.Serializable;
import java.util.Calendar;

public class AttendanceRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private EDate attendanceDate;
    private boolean isLate;
    private Time start;
    private Time end;

    public AttendanceRecord(EDate date, boolean late, Time start, Time end) {
        setDate(date);
        isLate = late;
        setTime(start, end);
    }

    public void setDate(EDate date) throws IllegalArgumentException {
        Calendar current = Calendar.getInstance();
        Calendar given = Calendar.getInstance();
        given.set(date.getYear(), date.getMonth() - 1, date.getDate()); // Adjust month indexing

        // Clear the time part for accurate date-only comparison
        current.set(Calendar.HOUR_OF_DAY, 0);
        current.set(Calendar.MINUTE, 0);
        current.set(Calendar.SECOND, 0);
        current.set(Calendar.MILLISECOND, 0);

        if (given.before(current) || given.equals(current)) {
            attendanceDate = date;
        } else {
            throw new IllegalArgumentException("出席的日期不可大於現在的日期。");
        }
    }

    public int getYear() {
        return attendanceDate.getYear();
    }

    public int getMonth() {
        return attendanceDate.getMonth();
    }

    public int getDate() {
        return attendanceDate.getDate();
    }

    public void setTime(Time start, Time end) throws IllegalArgumentException {
        if (start.getHour() < end.getHour() || (start.getHour() == end.getHour() && start.getMinute() <= end.getMinute())) {
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
