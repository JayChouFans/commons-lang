/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package io.github.jaychoufans.commons.lang.time;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ly
 */
public class DateUtils {

    // 转换日期

    public static Calendar parseCalender(String datetime) throws ParseException {
        return org.apache.commons.lang3.time.DateUtils.toCalendar(parseDate(datetime));
    }

    public static Date parseDate(String datetime) throws ParseException {
        return org.apache.commons.lang3.time.DateUtils.parseDate(datetime, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    public static long parseTimestamp(String datetime) throws ParseException {
        return parseDate(datetime).getTime();
    }

    // 将日期向下取整

    public static Calendar floorCalendar(final Date date, final int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return floorCalendar(calendar, field);
    }

    public static Calendar floorCalendar(final long timestamp, final int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return floorCalendar(calendar, field);
    }

    public static Calendar floorCalendar(final Calendar calendar, final int field) {
        calendar.set(Calendar.MILLISECOND, 0);
        if (Calendar.MILLISECOND == field) {
            return calendar;
        }

        calendar.set(Calendar.SECOND, 0);
        if (Calendar.SECOND == field) {
            return calendar;
        }

        calendar.set(Calendar.MINUTE, 0);
        if (Calendar.MINUTE == field) {
            return calendar;
        }

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        if (Calendar.HOUR_OF_DAY == field) {
            return calendar;
        }

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        if (Calendar.DAY_OF_MONTH == field) {
            return calendar;
        }

        calendar.set(Calendar.MONTH, 0);
        if (Calendar.MONTH == field) {
            return calendar;
        }

        throw new IllegalArgumentException("THe field is invalid");
    }

    public static Date floorDate(final Date date, final int field) {
        return floorCalendar(date, field).getTime();
    }

    public static Date floorDate(final long timestamp, final int field) {
        return floorCalendar(timestamp, field).getTime();
    }

    public static Date floorDate(final Calendar calendar, final int field) {
        return floorCalendar(calendar, field).getTime();
    }

    public static long floorTimestamp(final Date date, final int field) {
        return floorCalendar(date, field).getTimeInMillis();
    }

    public static long floorTimestamp(final long timestamp, final int field) {
        return floorCalendar(timestamp, field).getTimeInMillis();
    }

    public static long floorTimestamp(final Calendar calendar, final int field) {
        return floorCalendar(calendar, field).getTimeInMillis();
    }

}
