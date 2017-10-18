package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

import static jupiter.resourсes.SpaceObjectConstants.EUROPA.ECCENTRICITY;
import static jupiter.resourсes.SpaceObjectConstants.EUROPA.SEMI_MAJOR_AXIS;
import static jupiter.resourсes.SpaceObjectConstants.EUROPA.SIZE;

public class Europa extends SpaceObject {

    private final PhysicsProvider physics;

    public Europa(Jupiter jup) {
        super("europe.png",  SIZE, SEMI_MAJOR_AXIS, ECCENTRICITY);
        this.physics = new RotationPhysicsProvider(jup, this, .0229f, -0.000136f, 0.471f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
