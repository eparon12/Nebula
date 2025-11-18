

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

public class mineWoodMacro {
    final EntityPlayerSP player = mc.thePlayer;
    boolean targetFound = false;
    int searchedBlocksCounter = 0;
    int searchedBlocksCounterIncrement = 1;
    int searchedBlocksCounterTarget = 1 ;
    int searchedBlocksRing = 1;
    public static void WoodMacroMain() {
        final Minecraft mc = Minecraft.getMinecraft();


                class Main {
    public static void loop(String[] args, double px, double py, double pz, Block) {
        int[] coords = {px, py, pz};


        int searchedRings = 2;
        int searched = 0;

        double searchedTarget = Math.pow(2 * (searchedRings + 1) - 1, 2);

        while(searched < searchedTarget){
            int x = coords[0] - searchedRings;
            int z = coords[2] - searchedRings;
            coords[0] = x;
            coords[2] = z;

            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                x++;
                coords[0] = x;
                coords[2] = z;
            }
            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                z++;
                coords[0] = x;
                coords[2] = z;
            }
            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                x--;
                coords[0] = x;
                coords[2] = z;

            }
            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                z--;
                coords[0] = x;
                coords[2] = z;
            }
        }
    }
}

            //int seatchedBlocksCounterTarget = Math.pow(searchedBlocksCounterIncrement, 2) - Math.pow(searchedBlocksCounterIncrement - 2, 2);



         //while(targetFound == false);
        //KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);

