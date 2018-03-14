package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import talsapi.talsapi.TALSAPI;
import talscommand.talscommand.TALSCOMMAND;

public class PLevel implements CommandExecutor {

    TALSCOMMAND plugin = TALSCOMMAND.getPlugin(TALSCOMMAND.class);
    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //空白が少ない場合
        if(args.length == 0)
        {
            sender.sendMessage(prefix+"/setlevel <LEVEL> (プレイヤー)");
            return true;
        }

        //空白が1個だった場合
        if(args.length == 1)
        {
            //コンソールの時の処理
            if(!(sender instanceof Player))
            {
                sender.sendMessage(prefix+"/setlevel <LEVEL> (プレイヤー)");
                return true;
            }

            //intにできるか
            if(!isInt(args[0]))
            {
                sender.sendMessage(prefix+"数値を入力してください");
            }

            Player p = (Player) sender;

            //経験値を設定
            TALSAPI.getPlayerDeta(p).getMainClass().setLevel(Integer.parseInt(args[0]));
            p.sendMessage(prefix+"自分のLEVELを"+args[0]+"にしました");
            return true;
        }

        //2個だった場合
        if(args.length == 2)
        {
            //プレイヤーが存在するか
            if(plugin.getServer().getPlayer(args[1]) == null)
            {
                sender.sendMessage(prefix+"特定のプレイヤーデータは存在しません");
            }

            //プレイヤーがオンラインか
            if(plugin.getServer().getPlayer(args[1]).isOnline())
            {
                sender.sendMessage(prefix+"指定のプレイヤーはオフラインです");
            }

            Player p = plugin.getServer().getPlayer(args[1]);

            //intにできるか
            if(!isInt(args[0]))
            {
                sender.sendMessage(prefix+"数値を入力してください");
            }

            TALSAPI.getPlayerDeta(p).getMainClass().setLevel(Integer.parseInt(args[0]));
            p.sendMessage(prefix+args[1]+"のLEVELを"+args[0]+"にしました");
            return true;
        }

        return false;
    }

    private boolean isInt(String str)
    {
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
}
