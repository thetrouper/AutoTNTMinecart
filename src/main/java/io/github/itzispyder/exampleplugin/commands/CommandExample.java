/**
 * This file is for tutorial purposes made by ImproperIssues. Distribute if you want :)
 */

package io.github.itzispyder.exampleplugin.commands;

import io.github.itzispyder.exampleplugin.ExamplePlugin;
import io.github.itzispyder.exampleplugin.exceptions.CmdExHandler;
import io.github.itzispyder.exampleplugin.server.util.ServerUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Example command
 */
public class CommandExample implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            Player P = (Player) sender;
            Player W = Bukkit.getPlayer(args[0]);
            for (int i = 0; i < 1; i++) {
                P.chat("§bWelcome " + W.getName() + "!");
                Bukkit.getScheduler().scheduleSyncDelayedTask(ExamplePlugin.getInstance(),() -> {
                    P.chat("§bDo /daily for a key and /kit for some free gear!");
                }, 20);

            }
            return true;
        } catch (Exception ex) {
            CmdExHandler handler = new CmdExHandler(ex,command);
            sender.sendMessage(handler.getErrorMessage());
            return true;
        }
    }

    /**
     * Example command's tab completer
     */
    public static class Tabs implements TabCompleter {

        @Override
        public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
            List<String> list = new ArrayList<>();
            switch (args.length) {
                case 1 -> list.addAll(ServerUtils.listPlayers());
            }
            list.removeIf(s -> !s.toLowerCase().contains(args[args.length - 1].toLowerCase()));
            return list;
        }
    }
}
