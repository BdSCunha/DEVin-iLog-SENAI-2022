package devinhouseilog.excecoes;

public class UncheckedExceptions {
    public static void main(String[] args) {
        String palavra = null;
        palavra.toUpperCase();  // throws "java.lang.NullPointerException" / Cannot invoke "String.toUpperCase()" because "palavra" is null

        int a = 7, b = 0;
        int c = a/b;                // throws "java.lang.ArithmeticException" / division by zero
        System.out.println(c);

        int[] myNumbers = {1, 2, 3};
        System.out.println(myNumbers[10]);  // throws "java.lang.ArrayIndexOutOfBoundsException" / array does not have index 10

        // final Integer x = 10;
        // x = 25;
    }
}
