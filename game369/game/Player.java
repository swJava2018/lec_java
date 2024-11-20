package game;

public class Player {
    String name;
    double errorRate; // % 저장

    protected Player(){}

    private Player(String name, double errorRate) {
        this.name = name;
        this.errorRate = errorRate;
    }

    public static Player of(String name, double errorRate) {
        return new Player(name, errorRate);
    }

    public boolean isAnswerCorrect() {
        double randomValue = Math.random() * 101; // 0부터 100까지의 값
        return randomValue > errorRate;
    }
}