package exemple;

import bandeau.Bandeau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JeuDuPendu extends Effet{
    private final int rapidite;
    public JeuDuPendu(int nbRepetition, int rapidite) {
        super(nbRepetition);
        this.rapidite = rapidite;
    }

    public void appliquerEffet(Bandeau bandeau) {
        String mot = bandeau.getMessage();
        List<Integer> indexLettresCachees = new ArrayList<>();
        StringBuilder motCache = new StringBuilder();
        int cpt = 0;

        for (int i = 0 ; i < bandeau.getMessage().length() ; i++) {
            indexLettresCachees.add(cpt);
            motCache.append("_");
            cpt++;
        }
        bandeau.setMessage(motCache.toString());

        int rdIndex;
        for (int i = 0; i < mot.length(); i++) {
            bandeau.sleep(rapidite);
            rdIndex = getRandomIndex(indexLettresCachees);
            updateMotCache(motCache, rdIndex, mot.charAt(rdIndex));
            indexLettresCachees.remove((Integer) rdIndex);
            bandeau.setMessage(motCache.toString());
        }
    }

    private int getRandomIndex(List<Integer> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    private void updateMotCache(StringBuilder motCache, int index, char lettre)
    {
        motCache.setCharAt(index, lettre);
    }
}
