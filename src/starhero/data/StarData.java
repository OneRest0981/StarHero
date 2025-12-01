package starhero.data;

import starhero.model.Star;
import starhero.model.Stats;

public class StarData {

    public static Star defaultStar() {

        return new Star(1, "小星", "最平衡的星星",
                new Stats(
                        50.0,
                        5.0,
                        5.0,
                        1.0,
                        10.0,
                        110.0,
                        5.0,
                        20.0
                ), "/images/star/default.png"
        );

    }



    public static Star WarriorStar(){

        return new Star(2, "战斗星", "崇尚战士的一颗星",
                new Stats(
                        70,
                        10,
                        10,
                        0.8,
                        0,
                        100,
                        0,
                        0
                ), "/images/star/default.png"
        );
    }



}
