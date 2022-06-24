/**
 * 
 */
package FWCScoreBoard.Model;

/**
 * @author Patricio Moreno Losana
 * Class to save team data
 */

public class Team {

	private final String name;

    public Team(String name)throws Exception {
    	if(name.length()>2) {
    		this.name = name;
    	}else {
    		throw new Exception("Too short team name");
    	}
    }

    public String getName() {
        return this.name;
    }
    
    @Override
	public String toString() {
		return "Team [name=" + name + "]";
	}
}

