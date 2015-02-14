package factories;

import gameobject.GameObject;

public class ObjectFactory {
	private String xmlfile;
	private ArrayList<PlaceableObjectFactory> factories;

	public ObjectFactory(String xmlfile) {
		this.xmlfile = xmlfile;

		factories = new ArrayList<PlaceableObjectFactory>();
		factories.add(new EntityFactory());
		factories.add(new EquipableFactory());
		factories.add(new InteractiveItemFactory());
		factories.add(new ObstacleFactory());
		factories.add(new OneShotFactory());
		factories.add(new TakeableFactory());
	}

	public void ParseFile()
	{
		
	}
}