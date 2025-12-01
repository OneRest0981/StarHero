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

import static starhero.util.Format.doubleToInt;

public class MainView {

    // 战斗日志
    private TextArea logArea = new TextArea();

    // 控制按钮
    private Button prevButton = new Button("上一层");
    private Button nextButton = new Button("下一层");

    // 属性购买按钮
    private Button maxHpButton = new Button("最大生命");
    private Button armorButton = new Button("护甲");
    private Button attackButton = new Button("攻击伤害");
    private Button attackSpeedButton = new Button("攻击速度");
    private Button critChanceButton = new Button("暴击几率");
    private Button critDamageButton = new Button("暴击伤害");
    private Button goldBonusButton = new Button("金币加成");
    private Button expBonusButton = new Button("经验加成");

    // 根节点
    private BorderPane root = new BorderPane();


    // 构造
    public MainView() {

    VBox leftBox = new VBox(10);
    leftBox.getChildren().addAll(prevButton, nextButton, logArea);
    root.setLeft(leftBox);

    VBox rightBox = new VBox(10);


    }








}
