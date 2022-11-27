package naive_bayes;

import model.telephone_customer.TelephoneCustomer;

import java.util.List;

public class NaiveBayes {

    private final List<TelephoneCustomer> telephoneCustomers;

    float pc1 = 0;
    float pc2 = 0;

    float pCard = 0;
    float pCall = 0;
    float pBlock = 0;

    float pCardC1 = 0;
    float pCardC2 = 0;

    float pCallC1 = 0;
    float pCallC2 = 0;

    float pBlockC1 = 0;
    float pBlockC2 = 0;

    public NaiveBayes(List<TelephoneCustomer> telephoneCustomers) {
        this.telephoneCustomers = telephoneCustomers;
    }

    public TelephoneCustomer predict(TelephoneCustomer customerTest) {
        for (TelephoneCustomer telephoneCustomer : telephoneCustomers) {
            if (telephoneCustomer.isBonus()) {
                pc1++;
            } else {
                pc2++;
            }

            // hitung P(Card|C)
            if(customerTest.getCard().equals(telephoneCustomer.getCard())) {
                pCard++;
                if(telephoneCustomer.isBonus()) {
                    pCardC1++;
                } else {
                    pCardC2++;
                }
            }

            // hitung P(Call|C)
            if(customerTest.getCall().equals(telephoneCustomer.getCall())) {
                pCall++;
                if(telephoneCustomer.isBonus()) {
                    pCallC1++;
                } else {
                    pCallC2++;
                }
            }

            // hitung P(Block|C)
            if(customerTest.getBlock().equals(telephoneCustomer.getBlock())) {
                pBlock++;
                if(telephoneCustomer.isBonus()) {
                    pBlockC1++;
                } else {
                    pBlockC2++;
                }
            }
        }

        pCardC1 = pCardC1 / pc1;
        pCardC2 = pCardC2 / pc2;

        pCallC1 = pCallC1 / pc1;
        pCallC2 = pCallC2 / pc2;

        pBlockC1 = pBlockC1 / pc1;
        pBlockC2 = pBlockC2 / pc2;

        float pxc1 = pCardC1 * pCallC1 * pBlockC1;
        float pxc2 = pCardC2 * pCallC2 * pBlockC2;

        pc1 = pc1 / telephoneCustomers.size();
        pc2 = pc2 / telephoneCustomers.size();

        pxc1 = pxc1 * pc1;
        pxc2 = pxc2 * pc2;

        customerTest.setBonus(pxc1 > pxc2);

        return customerTest;
    }

}
