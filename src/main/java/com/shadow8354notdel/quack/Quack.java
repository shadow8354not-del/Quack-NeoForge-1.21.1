package com.shadow8354notdel.quack;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Quack.MODID)
public class Quack {
    public static final String MODID = "quack";

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredItem<Item> RUBBER_DUCK = ITEMS.register(
            "rubber_duck",
            () -> new RubberDuckItem(new Item.Properties().stacksTo(1))
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> QUACK_TAB =
            CREATIVE_MODE_TABS.register("quack", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.quack"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> RUBBER_DUCK.get().getDefaultInstance())
                    .displayItems((parameters, output) -> output.accept(RUBBER_DUCK.get()))
                    .build());

    public Quack(IEventBus modEventBus, ModContainer modContainer) {
        QuackSounds.SOUND_EVENTS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
    }
}
