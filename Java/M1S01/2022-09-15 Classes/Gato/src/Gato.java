public class Gato {
    public String name;
    public char gender;
    public int age;
    public int weight;
    public String color;

    public String eat(String food) {
        return("Eating " + food);
    }

    public String run(String dest) {
        return("Running to" + dest);
    }

    public static void sleep(int hours) {
        System.out.println("Cat will now sleep for " + hours + " hours.");
    }

    public String meow() {
        return("Meoooow!");
    }
}