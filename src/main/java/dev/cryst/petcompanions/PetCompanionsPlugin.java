package dev.cryst.petcompanions;

import org.bukkit.plugin.java.JavaPlugin;
import dev.cryst.petcompanions.command.PetCommand;
import dev.cryst.petcompanions.command.subcommand.DespawnCommand;
import dev.cryst.petcompanions.command.subcommand.SpawnCommand;
import dev.cryst.petcompanions.service.PetService;

import java.util.Objects;

public final class PetCompanionsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        PetCommand petCommand = new PetCommand();
        PetService petService = new PetService(this);


        petCommand.register(new SpawnCommand(petService));
        petCommand.register(new DespawnCommand(petService));

        Objects.requireNonNull(getCommand("pet")).setExecutor(petCommand);

    }


    @Override
    public void onDisable() {


    }
}
