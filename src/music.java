
import com.sun.source.tree.TryTree;
import javazoom.jl.player.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class music {
    public static void click(File music)
    {
        Player player;
        try
        {
            BufferedInputStream buffer = new BufferedInputStream((new FileInputStream(music)));
            player = new Player(buffer);
            player.play();
        }
        catch (Exception e)
        {

        }
    }
    public static class Audioplayer extends Thread{
        Player player;
        File music;
        public Audioplayer(File file){
            this.music = file;
        }
        @Override
        public  void run()
        {
            super.run();
            try{
                BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
                player = new Player(buffer);
                while(true) {
                    player.play();
                }
            }
            catch (Exception e)
            {

            }
        }

    }
}
