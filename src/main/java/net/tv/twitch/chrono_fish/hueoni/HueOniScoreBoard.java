package net.tv.twitch.chrono_fish.hueoni;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.tv.twitch.chrono_fish.hueoni.GamePack.HueOniGame;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class HueOniScoreBoard {

    private final Scoreboard board;
    private final Objective obj;
    private final Component boardName = Component.text("=Info=").decorate(TextDecoration.BOLD);

    private final String timer = "+Timer";
    private final String yourState = "+YourState";
    private final String remainRunners = "+RemainRunners";

    public HueOniScoreBoard(Player player){
        board = Bukkit.getScoreboardManager().getNewScoreboard();
        obj = board.registerNewObjective("sidebar", Criteria.DUMMY,boardName);
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score s = obj.getScore("");
        s.setScore(0);
        setScores(obj,player);
    }

    public Scoreboard getBoard() {
        return board;
    }

    public void setScores(Objective objective, Player player){
        HueOniGame hueOniGame = HueOni.getGame();
        Score timerScore = objective.getScore(timer);
        timerScore.setScore(-1);
        Score time = objective.getScore("   └???");
        time.setScore(-2);
        Score stateScore = objective.getScore(yourState);
        stateScore.setScore(-3);
        Score state = objective.getScore("  └"+hueOniGame.getMap().get(player).name());
        state.setScore(-4);
        Score runnersScore = objective.getScore(remainRunners);
        runnersScore.setScore(-5);
        Score runnersCount = objective.getScore("   └"+"残り"+hueOniGame.countRunners()+"人");
        runnersCount.setScore(-6);
    }

    public void timeManage(){

    }
}
