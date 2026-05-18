package io.github.crysscoder.petcompanions.pet.species;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import io.github.crysscoder.petcompanions.pet.Pet;
import io.github.crysscoder.petcompanions.util.CustomHead;

import java.util.List;

public class NormalPet extends Pet {

    String hamsterBase64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZmNzNiYmFmZDg5ZDY4M2Q0YmQ2YzljMWU0MWYzNzAxNTMxMGYwYzdhYWVjNDlmMmQ1ZDJkZWI2MDBkMTQ3In19fQ==";

    public NormalPet(String name, List<String> description, int level, Player owner) {
        super(name, description, level, owner);
    }


    @Override
    public void spawn() {
        super.spawn();

        ItemStack head = CustomHead.getCustomHead(hamsterBase64);
        stand.getEquipment().setHelmet(head);
    }

}
