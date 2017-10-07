package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.DPhysicsProvider;
import jupiter.physics.PhysicsProvider;

public class Stars extends SpaceObject {

    public Stars(){
        super("stars.png", 501F);
        renderInside = true;
    }

    @Override
    public PhysicsProvider getPhysics() {
        return DPhysicsProvider.instance;
    }

}
