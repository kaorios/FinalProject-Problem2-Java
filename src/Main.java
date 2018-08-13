import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        HeroLeague autobots = new HeroLeague("Autobots");
        HeroLeague decepticons = new HeroLeague("Decepticons");

        String[] inputLines = getInput();
        for (String inputLine : inputLines) {
            Hero target = createHero(inputLine);
            if (Objects.equals(target.getTeam(), "A")) {
                autobots.addHero(target);
            } else {
                decepticons.addHero(target);
            }
        }

        BattleMaster battleMaster = new BattleMaster();
        int maxBattleCount = autobots.size() < decepticons.size() ? autobots.size() : decepticons.size();
        for (int i = 0; i < maxBattleCount; i++) {
            Hero autobotsHero = autobots.getHero(i);
            Hero decepticonsHero = decepticons.getHero(i);

            // the end of the world
            if (battleMaster.isTheEnd(autobotsHero, decepticonsHero)) {
                System.out.println("The battle of 'Optimus Prime' and 'Predaking' destroyed the world.");
                return;
            }

            Hero winner = battleMaster.battle(autobotsHero, decepticonsHero);
            if (Objects.equals(winner, autobotsHero)) {
                decepticonsHero.dead();
            } else if (Objects.equals(winner, decepticonsHero)) {
                autobotsHero.dead();
            } else {
                autobotsHero.dead();
                decepticonsHero.dead();
            }
        }

        StringBuilder sb = new StringBuilder();

        // print battle count
        sb.append(battleMaster.getBattleCount()).append(" Battle(s)\n");

        // print winning team
        if (autobots.diedHeroCount() < decepticons.diedHeroCount()) {
            sb.append("Winning Team (Autobots): ");
            sb.append(autobots.toStringSurvivors()).append("\n");
            sb.append("Losing Team (Decepticons): ");
            sb.append(decepticons.toStringSurvivors()).append("\n");
        } else if (autobots.diedHeroCount() > decepticons.diedHeroCount()) {
            sb.append("Winning Team (Decepticons): ");
            sb.append(decepticons.toStringSurvivors()).append("\n");
            sb.append("Losing Team (Autobots): ");
            sb.append(autobots.toStringSurvivors()).append("\n");
        } else {
            sb.append("Result: No contest.\n");
        }

        System.out.println(sb.toString());
    }

    private static String[] getInput() {
        return new String[]{
                "Optimus Prime,A,10,10,8,10,10,8,10,10",
                "Predaking,D,10,5,1,8,7,9,9,8",
                "Soundwave,D,8,9,2,6,8,5,6,10",
                "Bluesteak,A,6,6,7,9,5,2,9,7",
                "Hubcap,A,4,4,4,4,4,4,4,4",
                "Sixshot,D,10,9,4,9,7,8,9,8",
        };
    }

    private static Hero createHero(String inputLine) {
        String[] params = inputLine.split(",");
        return new Hero(
                params[0],
                params[1],
                Integer.parseInt(params[2]),
                Integer.parseInt(params[3]),
                Integer.parseInt(params[4]),
                Integer.parseInt(params[5]),
                Integer.parseInt(params[6]),
                Integer.parseInt(params[7]),
                Integer.parseInt(params[8]),
                Integer.parseInt(params[9])
        );
    }
}
