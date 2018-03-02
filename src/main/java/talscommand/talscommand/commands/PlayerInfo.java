package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import talsapi.talsapi.api.PlayerDeta;
import talscommand.talscommand.TALSCOMMAND;

public class PlayerInfo implements CommandExecutor {

    TALSCOMMAND plugin = TALSCOMMAND.getPlugin(TALSCOMMAND.class);
    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length != 1)
        {
            sender.sendMessage("§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f使い方: /playerinfo <プレイヤー>");
            return true;
        }

        String player = args[0];

        Player p = plugin.getServer().getPlayer(player);

        if(!plugin.getServer().getOnlinePlayers().contains(p))
        {
            sender.sendMessage(prefix+"§4プレイヤーがオフラインではない可能性があります");
            return true;
        }

        PlayerDeta pd = new PlayerDeta(p);

        sender.sendMessage("§6§l◆§e§l━━━§6§l( §e"+p.getName()+"の情報 §6§l)§e§l━━━§6§l◆");
        sender.sendMessage(" ");
        sender.sendMessage(" §7MCID: "+p.getName());
        sender.sendMessage(" §7UUID: "+p.getUniqueId().toString());
        sender.sendMessage(" §7アドレス: "+p.getAddress());
        sender.sendMessage(" ");
        sender.sendMessage(" §7選択中の職業: "+ pd.getMainClass().getPrefix());
        sender.sendMessage(" ");
        sender.sendMessage("§6§l◆§e§l━━━━━━━━━━━━━━━━━━━━━━§6§l◆");


        return true;
    }
}
