package jupiter.jupitermodel.objects;

import jupiter.jupitermodel.SpaceObject;
import jupiter.physics.DummyPhysicsProvider;
import jupiter.physics.PhysicsProvider;

public class Stars extends SpaceObject {

    public Stars(){
        super("stars.png", 101F);
        renderInside = true;
    }

    @Override
    public PhysicsProvider getPhysics() {
        return DummyPhysicsProvider.instance;
    }

}
