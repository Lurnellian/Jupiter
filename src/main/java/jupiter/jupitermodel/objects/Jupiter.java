package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.DPhysicsProvider;
import jupiter.physics.PhysicsProvider;

import static jupiter.resourсes.SpaceObjectConstants.JUPITER.SIZE;

public class Jupiter extends SpaceObject {

    public Jupiter() {
        super("jupiter.png", SIZE);
        this.ignoreLight = true;

    }

    @Override
    public PhysicsProvider getPhysics() {
        return DPhysicsProvider.instance;
    }

}