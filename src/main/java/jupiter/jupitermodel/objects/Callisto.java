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
        this.physics = new RotationPhysicsProvider(jup, this, .0553f, -5f,0.143f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
