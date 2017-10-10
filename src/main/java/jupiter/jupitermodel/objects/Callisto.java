package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

public class Callisto extends SpaceObject {

    private final PhysicsProvider physics;

    public Callisto(Jupiter jup) {
        super("callisto.png", 0.4016f);
        this.physics = new RotationPhysicsProvider(jup, 314, .0053f, -5f,0.143f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
