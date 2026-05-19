package io.github.crysscoder.petcompanions.service;

import io.github.crysscoder.petcompanions.pet.Pet;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PetService {
    private final JavaPlugin plugin;
    private final Map<UUID, Pet> activePet = new HashMap<>();
    private BukkitTask task;

    public PetService(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void spawnPet(Pet pet) {
        despawnPet(pet.getOwner());
        pet.spawn();
        activePet.put(pet.getOwner().getUniqueId(), pet);
        if (task == null || task.isCancelled()) {
            task = Bukkit.getScheduler().runTaskTimer(plugin, this::updatePets, 0L, 2L);
        }
    }

    public void despawnPet(Player player) {
        Pet pet = activePet.remove(player.getUniqueId());
        if (pet != null) {
            pet.despawn();
        }
        if (activePet.isEmpty() && task != null) {
            task.cancel();
            task = null;
        }
    }

    public Pet getPet(Player player) {
        return activePet.get(player.getUniqueId());
    }

    public void updatePets() {
        activePet.values().removeIf(pet -> {
            if (pet.getOwner().isOnline()) {
                return false;
            }
            pet.despawn();
            return true;
        });
        for (Pet pet : activePet.values()) {
            pet.follow();
        }
        if (activePet.isEmpty() && task != null) {
            task.cancel();
            task = null;
        }
    }

    public void shutdown() {
        if (task != null) {
            task.cancel();
            task = null;
        }
        activePet.values().forEach(Pet::despawn);
        activePet.clear();
    }
}
