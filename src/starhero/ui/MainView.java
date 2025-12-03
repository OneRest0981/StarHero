package starhero.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import starhero.model.Monster;
import starhero.model.Player;

import java.util.Objects;

public class MainView {

    // 根节点
    private StackPane root = new StackPane();

    private BorderPane contentPane = new BorderPane(); // 内层

    private BattleView battleView; // 创建BattleView
    private BottomLeftView bottomLeftView;
    private BottomRightView bottomRightView;

    // 底部 UI 层
    private BorderPane bottomPane = new BorderPane(); // 底部区域
    private StackPane bottomLayer = new StackPane(); // 底部 UI 层：背景 + 左右两个面板


    // 构造
    public MainView(Player player) {
        // 装入BattleView
        battleView = new BattleView();

        // 新增一个容器，用来控制战斗区整体位置
        VBox battleContainer = new VBox();
        battleContainer.setAlignment(Pos.TOP_CENTER);

        battleContainer.setPadding(new Insets(30, 0, 0, 0));
        battleContainer.getChildren().add(battleView.getRoot());

        battleContainer.setPrefHeight(320);
        battleContainer.setMinHeight(320);
        battleContainer.setMaxHeight(320);

        contentPane.setTop(battleContainer);

        /*
          Bottom 部分
         */
        // 拼接BottomPane + 装入主界面
        bottomLeftView = new BottomLeftView(player);
        bottomRightView = new BottomRightView(player);

        bottomPane.setLeft(bottomLeftView.getRoot());
        bottomPane.setRight(bottomRightView.getRoot());
        bottomPane.setPadding(new Insets(10, 50, 20, 10 ));
        contentPane.setBottom(bottomPane);
        BorderPane.setMargin(
                bottomRightView.getRoot(),
                new Insets(60, 0, 0, 0)  // top=20 → 右侧面板在底部区域内往下移
        );



        // 底屏背景
        Image bottomImage = new Image(
                Objects.requireNonNull(
                        getClass().getResourceAsStream("/images/ui/bottom_back.png")
                )
        );
        ImageView bottomView = new ImageView(bottomImage);
        bottomView.setPreserveRatio(false);
        bottomView.setSmooth(false);

        bottomView.fitWidthProperty().set(1220);
        bottomView.fitHeightProperty().set(315);

        bottomLayer.getChildren().addAll(bottomView, bottomPane);
        contentPane.setBottom(bottomLayer);



        // 整屏UI
        Image frameImg = new Image(
                Objects.requireNonNull(
                        getClass().getResourceAsStream("/images/ui/frame.png")
                )
        );
        ImageView frameView = new ImageView(frameImg);
        frameView.setPreserveRatio(false);   // 让它可以铺满
        frameView.setSmooth(false);          // 像素风可以关掉平滑
        // 铺满全屏
        frameView.fitWidthProperty().bind(root.widthProperty());
        frameView.fitHeightProperty().bind(root.heightProperty());


        root.getChildren().addAll(contentPane, frameView);



    }



    public Parent getRoot() {
        return root;
    }

    // 改成调用 battleView
    public void refreshPlayerBattle(Player player) {
        BattleView.refreshPlayer(player);
    }

    public void refreshMonsterBattle(Monster monster) {
        BattleView.refreshMonster(monster);
    }
}



