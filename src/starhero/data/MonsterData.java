package starhero.data;

import javafx.stage.Stage;
import starhero.game.StageManager;
import starhero.model.Monster;
import starhero.model.Stats;

import java.math.BigDecimal;

public class MonsterData {
    public static Monster defaultMonster(int stage) { // 普通怪物
        return new Monster(1, "普通怪物", stage,
                new Stats(
                        10 * stage + 10,
                        2 * stage + 10,
                        5 * stage + 10,
                        stage

                ),
                BigDecimal.valueOf(stage),
                10L * stage
                );
    }







}
