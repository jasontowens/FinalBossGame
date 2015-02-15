package coordinators;

import map.GameMap;
import java.util.ArrayList;
import map.Pair;
import map.CoordinatePair;
import entity.Entity;
import item.Item;

public class SaveCoordinator {
	private static SaveCoordinator saveCoord = SaveCoordinator.getInstance();
	private GameMap activeMap;
	
	/*-----------CONSTRUCTORS--------------*/
	private SaveCoordinator(){};
	
	/*-----------USAGE--------------*/
	
	public void save(){
		//TODO: create XML file to write to called "writeFile"
		ArrayList<Pair<Entity, CoordinatePair>> entityList = activeMap.getAllEntities();
		ArrayList<Pair<Item, CoordinatePair>> itemList = activeMap.getAllItems();
		for(Pair<Entity, CoordinatePair> iterPair : entityList){
			writeFile = iterPair.getLeft().toXML();
		}
		for(Pair<Item, CoordinatePair> iterPair : itemList){
			writeFile = iterPair.getLeft().toXML();
		}
	}
	
	/*-----------SINGLETON RETRIEVAL--------*/
	public static SaveCoordinator getInstance(){
		if(saveCoord == null){
			saveCoord = new SaveCoordinator();
		}
		return saveCoord;
	}
}
