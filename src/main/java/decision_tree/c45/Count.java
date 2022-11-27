package decision_tree.c45;

public class Count {

    private int MEDIA = 0;
    private int SAINTEK = 0;
    private int SOSEK = 0;

    public int getMEDIA() {
        return MEDIA;
    }

    public void incrementPSPR() {
        this.MEDIA++;
    }

    public int getSAINTEK() {
        return SAINTEK;
    }

    public void incrementPSPT() {
        this.SAINTEK++;
    }

    public int getSOSEK() {
        return SOSEK;
    }

    public void incrementTKJ() {
        this.SOSEK++;
    }

}
