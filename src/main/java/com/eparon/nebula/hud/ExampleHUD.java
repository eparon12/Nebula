package com.eparon.nebula.hud;
import com.eparon.nebula.commands.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.Gui;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Mouse;

public class ExampleHUD {

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        final Minecraft mc = Minecraft.getMinecraft();
        // this method is called multiple times per frame, you want to filter it
        // by checking the event type to only render your HUD once per frame
        if (event.type == RenderGameOverlayEvent.ElementType.TEXT && ExampleCommand.openMainHUD == true) {
            this.drawHUD(event.resolution);
            mc.inGameHasFocus = false;
            Mouse.setGrabbed(false);
        }
    }

    /**
     * To help you learn how to render HUD you can look at some vanilla minecraft HUD
     * - Tab list : {@link net.minecraft.client.gui.GuiPlayerTabOverlay#renderPlayerlist(int, Scoreboard, ScoreObjective)}
     * - Scoreboard : {@link net.minecraft.client.gui.GuiIngame#renderScoreboard(ScoreObjective, ScaledResolution)}
     * - The Ingame gui, healthbar, hotbar... {@link net.minecraftforge.client.GuiIngameForge#renderGameOverlay(float)}
     */
    private void drawHUD(ScaledResolution resolution) {

        // when drawing a HUD, the coordinates (x, y) represent a point on your screen
        // coordinates (0, 0) is top left of your screen,
        // coordinates (screenWidth, screenHeight) is bottom right of your screen
        final int top = 0;
        final int left = 0;
        final int bottom = resolution.getScaledHeight();
        final int right = resolution.getScaledWidth();
        final int centerX = right / 2;
        final int centerY = bottom / 2;
        final FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;

        // for example here we draw text on the screen
        final String text = "Nebula Client";

        Gui.drawRect(centerX - 150, centerY + 150, centerX + 150, centerY - 150, 0xAA888888);
        fr.drawStringWithShadow(text, centerX - 5, centerY - 15, 0x00FFFF);

    }

}
