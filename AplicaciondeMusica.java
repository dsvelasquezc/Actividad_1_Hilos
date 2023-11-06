public class AplicaciondeMusica {
    public static void main(String[] args) {
        ReproductordeMusica hiloMusica = new ReproductordeMusica();
        InteraccionConUsuario hiloInteraccion = new InteraccionConUsuario(hiloMusica);

        hiloMusica.start();
        hiloInteraccion.start();

        try {
            hiloMusica.join();
            hiloInteraccion.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

