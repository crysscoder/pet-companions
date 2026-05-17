package dev.cryst.petcompanions.command.subcommand;

import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import dev.cryst.petcompanions.pet.Pet;
import dev.cryst.petcompanions.service.PetService;

@AllArgsConstructor
public class DespawnCommand implements SubCommand{
    private final PetService petService;

    @Override
    public String getName() {
        return "despawn";
    }

    @Override
    public String getPermission() {
        return "";
    }

    @Override
    public void execute(Player player, String[] args) {
        Pet pet = petService.getPet(player);
        if(pet != null){
            petService.despawnPet(player);
        }
    }
}
