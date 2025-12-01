package starhero.ui;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import starhero.game.StageManager;
import starhero.model.Monster;
import starhero.model.Player;
import starhero.util.Format;

public class BottomLeftView {

    // 创建垂直 VBox
    private VBox root = new VBox(10);

    // 战斗日志
    private static TextArea logArea = new TextArea();

    // 控制按钮
    private Button prevButton = new Button("上一层");
    private Button nextButton = new Button("下一层");


    public BottomLeftView(Player player){
        root.getStyleClass().add("log-panel"); // 增加root样式
        logArea.getStyleClass().add("battle-log-area"); // 增加logArea样式
        prevButton.getStyleClass().add("stage-button"); // 上下层按钮样式
        nextButton.getStyleClass().add("stage-button");



        // 创建一个横 HBox 控制按钮
        HBox stageControl = new HBox(20);
        stageControl.getChildren().addAll(prevButton, nextButton); // 切换层数按钮
        Format.uniformButtonWidth(prevButton, nextButton); // 设置按钮大小

        // 设置log大小
        logArea.setPrefWidth(200);
        logArea.setPrefHeight(100);

        // 让log尽量长
        VBox.setVgrow(logArea, Priority.ALWAYS);

        // 合并root
        root.getChildren().addAll(stageControl, logArea);
        root.setPadding(new Insets(50));

        prevButton.setOnAction(event -> {
            Monster monster = StageManager.prevStage(player);  // 拿到新的怪物

            BattleView.refreshPlayer(player);
            BattleView.refreshMonster(monster);

            appendLog("切换到第 " + StageManager.getCurrentStage() + " 层\n");
        }
        );

        nextButton.setOnAction(event -> {
            Monster monster = StageManager.nextStage(player);  // 拿到新的怪物

            BattleView.refreshPlayer(player);
            BattleView.refreshMonster(monster);

            appendLog("切换到第 " + StageManager.getCurrentStage() + " 层\n"); // 可选
        }
        );



    }

    public Parent getRoot() {
        return root;
    }

    public static void appendLog(String logText) {
        logArea.appendText(logText);
    }








}
