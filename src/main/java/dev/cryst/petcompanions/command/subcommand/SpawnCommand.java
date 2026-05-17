package dev.cryst.petcompanions.command.subcommand;

import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import dev.cryst.petcompanions.pet.Pet;
import dev.cryst.petcompanions.pet.species.NormalPet;
import dev.cryst.petcompanions.service.PetService;

import java.util.List;

@AllArgsConstructor
public class SpawnCommand implements SubCommand{
    private final PetService petService;

    @Override
    public String getName() {
        return "spawn";
    }

    @Override
    public String getPermission() {
        return "";
    }

    @Override
    public void execute(Player player, String[] args) {

        if (petService.getPet(player) != null) {
            player.sendMessage("У вас уже есть питомец!");
            return;
        }

        Pet pet = new NormalPet("Pet", List.of("Okak"), 1, player);
        petService.spawnPet(pet);
        player.sendMessage("Ваш питомец заспавнен!");
    }
}
