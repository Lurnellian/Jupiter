package jupiter;

import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

public class Config {

    public static boolean vSync = true;
    public static int fpsLimit = 0;
    public static String resDir = "C:\\Users\\OleG\\Desktop\\study\\Jupiter\\src\\main\\resources";
    public static byte samples = 8;
    public static short details = 50;
    public static int width = 800;
    public static int height = 600;

    public static void readFromArgs(String[] args) {
        OptionParser op = new OptionParser();
        op.allowsUnrecognizedOptions();
        ArgumentAcceptingOptionSpec<Integer> argFps = op.accepts("fpsLimit").withOptionalArg().ofType(Integer.class);
        ArgumentAcceptingOptionSpec<String> argResDir = op.accepts("resDir").withOptionalArg().ofType(String.class);
        ArgumentAcceptingOptionSpec<Byte> argSamples = op.accepts("samples").withOptionalArg().ofType(Byte.class);
        ArgumentAcceptingOptionSpec<Short> argDetails = op.accepts("details").withOptionalArg().ofType(Short.class);
        ArgumentAcceptingOptionSpec<Integer> argWidth = op.accepts("width").withOptionalArg().ofType(Integer.class);
        ArgumentAcceptingOptionSpec<Integer> argHeight = op.accepts("height").withOptionalArg().ofType(Integer.class);
        OptionSet os = op.parse(args);
        if(os.has(argFps)){
            vSync = false;
            fpsLimit = os.valueOf(argFps);
        }
        if(os.has(argResDir))
            resDir = os.valueOf(argResDir);
        if(os.has(argSamples))
            samples = os.valueOf(argSamples);
        if(os.has(argDetails))
            details = os.valueOf(argDetails);
        if(os.has(argWidth))
            width = os.valueOf(argWidth);
        if(os.has(argHeight))
            height = os.valueOf(argHeight);
    }

}
