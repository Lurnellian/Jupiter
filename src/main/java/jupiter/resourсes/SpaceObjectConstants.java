package jupiter.resourсes;
//TODO: забить реальными значениями из википедии.
public class SpaceObjectConstants {
    public static final Integer SCALE = 6000;
    public static class JUPITER{
        public static final Float ECCENTRICITY = 12.23F/SCALE;
        public static final Float SEMI_MAJOR_AXIS = 12.23F/SCALE;
        public static final Float SEMI_MINOR_AXIS = calculateSemiMinorAxis(ECCENTRICITY,SEMI_MAJOR_AXIS);
        public static final Float SIZE = 213.6F/SCALE;
    }
    public static class EUROPA{
        public static final Float ECCENTRICITY = 12.23F/SCALE;
        public static final Float SEMI_MAJOR_AXIS = 12.23F/SCALE;
        public static final Float SEMI_MINOR_AXIS = calculateSemiMinorAxis(ECCENTRICITY,SEMI_MAJOR_AXIS);
        public static final Float SIZE = 213.6F/SCALE;
    }
    public static class IO {
        public static final Float ECCENTRICITY = 12.23F/SCALE;
        public static final Float SEMI_MAJOR_AXIS = 12.23F/SCALE;
        public static final Float SEMI_MINOR_AXIS = calculateSemiMinorAxis(ECCENTRICITY,SEMI_MAJOR_AXIS);
        public static final Float SIZE = 213.6F/SCALE;
    }
    public static class GANYMEDE{
        public static final Float ECCENTRICITY = 12.23F/SCALE;
        public static final Float SEMI_MAJOR_AXIS = 12.23F/SCALE;
        public static final Float SEMI_MINOR_AXIS = calculateSemiMinorAxis(ECCENTRICITY,SEMI_MAJOR_AXIS);
        public static final Float SIZE = 213.6F/SCALE;
    }
    public static class METIDA{
        public static final Float ECCENTRICITY = 12.23F/SCALE;
        public static final Float SEMI_MAJOR_AXIS = 12.23F/SCALE;
        public static final Float SEMI_MINOR_AXIS = calculateSemiMinorAxis(ECCENTRICITY,SEMI_MAJOR_AXIS);
        public static final Float SIZE = 213.6F/SCALE;
    }
    public static class CALLISTO{
        public static final Float ECCENTRICITY = 12.23F/SCALE;
        public static final Float SEMI_MAJOR_AXIS = 12.23F/SCALE;
        public static final Float SEMI_MINOR_AXIS = calculateSemiMinorAxis(ECCENTRICITY,SEMI_MAJOR_AXIS);
        public static final Float SIZE = 213.6F/SCALE;
    }
    public static class STARS{
        public static final Float SIZE = 213.6F;
    }
    private static Float calculateSemiMinorAxis(Float ecc,Float sma){
        return (float)Math.sqrt(1-ecc)*sma;
    }
}
