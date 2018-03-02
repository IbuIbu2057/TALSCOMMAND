package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import talsapi.talsapi.MySQLs;
import talsapi.talsapi.TALSAPI;
import talsapi.talsapi.api.MySQLAPI;

public class Check implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage("§6§l◆§e§l━━━━━━━━━━━━━━━━━━━━━━§6§l◆");
        sender.sendMessage(" ");
        if(MySQLs.getConnection() ==null)
        {
            sender.sendMessage(" §7MySQL: NULL");
            MySQLs.PluginStop();
        }
        else
        {
            sender.sendMessage(" §7MySQL: §a§lCONNECT");
        }
        sender.sendMessage(" ");
        sender.sendMessage("§6§l◆§e§l━━━━━━━━━━━━━━━━━━━━━━§6§l◆");

        return true;
    }
}
