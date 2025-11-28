package starhero.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 星之勇者 游戏入口
 */
public class StarHeroApp extends Application{

    private Label infoLabel;
    private Label logLabel;
    private int tickCount = 0;
    private java.util.concurrent.ScheduledExecutorService executor;


    @Override
    public void start(Stage stage){


        // 标签
        Label titleLabel = new Label("星之勇者 - Star Hero");
        infoLabel = new Label("当前关卡: 1    金币: 0");
        logLabel = new Label("准备就绪");

        // 按钮
        Button button = new Button("开始战斗");
        button.setOnAction(event -> {


            infoLabel.setText("战斗中");
            logLabel.setText("战斗开始！（按钮触发）");

            // 初始化线程池, 只一次
            if(executor == null) {
                executor = Executors.newSingleThreadScheduledExecutor(); // 创建线程
            }

            // 定时执行任务
            executor.scheduleAtFixedRate(() -> {
                // 任务, 初始延迟, 间隔, 时间单位
                tickCount++;

                // 主线程中更新log
                javafx.application.Platform.runLater(() ->{
                    logLabel.setText("后台线程 tick:" + tickCount);
                });
            }, 1, 1, TimeUnit.SECONDS);



        });


        // 创建布局
        VBox root = new VBox(10);
        root.getChildren().add(titleLabel);
        root.getChildren().add(infoLabel);
        root.getChildren().add(button);
        root.getChildren().add(logLabel);

        // 创建场景
        Scene scene = new Scene(root, 1200, 600);

        // 添加标题
        stage.setTitle("星之勇者 - Star Hero");
        stage.setScene(scene); // 将画布放入场景
        stage.show();




    }

    public static void main(String[] args) {
        launch(args); // 启动 JavaFX 应用程序
    }
}
