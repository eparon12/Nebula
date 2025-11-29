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

public class pathFinding {
    public static void setpitch (BlockPos targetBlock){
        double goalX = targetBlock.getX();
        double goalZ = targetBlock.getZ();
        double goalY = targetBlock.getY();


    }
    public static void gototarget (BlockPos targetBlock){
        double goalX = targetBlock.getX();
        double goalZ = targetBlock.getZ();
        double goalY = targetBlock.getY();



    }

}