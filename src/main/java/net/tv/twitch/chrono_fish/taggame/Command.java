package net.tv.twitch.chrono_fish.taggame;

import net.tv.twitch.chrono_fish.taggame.Instance.PlayerState;
import net.tv.twitch.chrono_fish.taggame.Manager.ConfigManager;
import net.tv.twitch.chrono_fish.taggame.Manager.GameManager;
import net.tv.twitch.chrono_fish.taggame.Manager.StateManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player snd = (Player) sender;
            if(snd.isOp()){
                if(command.getName().equalsIgnoreCase("t")){
                    if(args.length == 1){
                        if(args[0].equalsIgnoreCase("start")){
                            GameManager.startGame();
                        }
                        if(args[0].equalsIgnoreCase("reset")){
                            GameManager.resetGame();
                        }
                        if(args[0].equalsIgnoreCase("test")){
                            snd.sendMessage(ConfigManager.getRequiredPlayers()+"");
                            StateManager.setState(snd, PlayerState.Oni);
                        }
                    }else{
                        snd.sendMessage("Invalid usage!");
                    }
                }
            }
        }

        return false;
    }

}
