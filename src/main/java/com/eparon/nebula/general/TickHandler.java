package com.eparon.nebula.general;
import com.eparon.nebula.commands.*;
import com.eparon.nebula.macros.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.Gui;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Mouse;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.util.ChatComponentText;
public class TickHandler {
    @SubscribeEvent
    public void onWorldLoad(net.minecraftforge.event.world.WorldEvent.Load event) {
        TestMacro.isMacroing = false;
    }
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(TestMacro.isMacroing == true) {
            WalkMacro.WalkMacroMethod();
        }
    }

}
