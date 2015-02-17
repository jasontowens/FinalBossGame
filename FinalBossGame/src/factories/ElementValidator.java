package factories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.w3c.dom.Element;

public class ElementValidator {

    HashMap<String, List<String>> attributes = new HashMap();

    public ElementValidator() {
        attributes.put("entity", Arrays.asList("occupation", "x", "y"));
        attributes.put("takeableItem", Arrays.asList("name", "durability"));
        attributes.put("stats", Arrays.asList("stats", "livesleft", "strength", "agility, intellect", "hardiness", "experience", "movement", "hpcurrent", "mpcurrent", "defense", "offense"));
        attributes.put("inventory", Arrays.asList("name", "durability"));
        attributes.put("takeable", Arrays.asList("x", "y", "durability"));
        attributes.put("oneshot", Arrays.asList("name", "x", "y"));
        attributes.put("interactive", Arrays.asList("name", "x", "y"));
        attributes.put("obstacle", Arrays.asList("name", "x", "y"));
    }

    public boolean ValidElement(Element e, String type) {
        for (String attribute : attributes.get(type)) {
            if (e.getAttribute(attribute).length() < 1) {
                return false;
            }
        }
        return true;
    }
}
