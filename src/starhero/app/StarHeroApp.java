package starhero.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import starhero.data.StarData;
import starhero.game.GameLoop;
import starhero.game.StageManager;
import starhero.model.Player;
import starhero.ui.MainView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 星之勇者 游戏入口
 */
public class StarHeroApp extends Application{


    @Override
    public void start(Stage stage){
        Player player = new Player(1, "Test");
        player.chooseStar(StarData.defaultStar());
        player.recalculateStats();

        player.healToFull();

        StageManager stageManager = new StageManager();

        MainView mainView = new MainView();
        GameLoop gameLoop = new GameLoop(player, stageManager, mainView);

        // 按钮控制
        mainView.getStartButton().setOnAction(e -> gameLoop.start());
        mainView.getStopButton().setOnAction(e -> gameLoop.stop());

        // 初始化
        mainView.refreshPlayer(player);

        // 显示界面
        Scene scene = new Scene(mainView.getRoot(), 1300, 500);
        stage.setScene(scene);
        stage.setTitle("星之勇者 Star Hero");
        stage.show();


    }

    public static void main(String[] args) {
        launch(args); // 启动 JavaFX 应用程序
    }

}
