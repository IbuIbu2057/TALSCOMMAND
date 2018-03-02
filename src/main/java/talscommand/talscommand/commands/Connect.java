package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import talsapi.talsapi.MySQLs;

public class Connect implements CommandExecutor {

    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(prefix+"MySQLをsetupしなおします");

        MySQLs.mysqlSetup();
        MySQLs.setTables();
        MySQLs.PluginStop();

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
