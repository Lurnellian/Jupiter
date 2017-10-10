package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.PhysicsProvider;
import jupiter.physics.RotationPhysicsProvider;

public class Metida extends SpaceObject {

    private final PhysicsProvider physics;
//TODO сделать не круглой
    public Metida(Jupiter jup) {
        super("metida.png", 0.0008f);
        this.physics = new RotationPhysicsProvider(jup, 21, .0957f, -5f,0.041f);
    }

    @Override
    public PhysicsProvider getPhysics() {
        return physics;
    }

}
