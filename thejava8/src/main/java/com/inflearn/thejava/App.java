package com.inflearn.thejava;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {

  public static void main(String[] args) {
      Date date = new Date(); //레거시 API
      Instant instant = date.toInstant(); //레거시 API to java8 time API
      Date newDate = Date.from(instant); //java8 Time API to 레거시 API

      GregorianCalendar gregorianCalendar = new GregorianCalendar(); // 이전 그레고리 캘린더 인스턴스를
      LocalDateTime dateTime1 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // LocalDateTime으로 바꿀 수 있음.
      ZonedDateTime dateTime2 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
      GregorianCalendar from = GregorianCalendar.from(dateTime2);

      ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId(); //최근
      TimeZone timeZone  = TimeZone.getTimeZone(zoneId); //레거시

      LocalDateTime now = LocalDateTime.now();
      LocalDateTime plus = now.plus(10, ChronoUnit.MINUTES);
      System.out.println(plus); //현재 시간에서 10분이 추가되었음.
  }
}
