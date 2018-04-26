package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import talsitems.talsitems.TALSITEMS;

public class ItemList implements CommandExecutor {

    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        for(Integer key : TALSITEMS.itemIdList.keySet())
        {
            sender.sendMessage("key"+key);
        }

        return false;
    }
}
