package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.DPhysicsProvider;
import jupiter.physics.PhysicsProvider;

public class Jupiter extends SpaceObject {
    //TODO сделать вращение

    public Jupiter() {
        super("jupiter.png", 6.99F);
        this.ignoreLight = true;

    }

    @Override
    public PhysicsProvider getPhysics() {
        return DPhysicsProvider.instance;
    }

}