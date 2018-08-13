public class Hero {
    private String name;
    private String team;
    private int strength;
    private int intelligence;
    private int speed;
    private int endurance;
    private int rank;
    private int courage;
    private int firePower;
    private int skill;
    private boolean isAlive;

    public Hero(String name, String team, int strength, int intelligence, int speed, int endurance, int rank,
                int courage, int firePower, int skill) {
        this.name = name;
        this.team = team;
        this.strength = strength;
        this.intelligence = intelligence;
        this.speed = speed;
        this.endurance = endurance;
        this.rank = rank;
        this.courage = courage;
        this.firePower = firePower;
        this.skill = skill;
        isAlive = true;
    }

    public int getOverall() {
        return strength + intelligence + speed + endurance + firePower;
    }

    public void dead() {
        isAlive = false;
    }

    int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getStrength() {
        return strength;
    }

    public int getCourage() {
        return courage;
    }

    public int getSkill() {
        return skill;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
