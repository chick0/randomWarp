package xyz.ch1ck

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

var warpConfig = File(".")
data class WarpData(
    var world: String? = null,
    val x : Double? = null,
    val y : Double? = null,
    val z : Double? = null,
    var yaw: Float? = null,
    var pitch: Float? = null
)
var WarpList = ArrayList<WarpData>()


class RandomWarp : JavaPlugin() {
    override fun onLoad() {
        super.onLoad()

        warpConfig = File(dataFolder,"warps.json")
        if(!warpConfig.exists()){
            warpConfig.writeText("[]")
        }
        else {
            val mapper = jacksonObjectMapper()
            WarpList = mapper.readValue(warpConfig)
        }
    }

    override fun onEnable() {
        super.onEnable()

        getCommand("setwarp")!!.setExecutor(SetWarp)
        getCommand("warp")!!.setExecutor(Warp)
    }

    override fun onDisable() {
        super.onDisable()

        val mapper = jacksonObjectMapper()
        mapper.writerWithDefaultPrettyPrinter().writeValue(
            warpConfig,
            WarpList
        )
    }
}
