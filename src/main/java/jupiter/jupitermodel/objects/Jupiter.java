package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.DummyPhysicsProvider;
import jupiter.physics.PhysicsProvider;

public class Jupiter extends SpaceObject {

    public Jupiter() {
        super("sun.png", 5F);
        this.ignoreLight = true;
    }

    @Override
    public PhysicsProvider getPhysics() {
        return DummyPhysicsProvider.instance;
    }

}