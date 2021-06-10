package xyz.ch1ck

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.event.player.PlayerTeleportEvent


object Warp : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(WarpList.size == 0 ){
//            sender.sendMessage("§cCan't find warp point")
            sender.sendMessage("§4Warp point is EMPTY!")
            return true
        }

        if(sender.name != "CONSOLE") {
            var warpIdx = 0
            if(WarpList.size != 1){
                warpIdx = (0 until WarpList.size).random()
            }

            val warpTarget = WarpList[warpIdx]
            val player = Bukkit.getPlayer(sender.name)

            player?.teleport(
                Location(
                    Bukkit.getWorld(warpTarget.world!!),
                    warpTarget.x!!,
                    warpTarget.y!!,
                    warpTarget.z!!,
                    warpTarget.yaw!!,
                    warpTarget.pitch!!
                ),
                PlayerTeleportEvent.TeleportCause.PLUGIN
            )
        }
        return true
    }
}
