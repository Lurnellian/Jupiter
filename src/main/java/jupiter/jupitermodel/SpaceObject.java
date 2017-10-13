package jupiter.jupitermodel;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import jupiter.physics.PhysicsProvider;
import jupiter.render.Coord3D;
import jupiter.render.RenderUtils;
import jupiter.render.Texture;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_LIGHT0;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_POSITION;
import static org.lwjgl.opengl.GL11.glCallList;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLight;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;



public abstract class SpaceObject {

    private Float semiMajorAxis, semiMinorAxis;
    private Float prevPosX = 0F, posX = 0F, prevPosY = 0F, posY = 0F, prevPosZ = 0F, posZ = 0F, prevRot = 0F, rot = 0F;
    private final Float size;
    private final Texture texture;
    private List<Integer> glLists = new ArrayList<>();
    private final boolean hasAtmosphere = this instanceof IHasAtmosphere;
   // public final boolean hasRings = this instanceof IHasRings;
    protected boolean ignoreLight = false, renderInside = false;

    public SpaceObject(String textureName, Float size){
        this.texture = new Texture(textureName);
        this.size = size;
    }
    public SpaceObject(String textureName, Float size, Float semiMajorAxis, Float semiMinorAxis) {
        this.texture = new Texture(textureName);
        this.size = size;
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
    }

    public abstract PhysicsProvider getPhysics();

    void update() {
        Coord3D pos = getPhysics().updatePosition();
        if(pos!=null){
            prevPosX = posX;
            prevPosY = posY;
            prevPosZ = posZ;
            prevRot = rot;
            posX = pos.x;
            posY = pos.y;
            posZ = pos.z;
            rot = pos.rot;
        }
    }

    void init() throws Exception{
        texture.upload();
        glLists.add(RenderUtils.prepareSphere(texture.id, size));
        if(hasAtmosphere){
            IHasAtmosphere atm = (IHasAtmosphere)this;
            Texture tex = atm.getAtmosphereTexture();
            tex.upload();
            glLists.add(RenderUtils.prepareSphere(tex.id, atm.getAtmosphereSize()));
        }
//        if(hasRings){
//            IHasRings rng = (IHasRings)this;
//            Texture tex = rng.getRingsTexture();
//            tex.upload();
//            glLists.add(RenderUtils.prepareSquare(tex.id, rng.getRingsSize()));
//        }
    }

    public void render(Float framePart) {
        Float x = prevPosX + (prevPosX - posX) * framePart;
        Float y = prevPosY + (prevPosY - posY) * framePart;
        Float z = prevPosZ + (prevPosZ - posZ) * framePart;
        FloatBuffer lightPosition = BufferUtils.createFloatBuffer(4);
        lightPosition.put(-x).put(-y).put(-z).put(0.0f).flip();
        Float rot = prevRot + (prevRot - this.rot) * framePart;
        glPushMatrix();
        if(renderInside)
            glDisable(GL_CULL_FACE);
        if(ignoreLight)
            glDisable(GL_LIGHTING);
        else
            glLight(GL_LIGHT0, GL_POSITION, lightPosition);
        glTranslatef(x, y, z);
        glRotatef(rot, 0, 0, 1);
        for(int list : glLists)
            glCallList(list);
        if(ignoreLight)
            glEnable(GL_LIGHTING);
        if(renderInside)
            glEnable(GL_CULL_FACE);
        glPopMatrix();
    }

    public Float getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(Float semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public Float getSemiMinorAxis() {
        return semiMinorAxis;
    }

    public void setSemiMinorAxis(Float semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }

    public Float getPrevPosX() {
        return prevPosX;
    }

    public void setPrevPosX(Float prevPosX) {
        this.prevPosX = prevPosX;
    }

    public Float getPosX() {
        return posX;
    }

    public void setPosX(Float posX) {
        this.posX = posX;
    }

    public Float getPrevPosY() {
        return prevPosY;
    }

    public void setPrevPosY(Float prevPosY) {
        this.prevPosY = prevPosY;
    }

    public Float getPosY() {
        return posY;
    }

    public void setPosY(Float posY) {
        this.posY = posY;
    }

    public Float getPrevPosZ() {
        return prevPosZ;
    }

    public void setPrevPosZ(Float prevPosZ) {
        this.prevPosZ = prevPosZ;
    }

    public Float getPosZ() {
        return posZ;
    }

    public void setPosZ(Float posZ) {
        this.posZ = posZ;
    }

    public Float getPrevRot() {
        return prevRot;
    }

    public void setPrevRot(Float prevRot) {
        this.prevRot = prevRot;
    }

    public Float getRot() {
        return rot;
    }

    public void setRot(Float rot) {
        this.rot = rot;
    }

    public Float getSize() {
        return size;
    }

    public Texture getTexture() {
        return texture;
    }

    public List<Integer> getGlLists() {
        return glLists;
    }

    public void setGlLists(List<Integer> glLists) {
        this.glLists = glLists;
    }

    public boolean isHasAtmosphere() {
        return hasAtmosphere;
    }

    public boolean isIgnoreLight() {
        return ignoreLight;
    }

    public void setIgnoreLight(boolean ignoreLight) {
        this.ignoreLight = ignoreLight;
    }

    public boolean isRenderInside() {
        return renderInside;
    }

    public void setRenderInside(boolean renderInside) {
        this.renderInside = renderInside;
    }
}
