package io.github.crysscoder.petcompanions;

import org.bukkit.plugin.java.JavaPlugin;
import io.github.crysscoder.petcompanions.command.PetCommand;
import io.github.crysscoder.petcompanions.command.subcommand.DespawnCommand;
import io.github.crysscoder.petcompanions.command.subcommand.SpawnCommand;
import io.github.crysscoder.petcompanions.service.PetService;

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
