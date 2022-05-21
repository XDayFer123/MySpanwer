package es.myspawner.es.myspawner;

import es.myspawner.es.myspawner.commando.CommandoPrincipal;
import es.myspawner.es.myspawner.commando.CommandoVersion;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Optional;

public final class MySpawner extends JavaPlugin{
    public String rutaConfig;
    PluginDescriptionFile pdffile = getDescription();
    public String version = pdffile.getVersion();
    public String nombre = ChatColor.GREEN+"["+ChatColor.GOLD+pdffile.getName()+ChatColor.GREEN+"]";
    public void onEnable(){
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"------------------------------------------------- ");
        Bukkit.getConsoleSender().sendMessage(nombre+ChatColor.WHITE+" Ha sido Activado (version: "+ChatColor.GREEN+version+")");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"!Este es mi primero Plugin");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"espero que les guste :)!");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"Author: "+ChatColor.RED+"DayFer");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"-------------------------------------------------");
        registrarCommandos();
        registerCofig();
    }

    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage(nombre+ChatColor.RED+" Ha sido Apagado (version: "+ChatColor.RED+version+")");
    }

    public void registrarCommandos(){
        this.getCommand("myspawner").setExecutor(new CommandoVersion(this));
        this.getCommand("ms").setExecutor(new CommandoPrincipal(this));
    }
    public void registerCofig(){
        File config = new File(this.getDataFolder(),"config.yml");
        rutaConfig = config.getPath();
        if(!config.exists()){
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
    // /myspawner -> usa /myspawner version para ver la version del plugin
    // /myspawner version -> Version 1.0.1
    // /myspawner cualquiercosa -> Este commando no existe
}
