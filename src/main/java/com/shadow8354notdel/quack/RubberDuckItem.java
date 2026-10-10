package com.shadow8354notdel.quack;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RubberDuckItem extends Item {
    public RubberDuckItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        player.startUsingItem(usedHand);

        if (!level.isClientSide) {
            if (Config.SHOW_QUACK_MESSAGE.get()) {
                player.sendSystemMessage(Component.translatable("message.quack.quack"));
            }
            player.getCooldowns().addCooldown(this, 20);
        }

        level.playSound(
                player,
                player.getX(),
                player.getY(),
                player.getZ(),
                QuackSounds.QUACK.get(),
                SoundSource.PLAYERS,
                1.0F,
                1.0F
        );

        return InteractionResultHolder.consume(player.getItemInHand(usedHand));
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 8;
    }
}
