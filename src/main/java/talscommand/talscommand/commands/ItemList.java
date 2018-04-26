package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import talsitems.talsitems.TALSITEMS;

public class ItemList implements CommandExecutor {

    String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //空白が0だった時
        if(args.length == 0)
        {
            sender.sendMessage("§6◆§e━━━§6( §bアイテムリスト PAGE1 §6)§e━━━§6◆");
            //拡張for文
            int list = 0;//リスト作成
            for(Integer id : TALSITEMS.IdName.keySet())
            {
                //ＩＤを取得
                String name = TALSITEMS.IdName.get(id);

                sender.sendMessage("§6▪ §a"+id+"§7:§f"+name);

                list = list+1;//リストに1追加
                if(list == 10) break;//10になったら消去
            }
            sender.sendMessage("§6◆§e━━━━━━━━━━━━━━━━━━━━━━━━━§6◆");

            return true;
        }

        //すべて表示
        if(args[0].equalsIgnoreCase("all"))
        {
            sender.sendMessage("§6◆§e━━━§6( §bアイテムリスト ALL §6)§e━━━§6◆");
            //拡張for文
            for(Integer id : TALSITEMS.IdName.keySet())
            {
                //ＩＤを取得
                String name = TALSITEMS.IdName.get(id);

                sender.sendMessage("§6▪ §a"+id+"§7:§f"+name);

            }
            sender.sendMessage("§6◆§e━━━━━━━━━━━━━━━━━━━━━━━§6◆");

            return true;
        }

        //intにできるか
        if(!isInt(args[0]))
        {
            sender.sendMessage(prefix+"数値を入力してください");
            return true;
        }

        if(Integer.parseInt(args[0]) <= 0)
        {
            sender.sendMessage(prefix+"1以上を入力してください");
            return true;
        }

        int page = Integer.parseInt(args[0]);//page作成

        //アイテムリスト表示
        sender.sendMessage("§6◆§e━━━§6( §bアイテムリスト PAGE"+page+" §6)§e━━━§6◆");
        //拡張for文
        int list = 0;//リスト作成
        for(Integer id : TALSITEMS.IdName.keySet())
        {
            list = list+1;//リストに1追加

            if(list <page*10-9) continue;

            //ＩＤを取得
            String name = TALSITEMS.IdName.get(id);

            sender.sendMessage("§6▪ §a"+id+"§7:§f"+name);

            if(list == 10*page) break;//ページになったら消去
        }
        sender.sendMessage("§6◆§e━━━━━━━━━━━━━━━━━━━━━━━━━§6◆");

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
