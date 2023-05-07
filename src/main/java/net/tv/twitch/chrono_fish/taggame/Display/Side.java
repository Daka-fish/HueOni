package net.tv.twitch.chrono_fish.taggame.Display;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Side {

    private static Scoreboard board;

    public static void setBoard(Player player){
        Objective obj = board.registerNewObjective("sidebar","dummy");
    }
}
