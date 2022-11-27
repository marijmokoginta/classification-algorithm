import decision_tree.c45.C45;

import java.io.IOException;

public class SiswaC45Application {

    public static void main(String[] args) throws IOException {
        String trainingFile = "C:\\Users\\marij_mokoginta\\Desktop\\siswa-training.csv";
        String testFile = "C:\\Users\\marij_mokoginta\\Desktop\\siswa-test.csv";

        C45 c45 = new C45(trainingFile, testFile);

        double accuracy = (double) c45.getCorrect() / ((double) c45.getCorrect() + (double) c45.getIncorrect()) * 100;
        System.out.println("Correct : " + c45.getCorrect());
        System.out.println("Incorrect : " + c45.getIncorrect());
        System.out.println("Accuracy is : " + accuracy + "%");
    }

}
