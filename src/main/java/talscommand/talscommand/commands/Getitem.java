package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import talsitems.talsitems.TALSITEMS;

public class Getitem implements CommandExecutor {

    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //プレイヤーかどうか
        if(!(sender instanceof Player))
        {
            sender.sendMessage(prefix+"プレイヤーのみが実行可能なコマンドです");
            return true;
        }

        Player p = (Player) sender;

        //空白が0だった場合
        if(args.length==0)
        {
            sender.sendMessage(prefix+"/getitem <id>");
            return true;
        }

        //intできるか
        if (!isInt(args[0]))
        {
            //アイテムが存在するか
            if(TALSITEMS.itemNameList.get(args[0]) == null)
            {
                sender.sendMessage(prefix+"そのＩＤのアイテムは存在しません");
                return true;
            }

            //アイテム取得
            ItemStack item = TALSITEMS.itemNameList.get(args[0]);

            //プレイヤーにアイテムを渡す
            p.sendMessage(prefix+args[0]+"§fを入手しました");
            p.getInventory().addItem(item);
            return true;
        }

        //idを代入
        int id = Integer.parseInt(args[0]);

        //アイテムが存在するか
        if(TALSITEMS.itemIdList.get(id) == null)
        {
            sender.sendMessage(prefix+"そのＩＤのアイテムは存在しません");
            return true;
        }

        //アイテム取得
        ItemStack item = TALSITEMS.itemIdList.get(id);

        //プレイヤーにアイテムを渡す
        p.sendMessage(prefix+args[0]+"§fを入手しました");
        p.getInventory().addItem(item);

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
