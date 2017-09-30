package jupiter.jupitermodel;

import jupiter.jupitermodel.objects.Jupiter;
import jupiter.jupitermodel.objects.Stars;
import jupiter.physics.PhysicsThread;

import java.util.ArrayList;
import java.util.List;

public class JupiterModel {
//TODO all a heal
    public final List<SpaceObject> objects = new ArrayList<>();
    public final PhysicsThread physics = new PhysicsThread(this);

    public JupiterModel() {
        objects.add(new Stars());
        Jupiter jupiter = new Jupiter();
        objects.add(jupiter);
        //objects.add(new PlaneMercury(jupiter));
//        objects.add(new PlanetVenus(jupiter));
//        PlanetEarth earth = new PlanetEarth(jupiter);
//        objects.add(earth);
//        objects.add(new SecondaryMoon(earth));
//        objects.add(new PlanetMars(jupiter));
//        objects.add(new PlanetJupiter(jupiter));
//        objects.add(new PlanetSaturn(jupiter));
//        objects.add(new PlanetUranus(jupiter));
//        objects.add(new PlanetNeptune(jupiter));
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
