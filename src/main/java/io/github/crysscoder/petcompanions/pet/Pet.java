package io.github.crysscoder.petcompanions.pet;

import lombok.Data;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;

@Data
public abstract class Pet {
    protected final String name;
    protected final List<String> description;
    protected final int level;
    protected final Player owner;
    protected ArmorStand stand;

    public void spawn(){
        Location loc = owner.getLocation().add(1, 0.5, 0);
        stand = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        stand.setVisible(false);
        stand.setGravity(false);
        stand.setMarker(true);
        stand.setSmall(true);
    }

    public void follow() {
        if (stand == null || stand.isDead() || owner == null || !owner.isOnline()) return;

        Location playerLoc = owner.getLocation();

        Vector forward = playerLoc.getDirection().normalize();

        Vector side = forward.clone().crossProduct(new Vector(0, 1, 0)).normalize();

        Location target = playerLoc.clone()
                .add(side.multiply(1.2))
                .add(0, 0.6, 0);

        Location current = stand.getLocation();
        Vector move = target.toVector().subtract(current.toVector());

        if (move.length() < 0.1) return;

        if (move.length() > 10) {
            stand.teleport(target);
            return;
        }

        Location newLoc = current.add(move.multiply(0.2));
        newLoc.setDirection(playerLoc.getDirection());

        stand.teleport(newLoc);
    }

    public void despawn(){
        if(stand != null && !stand.isDead()) stand.remove();

    }

}
