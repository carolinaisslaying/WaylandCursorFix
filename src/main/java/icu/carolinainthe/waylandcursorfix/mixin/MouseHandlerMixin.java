package icu.carolinainthe.waylandcursorfix.mixin;
import icu.carolinainthe.waylandcursorfix.WaylandCursorFix;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
    @Shadow private boolean mouseGrabbed;
    private boolean isGrabbing = false;
    @Inject(method = "grabMouse", at = @At("HEAD"))
    private void beforeGrabMouse(CallbackInfo ci) {
        if (this.isGrabbing) return;
        this.isGrabbing = true;
        Minecraft mc = Minecraft.getInstance();
        if (mc.getWindow() == null) return;
        long handle = mc.getWindow().getWindow();
        // 1. Wayland state desync fix
        if (GLFW.glfwGetInputMode(handle, GLFW.GLFW_CURSOR) == GLFW.GLFW_CURSOR_DISABLED) {
            GLFW.glfwSetInputMode(handle, GLFW.GLFW_CURSOR, GLFW.GLFW_CURSOR_NORMAL);
        }
        // 2. Mod state desync fix
        this.mouseGrabbed = false;
    }
    @Inject(method = "grabMouse", at = @At("RETURN"))
    private void afterGrabMouse(CallbackInfo ci) {
        this.isGrabbing = false;
        Minecraft mc = Minecraft.getInstance();
        if (mc.getWindow() != null) {
            long handle = mc.getWindow().getWindow();
            // Apply invisible transparent raster cursor so even if Wayland refuses to visually hide it, it's invisible
            GLFW.glfwSetCursor(handle, WaylandCursorFix.getEmptyCursor());
        }
    }
    @Inject(method = "releaseMouse", at = @At("RETURN"))
    private void afterReleaseMouse(CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.getWindow() != null) {
            long handle = mc.getWindow().getWindow();
            // Restore default arrow
            GLFW.glfwSetCursor(handle, 0L);
        }
    }
}
