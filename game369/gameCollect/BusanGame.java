package gameCollect;

import counter.Counter;
import game.Game369;
import game.Player;

public class BusanGame extends Game369 {

    public BusanGame(Player[] players, Counter clapCounter) {
        super(players, clapCounter, "busan");
    }

    @Override
    public String say(int number) {
        String toString = String.valueOf(number);
        StringBuilder sb = new StringBuilder();
        char[] clapNumbers = {'3','6','9'};
        for(char ch : toString.toCharArray()) {
            for(char clapNum : clapNumbers) {
                if(clapNum==ch) {
                    sb.append("clap");
                    break;
                }
            }
        }
        if(toString.matches(".*[369].*"))
            return sb.toString();
        else
            return toString;
    }
}