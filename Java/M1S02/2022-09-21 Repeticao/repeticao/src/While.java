public class While {
    public static void main(String[] args) {
        double invest = 1200.0;

        int anos = 0;

        while(invest < 1000000.0) {
            invest *= 1.1;
            anos++;
        }

        System.out.printf("Para um investimento inicial de R$ 1.200,00, rendendo 10pct a.a., e necessario %d anos para acumular %.2f.", anos, invest);
    }
}
