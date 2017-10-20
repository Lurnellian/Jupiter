package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

import static jupiter.resourсes.SpaceObjectConstants.GANYMEDE.ECCENTRICITY;
import static jupiter.resourсes.SpaceObjectConstants.GANYMEDE.SEMI_MAJOR_AXIS;
import static jupiter.resourсes.SpaceObjectConstants.GANYMEDE.SIZE;

public class Ganymede extends SpaceObject {

    private final PhysicsProvider physics;

    public Ganymede(Jupiter jup) {
        super("ganymede.png",  SIZE, SEMI_MAJOR_AXIS, ECCENTRICITY);
        this.physics = new RotationPhysicsProvider(jup, this, .018f, -0.00044f, 0.02f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
