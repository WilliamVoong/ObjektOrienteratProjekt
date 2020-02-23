package src.objektorienterat;

public class BackgroundSound extends Thread {
    public void run()
    {
        while (!interrupted())
        {
            Sound_effect.playSound("BS.wav");
            try {
                sleep(66000);
            }catch (Exception e)
            {

            }

        }



    }
}
