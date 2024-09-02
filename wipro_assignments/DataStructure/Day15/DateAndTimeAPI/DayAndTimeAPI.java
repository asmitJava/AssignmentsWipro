package Day15.DateAndTimeAPI;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DayAndTimeAPI {
    public static void main(String[] args) {
        // Step 1: Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Step 2: Ask the user to input the first date
        System.out.print("Enter the first date (yyyy-MM-dd): ");
        String date1Str = scanner.next();

        // Step 3: Ask the user to input the second date
        System.out.print("Enter the second date (yyyy-MM-dd): ");
        String date2Str = scanner.next();

        // Step 4: Parse the input dates using LocalDate
        LocalDate date1 = LocalDate.parse(date1Str);
        LocalDate date2 = LocalDate.parse(date2Str);

        // Step 5: Calculate the number of days between the two dates
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);

        // Step 6: Print the result
        System.out.println("Number of days between " + date1 + " and " + date2 + ": " + daysBetween);
    }
}