package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import talsapi.talsapi.TALSAPI;
import talscommand.talscommand.TALSCOMMAND;

public class PEXP implements CommandExecutor {

    private TALSCOMMAND plugin = TALSCOMMAND.getPlugin(TALSCOMMAND.class);
    private String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //空白が少ない場合
        if(args.length == 0)
        {
            sender.sendMessage(prefix+"/setexp <EXP> (プレイヤー)");
            return true;
        }

        //空白が1個だった場合
        if(args.length == 1)
        {
            //コンソールの時の処理
            if(!(sender instanceof Player))
            {
                sender.sendMessage(prefix+"/setexp <EXP> (プレイヤー)");
                return true;
            }

            //doubleにできるか
            if(!isDouble(args[0]))
            {
                sender.sendMessage(prefix+"数値を入力してください");
            }

            Player p = (Player) sender;

            //経験値を設定
            TALSAPI.getPlayerDeta(p).getMainClass().setExp(Double.parseDouble(args[0]));
            p.sendMessage(prefix+"自分のEXPを"+args[0]+"にしました");
            return true;
        }

        //2子だった場合
        if(args.length == 2)
        {
            //プレイヤーが存在するか
            if(plugin.getServer().getPlayer(args[1]) == null)
            {
                sender.sendMessage("特定のプレイヤーデータは存在しません");
            }

            Player p = plugin.getServer().getPlayer(args[1]);

            //doubleにできるか
            if(!isDouble(args[0]))
            {
                sender.sendMessage(prefix+"数値を入力してください");
            }

            TALSAPI.getPlayerDeta(p).getMainClass().setExp(Double.parseDouble(args[0]));
            p.sendMessage(prefix+args[1]+"のEXPを"+args[0]+"にしました");
            return true;
        }
        return false;
    }

    private boolean isDouble(String str)
    {
        try{
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
}
