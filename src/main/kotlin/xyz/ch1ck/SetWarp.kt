package xyz.ch1ck

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender


object SetWarp : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender.name != "CONSOLE"){
            val player = Bukkit.getPlayer(sender.name)
            val location = player!!.location

            for((i, e) in WarpList.withIndex()){
                if(e.x == location.x && e.z == location.z && e.world == player.world.name){
                    WarpList.removeAt(i)
                    sender.sendMessage("§f[§4-§f] ${location.x.toInt()}, ${location.y.toInt()}, ${location.z.toInt()}")
                    return true
                }
            }

            WarpList.add(WarpData(
                player.world.name,
                location.x,
                location.y,
                location.z,
                location.yaw,
                location.pitch
            ))

            sender.sendMessage("§f[§a+§f] ${location.x.toInt()}, ${location.y.toInt()}, ${location.z.toInt()}")
        }
        return true
    }
}
