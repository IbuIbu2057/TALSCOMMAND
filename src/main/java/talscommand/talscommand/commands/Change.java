package talscommand.talscommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import talsapi.talsapi.api.PlayerDeta;
import talsapi.talsapi.api.manager.enums.Classes;

public class Change implements CommandExecutor {


    private String prefix ="§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player))
        {
            return false;
        }

        Player p = (Player) sender;
        PlayerDeta pd = new PlayerDeta(p);

        if(args.length != 1)
        {
            p.sendMessage("§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫ §f使い方: /change <職業>");
            return true;
        }

        if(args[0].equalsIgnoreCase("1")
                ||args[0].equalsIgnoreCase("Soldier"))
        {
            pd.setClasses(Classes.SOLDIER);
            p.sendMessage(prefix+"§f§lソルジャー§fに変更しました");
            return true;
        }

        if(args[0].equalsIgnoreCase("2")
                ||args[0].equalsIgnoreCase("Wizard"))
        {
            pd.setClasses(Classes.WIZARD);
            p.sendMessage(prefix+"§c§lウィザード§fに変更しました");
            return true;
        }

        if(args[0].equalsIgnoreCase("3")
                ||args[0].equalsIgnoreCase("Guardian"))
        {
            pd.setClasses(Classes.GUARDIAN);
            p.sendMessage(prefix+"§3§lガーディアン§fに変更しました");
            return true;
        }

        if(args[0].equalsIgnoreCase("4")
                ||args[0].equalsIgnoreCase("Thief"))
        {
            pd.setClasses(Classes.THIEF);
            p.sendMessage(prefix+"§a§lシーフ§fに変更しました");
            return true;
        }

        if(args[0].equalsIgnoreCase("5")
                ||args[0].equalsIgnoreCase("Hunter"))
        {
            pd.setClasses(Classes.HUNTER);
            p.sendMessage(prefix+"§e§lハンター§fに変更しました");
            return true;
        }

        if(args[0].equalsIgnoreCase("6")
                ||args[0].equalsIgnoreCase("Assassin"))
        {
            pd.setClasses(Classes.ASSASSIN);
            p.sendMessage(prefix+"§4§lアサシン§fに変更しました");
            return true;
        }

        if(args[0].equalsIgnoreCase("7")
                ||args[0].equalsIgnoreCase("Necromancer"))
        {
            pd.setClasses(Classes.NECROMANCER);
            p.sendMessage(prefix+"§d§ネクロマンサー§fに変更しました");
            return true;
        }

        if(args[0].equalsIgnoreCase("8")
                ||args[0].equalsIgnoreCase("Priest"))
        {
            pd.setClasses(Classes.PRIEST);
            p.sendMessage(prefix+"§b§プリースト§fに変更しました");
            return true;
        }

        if(args[0].equalsIgnoreCase("0")
                ||args[0].equalsIgnoreCase("Adventure"))
        {
            pd.setClasses(Classes.NONE);
            p.sendMessage(prefix+"§6§lアドベンチャー§fに変更しました");
            return true;
        }

        p.sendMessage("§6§l≪§c§lT§6§lA§a§lL§b§lS§6§l≫" +
                " §fClasses§a: "+
                " §f§lSoldier§7," +
                " §c§lWizard§7," +
                " §3§lGuardian§7," +
                " §a§lThief§7," +
                " §e§lHunter§7," +
                " §4§lAssassin§7," +
                " §d§lNecromancer§7," +
                " §b§lPriest§7," +
                " §6§lAdventure");

        return true;
    }
}
