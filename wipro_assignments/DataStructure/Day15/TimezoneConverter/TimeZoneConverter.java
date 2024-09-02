package Day15.TimezoneConverter;


import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConverter {
    public static void main(String[] args) {
        // Step 1: Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Step 2: Ask the user to input the original timezone
        System.out.print("Enter the original timezone (e.g. America/New_York): ");
        String originalZoneId = scanner.next();

        // Step 3: Ask the user to input the target timezone
        System.out.print("Enter the target timezone (e.g. Europe/London): ");
        String targetZoneId = scanner.next();

        // Step 4: Ask the user to input the time in the original timezone
        System.out.print("Enter the time in the original timezone (yyyy-MM-dd HH:mm:ss): ");
        String timeStr = scanner.next();

        // Step 5: Parse the input time using ZonedDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime originalTime = ZonedDateTime.parse(timeStr + " " + originalZoneId, formatter);

        // Step 6: Convert the time to the target timezone
        ZonedDateTime targetTime = originalTime.withZoneSameInstant(ZoneId.of(targetZoneId));

        // Step 7: Print the result
        System.out.println("Time in " + targetZoneId + ": " + targetTime.format(formatter));
    }
}