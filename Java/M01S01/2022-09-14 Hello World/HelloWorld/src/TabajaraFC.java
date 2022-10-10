public class TabajaraFC {
    public static void main(String[] args) {
            String time = "Tabajara F.C.";
            int vitorias = 12, derrotas = 2, empates = 6;
            int partidas = vitorias + derrotas + empates;
            int pontos = vitorias*3 + empates;

            System.out.printf("O time %s acumulou %d após jogar %d partidas", time, pontos, partidas);
        }
}
