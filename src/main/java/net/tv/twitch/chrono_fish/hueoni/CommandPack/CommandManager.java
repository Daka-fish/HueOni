package net.tv.twitch.chrono_fish.hueoni.CommandPack;

import net.tv.twitch.chrono_fish.hueoni.GamePack.HueOniGame;
import net.tv.twitch.chrono_fish.hueoni.ItemPack.ItemManager;
import net.tv.twitch.chrono_fish.hueoni.State.GameState;
import net.tv.twitch.chrono_fish.hueoni.State.PlayerState;
import net.tv.twitch.chrono_fish.hueoni.HueOni;
import net.tv.twitch.chrono_fish.hueoni.GamePack.TimeManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Map;

public class CommandManager {
    public static void hueOni(Player sender, String[] args){
        HueOniGame hueOniGame = HueOni.getGame();
        switch(args[0]){
            case "start":
                GameState currentgameState = hueOniGame.getGameState();
                if(currentgameState.equals(GameState.Finished)){
                    if(hueOniGame.countChasers() < 2){
                        sender.sendMessage(ChatColor.RED+"鬼の数が足りません" +
                                        "(あと"+(hueOniGame.getNumberOfFirstOni()- hueOniGame.countChasers())+"人)");
                        return;
                    }
                    sender.sendMessage("ゲームを開始します");
                    hueOniGame.setGameState(GameState.Running);
                    Bukkit.getOnlinePlayers().forEach(player -> hueOniGame.getScoreBoardHashMap().get(player).updateGameState(currentgameState));

                    new TimeManager().runTaskTimer(HueOni.getInstance(),0L,20L);
                    return;
                }
                break;

            case "oni":
                if(args.length<2){
                    sender.sendMessage(ChatColor.RED+"/hueOni oni {playerName}");
                    return;
                }
                Player oTarget = Bukkit.getPlayerExact(args[1]);
                if(oTarget == null){
                    sender.sendMessage(ChatColor.RED+args[1]+"が見つかりません!");
                    return;
                }
                sender.sendMessage(ChatColor.YELLOW+oTarget.getName()+ChatColor.RESET+"を鬼にしました");
                oTarget.getInventory().addItem(HueOni.getItemManager().getItemMap().get("stick").getItemStack());

                PlayerState currentPlayerState1 = hueOniGame.getStateHashMap().get(oTarget.getName());
                int currentRunners1 = hueOniGame.countRunners();

                hueOniGame.getStateHashMap().put(oTarget.getName(),PlayerState.Chaser);
                hueOniGame.getScoreBoardHashMap().get(oTarget).updatePlayerState(currentPlayerState1);
                Bukkit.getOnlinePlayers().forEach(player -> hueOniGame.getScoreBoardHashMap().get(player).updateRunners(currentRunners1));
                break;

            case "nige":
                if(args.length<2){
                    sender.sendMessage(ChatColor.RED+"/hueOni nige {playerName}");
                    return;
                }
                Player nTarget = Bukkit.getPlayerExact(args[1]);
                if(nTarget == null){
                    sender.sendMessage(ChatColor.RED+args[1]+"が見つかりません!");
                    return;
                }
                sender.sendMessage(ChatColor.YELLOW+nTarget.getName()+ChatColor.RESET+"を逃げにしました");

                PlayerState currentPlayerState2 = hueOniGame.getStateHashMap().get(nTarget.getName());
                int currentRunners2 = hueOniGame.countRunners();

                hueOniGame.getStateHashMap().put(nTarget.getName(),PlayerState.Runner);
                hueOniGame.getScoreBoardHashMap().get(nTarget).updatePlayerState(currentPlayerState2);
                Bukkit.getOnlinePlayers().forEach(player -> hueOniGame.getScoreBoardHashMap().get(player).updateRunners(currentRunners2));
                break;

            case "check":
                for(Map.Entry<String, PlayerState> entry:hueOniGame.getStateHashMap().entrySet()){
                    sender.sendMessage(ChatColor.YELLOW+entry.getKey()+ChatColor.RESET+" : "+entry.getValue().getName());
                }
                break;

            case "time":
                if(args.length == 1){
                    sender.sendMessage("設定されている制限時間："+ChatColor.GREEN+hueOniGame.getTime()+ChatColor.RESET+"秒");
                    return;
                }
                if(args[1].equalsIgnoreCase("set")){
                    try{
                        int currentTime = hueOniGame.getTime();
                        HueOni.getGame().setTime(Integer.parseInt(args[2]));
                        Bukkit.getOnlinePlayers().forEach(player -> hueOniGame.getScoreBoardHashMap().get(player).updateTime(currentTime));
                        sender.sendMessage("制限時間を"+ChatColor.GREEN+args[2]+ChatColor.RESET+"秒に設定しました");
                    } catch (Exception e) {
                        sender.sendMessage(ChatColor.RED+"数字を入れてください");
                        throw new RuntimeException(e);
                    }
                    return;
                }
                break;
        }
    }
}
