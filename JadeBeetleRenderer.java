package com.giner.modginer.client.render;

import com.giner.modginer.client.model.JadeBeetleModel;
import com.giner.modginer.entities.JadeBeetleEntity;
import com.giner.modginer.modg;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class JadeBeetleRenderer extends MobRenderer<JadeBeetleEntity, JadeBeetleModel<JadeBeetleEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(modg.MOD_ID, "textures/entity/jade_beetle.png");

    public JadeBeetleRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new JadeBeetleModel<JadeBeetleEntity>(), 0.50F);
    }

    @Override
    public ResourceLocation getTextureLocation(JadeBeetleEntity entity) {
        return TEXTURE;
    }
}
