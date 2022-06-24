package FWCScoreBoard.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * @author Patricio Moreno Losana
 *T{@summary} Test script to check classes behaviour
 */
class FWCScoreBoardTest {

	/**
	 * This test checks Team Names, should be longer than 2 caracters
	 */
    @Test
    @DisplayName("1. Try to create team with too short name")
    public void testTooShortTeamName(){
    //TODO
    }
    
	/**
	 * This test checks score board constructor, list must be created but empty
	 */
    @Test
    @DisplayName("2. Create ScoreBoard and check that has no elements")
    public void testGamesBoardConstructor(){
        //TODO
    }
    
	/**
	 * This test checks match creation with to short team names
	 */
    @Test
    @DisplayName("3. Try to add match with too short team name")
    public void testTooShortTeamNameMatchCreation(){
        //TODO
    }
    
	/**
	 * This test checks match creation with to short team names
	 */
    @Test
    @DisplayName("4. Try to add match with too short team name")
    public void testMatchAddedTwice(){
        //TODO
    }
    
	/**
	 * This test checks match add to ScoreBoard by team names
	 */
    @Test
    @DisplayName("5. Add match to SB by team's names")
    public void testAddMatchWithNames() {
        //TODO
    }
    
    
	/**
	 * This test checks match add to ScoreBoard by Match class
	 */
    @Test
    @DisplayName("6. Add match to SB by Match class")
    public void testAddMatchWithMatch() {
        //TODO
    }
    
	/**
	 * Check score from match not included in scoreBoard
	 */
    @Test
    @DisplayName("7. Check not found match score")
    public void testGetScoreTeamNotFOund() {
        //TODO
    }
    
	/**
	 * Check score update from not included match
	 */
    @Test
    @DisplayName("8. Game score can't be updated, match not found")
    public void testNotFoundMatchUpdate() {
        //TODO
    }
    
	/**
	 * Check score correct update match process 
	 */
    @Test
    @DisplayName("9. Game score is updated if game in SB")
    public void testGameScoreWasUpdated() {
        //TODO
    }
    
	/**
	 * Check ending not existing match
	 */
    @Test
    @DisplayName("10. Finished game can't be found")
    public void testGameFinish() {
        //TODO
    }
    
	/**
	 * Check ordering system just by goals (all different number of goals)
	 */
    @Test
    @DisplayName("11. Check order board process without timestamp")
    public void testGBSortNoTimeFunction() {
        //TODO       
    }
    
	/**
	 * Check ordering system, check timestamp filter
	 */
    @Test
    @DisplayName("12. Check order board with timestamp needed")
    public void testGBSortFunctionwithTimestamp(){
        //TODO     
    }

}


