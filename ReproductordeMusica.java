import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class ReproductordeMusica extends Thread {
    private volatile boolean reproduciendo = true;
    private Player reproductor;
    private volatile boolean pause = false;
    private String rutaCancion = "Im Yours Jason Mraz.mp3";

    public synchronized void pausarMusica() {
        pause = true;
        if (reproductor != null) {
            reproductor.close();
            reproductor = null;
        }
    }

    public synchronized void reiniciarMusica() {
        if (reproductor != null) {
            reproductor.close();
            reproductor = null;
        }
        pause = false;
        notifyAll();
    }

    public synchronized void detenerMusica() {
    reproduciendo = false;
    pause = false;
    if (reproductor != null) {
        reproductor.close();
        reproductor = null;
    }
    notifyAll();
}

    @Override
    public void run() {
        try {
            while (reproduciendo) {
                synchronized (this) {
                    while (pause) {
                        wait();
                    }
                }
                try (FileInputStream entradaArchivo = new FileInputStream(rutaCancion)) {
                    reproductor = new Player(entradaArchivo);
                    reproductor.play();
                }
            }
            if (reproductor != null) {
                reproductor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
