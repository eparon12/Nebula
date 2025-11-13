package com.eparon.nebula.commands;
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
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.client.settings.KeyBinding;

public class WalkMacro {
    public static void WalkMacroMethod() {
        final Minecraft mc = Minecraft.getMinecraft();
        if (mc.thePlayer != null && TestMacro.isMacroing == true) {
            mc.thePlayer.addChatMessage(new ChatComponentText("looping"));
            System.out.println("looping");
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
        }
        else if (TestMacro.isMacroing == false){
            mc.thePlayer.addChatMessage(new ChatComponentText("looping"));
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
        }
    }
}
