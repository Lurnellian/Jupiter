package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

public class Europe extends SpaceObject {

    private final PhysicsProvider physics;

    public Europe(Jupiter jup) {
        super("europe.png", 1.56f);
        this.physics = new RotationPhysicsProvider(jup, 67, .0249f, -5f, 0.471f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
