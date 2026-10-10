package com.example.examplemod;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue SHOW_QUACK_MESSAGE = BUILDER
            .comment("Whether using the rubber duck sends a chat message.")
            .translation("examplemod.configuration.showQuackMessage")
            .define("show_quack_message", true);

    static final ModConfigSpec SPEC = BUILDER.build();
}
