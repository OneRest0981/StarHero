package starhero.game;

import starhero.data.MonsterData;
import starhero.model.Monster;
import starhero.model.Player;
import starhero.model.Stats;

import java.math.BigDecimal;

// 层数管理
public class StageManager {

    private static int currentStage;
    private static Monster currentMonster;


    public StageManager() {
        currentStage = 1;
    }

    public static Monster getCurrentMonster() {
        return currentMonster;
    }


    public static int getCurrentStage() {
        return currentStage;
    }

    public static Monster nextStage(Player player) {
        player.healToFull();
        currentStage++;
        generateMonster(currentStage);
        return currentMonster;

    }

    public static Monster prevStage(Player player){
        player.healToFull();
        currentStage--;
        generateMonster(currentStage);
        return currentMonster;
    }

    public static Monster generateMonster(int stage) {
        currentMonster = MonsterData.defaultMonster(stage);
        return currentMonster;
    }









}
