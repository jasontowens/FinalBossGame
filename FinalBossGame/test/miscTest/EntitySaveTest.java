package miscTest;
import inventory.*;
import entity.*;
import stats.*;

/*
 * A basic test to see if toXML() works.  Not super exhaustive because
 * the way entity is constructed here results in a null Inventory.
 * 
 * TODO: more exhaustive test that includes Inventory!
 * 
 * Just a console dump because comparing a giant string is a pain with JUnit
 * 
 * @author: hanif
 */
public class EntitySaveTest {
	public static void main(String [] args){
		
		
		Inventory inventory = new Inventory(new Sack() , new Armory());
		
		Occupation occupation = new Occupation("Summoner" , " ");
		PlayerStats stats = new PlayerStats(1 , 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		//TODO add to XML for Stats
		Entity entity = new Entity("Pacman" , "runs around" , "/path/to/nowhere" , MotionType.GROUND , inventory,
				 occupation , stats);
	
		System.out.println(entity.toXML());
	}
}

