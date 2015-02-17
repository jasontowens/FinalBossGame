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
        attributes.put("entity", Arrays.asList("inventory", "name", "durability"));
        attributes.put("entity", Arrays.asList("takeable", "x", "y", "durability"));
        attributes.put("entity", Arrays.asList("oneshot", "name", "x", "y"));
        attributes.put("entity", Arrays.asList("interactive", "name", "x", "y"));
        attributes.put("entity", Arrays.asList("obstacle", "name", "x", "y"));
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
