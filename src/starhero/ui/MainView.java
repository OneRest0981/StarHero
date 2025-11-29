package starhero.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import starhero.model.Player;
import starhero.model.Monster;

public class MainView {

    // ===== 玩家信息 =====
    private Label playerNameLabel = new Label("玩家：");
    private Label playerLevelLabel = new Label("等级：");
    private Label playerHpLabel = new Label("生命：");
    private Label playerGoldLabel = new Label("金币：");

    // ===== 怪物信息 =====
    private Label stageLabel = new Label("关卡：");
    private Label monsterNameLabel = new Label("怪物：");
    private Label monsterHpLabel = new Label("怪物生命：");

    // ===== 战斗日志 =====
    private TextArea logArea = new TextArea();

    // ===== 控制按钮 =====
    private Button startButton = new Button("开始");
    private Button stopButton = new Button("停止");

    // ===== 根节点 =====
    private BorderPane root = new BorderPane();


    // ===== 构造器 =====
    public MainView() {

        // --------------------
        // 左侧玩家信息布局
        // --------------------
        VBox playerBox = new VBox(8);
        playerBox.setPadding(new Insets(10));
        playerBox.getChildren().addAll(
                playerNameLabel,
                playerLevelLabel,
                playerHpLabel,
                playerGoldLabel
        );

        // --------------------
        // 右侧怪物信息布局
        // --------------------
        VBox monsterBox = new VBox(8);
        monsterBox.setPadding(new Insets(10));
        monsterBox.getChildren().addAll(
                stageLabel,
                monsterNameLabel,
                monsterHpLabel
        );

        // --------------------
        // 中间日志区域
        // --------------------
        logArea.setEditable(false);
        logArea.setWrapText(true);

        // --------------------
        // 底部按钮区域
        // --------------------
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));
        buttonBox.getChildren().addAll(startButton, stopButton);

        // --------------------
        // 整体放入 BorderPane
        // --------------------
        root.setLeft(playerBox);
        root.setRight(monsterBox);
        root.setCenter(logArea);
        root.setBottom(buttonBox);
    }


    // ===== UI 更新方法 =====
    public void refreshPlayer(Player player) {
        playerNameLabel.setText("玩家：" + player.getName());
        playerLevelLabel.setText("等级：" + player.getLevel());
        playerHpLabel.setText("生命：" + player.getCurrentHp() + "/" + player.getBaseStats().getMaxHp());
        playerGoldLabel.setText("金币：" + player.getGold());
    }

    public void refreshMonster(Monster monster, int stage) {
        stageLabel.setText("关卡：" + stage);
        monsterNameLabel.setText("怪物：" + monster.getName());
        monsterHpLabel.setText("怪物生命：" + monster.getCurrentHP() + "/" + monster.getStats().getMaxHp());
    }

    public void appendLog(String msg) {
        logArea.appendText(msg + "\n");
    }

    // 返回根节点给 JavaFX 主窗口使用
    public Parent getRoot() {
        return root;
    }

    // 给外部访问 start/stop 按钮
    public Button getStartButton() {
        return startButton;
    }

    public Button getStopButton() {
        return stopButton;
    }
}
