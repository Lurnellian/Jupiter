package jupiter.jupitermodel;

import java.util.ArrayList;
import java.util.List;

import jupiter.jupitermodel.objects.Callisto;
import jupiter.jupitermodel.objects.Europa;
import jupiter.jupitermodel.objects.Ganymede;
import jupiter.jupitermodel.objects.Io;
import jupiter.jupitermodel.objects.Jupiter;
import jupiter.jupitermodel.objects.Metida;
import jupiter.jupitermodel.objects.Stars;
import jupiter.physics.PhysicsThread;

public class JupiterModel {
    public final List<SpaceObject> objects = new ArrayList<>();
    public final PhysicsThread physics = new PhysicsThread(this);

    public JupiterModel() {
        objects.add(new Stars());
        Jupiter jupiter = new Jupiter();
        objects.add(jupiter);
        objects.add(new Io(jupiter));
        objects.add(new Europa(jupiter));
        objects.add(new Callisto(jupiter));
        objects.add(new Ganymede(jupiter));
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
