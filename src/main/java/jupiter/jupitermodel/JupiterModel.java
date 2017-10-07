package jupiter.jupitermodel;

import jupiter.jupitermodel.objects.*;
import jupiter.physics.PhysicsThread;

import java.util.ArrayList;
import java.util.List;

public class JupiterModel {
    public final List<SpaceObject> objects = new ArrayList<>();
    public final PhysicsThread physics = new PhysicsThread(this);

    public JupiterModel() {
        objects.add(new Stars());
        Jupiter jupiter = new Jupiter();
        objects.add(jupiter);
        objects.add(new Io(jupiter));
        objects.add(new Europe(jupiter));
        objects.add(new Kallisto(jupiter));
        objects.add(new Ganimede(jupiter));
        objects.add(new Metida(jupiter));
    }

    public void init() throws Exception{
        physics.start();
        for(SpaceObject obj : objects)
            obj.init();
    }
    public void render(float framePart) {
        for(SpaceObject obj : objects)
            obj.render(framePart);
    }

    public void updatePhysics() {
        for(SpaceObject obj : objects)
            obj.update();
    }

}
