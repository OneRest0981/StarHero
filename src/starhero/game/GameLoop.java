package starhero.game;

import javafx.application.Platform;
import starhero.model.Monster;
import starhero.model.Player;
import starhero.ui.MainView;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static starhero.util.Format.doubleToInt;


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
        if(running) {
            return;
        }
        // 初始化线程池, 只一次
        if (executor == null || executor.isShutdown()) {
            executor = Executors.newSingleThreadScheduledExecutor();
        }
        running = true;

        // 初始化怪物
        currentMonster = stageManager.generateMonster(stageManager.getCurrentStage());

        // 定时执行任务
        executor.scheduleAtFixedRate(() -> {
            try {
                tick(); // 执行战斗逻辑
            } catch (Exception e) {
                e.printStackTrace();
            }


            // 主线程中更新log ui 等
            Platform.runLater(() -> {
                // 更新UI
                mainView.refreshPlayer(player);
                mainView.refreshMonster(currentMonster, stageManager.getCurrentStage());




            });


        }, 1, TICK_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);

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
        StringBuilder logBuilder = new StringBuilder();


        if(currentMonster == null || currentMonster.isDead()) {
            player.addExp(currentMonster.getExpReward());
            player.addGold(currentMonster.getGoldReward());
            logBuilder.append("你击败了 ")
                    .append(currentMonster.getName())
                    .append("，获得 ")
                    .append(currentMonster.getGoldReward())
                    .append(" 金币 和 ")
                    .append(currentMonster.getExpReward())
                    .append(" 经验\n");


            stageManager.nextStage();
            currentMonster = stageManager.generateMonster(stageManager.getCurrentStage());
        }

        // 玩家攻击怪物
        int dmgToMonster = doubleToInt(player.attack(currentMonster));
        logBuilder.append("你对 ")
                .append(currentMonster.getName())
                .append(" 造成了 ")
                .append(dmgToMonster)
                .append(" 点伤害\n");

        // 怪物攻击玩家
        int dmgToPlayer =  doubleToInt(currentMonster.attack(player));
        player.takeDamage(dmgToPlayer);
        logBuilder.append(currentMonster.getName())
                .append(" 对你造成了 ")
                .append(dmgToPlayer)
                .append(" 点伤害\n");


        if(player.isDead()){
            player.healToFull();
            currentMonster.resetHP();
            logBuilder.append("你死亡了，但已自动满血复活。\n");
        }

        String logText = logBuilder.toString();
        if (!logText.isEmpty()) {
            mainView.appendLog(logText);
        }




    }



}
