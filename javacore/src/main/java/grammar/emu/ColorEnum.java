package grammar.emu;

/**
 * Created by qidima on 2017/7/13.
 */
public enum ColorEnum {
    black(1), white(2);
    private int color;

    ColorEnum(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
