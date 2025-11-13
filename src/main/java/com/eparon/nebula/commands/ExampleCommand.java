package com.eparon.nebula.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import java.util.List;

public class ExampleCommand extends CommandBase {
    public static boolean openMainHUD;
    @Override
    public String getCommandName() {
        return "bip";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + this.getCommandName();
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true; // return true otherwise you won't be able to use the command
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        sender.addChatMessage(new ChatComponentText("opening hud"));

        if (args.length > 0 && args[0].equalsIgnoreCase("open")) {

            sender.addChatMessage(new ChatComponentText("actually opening"));
            openMainHUD = true;

        } else if (args.length > 0 && args[0].equalsIgnoreCase("saf")) {

            sender.addChatMessage(new ChatComponentText("hello saf"));

        } else if (args.length > 0 && args[0].equalsIgnoreCase("eparon")) {

            sender.addChatMessage(new ChatComponentText("hello eparon"));

        }

    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        // when you type the command and press tab complete,
        // this method will allow you to cycle through the words that match what you typed
        final String[] options = new String[]{"sigma", "option2", "option3"};
        return getListOfStringsMatchingLastWord(args, options);
    }

}
