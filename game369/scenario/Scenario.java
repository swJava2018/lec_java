package scenario;

import counter.Counter;
import game.Game369;
import game.Player;
import gameCollect.BusanGame;
import gameCollect.SeoulGame;

public class Scenario {
    Counter counter;

    public Scenario(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        Player[] players = new Player[]{
            Player.of("광수", 0.01),
            Player.of("재석", 0),
            Player.of("석진", 0),
            Player.of("하하", 0)
        };

        Game369[] games = new Game369[]{
            new SeoulGame(players, counter),
            new BusanGame(players, counter),
        };

        for (Game369 game : games) {
            game.start();
        }
        try {
            for (Game369 game : games) {
                game.join();
            }

            int expectedCount = 0;
            for (Game369 game : games) {
                expectedCount += game.getLastIdx();
            }

            int result = counter.getCount();
            System.out.printf("모든 game의 박수 횟수: %d(shared), %d(expected), %s\n", result, expectedCount, result == expectedCount ? "일치" : "불일치");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
