public class Primo {
    public static void main(String[] args) {
        for(int i = 10 ; i < 100 ; i++) {
            if(i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
                System.out.printf("O número %d é PRIMO.\n", i);
            }
        }
    }
}
