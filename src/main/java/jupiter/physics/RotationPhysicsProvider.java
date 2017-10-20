package jupiter.physics;

import jupiter.StartApp;
import jupiter.jupitermodel.SpaceObject;
import jupiter.render.Coord3D;

public class RotationPhysicsProvider extends PhysicsProvider{

    private final SpaceObject center, moon;
    private final Float speed, speedSelf,orbitInclination;
    private Coord3D coord = new Coord3D();
    private float angle = 0;
    private float tilt = 0;

    public RotationPhysicsProvider(SpaceObject center, SpaceObject moon, float speed, float speedSelf, float orbitInclination) {
        this.center = center;
        this.speed = speed;
        this.moon = moon;
        this.speedSelf = speedSelf;
        this.orbitInclination=orbitInclination;
    }


    @Override
    public Coord3D updatePosition() {
        if(!StartApp.pausePhys){
            angle+=speed;
            coord.x = center.getPosX() + (float)Math.cos(angle)*moon.getSemiMajorAxis() + moon.getSemiMajorAxis()*moon.getEccentricity();
            coord.y = center.getPosY() + (float)Math.sin(angle)*moon.getSemiMinorAxis();
            coord.z = center.getPosZ() + orbitInclination*coord.x; //deleted radius and math
            coord.rot+=speedSelf;
        }
        return coord;
    }

}
