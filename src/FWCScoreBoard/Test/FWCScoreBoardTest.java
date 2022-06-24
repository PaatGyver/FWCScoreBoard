package FWCScoreBoard.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import FWCScoreBoard.Model.*;


/**
 * @author Patricio Moreno Losana
 *T{@summary} Test script to check classes behavior
 */
class FWCScoreBoardTest {

	/**
	 * This test checks Team Names, should be longer than 2 characters
	 */
    @Test
    @DisplayName("1. Try to create team with too short name")
    public void testTooShortTeamName(){
        try {
        	Team myTeam = new Team("AB");
        }catch (Exception e) {
            assertTrue(e.getMessage().equals("Too short team name"), "Game name is too short");
        }
    }
    
	/**
	 * This test checks Match creation
	 */
    @Test
    @DisplayName("2. Try to create match, test getScore")
    public void testCreateMatch()throws Exception {
        Team firstTeam = new Team("Mexico");
        Team secondTeam = new Team("Canada");
        Match myMatch = new Match(firstTeam, secondTeam);
        assertTrue(myMatch.getScore().toString().equals("0 - 0"), "Match was created, added and inicialized");
        
    }
    
	/**
	 * This test checks Match set score
	 */
    @Test
    @DisplayName("3. Try to setScore of a match")
    public void testSetScore()throws Exception {
        Team firstTeam = new Team("Mexico");
        Team secondTeam = new Team("Canada");
        Match myMatch = new Match(firstTeam, secondTeam);
        Score score = new Score(1,1);
        myMatch.setScore(score);
        assertTrue(myMatch.getScore().toString().equals("1 - 1"), "Match was created, added and inicialized");
        
    }
    
	/**
	 * This test checks score board constructor, list must be created but empty
	 */
    @Test
    @DisplayName("4. Create ScoreBoard and check that has no elements")
    public void testGamesBoardConstructor(){
    	GamesBoard myGamesBoard = new GamesBoard();
        assertTrue(myGamesBoard.getliveMatchesList().isEmpty());
    }
    
	/**
	 * This test checks match creation with to short team names
	 */
    @Test
    @DisplayName("5. Try to add match with too short team name")
    public void testTooShortTeamNameMatchCreation(){
        try {
        	GamesBoard myGamesBoard = new GamesBoard();
            myGamesBoard.addMatch("AB", "CD");
        }catch (Exception e) {
            assertTrue(e.getMessage().equals("Too short team name"), "Game name is too short");
        }
    }
    
	/**
	 * This test checks if same match can be added twice
	 */
    @Test
    @DisplayName("6. Try to add duplicated matches to list")
    public void testMatchAddedTwice(){
        try {
        	GamesBoard myGamesBoard = new GamesBoard();
            Team firstTeam = new Team("Mexico");
            Team secondTeam = new Team("Canada");
            Match myMatch = new Match(firstTeam, secondTeam);
            myGamesBoard.addMatch(myMatch);
            myGamesBoard.addMatch(myMatch);
        }catch (Exception e) {
            assertTrue(e.getMessage().equals("This match already exists"), "Match was included already");
        }
    }
    
	/**
	 * This test checks match add to ScoreBoard by team names
	 */
    @Test
    @DisplayName("7. Add match to SB by team's names")
    public void testAddMatchWithNames() throws Exception {
    	GamesBoard myGamesBoard = new GamesBoard();
        myGamesBoard.addMatch("Mexico", "Canada");
        assertTrue(myGamesBoard.getScore(myGamesBoard.getliveMatchesList().get(0)).toString().equals("0 - 0"), "Match was created, added and inicialized");
    }
    
    
	/**
	 * This test checks match add to ScoreBoard by Match class
	 */
    @Test
    @DisplayName("8. Add match to SB by Match class")
    public void testAddMatchWithMatch() throws Exception {
    	GamesBoard myGamesBoard = new GamesBoard();
        Team firstTeam = new Team("Mexico");
        Team secondTeam = new Team("Canada");
        Match myMatch = new Match(firstTeam, secondTeam);
        myGamesBoard.addMatch(myMatch);
        assertTrue(myGamesBoard.getScore(myMatch).toString().equals("0 - 0"), "Match was created, added and inicialized");
    }
    
	/**
	 * Check score from match not included in scoreBoard
	 */
    @Test
    @DisplayName("9. Check not found match score")
    public void testGetScoreTeamNotFOund() {
    	GamesBoard myGamesBoard = new GamesBoard();
        try {
            Team homeTeam1 = new Team("Mexico");
            Team AwayTeam1 = new Team("Canada");
            Match myMatch1 = new Match(homeTeam1, AwayTeam1);
            myGamesBoard.addMatch(myMatch1);
            myGamesBoard.updateScore(myMatch1, 2, 5);

            Team homeTeam2 = new Team("Spain");
            Team AwayTeam2 = new Team("Brazil");
            Match myMatch2 = new Match(homeTeam2, AwayTeam2);
            myGamesBoard.addMatch(myMatch2);
            myGamesBoard.updateScore(myMatch2, 10, 2);
            
            Team homeTeam3 = new Team("Germany");
            Team AwayTeam3 = new Team("France");
            Match myMatch3 = new Match(homeTeam3, AwayTeam3);

            Score score = myGamesBoard.getScore(myMatch3);
        }catch (Exception e) {
            assertTrue(e.getMessage().equals("Match Not Found"), "Can't get score from non existing match");
        }
    }
    
	/**
	 * Check score update from not included match
	 */
    @Test
    @DisplayName("10. Game score can't be updated, match not found")
    public void testNotFoundMatchUpdate() throws Exception {
    	GamesBoard myGamesBoard = new GamesBoard();
        Team firstTeam = new Team("Mexico");
        Team secondTeam = new Team("Canada");
        Match myMatch = new Match(firstTeam, secondTeam);
        try {
        	myGamesBoard.updateScore(myMatch,2,2);
        }catch (Exception e) {
            assertTrue(e.getMessage().equals("Match Not Found"), "Game score wasn't updated cause match not found");
        }
    }
    
	/**
	 * Check score correct update match process 
	 */
    @Test
    @DisplayName("11. Game score is updated if game in SB")
    public void testGameScoreWasUpdated() throws Exception {
    	GamesBoard myGamesBoard = new GamesBoard();
        Team firstTeam = new Team("Mexico");
        Team secondTeam = new Team("Canada");
        Match myMatch = new Match(firstTeam, secondTeam);
        myGamesBoard.addMatch(myMatch);
    	myGamesBoard.updateScore(myMatch,2,2);
        assertTrue(myGamesBoard.getScore(myMatch).toString().equals("2 - 2"), "Game score was updated");
    }
    
	/**
	 * Check ending not existing match
	 */
    @Test
    @DisplayName("12. Finished game can't be found")
    public void testGameFinish() throws Exception {
    	GamesBoard myGamesBoard = new GamesBoard();
        Team firstTeam = new Team("Mexico");
        Team secondTeam = new Team("Canada");
        Match myMatch = new Match(firstTeam, secondTeam);
        myGamesBoard.addMatch(myMatch);
        assertTrue(!myGamesBoard.getliveMatchesList().isEmpty());
        myGamesBoard.endMatch(myMatch);
        assertTrue(myGamesBoard.getliveMatchesList().isEmpty());
    }
    
	/**
	 * Check ordering system just by goals (all different number of goals)
	 */
    @Test
    @DisplayName("13. Check order board process without timestamp")
    public void testGBSortNoTimeFunction() throws Exception {
    	GamesBoard myGamesBoard = new GamesBoard();
        
        Team homeTeam1 = new Team("Mexico");
        Team AwayTeam1 = new Team("Canada");
        Match myMatch1 = new Match(homeTeam1, AwayTeam1);
        myGamesBoard.addMatch(myMatch1);
        myGamesBoard.updateScore(myMatch1, 2, 5);

        Team homeTeam2 = new Team("Spain");
        Team AwayTeam2 = new Team("Brazil");
        Match myMatch2 = new Match(homeTeam2, AwayTeam2);
        myGamesBoard.addMatch(myMatch2);
        myGamesBoard.updateScore(myMatch2, 10, 2);
        
        Team homeTeam3 = new Team("Germany");
        Team AwayTeam3 = new Team("France");
        Match myMatch3 = new Match(homeTeam3, AwayTeam3);
        myGamesBoard.addMatch(myMatch3);
        myGamesBoard.updateScore(myMatch3, 2, 2);
        
        Team homeTeam4 = new Team("Uruguay");
        Team AwayTeam4 = new Team("Italy");
        Match myMatch4 = new Match(homeTeam4, AwayTeam4);
        myGamesBoard.addMatch(myMatch4);
        myGamesBoard.updateScore(myMatch4, 5, 6);
        
        Team homeTeam5 = new Team("Argentina");
        Team AwayTeam5 = new Team("Australia");
        Match myMatch5 = new Match(homeTeam5, AwayTeam5);
        myGamesBoard.addMatch(myMatch5);
        myGamesBoard.updateScore(myMatch5, 2, 1);
       
        assertTrue(myGamesBoard.getsortedMatches().get(0).getScore().toString().equals("10 - 2"), "Good Order");
        assertTrue(myGamesBoard.getsortedMatches().get(1).getScore().toString().equals("5 - 6"), "Good Order");
        assertTrue(myGamesBoard.getsortedMatches().get(2).getScore().toString().equals("2 - 5"), "Good Order");
        assertTrue(myGamesBoard.getsortedMatches().get(3).getScore().toString().equals("2 - 2"), "Good Order");
        assertTrue(myGamesBoard.getsortedMatches().get(4).getScore().toString().equals("2 - 1"), "Good Order");
    }
    
	/**
	 * Check ordering system, check timestamp filter
	 */
    @Test
    @DisplayName("14. Check order board with timestamp needed")
    public void testGBSortFunctionwithTimestamp() throws Exception {
    	GamesBoard myGamesBoard = new GamesBoard();
        
        Team homeTeam1 = new Team("Mexico");
        Team AwayTeam1 = new Team("Canada");
        Match myMatch1 = new Match(homeTeam1, AwayTeam1);
        myGamesBoard.addMatch(myMatch1);
        myGamesBoard.updateScore(myMatch1, 0, 5);

        Team homeTeam2 = new Team("Spain");
        Team AwayTeam2 = new Team("Brazil");
        Match myMatch2 = new Match(homeTeam2, AwayTeam2);
        myGamesBoard.addMatch(myMatch2);
        myGamesBoard.updateScore(myMatch2, 10, 2);
        
        Team homeTeam3 = new Team("Germany");
        Team AwayTeam3 = new Team("France");
        Match myMatch3 = new Match(homeTeam3, AwayTeam3);
        myGamesBoard.addMatch(myMatch3);
        myGamesBoard.updateScore(myMatch3, 2, 2);
        
        Team homeTeam4 = new Team("Uruguay");
        Team AwayTeam4 = new Team("Italy");
        Match myMatch4 = new Match(homeTeam4, AwayTeam4);
        myGamesBoard.addMatch(myMatch4);
        myGamesBoard.updateScore(myMatch4, 6, 6);
        
        Team homeTeam5 = new Team("Argentina");
        Team AwayTeam5 = new Team("Australia");
        Match myMatch5 = new Match(homeTeam5, AwayTeam5);
        myGamesBoard.addMatch(myMatch5);
        myGamesBoard.updateScore(myMatch5, 3, 1);
       
        assertTrue(myGamesBoard.getsortedMatches().get(0).getScore().toString().equals("6 - 6"), "Good Order");
        assertTrue(myGamesBoard.getsortedMatches().get(1).getScore().toString().equals("10 - 2"), "Good Order");
        assertTrue(myGamesBoard.getsortedMatches().get(2).getScore().toString().equals("0 - 5"), "Good Order");
        assertTrue(myGamesBoard.getsortedMatches().get(3).getScore().toString().equals("3 - 1"), "Good Order");
        assertTrue(myGamesBoard.getsortedMatches().get(4).getScore().toString().equals("2 - 2"), "Good Order");
    }

}


