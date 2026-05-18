package io.github.crysscoder.petcompanions.command.subcommand;

import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import io.github.crysscoder.petcompanions.pet.Pet;
import io.github.crysscoder.petcompanions.service.PetService;

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
