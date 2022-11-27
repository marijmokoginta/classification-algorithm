package model.telephone_customer;

public class TelephoneCustomer {

    private String name;

    private Card card;

    private Call call;

    private Block block;

    private boolean bonus;

    public TelephoneCustomer(String name, Card card, Call call, Block block, boolean bonus) {
        this.name = name;
        this.card = card;
        this.call = call;
        this.block = block;
        this.bonus = bonus;
    }

    public TelephoneCustomer(String name, Card card, Call call, Block block) {
        this.name = name;
        this.card = card;
        this.call = call;
        this.block = block;
    }

    public TelephoneCustomer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "TelephoneCustomer{" +
                "name='" + name + '\'' +
                ", card=" + card +
                ", call=" + call +
                ", block=" + block +
                ", bonus=" + bonus +
                '}';
    }
}
