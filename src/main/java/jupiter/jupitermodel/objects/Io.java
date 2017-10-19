package jupiter.jupitermodel.objects;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

import static jupiter.resourсes.SpaceObjectConstants.IO.ECCENTRICITY;
import static jupiter.resourсes.SpaceObjectConstants.IO.SEMI_MAJOR_AXIS;
import static jupiter.resourсes.SpaceObjectConstants.IO.SIZE;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_FRONT;
import static org.lwjgl.opengl.GL11.GL_LIGHT0;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_POSITION;
import static org.lwjgl.opengl.GL11.GL_SHININESS;
import static org.lwjgl.opengl.GL11.GL_SPECULAR;
import static org.lwjgl.opengl.GL11.glCallList;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLight;
import static org.lwjgl.opengl.GL11.glMaterial;
import static org.lwjgl.opengl.GL11.glMaterialf;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

public class Io extends SpaceObject {
    private final PhysicsProvider physics;
    public Io(Jupiter jup) {
        super("io.png",  SIZE, SEMI_MAJOR_AXIS, ECCENTRICITY);
        this.physics = new RotationPhysicsProvider(jup, this, .028f, -.0000125f,0.034f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

    @Override
    public void render(Float framePart) {
        FloatBuffer someLight = BufferUtils.createFloatBuffer(4);
        someLight.put(1f).put(0.0f).put(0.0f).put(1f).flip();
        glMaterial(GL_FRONT, GL_DIFFUSE, someLight);
        glMaterial(GL_FRONT, GL_SPECULAR, someLight);
        glMaterialf(GL_FRONT, GL_SHININESS, 1.0f);



        Float x = getPrevPosX() + (getPrevPosX() - getPosX()) * framePart;
        Float y = getPrevPosY() + (getPrevPosY() - getPosY()) * framePart;
        Float z = getPrevPosZ() + (getPrevPosZ() - getPosZ()) * framePart;
        FloatBuffer lightPosition = BufferUtils.createFloatBuffer(4);
        lightPosition.put(-x).put(-y).put(-z).put(0.0f).flip();
        Float rot = getPrevRot() + (getPrevRot() - this.getRot()) * framePart;
        glPushMatrix();
        if(renderInside)
            glDisable(GL_CULL_FACE);
        if(ignoreLight)
            glDisable(GL_LIGHTING);
        else
            glLight(GL_LIGHT0, GL_POSITION, lightPosition);
        glTranslatef(x, y, z);
        glRotatef(rot, 0, 0, 1);
        for(int list : getGlLists())
            glCallList(list);
        if(ignoreLight)
            glEnable(GL_LIGHTING);
        if(renderInside)
            glEnable(GL_CULL_FACE);
        glPopMatrix();

        FloatBuffer whiteLight = BufferUtils.createFloatBuffer(4);
        whiteLight.put(1.0f).put(1.0f).put(1.0f).put(1.0f).flip();
        glMaterial(GL_FRONT, GL_DIFFUSE, whiteLight);
        glMaterial(GL_FRONT, GL_SPECULAR, whiteLight);
        glMaterialf(GL_FRONT, GL_SHININESS, 50.0f);

    }
}
