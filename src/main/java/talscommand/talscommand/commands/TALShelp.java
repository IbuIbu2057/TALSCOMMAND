package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TALShelp implements CommandExecutor {

    private String prefix= "§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //空白が0だった場合
        if(args.length == 0)
        {
            sender.sendMessage("§6◆§e━━━§6( §bコマンドリスト PAGE1 §6)§e━━━§6◆");
            sender.sendMessage("§6| §7/info §f- §7ステータス確認");
            sender.sendMessage("§6| §7/change  §f- §7クラスを変更する");
            sender.sendMessage("§6| §7/seestats §f- §7プレイヤーのステータスを確認");
            sender.sendMessage("§6| §7/playerinfo §f- §7プレイヤーの情報を確認");
            sender.sendMessage("§6| §7/check §f- §7MySQLの状態をチェック");
            sender.sendMessage("§6◆§e━━━§6( §bコマンドリスト PAGE1 §6)§e━━━§6◆");
            return true;
        }

        //intにできるか
        if(!isInt(args[0]))
        {
            sender.sendMessage(prefix+"数値を入力してください");
            return true;
        }

        if(Integer.parseInt(args[0]) <1)
        {
            sender.sendMessage(prefix+"1以上の数値を入力してください");
            return true;
        }

        int page = Integer.parseInt(args[0]);//ページを代入

        if(page == 1)
        {
            sender.sendMessage("§6◆§e━━━§6( §bコマンドリスト PAGE1 §6)§e━━━§6◆");
            sender.sendMessage("§6| §7/info §f- §7ステータス確認");
            sender.sendMessage("§6| §7/change  §f- §7クラスを変更する");
            sender.sendMessage("§6| §7/seestats §f- §7プレイヤーのステータスを確認");
            sender.sendMessage("§6| §7/playerinfo §f- §7プレイヤーの情報を確認");
            sender.sendMessage("§6| §7/check §f- §7MySQLの状態をチェック");
            sender.sendMessage("§6◆§e━━━§6( §bコマンドリスト PAGE1 §6)§e━━━§6◆");
            return true;
        }

        if(page == 2)
        {
            sender.sendMessage("§6◆§e━━━§6( §bコマンドリスト PAGE2 §6)§e━━━§6◆");
            sender.sendMessage("§6| §7/mysqlconnect §f- §7MySQLに接続");
            sender.sendMessage("§6| §7/serverstats §f- §7サーバーの状態を確認");
            sender.sendMessage("§6| §7/plevel §f- §7プレイヤーのレベルを設定");
            sender.sendMessage("§6| §7/pexp §f- §7プレイヤーのＥＸＰを設定");
            sender.sendMessage("§6| §7/debugexp §f- §7必要な経験値を計算");
            sender.sendMessage("§6◆§e━━━§6( §bコマンドリスト PAGE2 §6)§e━━━§6◆");
            return true;
        }

        if(page == 3)
        {
            sender.sendMessage("§6◆§e━━━§6( §bコマンドリスト PAGE3 §6)§e━━━§6◆");
            sender.sendMessage("§6| §7/getitem §f- §7アイテムを入手");
            sender.sendMessage("§6| §7/itemlist §f- §7アイテム一覧を表示");
            sender.sendMessage("§6| §7/itemreload §f- §7TALSITEMSをリロードする");
            sender.sendMessage("§6| §7/thelp §f- §7TALSのコマンド一覧を表示");
            sender.sendMessage("§6◆§e━━━§6( §bコマンドリスト PAGE3 §6)§e━━━§6◆");
            return true;
        }

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
