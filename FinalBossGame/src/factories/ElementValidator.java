package factories;

import org.w3c.dom.Element;

public class ElementValidator {
	public boolean ValidElement(Element e, String type) {
		switch(type) {
			case "entity":
				if(e.getAttribute("occupation").length() < 1) return false;
				if(e.getAttribute("x").length() < 1) return false;
				if(e.getAttribute("y").length() < 1) return false;
				return true;
			case "takeableItem":
				if(e.getAttribute("name").length() < 1) return false;
				if(e.getAttribute("durability").length() < 1) return false;
				return true;
			case "stats":
				if(e.getAttribute("livesleft").length() < 1) return false;
				if(e.getAttribute("strength").length() < 1) return false;
				if(e.getAttribute("agility").length() < 1) return false;
				if(e.getAttribute("intellect").length() < 1) return false;
				if(e.getAttribute("hardiness").length() < 1) return false;
				if(e.getAttribute("experience").length() < 1) return false;
				if(e.getAttribute("movement").length() < 1) return false;
				if(e.getAttribute("hpcurrent").length() < 1) return false;
				if(e.getAttribute("mpcurrent").length() < 1) return false;
				if(e.getAttribute("defense").length() < 1) return false;
				if(e.getAttribute("offense").length() < 1) return false;
				return true;	
			case "inventory":
				if(e.getAttribute("name").length() < 1) return false;
				if(e.getAttribute("durability").length() < 1) return false;
				return true;
			case "takeable":
				if(e.getAttribute("name").length() < 1) return false;
				if(e.getAttribute("x").length() < 1) return false;
				if(e.getAttribute("y").length() < 1) return false;
				if(e.getAttribute("durability").length() < 1) return false;
				return true;
			case "oneshot":
				if(e.getAttribute("name").length() < 1) return false;
				if(e.getAttribute("x").length() < 1) return false;
				if(e.getAttribute("y").length() < 1) return false;
				return true;
			case "interactive":
				if(e.getAttribute("name").length() < 1) return false;
				if(e.getAttribute("x").length() < 1) return false;
				if(e.getAttribute("y").length() < 1) return false;
				return true;
			case "obstacle":
				if(e.getAttribute("name").length() < 1) return false;
				if(e.getAttribute("x").length() < 1) return false;
				if(e.getAttribute("y").length() < 1) return false;
				return true;
			default:
				return false;
		}
	}
}