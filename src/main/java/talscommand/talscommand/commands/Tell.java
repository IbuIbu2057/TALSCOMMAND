package talscommand.talscommand.commands;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import talscommand.talscommand.TALSCOMMAND;

public class Tell implements CommandExecutor {

    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";
    private TALSCOMMAND plugin = TALSCOMMAND.getPlugin(TALSCOMMAND.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        //プレイヤーか
        if(!(sender instanceof Player))
        {
            return false;
        }

        Player p = (Player) sender;

        if(args.length != 2)
        {
            sender.sendMessage(prefix+"/"+command.getName()+" <player> <message>");
            return true;
        }

        if(plugin.getServer().getPlayer(args[0]) == null)
        {
            sender.sendMessage(prefix+"/"+command.getName()+" <player> <message>");
            return true;
        }

        talschat.talschat.manager.Tell.TellPlayer(p,plugin.getServer().getPlayer(args[0]),args[1]);

        return true;
    }
}
