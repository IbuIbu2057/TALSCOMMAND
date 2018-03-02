package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import talscommand.talscommand.TALSCOMMAND;
import org.bukkit.entity.Player;

public class ServerInfo implements CommandExecutor {

    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";
    TALSCOMMAND plugin = TALSCOMMAND.getPlugin(TALSCOMMAND.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player) sender;

            if(p.getName().equals("ibuibu2056")
                    || p.getName().equals("Shadow_Magician_")
                    ) {

                sender.sendMessage("§6§l◆§e§l━━━━━━━━━━━━━━━━━━━━━━━━━§6§l◆");
                sender.sendMessage(" ");
                sender.sendMessage(" §e§l*サーバー情報*");
                sender.sendMessage(" §7Motd: §f" + plugin.getServer().getMotd());
                sender.sendMessage(" §7Port: §f" + plugin.getServer().getPort());
                sender.sendMessage(" §7getServerId: §f" + plugin.getServer().getServerId());
                sender.sendMessage(" §7DefaultGameMode: §f" + plugin.getServer().getDefaultGameMode());
                sender.sendMessage(" §7OnlinePlayer: §f" + plugin.getServer().getOnlinePlayers().size());
                sender.sendMessage(" §7MaxPlayer: §f" + plugin.getServer().getMaxPlayers());
                sender.sendMessage(" §7BukkitVersion: §f" + plugin.getServer().getBukkitVersion());
                sender.sendMessage(" ");
                sender.sendMessage("§6§l◆§e§l━━━━━━━━━━━━━━━━━━━━━━━━━§6§l◆");

                return true;
            }

            p.sendMessage(prefix+"お前は何者だ！");

            return true;
        }

        sender.sendMessage("§6§l◆§e§l━━━━━━━━━━━━━━━━━━━━━━━━━§6§l◆");
        sender.sendMessage(" ");
        sender.sendMessage(" §e§l*サーバー情報*");
        sender.sendMessage(" §7Motd: §f" + plugin.getServer().getMotd());
        sender.sendMessage(" §7Port: §f" + plugin.getServer().getPort());
        sender.sendMessage(" §7getServerId: §f" + plugin.getServer().getServerId());
        sender.sendMessage(" §7DefaultGameMode: §f" + plugin.getServer().getDefaultGameMode());
        sender.sendMessage(" §7OnlinePlayer: §f" + plugin.getServer().getOnlinePlayers().size());
        sender.sendMessage(" §7MaxPlayer: §f" + plugin.getServer().getMaxPlayers());
        sender.sendMessage(" §7BukkitVersion: §f" + plugin.getServer().getBukkitVersion());
        sender.sendMessage(" ");
        sender.sendMessage("§6§l◆§e§l━━━━━━━━━━━━━━━━━━━━━━━━━§6§l◆");

        return true;
    }
}
