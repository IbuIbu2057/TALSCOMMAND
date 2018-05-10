package talscommand.talscommand;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import talscommand.talscommand.commands.*;
import talscommand.talscommand.commandtab.ChangeTab;

public final class TALSCOMMAND extends JavaPlugin implements Listener {

    private String prefix = "§e≪§cT§6A§aL§bS §9Command§e≫ ";

    /***************************************************
     *                                                 *
     *   Copyright                                     *
     *           The After Life Story                  *
     *                              Rights Reserved    *
     *                                                 *
     ***************************************************/

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
        //ステータス確認
        getCommand("info").setExecutor(new Stats());
        getCommand("stats").setExecutor(new Stats());
        getCommand("status").setExecutor(new Stats());
        //クラス変更
        getCommand("change").setExecutor(new Change());
        getCommand("changeclass").setExecutor(new Change());
        getCommand("class").setExecutor(new Change());
        getCommand("c").setExecutor(new Change());
        //メニューコマンド
        getCommand("menu").setExecutor(new Menu());
        //ステータス確認
        getCommand("seestats").setExecutor(new SeeStats());
        getCommand("sstats").setExecutor(new SeeStats());
        getCommand("ss").setExecutor(new SeeStats());
        //プレイヤーの乗法確認(Admin)
        getCommand("playerinfo").setExecutor(new PlayerInfo());
        getCommand("pinfo").setExecutor(new PlayerInfo());
        getCommand("pi").setExecutor(new PlayerInfo());
        //ＳＱＬ確認(Admin)
        getCommand("check").setExecutor(new Check());
        getCommand("mysqlcheck").setExecutor(new Check());
        getCommand("sqlcheck").setExecutor(new Check());
        getCommand("sql").setExecutor(new Check());
        getCommand("mysql").setExecutor(new Check());
        //ＳＱＬに接続(Admin)
        getCommand("mysqlconnect").setExecutor(new Connect());
        getCommand("sqlconnect").setExecutor(new Connect());
        getCommand("connect").setExecutor(new Connect());
        //サーバー情報確認(Admin)
        getCommand("serverinfo").setExecutor(new ServerInfo());
        getCommand("serverstats").setExecutor(new ServerInfo());
        //プレイヤーのレベルを設定
        getCommand("plevel").setExecutor(new PLevel());
        getCommand("playerlevel").setExecutor(new PLevel());
        getCommand("setlevel").setExecutor(new PLevel());
        getCommand("setplayerlevel").setExecutor(new PLevel());
        //プレイヤーの経験値を設定
        getCommand("pexp").setExecutor(new PEXP());
        getCommand("playerexp").setExecutor(new PEXP());
        getCommand("setexp").setExecutor(new PEXP());
        getCommand("setplayerexp").setExecutor(new PEXP());
        //ＥＸＰの計算式のデバッグ
        getCommand("debugexp").setExecutor(new ExpDebug());
        getCommand("debugxp").setExecutor(new ExpDebug());
        getCommand("dxp").setExecutor(new ExpDebug());
        getCommand("dexp").setExecutor(new ExpDebug());
        //アイテム入手コマンド
        getCommand("Getitem").setExecutor(new Getitem());
        getCommand("geti").setExecutor(new Getitem());
        getCommand("gi").setExecutor(new Getitem());
        //アイテムリスト
        getCommand("il").setExecutor(new ItemList());
        getCommand("itemlist").setExecutor(new ItemList());
        //TALSITEMリロードコマンド
        getCommand("itemreload").setExecutor(new ItemReload());
        getCommand("itemrl").setExecutor(new ItemReload());
        getCommand("ireload").setExecutor(new ItemReload());
        getCommand("irl").setExecutor(new ItemReload());
        //アイテムデバッグ
        getCommand("debugitem").setExecutor(new ItemDebug());
        getCommand("ditem").setExecutor(new ItemDebug());
        //TALSCOMMANDのヘルプ
        getCommand("thelp").setExecutor(new TALShelp());
        getCommand("talshelp").setExecutor(new TALShelp());
        //個人チャット
        getCommand("tell").setExecutor(new Tell());
        getCommand("message").setExecutor(new Tell());
        getCommand("msg").setExecutor(new Tell());
        getCommand("m").setExecutor(new Tell());
        getCommand("r").setExecutor(new R());

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
