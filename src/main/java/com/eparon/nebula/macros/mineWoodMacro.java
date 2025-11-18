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
                for(int j = 0; j <  searchedBlocksRing * 2 + 1; j++) {
                    BlockPos _pos = new BlockPos(player.posx - searchedBlocksRing + j, player.posy, player.posz - searchedBlocksRing);
                }
                //BlockPos pos = new BlockPos(player.posx, player.posy, player.posz - searchedBlocksRing);



            }

        } while(targetFound == false);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
        }
    }
    public static int[] loop(int px, int py, int pz, String targetBlock){
        int[] coords = {px, py, pz};
        int searchedRings = 0;
        while(searchedRings != 3){

            searchedRings++;
            System.out.println("--------Starting-------\n"+ " Rings to search: " + searchedRings);
            int searched = 0;
            double searchedTarget = Math.pow(2 * (searchedRings + 1) - 1, 2) - Math.pow(2 * (searchedRings) - 1, 2);
            int x = px - searchedRings;
            int z = pz - searchedRings;
            coords[0] = x;
            coords[2] = z;
            System.out.println("Blocks to be searched: " + searchedTarget);
            System.out.println(coords[0] + " " +  coords[1] + " " +  coords[2]);

            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                x++;
                coords[0] = x;
                coords[2] = z;
                System.out.println(coords[0] + " " +  coords[1] + " " +  coords[2]);
            }
            System.out.println(coords[0] + " " +  coords[1] + " " +  coords[2]);
            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                z++;
                coords[0] = x;
                coords[2] = z;
                System.out.println(coords[0] + " " +  coords[1] + " " +  coords[2]);
            }
            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                x--;
                coords[0] = x;
                coords[2] = z;
                System.out.println(coords[0] + " " +  coords[1] + " " +  coords[2]);
            }
            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                z--;
                coords[0] = x;
                coords[2] = z;
                System.out.println(coords[0] + " " +  coords[1] + " " +  coords[2]);

            }
            System.out.println("-------------Done-------------");
        }

        return coords;
    }
}