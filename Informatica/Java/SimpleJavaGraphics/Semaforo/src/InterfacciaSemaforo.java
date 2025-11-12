import graphics.*;

public class InterfacciaSemaforo {
    double height;
    double width;
    double ellipse_height;
    double ellipse_width;
    Semaforo s;
    Ellipse verde;
    Ellipse giallo;
    Ellipse rosso;
    Rectangle box;

    public InterfacciaSemaforo() {
        height = 800;
        width = 450;
        ellipse_height = 200;
        ellipse_width = 200;
        s = new Semaforo();
        box = new Rectangle(0, 0, width, height);
        box.setColor(Color.DARK_GRAY);
        box.fill();
        verde = new Ellipse(width/2 - ellipse_width/2, height / 6 * 5 - ellipse_height/2 , ellipse_width, ellipse_height);
        verde.setColor(Color.LIGHT_GRAY);
        verde.fill();
        giallo = new Ellipse(width/2 - ellipse_width/2, height / 6 * 3 - ellipse_height/2, ellipse_width, ellipse_height);
        giallo.setColor(Color.LIGHT_GRAY);
        giallo.fill();
        rosso = new Ellipse(width/2 - ellipse_width/2, height / 6 - ellipse_height/2, ellipse_width, ellipse_height);
        rosso.setColor(Color.LIGHT_GRAY);
        rosso.fill();
    }

    public void accendiSemaforo() {
        s.accendi();
        verde.setColor(Color.GREEN);
    }

    public void nextColor() {
        if (s.getColore().equals("VERDE")) {
            s.avanza();
            verde.setColor(Color.LIGHT_GRAY);
            giallo.setColor(Color.YELLOW);
        } else if (s.getColore().equals("GIALLO")) {
            s.avanza();
            giallo.setColor(Color.LIGHT_GRAY);
            rosso.setColor(Color.RED);
        }
        else if (s.getColore().equals("ROSSO")){
            s.avanza();
            rosso.setColor(Color.LIGHT_GRAY);
            verde.setColor(Color.GREEN);
        }
    }

    public void spegniSemaforo() {
        s.spegni();
        verde.setColor(Color.LIGHT_GRAY);
        giallo.setColor(Color.LIGHT_GRAY);
        rosso.setColor(Color.LIGHT_GRAY);
    }

    public void toggleSemaforo() {
        if (s.isAcceso()) {
            spegniSemaforo();
            s.spegni();
        }
        else {
            accendiSemaforo();
            s.accendi();
        }
    }

    public void eliminaSemaforo() {
        Canvas.close();
    }
}
