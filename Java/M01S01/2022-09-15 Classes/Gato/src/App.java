import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Please enter your date of birth (YYYY-MM-DD): ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        LocalDate dob = LocalDate.parse(input);

        LocalDate curDate = LocalDate.now();

        int age = Period.between(dob, curDate).getYears();

        System.out.println("You are " + age + " years old.");
    }
}
