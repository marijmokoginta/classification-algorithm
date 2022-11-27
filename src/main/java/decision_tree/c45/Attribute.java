package decision_tree.c45;

import java.util.HashMap;

public class Attribute {

    private String name;

    public HashMap<String, Count> attrList = new HashMap<>();

    public boolean used;

    public int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attribute (int index) {
        this.index = index;
    }

    public void update () {
        attrList = new HashMap<>();
    }

    public void addMEDIA(String key) {
        if (attrList.containsKey(key)) {
            attrList.get(key).incrementPSPR();
        } else {
            attrList.put(key, new Count());
            attrList.get(key).incrementPSPR();
        }
    }

    public void addSAINTEK(String key) {
        if (attrList.containsKey(key)) {
            attrList.get(key).incrementPSPT();
        } else {
            attrList.put(key, new Count());
            attrList.get(key).incrementPSPT();
        }
    }

    public void addSOSEK(String key) {
        if (attrList.containsKey(key)) {
            attrList.get(key).incrementTKJ();
        } else {
            attrList.put(key, new Count());
            attrList.get(key).incrementTKJ();
        }
    }
}
