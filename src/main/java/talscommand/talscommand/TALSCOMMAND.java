package talscommand.talscommand;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import talscommand.talscommand.commands.*;
import talscommand.talscommand.commandtab.ChangeTab;

public final class TALSCOMMAND extends JavaPlugin implements Listener {

    String prefix = "§e≪§cT§6A§aL§bS §9Command§e≫ ";

    @Override
    public void onEnable() {

        //プラグインをストップさせる
        //getServerPlugin();

        if(getServer().getPluginManager().getPlugin("TALSAPI") ==null)
        {
            return;
        }
        //LOADメッセージ開始
        Bukkit.getConsoleSender().sendMessage(prefix+"§aLoading command");

        //コマンドロード
        getCommand("info").setExecutor(new Stats());
        getCommand("stats").setExecutor(new Stats());
        getCommand("status").setExecutor(new Stats());
        getCommand("change").setExecutor(new Change());
        getCommand("changeclass").setExecutor(new Change());
        getCommand("class").setExecutor(new Change());
        getCommand("c").setExecutor(new Change());
        getCommand("seestats").setExecutor(new SeeStats());
        getCommand("sstats").setExecutor(new SeeStats());
        getCommand("ss").setExecutor(new SeeStats());
        getCommand("playerinfo").setExecutor(new PlayerInfo());
        getCommand("pinfo").setExecutor(new PlayerInfo());
        getCommand("pi").setExecutor(new PlayerInfo());
        getCommand("check").setExecutor(new Check());
        getCommand("mysqlcheck").setExecutor(new Check());
        getCommand("sqlcheck").setExecutor(new Check());
        getCommand("sql").setExecutor(new Check());
        getCommand("mysql").setExecutor(new Check());
        getCommand("mysqlconnect").setExecutor(new Connect());
        getCommand("sqlconnect").setExecutor(new Connect());
        getCommand("connect").setExecutor(new Connect());
        getCommand("serverinfo").setExecutor(new ServerInfo());
        getCommand("serverstats").setExecutor(new ServerInfo());

        //TABコンプレックス
        getCommand("change").setTabCompleter(new ChangeTab());
        getCommand("c").setTabCompleter(new ChangeTab());
        getCommand("changeclass").setTabCompleter(new ChangeTab());
        getCommand("class").setTabCompleter(new ChangeTab());

        //リスナーロード
        //getServer().getPluginManager().registerEvents(this, this);

        //LOADメッセージ終了
        Bukkit.getConsoleSender().sendMessage(prefix+"§aFinish loading commands");
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        getServerPlugin();
    }

    private void getServerPlugin()
    {
        if(getServer().getPluginManager().getPlugin("TALSAPI") ==null
                || !getServer().getPluginManager().getPlugin("TALSAPI").isEnabled())
        {
            getServer().getPluginManager().disablePlugin(getServer().getPluginManager().getPlugin(getName()));
            Bukkit.getConsoleSender().sendMessage(prefix+"§a Stop plugin");
        }
    }
}
