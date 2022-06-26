package pl.jakubdrozdz;

public class Player {
    private final String name;
    private final double points;
    private final int firstTries;
    private final double total;

    public Player(String name, double points, int firstTries, double total) {
        this.name = name;
        this.points = points;
        this.firstTries = firstTries;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public double getPoints() {
        return points;
    }


    public int getFirstTries() {
        return firstTries;
    }

    public double getTotal() {
        return total;
    }

}
