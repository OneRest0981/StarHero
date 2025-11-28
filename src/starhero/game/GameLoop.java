package starhero.game;

import javafx.application.Platform;
import starhero.model.Monster;
import starhero.model.Player;
import starhero.ui.MainView;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class GameLoop {
    private Player player; // 当前玩家
    private Monster currentMonster; // 当前正在战斗的怪物
    private StageManager stageManager; // 负责生成怪物和记录关卡

    private java.util.concurrent.ScheduledExecutorService executor; // 定时线程池
    private boolean running; // 当前 GameLoop 是否在运行
    private final long TICK_INTERVAL_MILLIS = 1000; // 每次战斗 tick 的间隔 (单位 毫秒)

    private MainView mainView;

    public GameLoop(Player player, StageManager stageManager, MainView mainView){
        this.player = player;
        this.stageManager = stageManager;
        this.mainView = mainView;

    }

    // 启动
    public void start() {
        if(this.running) {
            return;
        }

        currentMonster = stageManager.generateMonster(1);

        // 初始化线程池, 只一次
        if(executor == null) {
            executor = Executors.newSingleThreadScheduledExecutor(); // 创建线程
        }

        // 定时执行任务
        executor.scheduleAtFixedRate(() -> {
            tick(); // 执行战斗逻辑


            // 主线程中更新log ui 等
            Platform.runLater(() -> {
                // 更新UI
                mainView.refreshPlayer(player);
                mainView.refreshMonster(currentMonster, stageManager.getCurrentStage());
                mainView.appendLog("xxx");



            });


        }, 1, TICK_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);

        running = true;
    }

    // 停止
    public void stop() {
        if(this.executor != null){
            executor.shutdown();
        }
        running = false;

    }

    // 每次运行的tick入口
    public void tick() {

        if(currentMonster == null || currentMonster.isDead()) {
            player.addExp(currentMonster.getExpReward());
            player.addMoney(currentMonster.getGoldReward());

            stageManager.nextStage();
            currentMonster = stageManager.generateMonster(stageManager.getCurrentStage());
        }

        player.attack(currentMonster);
        player.takeDamage(currentMonster.attack());

        if(player.isDead()){
            player.healToFull();
            currentMonster.resetHP();
        }





    }



}
