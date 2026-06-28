package icu.carolinainthe.waylandcursorfix;
import net.neoforged.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.system.MemoryUtil;
import java.nio.ByteBuffer;

@Mod(WaylandCursorFix.MOD_ID)
public class WaylandCursorFix {
    public static final String MOD_ID = "waylandcursorfix";
    private static long emptyCursor = 0L;
    public static long getEmptyCursor() {
        if (emptyCursor == 0L) {
            GLFWImage image = GLFWImage.malloc();
            // 16x16 transparent texture
            ByteBuffer buffer = MemoryUtil.memCalloc(16 * 16 * 4); 
            image.set(16, 16, buffer);
            emptyCursor = GLFW.glfwCreateCursor(image, 0, 0);
        }
        return emptyCursor;
    }
}
