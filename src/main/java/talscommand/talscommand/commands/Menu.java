package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import talscore.talscore.TALSCore;
import talscore.talscore.listener.GrandMenu;

public class Menu implements CommandExecutor {

    private TALSCore plugin = TALSCore.getPlugin(TALSCore.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //プレイヤーか
        if(!(sender instanceof Player))
        {
            return false;
        }

        Player p = (Player) sender;

        new GrandMenu(plugin).show(p);

        return true;
    }
}
