package net.tv.twitch.chrono_fish.hueoni.GamePack;

import net.tv.twitch.chrono_fish.hueoni.HueOni;
import net.tv.twitch.chrono_fish.hueoni.HueOniScoreBoard;
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
                HueOni.getGame().getMap().put(damagedPlayer,PlayerState.Chaser);
                HueOni.getScoreMap().get(damagedPlayer).updateAllScore();
                HueOni.getScoreMap().get(damagerPlayer).updateRunners();

                if(HueOni.getGame().countRunners()==0){
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage("ゲーム終了!"));
                    HueOni.getGame().setGameState(HueOniGame.GameState.Finished);
                }
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        HueOni.getGame().getMap().put(player,PlayerState.Runner);
        HueOniScoreBoard board = new HueOniScoreBoard(player);
        player.setScoreboard(board.getBoard());
        HueOni.getScoreMap().put(player,board);
    }

    public PlayerState getPlayerState(Player player){
        return HueOni.getGame().getMap().get(player);
    }
}
