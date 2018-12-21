package practicals.task7;

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


public class Main extends Application {
    public final static int MAX_NO_TURNS = 106;
    private double speedMultiplier = 0.75; //speed multiplier
    private int spMU(int duration) {return (int)(duration* speedMultiplier);}
    private boolean completed = false;
    private boolean paused = true;

    private ArrayList<Integer> p1Set, p2Set;
    private CardsSet cS = new CardsSet();
    private String gameRes;

    private GridPane mainPane;
    private StackPane spA, spB;
    private Group bottomCardsA, bottomCardsB;
    private Label lbl1, lbl2;
    private Button btn;

    @Override
    public void start(Stage primaryStage) {
        fillArrays();

        mainPane = new GridPane();
        mainPane.setPadding(new Insets(10, 10, 10, 10));
        mainPane.setPrefSize(1000, 250);
        mainPane.setVgap(5);
        mainPane.setAlignment(Pos.TOP_CENTER);
        mainPane.setStyle("-fx-background-color: null;");

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        col1.setHalignment(HPos.LEFT);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        col2.setHalignment(HPos.RIGHT);
        mainPane.getColumnConstraints().addAll(col1, col2);
        setupScene(-1,false);

        Scene sc = new Scene(mainPane, 1026, 630, true, SceneAntialiasing.BALANCED);
        sc.getStylesheets().add("practicals/task7/StyleSheet.css");
        sc.setFill(Color.LIGHTCYAN.darker());
        sc.setCamera(new PerspectiveCamera());

        primaryStage.getIcons().add(new Image("practicals/task7/icon.png"));
        primaryStage.setTitle("Igra v \'Pyanitsu\'");
        primaryStage.setScene(sc);
        primaryStage.show();
    }
    private void fillArrays() {
        p1Set = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        p2Set = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 0));
    }

    private void assessScore(int step) {
            while (paused) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (step<= MAX_NO_TURNS && !completed) {
                Thread t1;
                if (p1Set.get(0) > p2Set.get(0) || ((p1Set.get(0) == 0) && (p2Set.get(0) == 9))) {  //LeftWins
                    p1Set.add(p1Set.get(0));
                    p1Set.add(p2Set.get(0));
                    t1 = new Thread(() -> Platform.runLater(() -> animateCards(step, true)));

                } else { //if (p1Set.get(0) < p2Set.get(0) || ((p1Set.get(0) == 9) && (p2Set.get(0) == 0))) {
                    p2Set.add(p2Set.get(0));
                    p2Set.add(p1Set.get(0));
                    t1 = new Thread(() -> Platform.runLater(() -> animateCards(step, false)));
                }
                p1Set.remove(0);
                p2Set.remove(0);

                t1.setDaemon(true);
                t1.start();

                if (p1Set.size() == 0) {
                    gameRes = "Second " + (step+1);
                    completed = true;
                } else if (p2Set.size() == 0) {
                    gameRes = "First " + (step+1);
                    completed = true;
                } else if (step+1>MAX_NO_TURNS) {
                    gameRes = "Botva!";
                    completed = true;
                }
            }
    }

    private void animateCards(int step, boolean leftSide) {
        Node topCardA = spA.getChildren().get(0);
        Node topCardB = spB.getChildren().get(0);

        topCardA.setCacheHint(CacheHint.ROTATE);
        topCardB.setCacheHint(CacheHint.ROTATE);
        RotateTransition revealCardA = rotator(topCardA, spMU(600), 0, -180);
        RotateTransition revealCardB = rotator(topCardB, spMU(600), 0, 180);

        topCardA.setCacheHint(CacheHint.SPEED);
        topCardB.setCacheHint(CacheHint.SPEED);
        TranslateTransition joinInMidA = new TranslateTransition(Duration.millis(spMU(400)), topCardA);
        joinInMidA.setByX((-1*spB.getTranslateX())+40);
        TranslateTransition JoinInMidB =new TranslateTransition(Duration.millis(spMU(400)), topCardB);
        JoinInMidB.setByX((-1*spA.getTranslateX())-40);

        SequentialTransition reveal1 = new SequentialTransition(new PauseTransition(Duration.millis(spMU(350))),
                                                                new ParallelTransition(joinInMidA, JoinInMidB));
        reveal1.setOnFinished(event -> new ParallelTransition(revealCardA, revealCardB).play());
        reveal1.play();

        if (leftSide) {
            TranslateTransition moveToLeftA = new TranslateTransition(Duration.millis(spMU(400)), topCardA);
            moveToLeftA.setByX(-397);
            TranslateTransition moveToLeftB = new TranslateTransition(Duration.millis(spMU(400)), topCardB);
            moveToLeftB.setByX(-426);

            TranslateTransition shiftDeckA = new TranslateTransition(Duration.millis(spMU(700)), bottomCardsA);
            shiftDeckA.setByX(70);

            topCardA.setCacheHint(CacheHint.ROTATE);
            topCardB.setCacheHint(CacheHint.ROTATE);
            RotateTransition hideCardA = rotator(topCardA, spMU(600), -180, 0);
            RotateTransition hideCardB = rotator(topCardB, spMU(600), -180, 0);
            hideCardB.setOnFinished(event -> bottomCardsA.toFront());

            topCardA.setCacheHint(CacheHint.SPEED);
            topCardB.setCacheHint(CacheHint.SPEED);
            TranslateTransition eatOtherAnimA = new TranslateTransition(Duration.millis(spMU(700)), topCardA);
            eatOtherAnimA.setByX(108);
            TranslateTransition eatOtherAnimB = new TranslateTransition(Duration.millis(spMU(550)), topCardB);
            eatOtherAnimB.setByX(-108);

            PauseTransition pause2 = new PauseTransition(Duration.millis(spMU(120)));

            PauseTransition pause1 = new PauseTransition(Duration.millis(spMU(1300)));
            pause1.setOnFinished(event -> spB.toBack());

            SequentialTransition delayer1 = new SequentialTransition(pause1, new ParallelTransition(eatOtherAnimA, eatOtherAnimB));
            delayer1.setOnFinished(event -> new ParallelTransition(
                    new ParallelTransition(hideCardB,
                                           new SequentialTransition(pause2,hideCardA)),
                    new SequentialTransition(new PauseTransition(Duration.millis(spMU(120))),pause2),
                                             new ParallelTransition(moveToLeftA,moveToLeftB,shiftDeckA)).play());
            delayer1.play();

        } else {
            TranslateTransition moveToRightA = new TranslateTransition(Duration.millis(spMU(400)), topCardA);
            moveToRightA.setByX(423);
            TranslateTransition moveToRightB = new TranslateTransition(Duration.millis(spMU(400)), topCardB);
            moveToRightB.setByX(394);

            TranslateTransition shiftDeckB = new TranslateTransition(Duration.millis(spMU(700)), bottomCardsB);
            shiftDeckB.setByX(-70);

            topCardA.setCacheHint(CacheHint.ROTATE);
            topCardB.setCacheHint(CacheHint.ROTATE);
            RotateTransition hideCardA = rotator(topCardA, spMU(600), 180, 0);
            RotateTransition hideCardB = rotator(topCardB, spMU(600), 180, 0);
            hideCardB.setOnFinished(event -> bottomCardsB.toFront());

            topCardA.setCacheHint(CacheHint.SPEED);
            topCardB.setCacheHint(CacheHint.SPEED);
            TranslateTransition eatOtherAnimA = new TranslateTransition(Duration.millis(spMU(700)), topCardA);
            eatOtherAnimA.setByX(108);
            TranslateTransition eatOtherAnimB = new TranslateTransition(Duration.millis(spMU(550)), topCardB);
            eatOtherAnimB.setByX(-108);

            PauseTransition pause2 = new PauseTransition(Duration.millis(spMU(120)));

            PauseTransition pause1 = new PauseTransition(Duration.millis(spMU(1300)));
            pause1.setOnFinished(event -> spA.toBack());

            SequentialTransition delayer1 = new SequentialTransition(pause1, new ParallelTransition(eatOtherAnimA, eatOtherAnimB));
            delayer1.setOnFinished(event -> new ParallelTransition(
                    new ParallelTransition(hideCardB,
                                            new SequentialTransition(pause2,hideCardA)),
                    new SequentialTransition(new PauseTransition(Duration.millis(spMU(120))),pause2),
                                             new ParallelTransition(moveToRightA,moveToRightB,shiftDeckB)).play());
            delayer1.play();
        }

        PauseTransition pause3 = new PauseTransition(Duration.millis(spMU(3400)));
        pause3.setOnFinished(event -> setupScene(step,false));
        pause3.play();
    }
    private RotateTransition rotator(Node card, int duration, int fromAngle, int toAngle) {
        RotateTransition rotator = new RotateTransition(Duration.millis(duration), card);
        rotator.setAxis(Rotate.Y_AXIS);
        rotator.setFromAngle(fromAngle);
        rotator.setToAngle(toAngle);
        rotator.setInterpolator(Interpolator.LINEAR);
        rotator.setCycleCount(1);

        return rotator;
    }

    private void setupScene(int step, boolean updateOnly) {
        int p1CardCount = p1Set.size() - 1;
        int p2CardCount = p2Set.size() - 1;

        Group miniCardsA = new Group();
        for (int c = 0; c < p1CardCount+1; c++) {
            ImageView iv = cS.getIV(p1Set.get(p1CardCount-c),70,1);
            final int index = p1CardCount-c;
            iv.setOnMouseClicked(event -> {
                if((event.getButton().equals(MouseButton.PRIMARY)) && (event.getClickCount() == 2) && paused) {
                        if (showCardInputDialog(p1Set,index)) setupScene(step,true);
                }
            });
            miniCardsA.getChildren().add(iv);
            iv.setX(25 * c);
        }
        Group miniCardsB = new Group();
        for (int c = p2CardCount+1; c > 0; c--) {
            ImageView iv = cS.getIV(p2Set.get(c-1),70,1);
            final int index = c-1;
            iv.setOnMouseClicked(event -> {
                if((event.getButton().equals(MouseButton.PRIMARY)) && (event.getClickCount() == 2) && paused) {
                    if(showCardInputDialog(p2Set,index)) setupScene(step,true);
                }
            });
            miniCardsB.getChildren().add(iv);
            iv.setX(25 * c);
        }

        Node uiControls;
        if (step==-1) {
            uiControls = uiControlPane();
        } else {
            uiControls = getNodeFromGridPane(mainPane,0,2);
        }
        lbl1.setText("Ходов сделано: " + (step+1));
        if (completed) {
            lbl2.setText(gameRes);
            btn.setText("Eще раз?");
            mainPane.getChildren().removeIf(node -> GridPane.getRowIndex(node)==1);
            mainPane.add(miniCardsA,0,1,1,1);
            mainPane.add(miniCardsB,1,1,1,1);
            return;
        }

        bottomCardsA = new Group();
        for (int c = 0; c < p1CardCount; c++) {
            ImageView iv = cS.getIV(10, 155, 1); //p1Set.get(p1CardCount-c)
            bottomCardsA.getChildren().add(iv);
            iv.setX(35 * c);
        }
        Node topCardA = createCard(p1Set.get(0));
        spA = new StackPane();
        spA.getChildren().addAll(topCardA, new AmbientLight(Color.WHITE));
        spA.setAlignment(Pos.TOP_LEFT);
        spA.setTranslateX(35 * p1CardCount);

        bottomCardsB = new Group();
        for (int c = p2CardCount; c > 0; c--) {
            ImageView iv = cS.getIV(10, 155, 1);    //p2Set.get(c)
            bottomCardsB.getChildren().add(iv);
            iv.setX(35 * c);
        }
        Node topCardB = createCard(p2Set.get(0));
        spB = new StackPane();
        spB.getChildren().addAll(topCardB, new AmbientLight(Color.WHITE));
        spB.setAlignment(Pos.TOP_RIGHT);
        spB.setTranslateX((-35 * p2CardCount) - 3);

        mainPane.getChildren().clear();
        mainPane.add(uiControls,0,2,2,1);
        mainPane.add(miniCardsA,0,1,1,1);
        mainPane.add(miniCardsB,1,1,1,1);
        mainPane.add(bottomCardsA, 0, 0);
        mainPane.add(spA, 0, 0);
        mainPane.add(bottomCardsB, 1, 0);
        mainPane.add(spB, 1, 0);

        if (!updateOnly) {
            Task task = new Task<Void>() {
                @Override public Void call() {
                    assessScore(step + 1);
                    return null;
                }
            };
            Thread t1 = new Thread(task);
            t1.setDaemon(true);
            t1.start();
        }
    }
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
    private boolean showCardInputDialog(ArrayList<Integer> arr, int index) {
        TextInputDialog dialog = new TextInputDialog(arr.get(index).toString());
        dialog.setTitle("Change Card");
        dialog.setHeaderText("Enter the card number:");
        dialog.setContentText("Value:");
        Stage dialogS = (Stage) dialog.getDialogPane().getScene().getWindow();
        dialogS.getIcons().add(new Image("practicals/task7/icon.png"));

        Optional<String> result = dialog.showAndWait();
        if(result.isPresent()) {
            int res = Integer.parseInt(result.get());
            if ((res>=0) && (res<=9) && (res!=arr.get(index))) {
                arr.set(index,res);
                return true;
            }
        }
        return false;
    }
    private GridPane uiControlPane() {
        GridPane cntrlP = new GridPane();
        GridPane.setMargin(cntrlP, new Insets(25, 0, 0, 0));
        cntrlP.setVgap(7);
        cntrlP.setId("cntrlP");

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(100);
        col1.setHalignment(HPos.CENTER);
        cntrlP.getColumnConstraints().add(col1);

        btn = new Button("Hачать");
        btn.setId("btn");
        btn.setOnAction(event -> {
            if(btn.getText().equals("Eще раз?")) {
                completed = false;
                fillArrays();
                setupScene(-1,false);
            }

            paused = !paused;
            btn.setText((paused)? "Hачать" : "Приостановить");
        });
        cntrlP.add(btn,0,0);

        Slider slider = new Slider(0.075,1.5, speedMultiplier);
        slider.setMinorTickCount(0);
        slider.setMajorTickUnit((slider.getMax()-slider.getMin())/4);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMaxWidth(300);
        slider.setId("slider");
        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                if (n < 0.375) return "x10";
                if (n < 0.75) return "x5";
                if (n < 1.125) return "Normal";
                if (n < 1.5) return "x0.75";

                return "x0.5";
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "x10":
                        return 0.075d;
                    case "x5":
                        return 0.375d;
                    case "Normal":
                        return 0.75d;
                    case "x0.75":
                        return 1.125d;
                    default:
                        return 1.5d;
                }
            }
        });

        slider.valueProperty().addListener((observable, oldValue, newValue) -> speedMultiplier = newValue.doubleValue());
        slider.setPadding(new Insets(10,0,-5,0));
        cntrlP.add(slider,0,1);

        lbl1 = new Label("Ходов сделано: 0");
        lbl1.setFont(Font.font("Consolas",FontWeight.NORMAL, 30));
        lbl1.setTextFill(Color.DARKSLATEBLUE.darker());
        lbl2 = new Label("");
        lbl2.setFont(Font.font("IMPACT",FontWeight.BOLD, 40));
        lbl2.setId("resLbl");
        cntrlP.add(lbl1,0,2);
        cntrlP.add(lbl2,0,3);

        return cntrlP;
    }
    private Node createCard(int number) {
        final int W = 150;
        final int H = 216;

        TriangleMesh mesh = new TriangleMesh();

        mesh.getPoints().addAll(-1 * W / 2, -1 * H / 2, 0,
                1 * W / 2, -1 * H / 2, 0,
                -1 * W / 2, 1 * H / 2, 0,
                1 * W / 2, 1 * H / 2, 0);

        mesh.getTexCoords().addAll(0.5f, 0,    //BL-1
                0, 0,
                0.5f, 1,    //TL-1
                0, 1,

                0.5f, 0, //BL-2
                1, 0,
                0.5f, 1, //TL-2
                1, 1);

        mesh.getFaces().addAll(0, 4, 2, 6, 3, 7,   //Face 1
                3, 7, 1, 5, 0, 4,

                0, 0, 3, 3, 2, 2,   //Face 2
                3, 3, 0, 0, 1, 1);


        Image CARD_IMAGE = new Image(cS.getCard(number,2));
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(CARD_IMAGE);

        MeshView card = new MeshView(mesh);
        card.setMaterial(material);
        card.setCache(true);
        card.setCacheHint(CacheHint.QUALITY);
        return card;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
