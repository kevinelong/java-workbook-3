package BB_DateBasics;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateFormatDemo {
    public static void main(String[] args) {
        //INPUT - string to dateTime
        String userInput = "12/31/2025 00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime realDate = LocalDateTime.parse(userInput, formatter);

        // OUTPUT dateTime to string
        // Specify the date/time format you will want to use
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("E, MMM dd, yyyy HH:mm:ss");
        String formattedDate = realDate.format(fmt);
        System.out.println("Date is: " + formattedDate);

        //DATE MATH
        LocalDateTime now = LocalDateTime.now();
        System.out.println("NOW: " + now);
        ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
        long epoch = now.atZone(zoneId).toEpochSecond();
        long epoch2 = realDate.atZone(zoneId).toEpochSecond();
        double difference = epoch - epoch2;
        double secondsInDay = 24 * 60 * 60; //2hours time 60minutes time 60seconds
        double dayDiff = Math.abs(difference) / secondsInDay;
        System.out.printf("DAYS APART: %.1f", dayDiff);
    }
}
