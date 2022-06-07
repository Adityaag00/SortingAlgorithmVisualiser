package projectalgorithmsortingvisualiaser;

public class LeaderboardDTO {
    private String name;
    private int score;
    private String email;

    public LeaderboardDTO() {}

    public LeaderboardDTO(String name, int score, String email) {
        this.name = name;
        this.score = score;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
