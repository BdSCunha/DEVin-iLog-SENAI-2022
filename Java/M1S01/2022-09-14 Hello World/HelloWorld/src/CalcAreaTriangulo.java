public class CalcAreaTriangulo {
    public static void main(String[] args) {
        float base = .12F, altura = .08F;

        float area = (base*altura)/2;

        System.out.printf("Um triângulo com base de %.2fcm e altura %.2fcm, tem uma área de %.4fcm².", base, altura, area);
    }
}
