package es.myspawner.es.myspawner.commando;

import es.myspawner.es.myspawner.MySpawner;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class CommandoVersion implements CommandExecutor{
    private MySpawner plugin;
    public CommandoVersion(MySpawner plugin){
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command commando , String label, String[] args) {
        if (!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(plugin.nombre+ChatColor.RED+" No puedes ejecutar este commando en la consola");
            return false;
        }else{
            Player jugador = (Player) sender;
            jugador.sendMessage(ChatColor.AQUA+"-----------"+ChatColor.GOLD+"MySpawner"+ChatColor.AQUA+"-----------");
            jugador.sendMessage(ChatColor.WHITE+"/ms menu:"+ChatColor.GRAY+" para abrir una interfaz de todos los spawner");
            jugador.sendMessage(ChatColor.WHITE+"/ms give (name_mob)"+ChatColor.GRAY+" para darte un spawner");
            jugador.sendMessage(ChatColor.WHITE+"/ms version: "+ChatColor.GRAY+" para ver la version del plugin");
            jugador.sendMessage(ChatColor.AQUA+"-------------------------------");
            return true;
        }
    }
}
