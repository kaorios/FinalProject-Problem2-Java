import java.util.Objects;

public class BattleMaster {
    private final String AUTOBOTS_LEADER_NAME = "Optimus Prime";
    private final String DECEPTICONS_LEADER_NAME = "Predaking";

    private int battleCount;

    public BattleMaster() {
        battleCount = 0;
    }

    public Hero battle(Hero hero1, Hero hero2) {
        battleCount++;
        if (hero1 == null) return hero2;
        if (hero2 == null) return hero1;
        if (doSpecialRule(hero1, hero2) != null) return doSpecialRule(hero1, hero2);
        if (doFirstRound(hero1, hero2) != null) return doFirstRound(hero1, hero2);
        if (doSecondRound(hero1, hero2) != null) return doSecondRound(hero1, hero2);
        if (doThirdRound(hero1, hero2) != null) return doThirdRound(hero1, hero2);
        return null;
    }

    public boolean isTheEnd(Hero hero1, Hero hero2) {
        return (Objects.equals(hero1.getName(), AUTOBOTS_LEADER_NAME) && Objects.equals(hero2.getName(), DECEPTICONS_LEADER_NAME))
                || (Objects.equals(hero1.getName(), DECEPTICONS_LEADER_NAME) && Objects.equals(hero2.getName(), AUTOBOTS_LEADER_NAME));
    }

    private Hero doSpecialRule(Hero hero1, Hero hero2) {
        if (Objects.equals(hero1.getName(), AUTOBOTS_LEADER_NAME) || Objects.equals(hero1.getName(), DECEPTICONS_LEADER_NAME)) {
            return hero1;
        }

        if (Objects.equals(hero2.getName(), AUTOBOTS_LEADER_NAME) || Objects.equals(hero2.getName(), DECEPTICONS_LEADER_NAME)) {
            return hero2;
        }

        return null;
    }

    private Hero doFirstRound(Hero hero1, Hero hero2) {
        if (hero1.getCourage() - hero2.getCourage() >= 4 || hero1.getStrength() - hero2.getStrength() >= 3) {
            return hero1;
        }

        if (hero2.getCourage() - hero1.getCourage() >= 4 || hero2.getStrength() - hero1.getStrength() >= 3) {
            return hero2;
        }

        return null;
    }

    private Hero doSecondRound(Hero hero1, Hero hero2) {
        if (hero1.getSkill() - hero2.getSkill() >= 3) {
            return hero1;
        }

        if (hero2.getSkill() - hero1.getSkill() >= 3) {
            return hero2;
        }

        return null;
    }

    private Hero doThirdRound(Hero hero1, Hero hero2) {
        if (hero1.getOverall() > hero2.getOverall()) {
            return hero1;
        }

        if (hero1.getOverall() < hero2.getOverall()) {
            return hero2;
        }

        return null;
    }

    public int getBattleCount() {
        return battleCount;
    }
}
