package net.tv.twitch.chrono_fish.hueoni;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.tv.twitch.chrono_fish.hueoni.GamePack.HueOniGame;
import net.tv.twitch.chrono_fish.hueoni.GamePack.PlayerState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class HueOniScoreBoard {

    private final Scoreboard board;
    private final Objective obj;
    private final Component boardName = Component.text("=Info=").decorate(TextDecoration.BOLD);

    private final String timer = ChatColor.BOLD+"+Timer";
    private final String yourState = ChatColor.BOLD+"+YourState";
    private final String remainRunners = ChatColor.BOLD+"+RemainRunners";

    public HueOniScoreBoard(Player player){
        board = Bukkit.getScoreboardManager().getNewScoreboard();
        obj = board.registerNewObjective("sidebar", Criteria.DUMMY,boardName);
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        for (int i = 0; i < 4; i++) {
            obj.getScore(generateSpace(i)).setScore(-3 * i);
        }
        setScores(obj,player);
    }

    public void setScores(Objective objective, Player player){
        HueOniGame hueOniGame = HueOni.getGame();
        objective.getScore(timer).setScore(-1);
        objective.getScore("   └???").setScore(-2);

        objective.getScore(yourState).setScore(-4);
        objective.getScore("  └" + hueOniGame.getMap().get(player).getName()).setScore(-5);

        objective.getScore(remainRunners).setScore(-7);
        objective.getScore("   └残り" + hueOniGame.countRunners() + "人").setScore(-8);
    }

    public Scoreboard getBoard() {
        return board;
    }

    public String generateSpace(int count){
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(' ');
        }
        return spaces.toString();
    }

    public void updateState(Player player){
        HueOniGame hueOniGame = HueOni.getGame();
        board.resetScores("  └" + PlayerState.Runner.getName());
        board.resetScores("  └" + PlayerState.Chaser.getName());
        Score state = obj.getScore("  └" + hueOniGame.getMap().get(player).getName());
        state.setScore(-5);
    }

    public void updateRunners(Player player){
        HueOniGame hueOniGame = HueOni.getGame();
        board.resetScores("   └残り" + (hueOniGame.countRunners() +1) + "人");
        obj.getScore("   └残り" + hueOniGame.countRunners() + "人").setScore(-8);
    }
}
