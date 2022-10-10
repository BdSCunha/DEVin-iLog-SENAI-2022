public class RepeticaoFor {
    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i++) {
            if(i % 2 == 0) {
                System.out.printf("O numero %d e PAR.\n", i);
            } else {
                System.out.printf("O numero %d e IMPAR.\n", i);
            }
        }
    }
}
