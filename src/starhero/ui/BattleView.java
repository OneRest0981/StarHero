package starhero.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import starhero.model.Monster;
import starhero.model.Player;

import java.util.Objects;

import static starhero.util.Format.doubleToInt;

public class BattleView {

    // 现在的根节点改成 StackPane，用来叠加：背景 + 蒙版 + 内容
    private StackPane root = new StackPane();

    // 原来的 HBox 作为“内容层”，承载玩家/怪物布局
    private HBox contentBox = new HBox(50);

    private static Label playerNameLabel = new Label("玩家");
    private static Label playerHpLabel = new Label("Hp");
    private static ProgressBar playerHpBar = new ProgressBar(1.0);
    private static ImageView playerImageView = new ImageView();

    private static Label monsterNameLabel = new Label("怪物");
    private static Label monsterHpLabel   = new Label("HP: 0 / 0");
    private static ProgressBar monsterHpBar = new ProgressBar(1.0);
    private static ImageView monsterImageView = new ImageView();

    // 蒙版
    private Rectangle overlay = new Rectangle();

    // 顶部战斗区域
    public BattleView() {
        // Lable调整
        playerNameLabel.getStyleClass().add("battle-name-label");
        monsterNameLabel.getStyleClass().add("battle-name-label");
        playerHpLabel.getStyleClass().add("battle-hp-label");
        monsterHpLabel.getStyleClass().add("battle-hp-label");
        playerHpBar.getStyleClass().add("player-hp-bar");
        // 血条样式
        monsterHpBar.getStyleClass().add("monster-hp-bar");

        // 玩家贴图
        playerImageView.setFitWidth(128);
        playerImageView.setFitHeight(128);
        playerImageView.setPreserveRatio(true);
        playerImageView.setImage(new Image(
                Objects.requireNonNull(
                        getClass().getResourceAsStream("/images/star/default.png")
                )
        ));

        // 怪物贴图
        monsterImageView.setFitWidth(128);
        monsterImageView.setFitHeight(128);
        monsterImageView.setPreserveRatio(true);
        monsterImageView.setImage(new Image(
                Objects.requireNonNull(
                        getClass().getResourceAsStream("/images/monster/default.png")
                )
        ));

        // 玩家布局
        playerHpBar.setPrefWidth(200);
        VBox playerBox = new VBox(5);
        playerBox.setAlignment(Pos.CENTER);
        playerBox.getChildren().addAll(
                playerImageView,
                playerNameLabel,
                playerHpLabel,
                playerHpBar
        );

        // 怪物布局
        monsterHpBar.setPrefWidth(200);
        VBox monsterBox = new VBox(5);
        monsterBox.setAlignment(Pos.CENTER);
        monsterBox.getChildren().addAll(
                monsterImageView,
                monsterNameLabel,
                monsterHpLabel,
                monsterHpBar
        );


        // 整体 HBox
        contentBox.setPadding(new Insets(50));
        contentBox.setAlignment(Pos.CENTER);
        contentBox.getChildren().addAll(playerBox, monsterBox);

        // 背景
        Image bgImage = new Image(
                Objects.requireNonNull(
                        getClass().getResourceAsStream("/images/background/default.png")
                )
        );

        BackgroundSize bgSize = new BackgroundSize(
                BackgroundSize.AUTO, BackgroundSize.AUTO,
                false, false, true, false
        );
        BackgroundImage backgroundImage = new BackgroundImage(
                bgImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bgSize
        );
        root.setBackground(new Background(backgroundImage));

        //  蒙版
        overlay.setFill(Color.rgb(0, 0, 0, 0.3));

        // 蒙版尺寸跟着根节点变
        overlay.widthProperty().bind(root.widthProperty());
        overlay.heightProperty().bind(root.heightProperty());

        // =========================
        //  叠加顺序：背景(在 Background 里) -> overlay -> 内容
        // =========================
        root.getChildren().addAll(overlay, contentBox);

    }

    public Parent getRoot() {
        return root;
    }

    public static void refreshPlayer(Player player) {
        if (player == null) return;

        int currentHp = doubleToInt(player.getCurrentHp());
        int maxHp = doubleToInt(player.getFinalStats().getMaxHp());
        BottomRightView.refreshGold(player);

        playerNameLabel.setText(player.getName());
        playerHpLabel.setText("HP: " + currentHp + " / " + maxHp);

        if (maxHp > 0) {
            double progress = (double) currentHp / maxHp;
            progress = Math.max(0, Math.min(1, progress));
            playerHpBar.setProgress(progress);
        } else {
            playerHpBar.setProgress(0);
        }
    }

    public static void refreshMonster(Monster monster) {
        if (monster == null) return;

        int currentHp = doubleToInt(monster.getCurrentHP());
        int maxHp = doubleToInt(monster.getStats().getMaxHp());

        monsterNameLabel.setText(monster.getName());
        monsterHpLabel.setText("HP: " + currentHp + " / " + maxHp);

        if (maxHp > 0) {
            double progress = (double) currentHp / maxHp;
            progress = Math.max(0, Math.min(1, progress));
            monsterHpBar.setProgress(progress);
        } else {
            monsterHpBar.setProgress(0);
        }
    }

}
