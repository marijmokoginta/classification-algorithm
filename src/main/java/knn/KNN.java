package knn;

import model.healthy.Healthy;

import java.util.ArrayList;
import java.util.List;

public record KNN(List<Healthy> dataset) {

    public void predict(Healthy datatest, int k) {
        List<Healthy> dataDistance = new ArrayList<>();

        // distance
        for (Healthy data : dataset) {
            int x1 = data.getAge() - datatest.getAge();
            int x2 = data.getWeight() - datatest.getWeight();
            int sqd = (x1 * x1) + (x2 * x2);
            data.setDistance(sqd);
            dataDistance.add(data);
        }

        // sorting (bubble sort)
        for (int i = 0; i < (dataDistance.size() - 1); i++) {
            for (int j = i + 1; j < dataDistance.size(); j++) {
                if (dataDistance.get(i).getDistance() > dataDistance.get(j).getDistance()) {
                    Healthy tempHealthy = dataDistance.get(i);
                    dataDistance.set(i, dataDistance.get(j));
                    dataDistance.set(j, tempHealthy);
                }
            }
        }

        // calculate
        int isHealth = 0;
        int notHealth = 0;
        for (int i = 0; i < k; i++) {
            if (dataDistance.get(i).isHealth()) {
                isHealth++;
            } else {
                notHealth++;
            }
        }

        datatest.setHealth(isHealth > notHealth);
    }
}
