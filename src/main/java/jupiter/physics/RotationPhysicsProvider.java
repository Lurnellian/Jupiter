package jupiter.physics;

import jupiter.StartApp;
import jupiter.jupitermodel.SpaceObject;
import jupiter.render.Coord3D;

public class RotationPhysicsProvider extends PhysicsProvider{

    public final SpaceObject center;
    public final Float radius, speed, speedSelf,orbitInclination;
    private Coord3D coord = new Coord3D();
    private float angle = 0;
    public float tilt = 0;

    public RotationPhysicsProvider(SpaceObject center, float radius, float speed, float speedSelf, float orbitInclination) {
        this.center = center;
        this.radius = radius;
        this.speed = speed;
        this.speedSelf = speedSelf;
        this.orbitInclination=orbitInclination;
    }


    @Override
    public Coord3D updatePosition() {
        if(!StartApp.pausePhys){
            angle+=speed;
            coord.x = center.getPosX() + (float)Math.cos(angle)*radius;
            coord.y = center.getPosY() + (float)Math.sin(angle)*radius*0.5F;
            coord.z = center.getPosZ() + (float)Math.cos(angle)*radius*tilt +orbitInclination;
            coord.rot+=speedSelf;
        }
        return coord;
    }

}
