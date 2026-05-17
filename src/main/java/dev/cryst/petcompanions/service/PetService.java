package dev.cryst.petcompanions.service;

import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import dev.cryst.petcompanions.pet.Pet;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class PetService {
    private final JavaPlugin plugin;
    private final Map<Player, Pet> activePet = new HashMap<>();

    public void spawnPet(Pet pet){
        pet.spawn();
        activePet.put(pet.getOwner(), pet);

        Bukkit.getScheduler().runTaskTimer(plugin, this::updatePets, 0L, 2L);
    }

    public void despawnPet(Player player){
        Pet pet = activePet.remove(player);
        if(pet != null) pet.despawn();
    }

    public Pet getPet(Player player) {
        return activePet.get(player);
    }

    public void updatePets() {
        for (Pet pet : activePet.values()) {
            pet.follow();
        }
    }


}
