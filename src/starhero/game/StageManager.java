package starhero.game;

import starhero.data.MonsterData;
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
        return MonsterData.defaultMonster(stage);
    }









}
