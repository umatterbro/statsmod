package xyz.squables.statsmod;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.squables.statsmod.cmd.Command;
import xyz.squables.statsmod.cmd.CommandRegistrar;
import xyz.squables.statsmod.cmd.cmds.StatsCommand;
import xyz.squables.statsmod.cmd.tc.cmds.StatsCommandTabComplete;
import xyz.squables.statsmod.cmd.tc.TabCompleteRegistrar;
import xyz.squables.statsmod.events.EventRegistrar;
import xyz.squables.statsmod.events.chat.AnswerChatSent;
import xyz.squables.statsmod.events.chat.PlayerJoin;
import xyz.squables.statsmod.events.custom.CustomEventRegistrar;
import xyz.squables.statsmod.events.custom.all.*;

import java.util.Map;

public final class Statsmod extends JavaPlugin {
    private static Statsmod instance;
    private static PlayerQuestions pq;

    public static Statsmod getInstance() {
        return instance;
    }

    public static PlayerQuestions getPq() {
        return pq;
    }

    @Override
    public void onEnable() {
        instance = this;
        pq = new PlayerQuestions();

        new EventRegistrar(
                new AnswerChatSent(),
                new PlayerJoin()
        );

        new CustomEventRegistrar(
                new AsyncPlayerChatCustomEvent(),
                new BellRingCustomEvent(),
                new BlockBreakCustomEvent(),
                new BlockDamageCustomEvent(),
                new BlockDispenseArmorCustomEvent(),
                new BlockDispenseLootCustomEvent(),
                new BlockDropItemCustomEvent(),
                new BlockFertilizeCustomEvent(),
                new BlockIgniteCustomEvent(),
                new BlockMultiPlaceCustomEvent(),
                new BlockPlaceCustomEvent(),
                new BlockShearEntityCustomEvent(),
                new CauldronLevelChangeCustomEvent(),
                new EnchantItemCustomEvent(),
                new EntityDamageByBlockCustomEvent(),
                new EntityDamageByEntityCustomEvent(),
                new EntityDamageCustomEvent(),
                new EntityDismountCustomEvent(),
                new EntityDropItemCustomEvent(),
                new EntityEnterBlockCustomEvent(),
                new EntityExhaustionCustomEvent(),
                new EntityExplodeCustomEvent(),
                new EntityInteractCustomEvent(),
                new EntityKnockbackByEntityCustomEvent(),
                new EntityMountCustomEvent(),
                new EntityPickupItemCustomEvent(),
                new EntityPortalCustomEvent(),
                new EntityPortalExitCustomEvent(),
                new EntityPotionEffectCustomEvent(),
                new EntityRegainHealthCustomEvent(),
                new EntityShootBowCustomEvent(),
                new EntityTameCustomEvent(),
                new EntityTargetCustomEvent(),
                new EntityTargetLivingEntityCustomEvent(),
                new EntityTeleportCustomEvent(),
                new EntityToggleGlideCustomEvent(),
                new EntityToggleSwimCustomEvent(),
                new FoodLevelChangeCustomEvent(),
                new InventoryOpenCustomEvent(),
                new PigZombieAngerCustomEvent(),
                new PlayerAnimationCustomEvent(),
                new PlayerArmorStandManipulateCustomEvent(),
                new PlayerBedEnterCustomEvent(),
                new PlayerBucketCustomEvent(),
                new PlayerBucketEmptyCustomEvent(),
                new PlayerBucketEntityCustomEvent(),
                new PlayerBucketFillCustomEvent(),
                new PlayerEditBookCustomEvent(),
                new PlayerFishCustomEvent(),
                new PlayerHarvestBlockCustomEvent(),
                new PlayerInteractEntityCustomEvent(),
                new PlayerItemConsumeCustomEvent(),
                new PlayerItemDamageCustomEvent(),
                new PlayerItemMendCustomEvent(),
                new PlayerLeashEntityCustomEvent(),
                new PlayerMoveCustomEvent(),
                new PlayerPickupArrowCustomEvent(),
                new PlayerSwapHandItemsCustomEvent(),
                new PlayerTakeLecternBookCustomEvent(),
                new PlayerToggleFlightCustomEvent(),
                new PlayerToggleSneakCustomEvent(),
                new PlayerToggleSprintCustomEvent(),
                new PlayerUnleashEntityCustomEvent(),
                new PlayerVelocityCustomEvent(),
                new PortalCreateCustomEvent(),
                new PotionSplashCustomEvent(),
                new ProjectileHitCustomEvent(),
                new RaidTriggerCustomEvent(),
                new SheepDyeWoolCustomEvent(),
                new TNTPrimeCustomEvent()
        );

        new CommandRegistrar(
                new Command("statsmod", new StatsCommand(), new StatsCommandTabComplete())
        );

        /*new TabCompleteRegistrar(Map.ofEntries(
                Map.entry("statsmod", new StatsCommandTabComplete())
        ));*/
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
