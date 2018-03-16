package talscommand.talscommand.commandtab;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;

public class ChangeTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> tab =  new ArrayList<>();

        if(args.length !=1)
        {
            return null;
        }

        if(!(sender instanceof Player))
        {
            return null;
        }

        Player p = (Player) sender;

        p.playSound(p.getLocation(),Sound.BLOCK_DISPENSER_DISPENSE,0.8f,08f);

        tab.add("Soldier");
        tab.add("Wizard");
        tab.add("Guardian");
        tab.add("Thief");
        tab.add("Hunter");
        tab.add("Assassin");
        tab.add("Necromancer");
        tab.add("Priest");
        tab.add("Adventure");

        return tab;
    }
    /*
    " §f§lSoldier§7," +
                " §c§lWizard§7," +
                " §3§lGuardian§7," +
                " §a§lThief§7," +
                " §e§lHunter§7," +
                " §4§lAssassin§7," +
                " §d§lNecromancer§7," +
                " §b§lPriest§7," +
                " §6§lAdventure");
     */
}
