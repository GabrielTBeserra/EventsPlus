package br.com.quantum.eventsplus.commands.admin;

import br.com.quantum.eventsplus.core.EventsPlus;
import br.com.quantum.eventsplus.data.PluginData;
import br.com.quantum.eventsplus.entity.CommandBase;
import br.com.quantum.eventsplus.utils.Utilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetEffect extends CommandBase implements TabCompleter {
    public SetEffect(EventsPlus eventsPlus) {
        super(eventsPlus, "seteffect");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {

            for (PotionEffectType effect : PotionEffectType.values()) {
                completions.add(effect.getName());
            }
        }

        Collections.sort(completions);
        return completions;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p;

        try {
            PotionEffectType po = PotionEffectType.getByName(args[0]);

            PotionEffect asd = new PotionEffect(po, 10000000, 10);

            PluginData.event.setEffect(asd.getType());
        } catch (Exception e) {
            sender.sendMessage(Utilities.formatText("&cUse /seteffect <EFFECT>"));
        }
    }
}
