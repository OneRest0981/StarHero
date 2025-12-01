package starhero.ui;

import javafx.scene.Parent;
import javafx.scene.layout.*;
import starhero.model.Monster;
import starhero.model.Player;

public class MainView {

    // 根节点
    private BorderPane root = new BorderPane();

    private BattleView battleView; // 创建BattleView
    private BottomLeftView bottomLeftView;
    private BottomRightView bottomRightView;



    // 构造
    public MainView(Player player) {
        // 装入BattleView
        battleView = new BattleView();
        root.setCenter(battleView.getRoot());

        // 拼接BottomPane + 装入主界面
        bottomLeftView = new BottomLeftView(player);
        bottomRightView = new BottomRightView(player);

        BorderPane bottomPane = new BorderPane();
        bottomPane.setLeft(bottomLeftView.getRoot());
        bottomPane.setRight(bottomRightView.getRoot());
        root.setBottom(bottomPane);


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



