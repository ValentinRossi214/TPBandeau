package exemple;

public class Teletype extends Effet {
    private final int rapidite;

    public Teletype(int nbRepetition, int rapidite) {
        super(nbRepetition);
        this.rapidite = rapidite;
    }

    @Override
    public void appliquerEffet(bandeau.Bandeau bandeau) {
        String message = bandeau.getMessage();
        StringBuilder messageCache = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            messageCache.append("_");
        }
        bandeau.setMessage(messageCache.toString());
        for (int i = 0; i < message.length(); i++) {
            bandeau.sleep(rapidite);
            messageCache.setCharAt(i, message.charAt(i));
            bandeau.setMessage(messageCache.toString());
        }
    }
}
