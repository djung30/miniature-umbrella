public class Cereal {
    private double rating;
    private int sugar;
    private String name;
    private char type;

    public Cereal(double rating, int sugar, String name, char type) {
        this.rating = rating;
        this.sugar = sugar;
        this.name = name;
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public int getSugar() {
        return sugar;
    }

    public String getName() {
        return name;
    }

    public char getType() {
        return type;
    }

    public String toString() {
        return "Name:" + name + " Type:" + type + " Rating:" + rating + " Sugar:" + sugar;
    }

    public static void main(String[] args) {
        Cereal allBran = new Cereal(59.42, 5, "All-Bran", 'C');
        Cereal honeyNut = new Cereal(48.32, 5, "Honey Nut", 'C');
        System.out.println(allBran);
        System.out.println(honeyNut);
    }
}
