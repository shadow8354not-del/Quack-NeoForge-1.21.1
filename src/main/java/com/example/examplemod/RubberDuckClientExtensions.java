package com.example.examplemod;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class RubberDuckClientExtensions implements IClientItemExtensions {

    @Override
    public boolean applyForgeHandTransform(
            PoseStack poseStack,
            LocalPlayer player,
            HumanoidArm arm,
            ItemStack itemInHand,
            float partialTick,
            float equipProcess,
            float swingProcess
    ) {

        if (player.isUsingItem()
                && player.getUseItem().is(ExampleMod.RUBBER_DUCK.get())) {

            float remaining = player.getUseItemRemainingTicks() - partialTick;
            float progress = 1.0F - remaining / 8.0F;

            progress = Math.max(0.0F, Math.min(1.0F, progress));

            float squash = 1.0F
                    - 0.4F * (float) Math.sin(progress * Math.PI);

            poseStack.scale(1.0F, squash, 1.0F);
        }

        return false;
    }
}