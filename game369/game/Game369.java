package game;

import counter.Counter;

public abstract class Game369 extends Thread {

    Player[] players;
    Counter clapCounter;
    String info;
    int lastIdx;

    public Game369(Player[] players, Counter clapCounter, String info) {
        this.players = players;
        this.clapCounter = clapCounter;
        this.info = info;
    }

    /**
     number 에 3,6,9가 포함되면 "clap", 아니면 입력받은 숫자를 String으로 리턴
     do369(16) -> "clap"
     do369(12) -> "12"
     do369(33) -> "clap"
     */
    public abstract String say(int number);

    void playGame() {
        int t = 0;
        while(true) {
            int playerIdx = t % players.length;
            Player player = players[playerIdx];
            String result = say(t+1);

            // 정답을 말하면 숫자 출력, 오답을 말하면 오답 출력
            if(player.isAnswerCorrect()) {
//                print(player.name, result, true);
            } else {
//                print(player.name, result, false);
                break;
            }

            if(result.contains("clap")) {
                clapCounter.increase();
                lastIdx++;
            }
            t++;
        }
    }

    public int getLastIdx() {
        return lastIdx;
    }

    void print(String playerName, String t, boolean isAnswer) {
        String output = "["+this.info+"] " + playerName +": " + t;

        if (t.contains("clap")){
            output += " (누적: " + clapCounter.getCount() + ")";
        }

        if (!isAnswer) {
            output += " (오답)";
        }
        System.out.println(output);
    }

    @Override
    public void run() {
        playGame();
    }
}