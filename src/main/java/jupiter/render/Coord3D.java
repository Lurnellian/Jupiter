package jupiter.render;

public class Coord3D {

    public Float x, y, z, rot;

    public Coord3D(Float x, Float y, Float z, Float rot) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.rot = rot;
    }

    public Coord3D(){
        this(0F, 0F, 0F, 0F);
    }
}
