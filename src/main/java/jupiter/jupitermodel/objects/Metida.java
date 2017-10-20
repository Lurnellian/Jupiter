package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

import static jupiter.resourсes.SpaceObjectConstants.METIDA.ECCENTRICITY;
import static jupiter.resourсes.SpaceObjectConstants.METIDA.SEMI_MAJOR_AXIS;
import static jupiter.resourсes.SpaceObjectConstants.METIDA.SIZE;

public class Metida extends SpaceObject {

    private final PhysicsProvider physics;
    public Metida(Jupiter jup) {
        super("metida.png",  SIZE, SEMI_MAJOR_AXIS, ECCENTRICITY);
        this.physics = new RotationPhysicsProvider(jup, this, .0525f, -.00088f,0.006f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
