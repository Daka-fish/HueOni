package net.tv.twitch.chrono_fish.hueoni.CommandPack;

import net.tv.twitch.chrono_fish.hueoni.GamePack.HueOniGame;
import net.tv.twitch.chrono_fish.hueoni.State.PlayerState;
import net.tv.twitch.chrono_fish.hueoni.HueOni;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CommandManager {
    public static void hueOni(Player sender, String[] args){
        HueOniGame hueOniGame = HueOni.getGame();
        switch(args[0]){
            case "start":
                if(hueOniGame.getGameState().equals(HueOniGame.GameState.Finished)){
                    if(hueOniGame.countChasers() < 2){
                        sender.sendMessage(ChatColor.RED+"鬼の数が足りません" +
                                        "(あと"+(hueOniGame.getNumberOfFirstOni()- hueOniGame.countChasers())+"人)");
                        return;
                    }
                    sender.sendMessage("ゲームを開始します");
                    hueOniGame.setGameState(HueOniGame.GameState.Running);
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
                sender.sendMessage(oTarget.getName()+"を鬼にしました");
                PlayerState currentPlayerState1 = hueOniGame.getStateHashMap().get(oTarget);
                int currentRunners1 = hueOniGame.countRunners();
                hueOniGame.getStateHashMap().put(oTarget,PlayerState.Chaser);
                hueOniGame.getScoreBoardHashMap().get(oTarget).updateState(currentPlayerState1);
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
                sender.sendMessage(nTarget.getName()+"を逃げにしました");

                PlayerState currentPlayerState2 = hueOniGame.getStateHashMap().get(nTarget);
                int currentRunners2 = hueOniGame.countRunners();

                hueOniGame.getStateHashMap().put(nTarget,PlayerState.Runner);
                hueOniGame.getScoreBoardHashMap().get(nTarget).updateState(currentPlayerState2);
                Bukkit.getOnlinePlayers().forEach(player -> hueOniGame.getScoreBoardHashMap().get(player).updateRunners(currentRunners2));
                break;

            case "check":
                break;
        }
    }
}
