import java.util.Scanner;

public class InteraccionConUsuario extends Thread {
    private ReproductordeMusica hiloMusica;
    private final String Lyrics = 
 	"Well, you done done me in, you bet I felt it\n" +
	"I tried to be chill, but you're so hot that I melted\n" +
	"I fell right through the cracks\n" +
	"Now I'm trying to get back\n" +
	"Before the cool done run out\n" +
	"I'll be giving it my bestest\n" +
	"And nothing's gonna stop me but divine intervention\n" +
	"I reckon it's again my turn\n" +
	"To win some or learn some\n" +
	"\nBut I won't hesitate no more, no more\n" +
	"It cannot wait, I'm yours\n" +
	"Hmm (hey, hey)\n" +
	"\nWell, open up your mind and see like me\n" +
	"Open up your plans and, damn, you're free\n" +
	"Look into your heart and you'll find love, love, love, love\n" +
	"Listen to the music of the moment, people dance and sing\n" +
	"We're just one big family\n" +
	"And it's our God-forsaken right to be loved, loved, loved, loved, loved\n" +
	"\nSo I won't hesitate no more, no more\n" +
	"It cannot wait, I'm sure\n" +
	"There's no need to complicate\n" +
	"Our time is short\n" +
	"This is our fate, I'm yours";


    public InteraccionConUsuario(ReproductordeMusica hiloMusica) {
        this.hiloMusica = hiloMusica;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("MusicPlayer by: DavidV. - ¡Bienvenido! Ahora mismo escuchas 'I'm Yours' de Jason Mraz.");
        System.out.println("Esta canción cuenta con lyrics disponibles ¿Deseas ver la letra de la canción? (Contesta Yes / No)");

        String respuesta = scanner.nextLine().trim().toLowerCase();
        if (respuesta.equals("Yes") || respuesta.equals("yes")) {
            System.out.println(Lyrics);
        } else {
            System.out.println("Aquí tienes la letra de 'I'm Yours' de Jason Mraz.");
        }

        while (true) {
            System.out.println("\nMENÚ:");
            System.out.println("'Pause' - Pausa la canción.");
            System.out.println("'Replay' - Reiniciar la canción.");
            System.out.println("'Exit' - Salir del reproductor.\n");
            
            String entrada = scanner.nextLine().trim().toLowerCase();

            switch (entrada) {
                case "pause":
                    hiloMusica.pausarMusica();
                    System.out.println("Canción en pausa");
                    break;
                case "replay":
                    System.out.println("Reproduciendo 'Im yours' de nuevo.");
                    hiloMusica.reiniciarMusica();
                    break;
                case "exit":
                    hiloMusica.detenerMusica();
                    System.out.println("Saliedo de MusicPlayer by: DavidV. ¡Hasta pronto!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
    }
}

