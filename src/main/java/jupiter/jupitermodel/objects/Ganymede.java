package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

public class Ganymede extends SpaceObject {

    private final PhysicsProvider physics;

    public Ganymede(Jupiter jup) {
        super("ganymede.png", 0.439f);
        this.physics = new RotationPhysicsProvider(jup, 178, .0123f, -5f, 0.142f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
