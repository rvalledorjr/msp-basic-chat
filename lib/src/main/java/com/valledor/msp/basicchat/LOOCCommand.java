package com.valledor.msp.basicchat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LOOCCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
      @NotNull String[] args) {
    if (!(sender instanceof Player))
      return false;

    var player = (Player) sender;
    for (var entity : player.getNearbyEntities(20, 20, 20)) {
      if (!(entity instanceof Player))
        continue;

      var nearbyPlayer = (Player) entity;
      nearbyPlayer.sendMessage(String.join(" ", args));
    }

    sender.sendMessage(String.join(" ", args));

    return true;
  }

}
