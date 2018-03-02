package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import talsapi.talsapi.api.PlayerDeta;

public class Stats implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player))
        {
            return false;
        }

        Player p = (Player) sender;
        PlayerDeta pd = new PlayerDeta(p);

        p.sendMessage("§6§l◆§e§l━━━§6§l( §e"+p.getName()+" §6§l)§e§l━━━§6§l◆");
        p.sendMessage(" ");
        p.sendMessage(" §7職業名: "+ pd.getMainClass().getPrefix());
        p.sendMessage(" §7レベル: Lv."+pd.getMainClass().getLevel());
        p.sendMessage(" ");
        p.sendMessage(" §7Exp: "+pd.getMainClass().getExp()+" / "+pd.getMainClass().getNextExp());
        p.sendMessage(" ");
        p.sendMessage("§6§l◆§e§l━━━━━━━━━━━━━━━━━━§6§l◆");


        return true;
    }
}
