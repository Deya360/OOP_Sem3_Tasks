package practicals.task7;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

class CardsSet {
    private ArrayList<String> cardImgPaths;

    CardsSet() {
        this.cardImgPaths = new ArrayList<>(11);
        for(int i=0; i<10; i++) {
            cardImgPaths.add("card"+i);
        }
        cardImgPaths.add("cardBack");
    }

    String getCard(int number, int faces) {
        return cardImgPaths.get(number) + ((faces==1)? ".png":"N.png");
    }

    ImageView getIV(int num, int fitWidth, int faces) {
        Image img = new Image(getCard(num,faces));

        ImageView iv = new ImageView();
        iv.setImage(img);
        iv.setFitWidth(fitWidth);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);
        return iv;
    }
}
