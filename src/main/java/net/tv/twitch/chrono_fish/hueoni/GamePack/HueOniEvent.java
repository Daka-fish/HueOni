package net.tv.twitch.chrono_fish.hueoni.GamePack;

import net.tv.twitch.chrono_fish.hueoni.HueOni;
import net.tv.twitch.chrono_fish.hueoni.HueOniScoreBoard;
import net.tv.twitch.chrono_fish.hueoni.State.GameState;
import net.tv.twitch.chrono_fish.hueoni.State.PlayerState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class HueOniEvent implements Listener {

    @EventHandler
    public void onTouch(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
            Player damagerPlayer = (Player) e.getDamager();
            Player damagedPlayer = (Player) e.getEntity();

            PlayerState damagerState = getPlayerState(damagerPlayer);
            PlayerState damagedState = getPlayerState(damagedPlayer);

            if(damagerState.equals(PlayerState.Chaser) && damagedState.equals(PlayerState.Runner)){
                Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(damagedPlayer.getName()+"が捕まりました"));
                HueOniGame hueOniGame = HueOni.getGame();
                int currentRunners = hueOniGame.countRunners();

                hueOniGame.getStateHashMap().put(damagedPlayer.getName(),PlayerState.Chaser);
                hueOniGame.getScoreBoardHashMap().get(damagedPlayer).updatePlayerState(damagedState);
                Bukkit.getOnlinePlayers().forEach(player -> hueOniGame.getScoreBoardHashMap().get(player).updateRunners(currentRunners));

                if(HueOni.getGame().countRunners()==0){
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage("ゲーム終了!"));
                    HueOni.getGame().setGameState(GameState.Finished);
                }
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        HueOniGame hueOniGame = HueOni.getGame();
        int currentRunners = hueOniGame.countRunners();
        hueOniGame.getStateHashMap().put(player.getName(),PlayerState.Runner);
        HueOniScoreBoard board = new HueOniScoreBoard(player);
        player.setScoreboard(board.getBoard());
        hueOniGame.getScoreBoardHashMap().put(player,board);
        Bukkit.getOnlinePlayers().forEach(player1 -> hueOniGame.getScoreBoardHashMap().get(player1).updateRunners(currentRunners));
    }

    public PlayerState getPlayerState(Player player){
        return HueOni.getGame().getStateHashMap().get(player);
    }
}
