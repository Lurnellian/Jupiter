package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

public class Ganimede extends SpaceObject {

    private final PhysicsProvider physics;

    public Ganimede(Jupiter jup) {
        super("ganimede.png", 2.63f);
        this.physics = new RotationPhysicsProvider(jup, 107, .0123f, -5f, 0.142f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
