package jupiter.physics;

import jupiter.render.Coord3D;

public class DummyPhysicsProvider extends PhysicsProvider{

    public static DummyPhysicsProvider instance = new DummyPhysicsProvider();

    @Override
    public Coord3D updatePosition() {
        return null;
    }

}