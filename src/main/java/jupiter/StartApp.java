package jupiter;


import jupiter.jupitermodel.SpaceObject;
import jupiter.resourсes.SpaceObjectConstants;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import jupiter.jupitermodel.JupiterModel;
import jupiter.physics.PhysicsException;
import jupiter.render.RenderUtils;
import jupiter.resourсes.Resources;


public class StartApp {
    private static Logger log = Logger.getLogger(StartApp.class.getName());
    private boolean shouldExit = false;
    public static boolean working = true;
    public static boolean pausePhys = false;
    private static boolean model1 =false;
    private static boolean model2 =false;
    public static boolean checkModel1 =true;
    public static boolean checkModel2 =false;
    public static boolean physTicked = false;
    public static short ups = 20;
    private float distance = -500, rotX = 45, rotZ = 0;
    private int width, height;
    private int clickX = 0, clickY = 0;

    private KeyBind[] keyBinds = new KeyBind[] {
            new KeyBind(Keyboard.KEY_ESCAPE){
                @Override
                void pressed() {
                    shouldExit = true;
                }
            },
            new KeyBind(Keyboard.KEY_SPACE){
                @Override
                void pressed() {
                    pausePhys = !pausePhys;
                }
            },
            new KeyBind(Keyboard.KEY_1) {
                @Override
                void pressed() {
                    model1=true;
                    log.info("реальный масштаб");
                }
            },
            new KeyBind(Keyboard.KEY_2) {
                @Override
                void pressed() {
                    model2=true;
                    log.info("схематичный масштаб");
                }
            }
    };

    private StartApp(){}

    public static void main(String[] args) {
        new StartApp().start(args);
    }

    private void start(String[] args) {
        try{
            Config.readFromArgs(args);
            JupiterModel jm = new JupiterModel();
            Display.setTitle("Jupiter");
            Display.setDisplayMode(new DisplayMode(Config.width, Config.height));
            Display.setResizable(true);
            Display.setIcon(new ByteBuffer[] { Resources.getImageBuf("icon-16.png"), Resources.getImageBuf("icon-32.png") });
            Display.create(new PixelFormat(8, 8, 0, Config.samples));
            if(Config.vSync)
                Display.setVSyncEnabled(true);
            long time = System.currentTimeMillis(); //For FPS counter
            long utime = time; //For framePart calculation
            int fps = 0;
            float tickPart = 0;
            width = Display.getWidth();
            height = Display.getHeight();
            RenderUtils.init(width, height);
            jm.init();
            Keyboard.create();
            Keyboard.enableRepeatEvents(false);
            Mouse.create();
            while(!(Display.isCloseRequested() || shouldExit)){
                working = Display.isVisible();
                if(working){ //Draw only if display visible
                    checkSize();
                    handleKeyboard();
                    handleMouse();
                    GL11.glPushMatrix();
                    moveCamera();
                    GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
                    jm.render(tickPart);
                    GL11.glPopMatrix();
                    while(model1){
                        jm.setRealSize();
                        model1 = false;
                    }
                    while(model2){
                        jm.setUnrealSize();
                        model2 = false;
                    }
                }
                Display.update(); //Must be called even if display not visible
                if(!Config.vSync)
                    Display.sync(Config.fpsLimit);
                if(working){ //Count FPS and tickPart only if display visible
                    long sysTime = System.currentTimeMillis();
                    long delta = sysTime - time;
                    if (delta >= 1000){
                        Display.setTitle(String.format("Jupiter (%d fps, %d ups)", ++fps, ups));
                        time = sysTime;
                        fps = 0;
                    }else{
                        fps++;
                    }
                    sysTime = System.currentTimeMillis();
                    if(physTicked){
                        physTicked = false;
                        utime = sysTime;
                    }
                    delta = sysTime - utime;
                    tickPart = (50-delta)/50f;
                }
                if(jm.physics.error)
                    throw new PhysicsException();
            }
        }catch(Throwable th){
            JOptionPane.showMessageDialog(null, th.getMessage(), "Error (stack trace in console)", 0);
            if(!(th instanceof PhysicsException))
                th.printStackTrace();
        }finally{
            if(Display.isCreated())
                Display.destroy();
            System.exit(0);
        }
    }

    private void checkSize() {
        if(!(width==Display.getWidth() && height==Display.getHeight())){
            width = Display.getWidth();
            height = Display.getHeight();
            RenderUtils.setupView(width, height);
        }
    }

    private void moveCamera() {
        GL11.glTranslatef(0, 0, distance);
        GL11.glRotatef(rotX, -1, 0, 0);
        GL11.glRotatef(rotZ, 0, 0, -1);
    }

    private void handleKeyboard() {
        for(KeyBind kb : keyBinds)
            kb.update();
    }

    private void handleMouse() {
        int dWheel = Mouse.getDWheel();
        if(dWheel!=0){
            if(dWheel>0)
            {
                if (Keyboard.isKeyDown(16))
                    distance+=10;
                else
                    distance++;}
            else{
                if (Keyboard.isKeyDown(16))
                    distance-=10;
                else
                    distance--;
            }
        }
        if(Mouse.isButtonDown(0)){
            rotX += (clickY - Mouse.getY())/4f;
            rotZ += (clickX - Mouse.getX())/4f;
        }else if(Mouse.isButtonDown(1)){
            distance += (clickY - Mouse.getY())/4f;
        }
        clickX = Mouse.getX();
        clickY = Mouse.getY();
        if(distance>-SpaceObjectConstants.JUPITER.SIZE-1)
            distance = -SpaceObjectConstants.JUPITER.SIZE-1;
        else if(distance<-1000)
            distance = -1000;
    }

    private static abstract class KeyBind {

        private final int key;
        private boolean down = false;

        KeyBind(int key) {
            this.key = key;
        }

        abstract void pressed();

        void update() {
            if(Keyboard.isKeyDown(key)){
                if(!down) {
                    down = true;
                    pressed();
                }
            }else{
                down = false;
            }
        }
    }

}
