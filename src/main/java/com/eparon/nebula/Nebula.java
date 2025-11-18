package com.eparon.nebula;
import com.eparon.nebula.macros.*;
import com.eparon.nebula.commands.*;
import com.eparon.nebula.hud.*;
import com.eparon.nebula.config.*;
import com.eparon.nebula.events.*;
import com.eparon.nebula.general.*;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = "Nebula",
        name = "Nebula",
        version = "0.0.1-beta" )
public class Nebula { // select ExampleMod and hit shift+F6 to rename it

    public static final String MODID = "Nebula";      // the id of your mod, it should never change, it is used by forge and servers to identify your mods
    public static final String MODNAME = "Nebula";// the name of your mod
    public static final String VERSION = "0.0.1-beta";           // the current version of your mod

    // this method is one entry point of you mod
    // it is called by forge when minecraft is starting
    // it is called before the other methods below
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // loads the config file from the disk
        ConfigHandler.loadConfig(event.getSuggestedConfigurationFile());

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // register your commands here
        ClientCommandHandler.instance.registerCommand(new ExampleCommand());
        ClientCommandHandler.instance.registerCommand(new TestMacro());


        // the ExampleKeybind has a method with the @SubscribeEvent annotation
        // for that code to run, that class needs to be registered on the MinecraftForge EVENT_BUS
        // register your other EventHandlers here
        MinecraftForge.EVENT_BUS.register(new ExampleKeybindListener());
        MinecraftForge.EVENT_BUS.register(new ExampleHUD());
        MinecraftForge.EVENT_BUS.register(new TickHandler());
        // MinecraftForge.EVENT_BUS.register(new mineWoodMacro());

        if (Loader.isModLoaded("patcher")) {
            // this code will only run if the mod with id "patcher" is loaded
            // you can use it to load or not while modules of your mod that depends on other mods
        }

    }
}
