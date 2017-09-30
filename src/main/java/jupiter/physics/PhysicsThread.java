package jupiter.physics;

import jupiter.StartApp;

public class PhysicsThread extends Thread {

    public boolean error = false;
    //TODO изменить соларсистем
    private final SolarSystem ss;

    public PhysicsThread(SolarSystem ss) {
        super("Physics");
        this.ss = ss;
    }

    @Override
    public void run() {
        try{
            long utime = System.currentTimeMillis();
            short ups = 0;
            while(true){
                long time = System.currentTimeMillis();
                if(StartApp.working){
                    ss.updatePhysics();
                    StartApp.physTicked = true;
                    if (System.currentTimeMillis() - utime >= 1000) {
                        utime = System.currentTimeMillis();
                        StartApp.ups = ups;
                        ups = 0;
                    }else ups++;
                }
                long sleep = time + 49 - System.currentTimeMillis();
                if(sleep>0)
                    Thread.sleep(sleep);
                else
                    System.out.println(String.format("Physics is updating too slow. Missed %d ms", -sleep));
            }
        }catch(Throwable th){
            error = true;
            th.printStackTrace();
        }
    }

}
