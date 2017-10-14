package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

import static jupiter.resourсes.SpaceObjectConstants.IO.ECCENTRICITY;
import static jupiter.resourсes.SpaceObjectConstants.IO.SEMI_MAJOR_AXIS;
import static jupiter.resourсes.SpaceObjectConstants.IO.SIZE;

public class Io extends SpaceObject {

    private final PhysicsProvider physics;
//TODO синхронизировать скорость вращения
    public Io(Jupiter jup) {
        super("io.png",  SIZE, SEMI_MAJOR_AXIS, ECCENTRICITY);
        this.physics = new RotationPhysicsProvider(jup, this, .05f, -.3004f,0.034f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
