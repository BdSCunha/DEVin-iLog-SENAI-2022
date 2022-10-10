import java.util.Scanner;
// import java.lang.Math.*;

public class Operadores {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter radius: ");
        float myFloat = input.nextFloat();
        double C = 2 * Math.PI * myFloat;
        System.out.println("Perimeter: " + C);
        input.close();
    }
}
