package starhero.game;

import starhero.model.Monster;
import starhero.model.Stats;

import java.math.BigDecimal;

// 层数管理
public class StageManager {

    private int currentStage;


    public StageManager() {
        this.currentStage = 1;
    }


    public int getCurrentStage() {
        return currentStage;
    }

    public void nextStage() {
        currentStage++;
    }

    public Monster generateMonster(int stage) {
        return new  Monster(stage, "测试怪物", stage, new Stats(stage*10, 1, 1, 1, 1, 1), BigDecimal.valueOf(1), 1);
    }









}
