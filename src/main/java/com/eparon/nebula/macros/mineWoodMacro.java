package com.eparon.nebula.macros;
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
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
// 8,
public class mineWoodMacro {
    final EntityPlayerSP player = mc.thePlayer;
    boolean targetFound = false;
    int searchedBlocksCounter = 0;
    int searchedBlocksCounterIncrement = 1;
    int searchedBlocksCounterTarget = 1 ;
    int searchedBlocksRing = 1;
    public static void WoodMacroMain() {
        final Minecraft mc = Minecraft.getMinecraft();
        do{
            //int seatchedBlocksCounterTarget = Math.pow(searchedBlocksCounterIncrement, 2) - Math.pow(searchedBlocksCounterIncrement - 2, 2);
            for(int i = 1; i <= searchedBlocksCounterTarget; i++) {

                BlockPos pos = new BlockPos(player.posx, player.posy, player.posz - searchedBlocksRing);
                BlockPos pos2 = new BlockPos(player.posx);

            }

        } while(targetFound == false);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
        }
    }
}