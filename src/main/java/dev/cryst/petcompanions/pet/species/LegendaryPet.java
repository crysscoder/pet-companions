package dev.cryst.petcompanions.pet.species;

import org.bukkit.entity.Player;
import dev.cryst.petcompanions.pet.Pet;

import java.util.List;

public class LegendaryPet extends Pet {
    public LegendaryPet(String name, List<String> description, int level, Player owner) {
        super(name, description, level, owner);
    }
}
