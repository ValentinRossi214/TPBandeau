package exemple;

import bandeau.Bandeau;

public abstract class Effet {
    private int nbRepetition;

    public Effet(int nbRepetition) {
        this.nbRepetition = nbRepetition;
    }

    public abstract void appliquerEffet(Bandeau bandeau);
}
