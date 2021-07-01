package com.giner.modginer.client.model;

import com.giner.modginer.entities.JadeBeetleEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class JadeBeetleModel<T extends JadeBeetleEntity> extends EntityModel<T> {

    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer bone;
    private final ModelRenderer legs;
    private final ModelRenderer r;
    private final ModelRenderer l;


    // to add new, visit principal class mod, modentityclass in init, in util clienteventbussubscriber and en_us in lang

    public JadeBeetleModel() {
        texHeight = 64;
        texWidth = 64;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 11.0F, 2.0F);
        body.setTexSize(20, 32).addBox(-5.0F, 5.0F, -7.0F, 10.0F, 7.0F, 12.0F, 0.0F, false);
        body.setTexSize(0, 47).addBox(-4.0F, 6.5F, -9.0F, 8.0F, 5.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 17.0F, -6.0F);
        head.setTexSize(34, 52).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 6.0F, 5.0F, 0.0F, false);
        head.setTexSize(0, 60).addBox(-4.5F, 2.0F, -6.0F, 9.0F, 3.0F, 1.0F, 0.0F, false);


        bone = new ModelRenderer(this);
        bone.setPos(0.0F, -14.0F, 0.0F);
        head.addChild(bone);
        setRotationAngle(bone, 0.3491F, 0.0F, 0.0F);
        bone.setTexSize(0, 32).addBox(-3.0F, 4.4824F, -12.9319F, 0.0F, 9.0F, 4.0F, 0.0F, false);
        bone.setTexSize(0, 32).addBox(4.0F, 4.4824F, -12.9319F, 0.0F, 9.0F, 4.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 24.0F, 0.0F);


        r = new ModelRenderer(this);
        r.setPos(-4.0F, -1.0F, 1.0F);
        legs.addChild(r);
        r.setTexSize(6, 1).addBox(-5.5F, 0.0F, -7.0F, 5.0F, 1.0F, 13.0F, 0.0F, false);

        l = new ModelRenderer(this);
        l.setPos(4.5F, -1.0F, 0.0F);
        legs.addChild(l);
        l.setTexSize(18, 16).addBox(0.0F, 0.0F, -6.0F, 5.0F, 1.0F, 13.0F, 0.0F, false);

    }

    @Override
    public void setupAnim(JadeBeetleEntity jd, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch * ((float)Math.PI /180F);
        this.r.zRot = MathHelper.cos(limbSwing * 2.5F + (float)Math.PI) * 1.4F * limbSwingAmount * -1.0F;
        this.l.zRot = MathHelper.cos(limbSwing * 2.5F) * 1.4F * limbSwingAmount * -1.0F;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        legs.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
