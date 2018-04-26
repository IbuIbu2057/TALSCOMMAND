package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import talsitems.talsitems.TALSITEMS;
import talsitems.talsitems.manager.ItemManager;

public class ItemReload implements CommandExecutor {

    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        new ItemManager().itemLoad();
        sender.sendMessage(prefix+"TALSITEMSをリロードしました");

        return true;
    }
}
