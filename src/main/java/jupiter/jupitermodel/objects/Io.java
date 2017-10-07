package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

public class Io extends SpaceObject {

    private final PhysicsProvider physics;
//TODO синхронизировать скорость вращения
    public Io(Jupiter jup) {
        super("io.png", 1.82f);
        this.physics = new RotationPhysicsProvider(jup, 42, .05f, -.3004f,0.034f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
