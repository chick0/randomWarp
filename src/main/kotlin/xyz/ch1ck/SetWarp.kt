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

//            val config = RandomWarp().jpConfig

            sender.sendMessage("워프 등록됨: ${location.x} ${location.y} ${location.z}")
//            val prev = config.getList("warp")
//            prev?.add(doubleArrayOf(location.x, location.y, location.z))

//            config.set("warp", prev)

        }
        return true
    }
}
