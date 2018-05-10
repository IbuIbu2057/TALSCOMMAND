package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import talschat.talschat.manager.Tell;

public class R implements CommandExecutor {

    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        //プレイヤーか
        if(!(sender instanceof Player))
        {
            return false;
        }

        Player p = (Player) sender;

        if(args.length != 1)
        {
            sender.sendMessage(prefix+"/r <message>");
            return true;
        }

        Tell.setR(p,args[0]);

        return true;
    }
}
