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

import junit.framework.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DateUtilsTest {

    @Test
    public void floorCalendar() throws ParseException {
        final Date date = DateUtils.parseDate("2019-08-30 12:03:05.123");
        final Calendar calendar = org.apache.commons.lang3.time.DateUtils.toCalendar(date);
        final long timestamp = date.getTime();

        Assert.assertEquals(DateUtils.floorCalendar(calendar, Calendar.SECOND), DateUtils.parseCalender("2019-08-30 12:03:00.000"));
        Assert.assertEquals(DateUtils.floorCalendar(date, Calendar.MILLISECOND), DateUtils.parseCalender("2019-08-30 12:03:05.000"));
        Assert.assertEquals(DateUtils.floorCalendar(timestamp, Calendar.MINUTE), DateUtils.parseCalender("2019-08-30 12:00:00.000"));

        Assert.assertEquals(DateUtils.floorDate(calendar, Calendar.DAY_OF_MONTH), DateUtils.parseDate("2019-08-01 00:00:00.000"));
        Assert.assertEquals(DateUtils.floorDate(date, Calendar.HOUR_OF_DAY), DateUtils.parseDate("2019-08-30 00:00:00.000"));
        Assert.assertEquals(DateUtils.floorDate(timestamp, Calendar.MONTH), DateUtils.parseDate("2019-01-01 00:00:00.000"));

        Assert.assertEquals(DateUtils.floorTimestamp(calendar, Calendar.DAY_OF_MONTH), DateUtils.parseTimestamp("2019-08-01 00:00:00.000"));
        Assert.assertEquals(DateUtils.floorTimestamp(date, Calendar.HOUR_OF_DAY), DateUtils.parseTimestamp("2019-08-30 00:00:00.000"));
        Assert.assertEquals(DateUtils.floorTimestamp(timestamp, Calendar.MONTH), DateUtils.parseTimestamp("2019-01-01 00:00:00.000"));
    }

}
