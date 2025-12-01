package starhero.ui;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import starhero.model.Monster;
import starhero.model.Player;

import java.util.Objects;

public class MainView {

    // 根节点
    private BorderPane root = new BorderPane();

    private BattleView battleView; // 创建BattleView
    private BottomLeftView bottomLeftView;
    private BottomRightView bottomRightView;

    // 底部 UI 层
    private StackPane bottomLayer = new StackPane();
    private BorderPane bottomPane = new BorderPane(); // 原来的局部变量提到这里


    // 构造
    public MainView(Player player) {
        // 装入BattleView
        battleView = new BattleView();
        root.setCenter(battleView.getRoot());

        // 拼接BottomPane + 装入主界面
        bottomLeftView = new BottomLeftView(player);
        bottomRightView = new BottomRightView(player);

        bottomPane.setLeft(bottomLeftView.getRoot());
        bottomPane.setRight(bottomRightView.getRoot());

        // 底部 UI 图片（你的这张框）
        Image frameImg = new Image(
                Objects.requireNonNull(
                        getClass().getResourceAsStream("/images/ui/bottom_frame.png")
                )
        );
        ImageView frameView = new ImageView(frameImg);
        frameView.setPreserveRatio(false);   // 让它可以铺满
        frameView.setSmooth(false);          // 像素风可以关掉平滑

        // ★ 绑定尺寸：让图片自动跟随底部区域伸缩
        frameView.fitWidthProperty().bind(bottomLayer.widthProperty());
        frameView.fitHeightProperty().bind(bottomLayer.heightProperty());

        // ★ 把图片放在下面，内容放在上面
        bottomLayer.getChildren().addAll(frameView, bottomPane);

        // ★ 把整块 bottomLayer 放到 root 底部
        root.setBottom(bottomLayer);

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



