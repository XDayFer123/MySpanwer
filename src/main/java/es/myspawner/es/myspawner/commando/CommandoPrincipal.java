package es.myspawner.es.myspawner.commando;

import es.myspawner.es.myspawner.MySpawner;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandoPrincipal implements CommandExecutor {
    private MySpawner plugin;

    public CommandoPrincipal(MySpawner plugin){
        this.plugin = plugin;
    }
    public boolean onCommand(CommandSender sender, Command commando , String label, String[] args) {
        if (!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(plugin.nombre+ ChatColor.RED+" No puedes ejecutar este commando en la consola");
            return false;
        }else{
            Player jugador = (Player) sender;
            if (args.length > 0){
                if(args[0].equalsIgnoreCase("version")) {
                    jugador.sendMessage(ChatColor.AQUA + "-----------" + ChatColor.GOLD + "MySpawner" + ChatColor.AQUA + "-----------");
                    jugador.sendMessage(ChatColor.GOLD + "version: " + ChatColor.GREEN + plugin.version);
                    jugador.sendMessage(ChatColor.GOLD + "Premium:" + ChatColor.GREEN + " YES");
                    jugador.sendMessage(ChatColor.GOLD + "Author:" + ChatColor.RED + " DayFer");
                    jugador.sendMessage(ChatColor.AQUA + "-------------------------------");
                    return true;
                }
                else if(args[0].equalsIgnoreCase("reload")){
                    // /MySpawner reload
                    plugin.reloadConfig();
                    jugador.sendMessage(plugin.nombre+ChatColor.RED+" El plugin ha sido recargado correctamente");
                    return true;
                }
                else{
                    jugador.sendMessage(plugin.nombre+ChatColor.RED+" Ese commando no existe");
                    return true;

                }
            }else{
                jugador.sendMessage(plugin.nombre+ChatColor.RED+"/ms version"+ChatColor.YELLOW+" para ver la version del plugin");
                jugador.sendMessage(plugin.nombre+ChatColor.RED+"/myspawner"+ChatColor.YELLOW+" para ver la help del plugin");
                return true;


            }
        }
    }
}
