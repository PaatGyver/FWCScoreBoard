package FWCScoreBoard.Model;
import java.sql.Timestamp;

/**
 * @author Patricio Moreno Losana
 * Class representing a match, saves timestamp to be able to order matches
 */

public class Match {
	private Team home;
    private Team away;
    private int scoredGoals;
    private Score score; 
    private Timestamp matchCreationTimestamp;
    
	/**
	 * Constructor of the class, score starts in 0 - 0 if no parameters added
	 */
    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
        this.scoredGoals = 0;
        this.score = new Score();
        this.matchCreationTimestamp = new Timestamp(System.currentTimeMillis());
    }

	public Team getHome() {
		return home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public Team getAway() {
		return away;
	}

	public void setAway(Team away) {
		this.away = away;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
		this.scoredGoals = score.getHomeGoals() + score.getAwayGoals();
	}

	public Timestamp getMatchCreationTimestamp() {
		return matchCreationTimestamp;
	}

	public void setMatchCreationTimestamp(Timestamp matchCreationTimestamp) {
		this.matchCreationTimestamp = matchCreationTimestamp;
	}

	public int getScoredGoals() {
		return scoredGoals;
	}
	
    public void setScoredGoals(int scoredGoals) {
		this.scoredGoals = scoredGoals;
	}
    
	@Override
	public String toString() {
		return this.home + " - " + this.away + ": "+ score.getHomeGoals() + " - " + score.getAwayGoals();
	}

}
