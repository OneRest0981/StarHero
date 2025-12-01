package starhero.util;

import javafx.scene.control.Button;

public class Format {
    // 设置按钮宽度
    public static void uniformButtonWidth(Button... buttons) {
        for(Button b : buttons){
            b.setPrefWidth(100);
        }
    }

    // double转int
    public static int doubleToInt(double number) {
        return (int) number;
    }




}
