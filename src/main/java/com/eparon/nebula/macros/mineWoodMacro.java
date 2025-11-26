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
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ChatComponentText;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.client.entity.EntityPlayerSP;
// 8,
public class mineWoodMacro {
    final Minecraft mcStatic = Minecraft.getMinecraft();
    final EntityPlayerSP playerStatic = mcStatic.thePlayer;
    MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();



    public static void WoodMacroMain() {

        mineWoodMacro mineWoodMacro = new mineWoodMacro();
        final Minecraft mc = mineWoodMacro.mcStatic;
        final EntityPlayerSP player = mineWoodMacro.playerStatic;

        World world = mc.theWorld;
        boolean targetFound = false;

        BlockPos targetBlockToBreak;
        //do{
        targetBlockToBreak = loop(player.posX, player.posY, player.posZ, "minecraft:cobblestone");
            //KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);

        //} while(targetFound == false);

    }
    public static BlockPos loop(double px, double py, double pz, String targetBlockName){
        mineWoodMacro mineWoodMacro = new mineWoodMacro();
        final Minecraft mc = mineWoodMacro.mcStatic;
        final EntityPlayerSP player = mineWoodMacro.playerStatic;
        World world = mc.theWorld;

        Block targetBlock = Block.getBlockFromName(targetBlockName);
        double[] coords = {px, py, pz};
        int searchedRings = 0;

        while(searchedRings <= 128){

            searchedRings++;
            player.addChatMessage(new ChatComponentText("Starting -- Rings to search: " + searchedRings));
            int searched = 0;
            double searchedTarget = Math.pow(2 * (searchedRings + 1) - 1, 2) - Math.pow(2 * (searchedRings) - 1, 2);
            double x = px - searchedRings;
            double z = pz - searchedRings;
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
                    player.addChatMessage(new ChatComponentText("DONE! found block at: " + _pos));
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
                    player.addChatMessage(new ChatComponentText("DONE! found block at: " + _pos));
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
                    player.addChatMessage(new ChatComponentText("DONE! found block at: " + _pos));
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
                    player.addChatMessage(new ChatComponentText("DONE! found block at: " + _pos));
                    return _pos;

                }

            }
            player.addChatMessage(new ChatComponentText("---------------Done-------------"));
        }
        BlockPos notFound = new BlockPos(px, py, pz);
        player.addChatMessage(new ChatComponentText("Block not found, returning player's position"));
        return notFound;



    }
}