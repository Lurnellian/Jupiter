package jupiter.render;

import org.lwjgl.BufferUtils;
import org.lwjgl.util.glu.Sphere;

import java.nio.FloatBuffer;

import jupiter.Config;

import static org.lwjgl.opengl.GL11.GL_AMBIENT_AND_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_MATERIAL;
import static org.lwjgl.opengl.GL11.GL_COMPILE;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_ENABLE_BIT;
import static org.lwjgl.opengl.GL11.GL_FRONT;
import static org.lwjgl.opengl.GL11.GL_LEQUAL;
import static org.lwjgl.opengl.GL11.GL_LIGHT0;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_LIGHT_MODEL_AMBIENT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_POSITION;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SHININESS;
import static org.lwjgl.opengl.GL11.GL_SMOOTH;
import static org.lwjgl.opengl.GL11.GL_SPECULAR;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClearDepth;
import static org.lwjgl.opengl.GL11.glColorMaterial;
import static org.lwjgl.opengl.GL11.glDepthFunc;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glGenLists;
import static org.lwjgl.opengl.GL11.glLight;
import static org.lwjgl.opengl.GL11.glLightModel;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMaterial;
import static org.lwjgl.opengl.GL11.glMaterialf;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glNewList;
import static org.lwjgl.opengl.GL11.glPopAttrib;
import static org.lwjgl.opengl.GL11.glPushAttrib;
import static org.lwjgl.opengl.GL11.glShadeModel;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.util.glu.GLU.GLU_FILL;
import static org.lwjgl.util.glu.GLU.GLU_SMOOTH;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class RenderUtils {

    private static Sphere sphere;

    public static void setupLighting() {
        FloatBuffer lightPosition = BufferUtils.createFloatBuffer(4);
        lightPosition.put(0.0f).put(0.0f).put(0.0f).put(0.0f).flip();

        FloatBuffer whiteLight = BufferUtils.createFloatBuffer(4);
        whiteLight.put(1.0f).put(1.0f).put(1.0f).put(1.0f).flip();

        FloatBuffer lModelAmbient = BufferUtils.createFloatBuffer(4);
        lModelAmbient.put(0.4f).put(0.4f).put(0.4f).put(1.0f).flip();

        glShadeModel(GL_SMOOTH);
        glMaterial(GL_FRONT, GL_SPECULAR, whiteLight);
        glMaterialf(GL_FRONT, GL_SHININESS, 50.0f);

        glLight(GL_LIGHT0, GL_POSITION, lightPosition);
        glLight(GL_LIGHT0, GL_SPECULAR, whiteLight);
        glLight(GL_LIGHT0, GL_DIFFUSE, whiteLight);
        glLightModel(GL_LIGHT_MODEL_AMBIENT, lModelAmbient);

        glEnable(GL_LIGHTING);
        glEnable(GL_LIGHT0);

        glEnable(GL_COLOR_MATERIAL);
        glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
    }

    public static void setupView(int width, int height) {
        glPopAttrib();
        glPushAttrib(GL_ENABLE_BIT);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        setupLighting();
        glClearDepth(1D);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_CULL_FACE);
        glDepthFunc(GL_LEQUAL);
        glViewport(0, 0, width, height);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(60F, (float)width / height, 0.1F, 5000F);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }

    public static void init(int width, int height) {
        setupView(width, height);
        sphere = new Sphere();
        sphere.setDrawStyle(GLU_FILL);
        sphere.setTextureFlag(true);
        sphere.setNormals(GLU_SMOOTH);
    }

    public static int prepareSphere(int texId, float size) {
        int list = glGenLists(1);
        glNewList(list, GL_COMPILE);
        glBindTexture(GL_TEXTURE_2D, texId);
        sphere.draw(size, Config.details, Config.details);
        glEndList();
        return list;
    }

    public static int prepareSquare(int texId, float size) {
        int list = glGenLists(1);
        glNewList(list, GL_COMPILE);
        glDisable(GL_CULL_FACE);
        glBindTexture(GL_TEXTURE_2D, texId);
        glTranslatef(-size/2, -size/2, 0);
        //glRotatef(180.0f, 0.0f, 0.0f, 0.0f);
        glBegin(GL_QUADS);
        glTexCoord2f(0.0f, 0.0f);
        glVertex2f(0.0f, 0.0f);
        glTexCoord2f(1.0f, 0.0f);
        glVertex2f(size, 0.0f);
        glTexCoord2f(1.0f, 1.0f);
        glVertex2f(size, size);
        glTexCoord2f(0.0f, 1.0f);
        glVertex2f(0.0f, size);
        glEnd();
        glEnable(GL_CULL_FACE);
        glEndList();
        return list;
    }

}
