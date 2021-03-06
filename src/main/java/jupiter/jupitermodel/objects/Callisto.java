package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

import static jupiter.resourсes.SpaceObjectConstants.CALLISTO.ECCENTRICITY;
import static jupiter.resourсes.SpaceObjectConstants.CALLISTO.SEMI_MAJOR_AXIS;
import static jupiter.resourсes.SpaceObjectConstants.CALLISTO.SIZE;

public class Callisto extends SpaceObject {

    private final PhysicsProvider physics;

    public Callisto(Jupiter jup) {
        super("callisto.png", SIZE, SEMI_MAJOR_AXIS, ECCENTRICITY);
        this.physics = new RotationPhysicsProvider(jup, this, .010838f, -.001093f,0.02f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
