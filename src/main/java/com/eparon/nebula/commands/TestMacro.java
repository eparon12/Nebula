package com.eparon.nebula.commands;
import com.eparon.nebula.macros.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.util.List;

public class TestMacro extends CommandBase {

    public static boolean isMacroing = false;

    @Override
    public String getCommandName() {
        return "nebula";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + this.getCommandName();
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true; // anyone can use it client-side
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        sender.addChatMessage(new ChatComponentText("nebula active"));

        if (args.length > 0 && args[0].equalsIgnoreCase("run")) {
            sender.addChatMessage(new ChatComponentText("running macro"));
            isMacroing = true;
        }
        if (args.length > 0 && args[0].equalsIgnoreCase("run")) {
            sender.addChatMessage(new ChatComponentText("running macro"));
            isMacroing = true;
        }
        if (args.length > 0 && args[0].equalsIgnoreCase("stop")) {
            sender.addChatMessage(new ChatComponentText("stopping macro"));
            isMacroing = false;
        }
        if (args.length > 0 && args[0].equalsIgnoreCase("runWood")) {
            sender.addChatMessage(new ChatComponentText("starting wood mining macro"));
            mineWoodMacro.WoodMacroMain();
        }
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        final String[] options = new String[]{"run"};
        return getListOfStringsMatchingLastWord(args, options);
    }
}
