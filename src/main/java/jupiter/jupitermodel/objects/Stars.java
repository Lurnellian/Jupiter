package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.DPhysicsProvider;
import jupiter.physics.PhysicsProvider;

import static jupiter.resourсes.SpaceObjectConstants.STARS.SIZE;

public class Stars extends SpaceObject {

    public Stars(){
        super("stars.png", SIZE);
        renderInside = true;
    }

    @Override
    public PhysicsProvider getPhysics() {
        return DPhysicsProvider.instance;
    }

}
