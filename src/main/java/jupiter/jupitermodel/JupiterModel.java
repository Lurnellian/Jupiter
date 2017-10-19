package jupiter.jupitermodel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jupiter.StartApp;
import jupiter.jupitermodel.objects.Callisto;
import jupiter.jupitermodel.objects.Europa;
import jupiter.jupitermodel.objects.Ganymede;
import jupiter.jupitermodel.objects.Io;
import jupiter.jupitermodel.objects.Jupiter;
import jupiter.jupitermodel.objects.Metida;
import jupiter.jupitermodel.objects.Stars;
import jupiter.physics.PhysicsThread;

public class JupiterModel {
    private static Logger log = Logger.getLogger(StartApp.class.getName());
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
    public void render(Float framePart) {
        for(SpaceObject obj : objects)
            obj.render(framePart);
    }

    public void updatePhysics() {
        for(SpaceObject obj : objects)
            obj.update();
    }

    public void setRealSize() throws Exception {
        if (!StartApp.checkModel1) {
            for (int i = 2; i < objects.size(); i++) {
                objects.get(i).refresh();
                objects.get(i).setSize(objects.get(i).getSize() / 10f);
                objects.get(i).refresh();
            }
            StartApp.checkModel1=true;
            StartApp.checkModel2=false;
        }
    }

    public void setUnrealSize() throws Exception{
        if(!StartApp.checkModel2) {
            for (int i = 2; i < objects.size(); i++) {
                objects.get(i).refresh();
                objects.get(i).setSize(objects.get(i).getSize() * 10f);
                objects.get(i).refresh();
            }
            StartApp.checkModel1=false;
            StartApp.checkModel2=true;
        }
    }
}
