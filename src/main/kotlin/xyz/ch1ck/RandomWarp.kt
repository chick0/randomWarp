package xyz.ch1ck

import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class RandomWarp : JavaPlugin() {
    val jpConfig = config

    override fun onLoad() {
        super.onLoad()

        val configFile = File(dataFolder,"warps.json")
        if(!configFile.exists()){
            config.set("warp", mutableListOf(arrayOf(Double)))
        }
        else{
            config.load(configFile)
        }
    }

    override fun onEnable() {
        super.onEnable()

        getCommand("set_warp")!!.setExecutor(SetWarp)
        getCommand("warp")!!.setExecutor(Warp)
    }

}
