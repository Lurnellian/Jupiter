package jupiter.resourсes;
/*
* km/scale
* */
public final class SpaceObjectConstants{
    private SpaceObjectConstants(){}

    public static final Integer SCALE = 6000;
    public static class JUPITER{
        public static final Float ECCENTRICITY = 0.048775F; //не нужно
        public static final Float SEMI_MAJOR_AXIS = 778547200F/SCALE; // не нужно
        public static final Float SIZE = 69911F/SCALE;
    }
    public static class EUROPA{
        public static final Float ECCENTRICITY = 0.0094F;
        public static final Float SEMI_MAJOR_AXIS = 671100F/SCALE;
        public static final Float SIZE = 1560.8F/SCALE;
    }
    public static class IO{
        public static final Float ECCENTRICITY = 0.0041F;
        public static final Float SEMI_MAJOR_AXIS = 421700F/SCALE;
        public static final Float SIZE = 1822F/SCALE;
    }
    public static class GANYMEDE{
        public static final Float ECCENTRICITY = 0.0013F;
        public static final Float SEMI_MAJOR_AXIS = 1070400F/SCALE;
        public static final Float SIZE = 2634.1F/SCALE;
    }
    public static class METIDA{
        public static final Float ECCENTRICITY = 0.0002F;
        public static final Float SEMI_MAJOR_AXIS = 128000F/SCALE;
        public static final Float SIZE = 60F*10/SCALE; //увеличил в 10 раз чтобы было видно
    }
    public static class CALLISTO{
//        public static final Float ECCENTRICITY = 0.75F;
//        public static final Float SEMI_MAJOR_AXIS = 1882700F/SCALE;
//        public static final Float SIZE = 2410.3F/SCALE * 10;
        public static final Float ECCENTRICITY = 0.0074F;
        public static final Float SEMI_MAJOR_AXIS = 1882700F/SCALE;
        public static final Float SIZE = 2410.3F/SCALE;
    }
    public static class STARS{
        public static final Float SIZE = 1006.6F;
    }
}
