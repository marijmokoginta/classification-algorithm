package decision_tree.c45;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class C45 {

    private final String MediaTitle = "MEDIA";
    private final String SaintekTitle = "SAINTEK";
    private final String SosekTitle = "SOSEK";

    private final List<Attribute> attributes = new ArrayList<>();
    private final List<String[]> records = new ArrayList<>();

    private final String trainingFile;
    private final String testFile;

    private int correct = 0;
    private int incorrect = 0;

    public C45 (String trainingFile, String testFile) throws IOException {
        this.trainingFile = trainingFile;
        this.testFile = testFile;

        createAllAttribute();
        loadDataRecord();

        Node root = new Node("root");
        root.getRecordList().addAll(records);
        root.setAttachdedAttr(null);
        root.setParent("root");

        splitTree(root);
        treeVisualize(root);

        testTree(root);

    }

    public int getCorrect() {
        return correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void treeVisualize(Node root) {
        LinkedList<Node> children = new LinkedList<>();

        children.add(root);

        while (!children.isEmpty()) {
            Node a = children.poll();
            if (a.getAttachdedAttr() != null) {
                System.out.println("Splitting attribute : " + a.getAttachdedAttr().index + ". " + a.getAttachdedAttr().getName());
                System.out.println("Attribute : " + a.getName());
                System.out.println("media : " + a.getAttachdedAttr().attrList.get(a.getName()).getMEDIA());
                System.out.println("saintek : " + a.getAttachdedAttr().attrList.get(a.getName()).getSAINTEK());
                System.out.println("sosek : " + a.getAttachdedAttr().attrList.get(a.getName()).getSOSEK());
                System.out.println("parent : " + a.getParent());
                System.out.println("children : " + a.getChildren().size());
                System.out.println();
            }

            if (a.getChildren().size() != 0) {
                children.addAll(a.getChildren());
            }
        }
    }

    private void testTree(Node node) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(testFile));

        String line;

        while ((line = reader.readLine()) != null) {
            String[] testRecord = line.split(",");
            node.getTestList().add(testRecord);
        }

        clasify(node);

        reader.close();
    }

    private void clasify(Node node) {
        if(node.getChildren().size() == 0) {
            for (String[] test : node.getTestList()) {
                if(node.getRule() != null) {
                    if(test[0].equals(node.getRule())) {
                        correct++;
                         System.out.println(Arrays.toString(test) + " : Correct classification label " + node.getRule());
                    } else {
                        incorrect++;
                         System.out.println(Arrays.toString(test) + " : Incorrect classification label " + node.getRule());
                    }
                } else {
                    incorrect++;
                     System.out.println(Arrays.toString(test) + " : Classification label : impure class");
                }
            }
            return;
        }

        for (String[] test : node.getTestList()) {
            for (Node element : node.getChildren()) {
                if(test[element.getAttachdedAttr().index].equals(element.getName())) {
                    element.getTestList().add(test);
                }
            }
        }

        for (Node element : node.getChildren()) {
            clasify(element);
        }
    }

    private void splitTree(Node node) {
        boolean flag = false;
        for (Attribute attr : attributes) {
            if (!attr.used) {
                flag = true;
                break;
            }
        }

        if (!flag) return;

        int media = 0;
        int saintek = 0;
        int sosek = 0;

        if(!node.getName().equals("root")) {
            for (Attribute attr : attributes) {
                if (!attr.used) {
                    attr.update();
                }
            }
        }

        for (String[] rec : node.getRecordList()) {
            if (!node.getName().equals("root")) {
                for (int i = 1; i < rec.length; i++) {
                    switch (rec[0]) {
                        case MediaTitle:
                            if (!attributes.get(i - 1).used) {
                                attributes.get(i - 1).addMEDIA(rec[i]);
                            }
                            break;
                        case SaintekTitle:
                            if (!attributes.get(i - 1).used) {
                                attributes.get(i - 1).addSAINTEK(rec[i]);
                            }
                            break;
                        case SosekTitle:
                            if (!attributes.get(i - 1).used) {
                                attributes.get(i - 1).addSOSEK(rec[i]);
                            }
                            break;
                    }
                }
            }

            switch (rec[0]) {
                case MediaTitle -> media++;
                case SaintekTitle -> saintek++;
                case SosekTitle -> sosek++;
            }
        }

        // set rule
        if ((saintek + sosek) == 0) {
            node.setRule(MediaTitle);
            return;
        }
        if ((media + sosek) == 0) {
            node.setRule(SaintekTitle);
            return;
        }
        if ((media + saintek) == 0) {
            node.setRule(SosekTitle);
            return;
        }

        Attribute bestAttribute = selectAttribute(media, saintek, sosek, node.getRecordList());
        if (bestAttribute == null) return;
        else bestAttribute.used = true;

        for (String key : bestAttribute.attrList.keySet()) {
            Node child = new Node(key);
            child.setAttachdedAttr(bestAttribute);
            child.setParent(node.getName());
            node.getChildren().add(child);
        }

        for (String[] rec : node.getRecordList()) {
            for (Node child : node.getChildren()) {
                if (rec[bestAttribute.index].equals(child.getName())) {
                    child.getRecordList().add(rec);
                }
            }
        }

        for (Node child : node.getChildren()) {
            splitTree(child);
        }
    }

    private double entrophy(int media, int saintek, int sosek) {
        double cSum = media + saintek + sosek;

        double cMedia = (media == 0) ? 0 : (-1 * media / (cSum)) * (Math.log(media / cSum) / Math.log(2));
        double cSaintek = (saintek == 0) ? 0 : (-1 * saintek / (cSum)) * (Math.log(saintek / cSum) / Math.log(2));
        double cSosek = (sosek == 0) ? 0 : (-1 * sosek / (cSum)) * (Math.log(sosek / cSum) / Math.log(2));

        return cMedia + cSaintek + cSosek;
    }

    private Attribute selectAttribute(int media, int saintek, int sosek, List<String[]> recordList) {
        double entrophyS = entrophy(media, saintek, sosek);
        double max = -Double.MIN_VALUE;

        Attribute bestAttribute = null;

        for (Attribute attr : attributes) {
            double entrophyAttr = 0.0;
            double splitInfo = 0.0;

            if(attr.used) continue;

            for (String key : attr.attrList.keySet()) {
                int vMedia = attr.attrList.get(key).getMEDIA();
                int vSaintek = attr.attrList.get(key).getSAINTEK();
                int vSosek = attr.attrList.get(key).getSOSEK();

                int vSum = vMedia + vSaintek + vSosek;

                entrophyAttr += (vSum/(double) recordList.size()) * entrophy(vMedia,vSaintek,vSosek);
                splitInfo += (-vSum/(double) recordList.size()) * (Math.log(vSum/(double) recordList.size()) / Math.log(2));
            }

            double gain = entrophyS - entrophyAttr;
            double gainRatio = gain/splitInfo;

            if (gainRatio >= max) {
                max = gainRatio;
                bestAttribute = attr;
            }
        }

        return bestAttribute;
    }

    private void loadDataRecord() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(trainingFile));

        String line;

        while ((line = reader.readLine()) != null) {
            String[] lineRecords = line.split(",");
            for (int i = 1; i < lineRecords.length; i++) {
                switch (lineRecords[0]) {
                    case MediaTitle -> attributes.get(i-1).addMEDIA(lineRecords[i]);
                    case SaintekTitle -> attributes.get(i-1).addSAINTEK(lineRecords[i]);
                    case SosekTitle -> attributes.get(i-1).addSOSEK(lineRecords[i]);
                }
            }
            records.add(lineRecords);
        }

        reader.close();
    }

    private void createAllAttribute() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(trainingFile));

        String header = reader.readLine();
        String[] labels = header.split(",");

        String attr = reader.readLine();
        String[] attrList = attr.split(",");

        for (int i = 1; i < attrList.length; i++) {
            Attribute attribute = new Attribute(i);
            attribute.setName(labels[i]);
            attributes.add(attribute);
        }

        reader.close();
    }

}
