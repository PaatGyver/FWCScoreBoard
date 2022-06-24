/**
 * 
 */
package FWCScoreBoard.Model;

/**
 * @author Patricio Moreno Losana
 * Calss to represent score of a match
 */
public class Score {
	
	private int homeGoals;
	private int awayGoals;
	
	/**
	 * Constructor of the class, score starts in 0 - 0 if no parameters added
	 */
	public Score() {
		this.homeGoals = 0;
		this.awayGoals = 0;
	}
	/**
	 * Constructor of the class, score starts with goals added by parameters
	 */
	public Score(int homeGoals, int awayGoals) {
		this.homeGoals = homeGoals;
		this.awayGoals = awayGoals;
	}
	
	public int getHomeGoals() {
		return homeGoals;
	}

	public void setHomeGoals(int homeGoals) {
		this.homeGoals = homeGoals;
	}

	public int getAwayGoals() {
		return awayGoals;
	}

	public void setAwayGoals(int awayGoals) {
		this.awayGoals = awayGoals;
	}

	@Override
	public String toString() {
		return homeGoals + " - " + awayGoals;
	}


}
