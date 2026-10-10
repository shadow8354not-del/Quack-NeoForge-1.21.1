package com.example.examplemod;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final String MODID = "examplemod";

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> RUBBER_DUCK = ITEMS.register(
            "rubber_duck",
            () -> new RubberDuckItem(new Item.Properties().stacksTo(1))
    );

    public ExampleMod(IEventBus modEventBus, ModContainer modContainer) {
        ModSounds.SOUND_EVENTS.register(modEventBus);
        ITEMS.register(modEventBus);
        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(RUBBER_DUCK);
        }
    }
}
