package exemple;

import java.awt.*;

public class Zoom extends Effet {
    private final int rapidite;
    private int tailleMaxZoom = 60;

    public Zoom(int nbRepetition, int rapidite) {
        super(nbRepetition);
        this.rapidite = rapidite;
    }

    public Zoom(int nbRepetition, int rapidite, int tailleMaxZoom) {
        super(nbRepetition);
        this.rapidite = rapidite;
        this.tailleMaxZoom = tailleMaxZoom;
    }

    @Override
    public void appliquerEffet(bandeau.Bandeau bandeau) {
        Font oldFont = bandeau.getFont();

        for (int i = 5; i < tailleMaxZoom; i += 5) {
            bandeau.setFont(new java.awt.Font(oldFont.getName(), oldFont.getStyle(), 5 + i));
            bandeau.sleep(rapidite);
        }
        bandeau.sleep(1000);
    }
}
