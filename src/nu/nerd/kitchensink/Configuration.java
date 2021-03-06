package nu.nerd.kitchensink;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;

enum countdown {
    maxtime, format, color, style, msgcolor, msgstyle
};

public class Configuration {

    private final KitchenSink plugin;

    public boolean DEBUG_DISABLE_TNT;

    public boolean ANIMAL_COUNT;
    public boolean LOG_ANIMAL_DEATH;
    public boolean LOG_PLAYER_DROPS;
    public int BUFF_DROPS;
    public int BUFF_SHEAR_DROPS;
    public boolean DISABLE_SNOW;
    public boolean DISABLE_DROPS;
    public boolean DISABLE_TNT;
    public boolean DISABLE_INVISIBILITY_ON_COMBAT;
    public boolean DISABLE_GOLEM_NATURAL_SPAWN;
    public boolean LOWER_STRENGTH_POTION_DAMAGE;
    public double HEALTH_POTION_MULTIPLIER;
    public double REGEN_POTION_MULTIPLIER;
    public boolean BLOCK_CAPS;
    public boolean BLOCK_VILLAGERS;
    public boolean SAFE_ICE;
    public boolean SAFE_DISPENSERS;
    public boolean SAFE_BOATS;
    public int SAFE_BOATS_DELAY;
    public boolean SAFE_BOATS_DROP;
    public boolean SAFE_MINECARTS;
    public int SAFE_MINECARTS_DELAY;
    public boolean SAFE_MINECARTS_DROP;
    public boolean SAFE_SPECIAL_CARTS;
    public boolean REMOVE_ON_EXIT;
    public boolean SAFE_PORTALS;
    public int PEARL_DAMAGE;
    public boolean LEATHERLESS_BOOKS;
    public boolean LOCK_HORSES;
    public boolean INVULNERABLE_TAME_HORSES;
    public boolean UNTAME_PETS;
    public boolean HOST_KEYS_CHECK;
    public boolean HOST_KEYS_DROP_PERMISSIONS;
    public boolean WARN_RESTART_ON_JOIN;
    public boolean WARN_RESTART_ON_INVENTORY_OPEN;
    public int SPRINT_MAX_TICKS;
    public int COUNTDOWN_MAX_TIME;
    public String COUNTDOWN_FORMAT;
    public String COUNTDOWN_COLOR;
    public String COUNTDOWN_STYLE;
    public String COUNTDOWN_MSG_COLOR;
    public String COUNTDOWN_MSG_STYLE;
    public boolean CULL_ZOMBIES;
    public int CULL_ZOMBIES_INTERVAL;
    public List<String> RESTART_TIMES;
    public List<Integer> ALLOW_ENCH_ITEMS;
    public List<Integer> BLOCK_CRAFT;
    public List<Integer> BLOCK_BREW;
    public List<Integer> DISABLED_LEFT_ITEMS;
    public List<Integer> DISABLED_RIGHT_ITEMS;
    public List<Integer> DISABLE_DISPENSED;
    public List<Integer> DISABLE_BUFF;
    public Map<EntityType, Set<Material>> DISABLED_DROPS;
    public EnumSet<EntityType> DISABLE_ENTITY_BLOCK_DAMAGE = EnumSet.noneOf(EntityType.class);
    public boolean ALLOW_EGG_HATCHING;
    public boolean DISABLE_PEARL_DROPS_IN_END;
    public boolean DISABLE_PLAYER_DAMAGE_TO_VILLAGERS;
    public boolean NORMALIZE_CHAT;

    public Configuration(KitchenSink instance) {
        plugin = instance;
    }

    public void load() {
        plugin.reloadConfig();

        DEBUG_DISABLE_TNT = plugin.getConfig().getBoolean("debug.disable-tnt");
        ANIMAL_COUNT = plugin.getConfig().getBoolean("animal-count");
        LOG_ANIMAL_DEATH = plugin.getConfig().getBoolean("log-animals");
        LOG_PLAYER_DROPS = plugin.getConfig().getBoolean("log-player-drops");
        BUFF_DROPS = plugin.getConfig().getInt("buff-drops");
        BUFF_SHEAR_DROPS = plugin.getConfig().getInt("buff-shear-drops");
        DISABLE_SNOW = plugin.getConfig().getBoolean("disable-snowgrow");
        DISABLE_DROPS = plugin.getConfig().getBoolean("disable-drops");
        DISABLE_TNT = plugin.getConfig().getBoolean("disable-tnt");
        DISABLE_INVISIBILITY_ON_COMBAT = plugin.getConfig().getBoolean("disable-invisibility-on-combat");
        DISABLE_GOLEM_NATURAL_SPAWN = plugin.getConfig().getBoolean("disable-golem-natural-spawn", false);
        LOWER_STRENGTH_POTION_DAMAGE = plugin.getConfig().getBoolean("lower-strength-potion-damage");
        HEALTH_POTION_MULTIPLIER = plugin.getConfig().getDouble("health-potion-multiplier", 1.0);
        REGEN_POTION_MULTIPLIER = plugin.getConfig().getDouble("regen-potion-multiplier", 1.0);
        BLOCK_CAPS = plugin.getConfig().getBoolean("block-caps");
        BLOCK_VILLAGERS = plugin.getConfig().getBoolean("block-villagers");
        SAFE_ICE = plugin.getConfig().getBoolean("safe-ice");
        SAFE_DISPENSERS = plugin.getConfig().getBoolean("safe-dispensers");
        SAFE_BOATS = plugin.getConfig().getBoolean("safe-boats");
        SAFE_BOATS_DELAY = plugin.getConfig().getInt("safe-boats-delay");
        SAFE_BOATS_DROP = plugin.getConfig().getBoolean("safe-boats-drop");
        SAFE_MINECARTS = plugin.getConfig().getBoolean("safe-minecarts");
        SAFE_MINECARTS_DELAY = plugin.getConfig().getInt("safe-minecarts-delay");
        SAFE_MINECARTS_DROP = plugin.getConfig().getBoolean("safe-minecarts-drop");
        SAFE_SPECIAL_CARTS = plugin.getConfig().getBoolean("safe-special-carts");
        REMOVE_ON_EXIT = plugin.getConfig().getBoolean("remove-on-exit");
        SAFE_PORTALS = plugin.getConfig().getBoolean("safe-portals");
        PEARL_DAMAGE = plugin.getConfig().getInt("pearl-damage");
        LEATHERLESS_BOOKS = plugin.getConfig().getBoolean("leatherless-books");
        LOCK_HORSES = plugin.getConfig().getBoolean("lock-horses");
        INVULNERABLE_TAME_HORSES = plugin.getConfig().getBoolean("invulnerable-tame-horses");
        UNTAME_PETS = plugin.getConfig().getBoolean("untame-pets");
        HOST_KEYS_CHECK = plugin.getConfig().getBoolean("host-keys-check");
        HOST_KEYS_DROP_PERMISSIONS = plugin.getConfig().getBoolean("host-keys-drop-permissions");
        ALLOW_ENCH_ITEMS = plugin.getConfig().getIntegerList("allow-enchant-items");
        BLOCK_CRAFT = plugin.getConfig().getIntegerList("block-craft");
        BLOCK_BREW = plugin.getConfig().getIntegerList("block-brew");
        DISABLED_LEFT_ITEMS = plugin.getConfig().getIntegerList("disabled-items.left-click");
        DISABLED_RIGHT_ITEMS = plugin.getConfig().getIntegerList("disabled-items.right-click");
        DISABLE_DISPENSED = plugin.getConfig().getIntegerList("disabled-items.dispensed");
        DISABLE_BUFF = plugin.getConfig().getIntegerList("disable-buff");
        DISABLED_DROPS = new EnumMap<EntityType, Set<Material>>(EntityType.class);
        ConfigurationSection disabledDropsSection = plugin.getConfig()
        .getConfigurationSection("disabled-drops");
        if (disabledDropsSection != null) {
            for (String key : disabledDropsSection.getKeys(false)) {
                try {
                    EntityType type = EntityType.valueOf(key.toUpperCase());
                    List<String> matStrings = disabledDropsSection.getStringList(key);
                    Set<Material> mats = EnumSet.noneOf(Material.class);
                    for (String matString : matStrings) {
                        try {
                            mats.add(Material.valueOf(matString.toUpperCase()));
                        } catch (IllegalArgumentException e) {
                            plugin.getLogger().warning("disabled-drops." + key
                                                       + " contains an invalid material" + matString);
                        }
                    }
                    DISABLED_DROPS.put(type, mats);
                } catch (IllegalArgumentException e) {
                    plugin.getLogger().warning("disabled-drops contains invalid entity type "
                                               + key);
                }
            }
        }
        for (String entityTypeName : plugin.getConfig().getStringList("disable-entity-block-damage")) {
            try {
                EntityType entityType = EntityType.valueOf(entityTypeName);
                DISABLE_ENTITY_BLOCK_DAMAGE.add(entityType);
            } catch (IllegalArgumentException ex) {
                plugin.getLogger().warning("disable-entity-block-damage contains invalid entity type " + entityTypeName);
            }
        }
        WARN_RESTART_ON_JOIN = plugin.getConfig().getBoolean("warn-restart-on-join");
        WARN_RESTART_ON_INVENTORY_OPEN = plugin.getConfig().getBoolean("warn-restart-on-inventory-open");
        SPRINT_MAX_TICKS = plugin.getConfig().getInt("sprint-max-time", 0);
        COUNTDOWN_MAX_TIME = plugin.getConfig().getInt("countdown.maxtime", 15);
        COUNTDOWN_FORMAT = plugin.getConfig().getString("countdown.format", ">>$s<<");
        if (!COUNTDOWN_FORMAT.contains("$s")) {
            COUNTDOWN_FORMAT = ">>$s<<";
        }
        COUNTDOWN_COLOR = plugin.getConfig().getString("countdown.color", "&c");
        COUNTDOWN_STYLE = plugin.getConfig().getString("countdown.style", "&l");
        COUNTDOWN_MSG_COLOR = plugin.getConfig().getString("countdown.msgColor", "&a");
        COUNTDOWN_MSG_STYLE = plugin.getConfig().getString("countdown.msgStyle", "&l");
        CULL_ZOMBIES = plugin.getConfig().getBoolean("cull-zombies", true);
        CULL_ZOMBIES_INTERVAL = plugin.getConfig().getInt("cull-zombies-interval", 1200);
        RESTART_TIMES = plugin.getConfig().getStringList("restart-times");
        ALLOW_EGG_HATCHING = plugin.getConfig().getBoolean("allow-egg-hatching", true);
        DISABLE_PEARL_DROPS_IN_END = plugin.getConfig().getBoolean("disable-pearl-drops-in-end", false);
        DISABLE_PLAYER_DAMAGE_TO_VILLAGERS = plugin.getConfig().getBoolean("disable-player-damage-to-villagers", false);
        NORMALIZE_CHAT = plugin.getConfig().getBoolean("normalize-chat", true);
    }

    protected void setCountDownSetting(countdown setting, Object value) {
        plugin.reloadConfig();
        switch (setting) {
        case maxtime:
            COUNTDOWN_MAX_TIME = (Integer) value;
            plugin.getConfig().set("countdown.maxTime", value);
            break;
        case format:
            COUNTDOWN_FORMAT = (String) value;
            plugin.getConfig().set("countdown.format", value);
            break;
        case color:
            COUNTDOWN_COLOR = (String) value;
            plugin.getConfig().set("countdown.color", value);
            break;
        case style:
            COUNTDOWN_STYLE = (String) value;
            plugin.getConfig().set("countdown.style", value);
            break;
        case msgcolor:
            COUNTDOWN_MSG_COLOR = (String) value;
            plugin.getConfig().set("countdown.msgcolor", value);
        case msgstyle:
            COUNTDOWN_MSG_STYLE = (String) value;
            plugin.getConfig().set("countdown.msgstyle", value);
        }
        plugin.saveConfig();
    }
}
