//Last updated by Matthew Kroeze on 2015-02-12

package item;

import entity.Entity;

public interface Item{	
	/*
	 * activate(): 
	 * 
	 * RETURNS a boolean that signals whether the triggering entity is allowed
	 * to enter the tile of the interactive item. A signal of true means that the entity will enter the
	 * tile, and a signal of false means that the entity will be refused entry to the current tile 
	 * (and therefore will remain on the tile from which it requested entry)
	 * 
	 * PERFORMS whatever function is required of the item when it an entity attempts to touch it.
	 */
	public boolean activate(Entity entity);
	public String toXML();
        public int getID();
}
