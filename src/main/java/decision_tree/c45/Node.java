package decision_tree.c45;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Node> children = new ArrayList<>();
    private String rule;
    private String name;

    private String parent;
    private Attribute attachdedAttr;
    private List<String[]> recordList = new ArrayList<>();
    private List<String[]> testList = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public String getRule() {
        return rule;
    }

    public String getName() {
        return name;
    }

    public Attribute getAttachdedAttr() {
        return attachdedAttr;
    }

    public List<String[]> getRecordList() {
        return recordList;
    }

    public List<String[]> getTestList() {
        return testList;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public void setAttachdedAttr(Attribute attachdedAttr) {
        this.attachdedAttr = attachdedAttr;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
