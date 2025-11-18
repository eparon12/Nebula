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
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.lwjgl.input.Mouse;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
// 8,
public class mineWoodMacro {
    final EntityPlayerSP player = mc.thePlayer;
    MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
    WorldServer world = server.worldServers[0];

    boolean targetFound = false;
    public static void WoodMacroMain() {
        final Minecraft mc = Minecraft.getMinecraft();
        BlockPos targetBlockToBreak = new BlockPos();
        BlockPos targetBlockToBreak = loop(player.posx, player.posy, player.posz, "minecraft:cobblestone");
        do{


        } while(targetFound == false);
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);

    }
    public static BlockPos loop(double px, double py, double pz, String targetBlockName){
        Block targetBlock = new Block();
        targetBlock = Block.getBlockFromName(targetBlockName);
        double[] coords = {px, py, pz};
        int searchedRings = 0;

        while(searchedRings <= 128){

            searchedRings++;
            player.addChatMessage(new ChatComponentText("Starting -- Rings to search: " + searchedRings));
            int searched = 0;
            double searchedTarget = Math.pow(2 * (searchedRings + 1) - 1, 2) - Math.pow(2 * (searchedRings) - 1, 2);
            int x = px - searchedRings;
            int z = pz - searchedRings;
            coords[0] = x;
            coords[2] = z;
            player.addChatMessage(new ChatComponentText("Blocks to be searched: " + searchedTarget));
            player.addChatMessage(new ChatComponentText(coords[0] + " " +  coords[1] + " " +  coords[2]));

            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                x++;
                coords[0] = x;
                coords[2] = z;
                player.addChatMessage(new ChatComponentText(coords[0] + " " +  coords[1] + " " +  coords[2]));
                BlockPos _pos = new BlockPos(coords[0], coords[1], coords[2]);
                IBlockState blockState = world.getBlockState(_pos);
                Block _block = blockState.getBlock();
                if(_block == targetBlock) {
                    return _pos;
                }
            }
            player.addChatMessage(new ChatComponentText(coords[0] + " " +  coords[1] + " " +  coords[2]));
            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                z++;
                coords[0] = x;
                coords[2] = z;
                player.addChatMessage(new ChatComponentText(coords[0] + " " +  coords[1] + " " +  coords[2]));
                BlockPos _pos = new BlockPos(coords[0], coords[1], coords[2]);
                IBlockState blockState = world.getBlockState(_pos);
                Block _block = blockState.getBlock();
                if(_block == targetBlock) {
                    return _pos;
                }
            }
            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                x--;
                coords[0] = x;
                coords[2] = z;
                player.addChatMessage(new ChatComponentText(coords[0] + " " +  coords[1] + " " +  coords[2]));
                BlockPos _pos = new BlockPos(coords[0], coords[1], coords[2]);
                IBlockState blockState = world.getBlockState(_pos);
                Block _block = blockState.getBlock();
                if(_block == targetBlock) {
                    return _pos;
                }
            }
            for(int i = 0; i < searchedRings * 2; i++){
                searched++;
                z--;
                coords[0] = x;
                coords[2] = z;
                player.addChatMessage(new ChatComponentText(coords[0] + " " +  coords[1] + " " +  coords[2]));
                BlockPos _pos = new BlockPos(coords[0], coords[1], coords[2]);
                IBlockState blockState = world.getBlockState(_pos);
                Block _block = blockState.getBlock();
                if(_block == targetBlock) {
                    return _pos;
                }

            }
            player.addChatMessage(new ChatComponentText(("---------------Done-------------"));
        }
        BlockPos notFound = new BlockPos(px, py, pz);
        player.addChatMessage(new ChatComponentText("Block not found, returning player's position"));
        return notFound;



    }
}