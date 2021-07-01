package com.giner.modginer.entities;

import com.giner.modginer.init.ModEntityClass;
import com.giner.modginer.init.SoundInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class JadeBeetleEntity extends AnimalEntity {

    public JadeBeetleEntity(EntityType<? extends AnimalEntity> type, World worldIn) {

        super(type, worldIn);
    }

    // ModItems.ITEMNAME.get()
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {

        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new AvoidEntityGoal<PlayerEntity>(this, PlayerEntity.class, 10F, 1.75F,1.75F));
        this.goalSelector.addGoal(0, new AvoidEntityGoal<VillagerEntity>(this, VillagerEntity.class, 10F, 1.75F,1.75F));
        this.goalSelector.addGoal(1, new FleeSunGoal(this, 3.0F));
        this.goalSelector.addGoal(2, new SwimGoal(this));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new PanicGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(6, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new FollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(9, new LookRandomlyGoal(this));
    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return 3 + this.getCommandSenderWorld().random.nextInt(3);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundInit.FROGIDLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.HONEY_BLOCK_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.FROGDEATH.get();
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        //VANILLA VALUES
        this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }
}
