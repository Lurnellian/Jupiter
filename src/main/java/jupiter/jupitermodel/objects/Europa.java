package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

public class Europa extends SpaceObject {

    private final PhysicsProvider physics;

    public Europa(Jupiter jup) {
        super("europe.png", 0.26f);
        this.physics = new RotationPhysicsProvider(jup, 112, .0249f, -5f, 0.471f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
