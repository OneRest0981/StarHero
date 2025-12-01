package starhero.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import starhero.model.Monster;
import starhero.model.Player;

import java.util.Objects;

import static starhero.util.Format.doubleToInt;

public class BattleView {
    private HBox root = new HBox(50);

    private static Label playerNameLabel = new Label("玩家");
    private static Label playerHpLabel = new Label("Hp");
    private static ProgressBar playerHpBar = new ProgressBar(1.0);
    private static ImageView playerImageView = new ImageView();

    private static Label monsterNameLabel = new Label("怪物");
    private static Label monsterHpLabel   = new Label("HP: 0 / 0");
    private static ProgressBar monsterHpBar = new ProgressBar(1.0);
    private static ImageView monsterImageView = new ImageView();


    // 顶部战斗区域
    public BattleView() {
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
        root.setPadding(new Insets(50));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(playerBox, monsterBox);

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
