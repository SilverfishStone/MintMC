package net.silverfishstone.mintmc.resource.screens;

import net.minecraft.block.FurnaceBlock;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.FurnaceScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.ScreenHandler;

public class CrucibleScreen extends HandledScreen<CrucibleScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of("mintmc", "textures/gui/crucible.png");

    public CrucibleScreen(CrucibleScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
        context.drawTexture(RenderLayer::getGuiTextured, TEXTURE,( backgroundWidth * 2) + 40, backgroundHeight - 1, 0, 0, backgroundWidth, backgroundHeight, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
