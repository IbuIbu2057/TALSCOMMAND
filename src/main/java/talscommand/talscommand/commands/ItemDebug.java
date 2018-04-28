package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import talsitems.talsitems.TALSITEMS;

public class ItemDebug implements CommandExecutor {

    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //プレイヤーか
        if(!(sender instanceof Player))
        {
            return false;
        }

        Player p = (Player) sender;

        if(!TALSITEMS.PlayerDebug.containsKey(p))
        {
            p.sendMessage(prefix+"アイテムデバッグモード§aON");
            TALSITEMS.PlayerDebug.put(p,true);
            return true;
        }

        if(!TALSITEMS.PlayerDebug.get(p))
        {
            p.sendMessage(prefix+"アイテムデバッグモード§aON");
            TALSITEMS.PlayerDebug.put(p,true);
            return true;
        }

        if(TALSITEMS.PlayerDebug.get(p))
        {
            p.sendMessage(prefix+"アイテムデバッグモード§cOFF");
            TALSITEMS.PlayerDebug.put(p,false);
            return true;
        }

        return true;
    }
}
