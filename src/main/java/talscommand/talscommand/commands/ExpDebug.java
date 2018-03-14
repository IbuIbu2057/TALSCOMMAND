package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import talscommand.talscommand.TALSCOMMAND;

public class ExpDebug implements CommandExecutor {

    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //空白が０だった場合
        if(args.length==0)
        {
            sender.sendMessage(prefix+"/debugexp <level>");
            return true;
        }

        //intできるか
        if (!isInt(args[0]))
        {
            sender.sendMessage(prefix+"数値を入れてください");
            return true;
        }

        int level = Integer.parseInt(args[0]);

        //計算して送る((now+35) ×2 + (now×now))
        sender.sendMessage(prefix+"デバッグ結果§a: §f"+(((level+60)*2+(level*level))*2)+"EXP");

        return true;
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
