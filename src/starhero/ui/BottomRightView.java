package starhero.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import starhero.model.Player;
import starhero.util.Format;

public class BottomRightView {

    // 创建垂直 VBox
    private VBox root = new VBox(20);

    // 属性购买按钮
    private static Label goldLable = new Label("金币");
    private Button maxHpButton = new Button("最大生命");
    private Button armorButton = new Button("护甲");
    private Button attackButton = new Button("攻击伤害");
    private Button attackSpeedButton = new Button("攻击速度");
    private Button critChanceButton = new Button("暴击几率");
    private Button critDamageButton = new Button("暴击伤害");
    private Button goldBonusButton = new Button("金币加成");
    private Button expBonusButton = new Button("经验加成");

    public BottomRightView(Player player){
        // 右侧升级面板整体样式
        root.getStyleClass().add("upgrade-panel");
        HBox goldRow = new HBox();
        goldRow.setAlignment(Pos.CENTER_RIGHT);
        goldRow.getChildren().add(goldLable);

        // 金币文字样式
        goldLable.getStyleClass().add("gold-label");

        // 创建每排的横 HBOX
        HBox row1 = new HBox(20);
        row1.getChildren().addAll(maxHpButton, armorButton);
        HBox row2 = new HBox(20);
        row2.getChildren().addAll(attackButton, attackSpeedButton);
        HBox row3 = new HBox(20);
        row3.getChildren().addAll(critChanceButton, critDamageButton);
        HBox row4 = new HBox(20);
        row4.getChildren().addAll(goldBonusButton, expBonusButton);
        // 升级按钮统一样式类
        maxHpButton.getStyleClass().add("upgrade-button");
        armorButton.getStyleClass().add("upgrade-button");
        attackButton.getStyleClass().add("upgrade-button");
        attackSpeedButton.getStyleClass().add("upgrade-button");
        critChanceButton.getStyleClass().add("upgrade-button");
        critDamageButton.getStyleClass().add("upgrade-button");
        goldBonusButton.getStyleClass().add("upgrade-button");
        expBonusButton.getStyleClass().add("upgrade-button");



        // 设置按钮大小
        Format.uniformButtonWidth(maxHpButton, armorButton, attackButton, attackSpeedButton, critChanceButton, critDamageButton, goldBonusButton, expBonusButton);

        // 合并至root
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(16);
        root.getChildren().addAll(goldRow, row1, row2, row3, row4);
        root.setPadding(new Insets(50));

        maxHpButton.setOnAction(
                event -> player.upgradeMaxHpWithGold()
        );
        armorButton.setOnAction(
                event -> player.upgradeArmorWithGold()
        );
        attackButton.setOnAction(
                event -> player.upgradeAttackWithGold()
        );
        attackSpeedButton.setOnAction(
                event -> player.upgradeAttackSpeedWithGold()
        );
        critChanceButton.setOnAction(
                event -> player.upgradeCritChanceWithGold()
        );
        critDamageButton.setOnAction(
                event -> player.upgradeCritDamageWithGold()
        );
        goldBonusButton.setOnAction(
                event -> player.upgradeGoldBonusWithGold()
        );
        expBonusButton.setOnAction(
                event -> player.upgradeExpBonusWithGold()
        );





    }

    public Parent getRoot() {
        return root;
    }

    public static void refreshGold(Player player){
        goldLable.setText("金币: " + player.getGold().toString());
    }
}
