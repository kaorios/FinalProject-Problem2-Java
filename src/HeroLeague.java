import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class HeroLeague {
    private String name;
    private ArrayList<Hero> heroList;

    public HeroLeague(String name) {
        this.name = name;
        heroList = new ArrayList<Hero>();
    }

    public void addHero(Hero hero) {
        heroList.add(hero);
        Collections.sort(heroList, new HeroComparator());
    }

    public Hero getHero(int index) {
        return heroList.size() - 1 >= index ? heroList.get(index) : null;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Hero hero : heroList) {
            if (!Objects.equals(sb.toString(), "")) sb.append(", ");
            sb.append(hero.getName());
        }
        return sb.toString();
    }

    public int size() {
        return heroList.size();
    }

    public int diedHeroCount() {
        int count = 0;
        for (Hero hero : heroList) {
            if (!hero.isAlive()) count++;
        }
        return count;
    }

    public String toStringSurvivors() {
        StringBuilder sb = new StringBuilder();
        for (Hero hero : heroList) {
            if (!Objects.equals(sb.toString(), "") && hero.isAlive()) sb.append(", ");
            if (hero.isAlive()) sb.append(hero.getName());
        }
        return sb.toString();
    }
}
