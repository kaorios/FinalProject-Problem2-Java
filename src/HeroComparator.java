import java.util.Comparator;

public class HeroComparator implements Comparator<Hero> {

    @Override
    public int compare(Hero h1, Hero h2) {
        if (h1.getRank() == h2.getRank()) return 0;
        return h1.getRank() > h2.getRank() ? -1 : 1;
    }
}
