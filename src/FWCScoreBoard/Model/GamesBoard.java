/**
 * 
 */
package FWCScoreBoard.Model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GamesBoard {
    private List<Match> liveMatches;
    
    /**
     * Class constructor, new arrayList is created to initialize liveMatches
     */
    public GamesBoard() {
        this.liveMatches = new ArrayList<>();
    }
    
    /** Get Matches list
     * @return List<Match> liveMatches
     */
    public List<Match> getliveMatchesList() {
        return liveMatches;
    }
    
    
    /**Adds a match to liveMatches by Match object
     * @param Match pMatch 
     * @throws Exception in case match can't be added
     */
    public void addMatch(Match pMatch) throws Exception {
        for (Match myMatch : this.liveMatches) {
            if (myMatch.equals(pMatch)) {
            	throw new Exception("This match already exists");
            }
        }
        this.liveMatches.add(pMatch);
    }
    
    /**Adds a match to liveMatches by teams names
     * @param String pHomeName
     * @param String pAwayName
     * @throws Exception In case match can't be added or team name is too short
     */
    public void addMatch(String pHomeName, String pAwayName) throws Exception {
    	if(pHomeName.length()>2 & pAwayName.length()>2) {
        	Team myHomeTeam = new Team(pHomeName);
        	Team myAwayTeam = new Team(pAwayName);
        	Match myMatch = new Match(myHomeTeam, myAwayTeam);
    		this.liveMatches.add(myMatch);
    	}else {
    		throw new Exception("Too short team name");
    	}
    		
    }
    
    /**Gets score from match object
     * @param Match pMatch
     * @return Score score
     * @throws Exception in case match not found
     */
    public Score getScore(Match pMatch) throws Exception {
        for (Match myMatch : this.liveMatches) {
            if (myMatch.equals(pMatch)) {
                return myMatch.getScore();
            }
        }
        throw new Exception("Match Not Found");
    }
    

    /**Update match score by Match Object, homeGoals and awayGoals
     * @param Match pMatch
     * @param int pHomeGoals
     * @param int pAwayGoals
     * @throws Exception in case match not found
     */
    public void updateScore(Match pMatch, int pHomeGoals, int pAwayGoals) throws Exception {
    	Boolean found = false;
        for(Match myMatch : this.liveMatches){
        	if(myMatch.equals(pMatch)) {
            	myMatch.getScore().setHomeGoals(pHomeGoals);
            	myMatch.getScore().setAwayGoals(pAwayGoals);
            	myMatch.setScoredGoals(pHomeGoals + pAwayGoals);     
            	found = true;
        	}
        }
        if (!found) {
            throw new Exception("Match Not Found");
        }

    }  
    
    /**Finish a match by Match object
     * @param Match pMatch
     * @throws Exception in case match not found
     */
    public void endMatch(Match pMatch) throws Exception{
    	Boolean found = false;
        Iterator<Match> itr = liveMatches.iterator();
        while (itr.hasNext()) {
        	Match myMatch = itr.next();
        	if(pMatch.equals(myMatch)){
                    itr.remove();
                    found = true;
            }
        }
        if (!found) {
            throw new Exception("Match can't be found");
        }
    
    }
    
    /**Sort matches list by List<Match> pMatches
     * @param List<Match> pMatches
     * @return ordered pMatches
     */
    public List<Match> sortMatches(List<Match> pMatches) {
    	pMatches.sort((firstMatch, secondMatch2) -> {
            if (firstMatch.getScoredGoals() == secondMatch2.getScoredGoals() ){
                if(firstMatch.getMatchCreationTimestamp().after(secondMatch2.getMatchCreationTimestamp())){
                    return -1;
                }else {
                    return 1;
                }
            }
            if (firstMatch.getScoredGoals() > secondMatch2.getScoredGoals()) {
                return -1;
            } else {
                return 1;
            }

            });

            return pMatches;
    }
    

    /** Gets List<Match> pMatches from scoreBoard
     * @return List<Match>
     */
    public List<Match> getsortedMatches() {
    	ArrayList<Match> myMatches = new ArrayList<>();
    	myMatches.addAll(this.liveMatches);
    	this.sortMatches(myMatches);
    	return myMatches;
    }
    
   	/**To String method
   	 *@return String containing all ScoreBoard
   	 */
   	@Override
	public String toString() {
    	String fullBoard = "";
    	ArrayList<Match> myMatches = new ArrayList<>();
    	myMatches.addAll(this.liveMatches);
    	this.sortMatches(myMatches);
    	for(Match myMatch : myMatches){
    		fullBoard += myMatch.toString() + System.getProperty("line.separator");
    		
    	}
    	return fullBoard;
	}
}
