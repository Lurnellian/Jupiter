package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

public class Kallisto extends SpaceObject {

    private final PhysicsProvider physics;

    public Kallisto(Jupiter jup) {
        super("kallisto.png", 2.4f);
        this.physics = new RotationPhysicsProvider(jup, 188, .0053f, -5f,0.143f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
