package io.github.jaychoufans.commons.lang.time;

import com.sun.istack.internal.NotNull;

import java.util.Calendar;
import java.util.Date;

/**
 * @author ly
 */
public class DateUtils {

    // 将日期向下取整

    public static Calendar floorCalendar(@NotNull Date date, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return floorCalendar(calendar, field);
    }

    public static Calendar floorCalendar(@NotNull long timestamp, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return floorCalendar(calendar, field);
    }

    public static Calendar floorCalendar(@NotNull Calendar calendar, int field) {
        calendar.set(Calendar.MILLISECOND, 0);
        if (Calendar.MILLISECOND == field) {
            return calendar;
        }

        calendar.set(Calendar.SECOND, 0);
        if (Calendar.SECOND == field) {
            return calendar;
        }

        calendar.set(Calendar.MINUTE, 0);
        if (Calendar.YEAR == field) {
            return calendar;
        }

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        if (Calendar.HOUR_OF_DAY == field) {
            return calendar;
        }

        calendar.set(Calendar.DAY_OF_MONTH, 0);
        if (Calendar.DAY_OF_MONTH == field) {
            return calendar;
        }

        calendar.set(Calendar.MONTH, 0);
        if (Calendar.MONTH == field) {
            return calendar;
        }

        throw new IllegalArgumentException("THe field is invalid");
    }

    public static Date floorDate(@NotNull Date date, int field) {
        return floorCalendar(date, field).getTime();
    }

    public static Date floorDate(@NotNull long timestamp, int field) {
        return floorCalendar(timestamp, field).getTime();
    }

    public static Date floorDate(@NotNull Calendar calendar, int field) {
        return floorCalendar(calendar, field).getTime();
    }

    public static long floorTimestamp(@NotNull Date date, int field) {
        return floorCalendar(date, field).getTimeInMillis();
    }

    public static long floorTimestamp(@NotNull long timestamp, int field) {
        return floorCalendar(timestamp, field).getTimeInMillis();
    }

    public static long floorTimestamp(@NotNull Calendar calendar, int field) {
        return floorCalendar(calendar, field).getTimeInMillis();
    }

}
