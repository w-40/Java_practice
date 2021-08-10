package Swing学习.列表框;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberListModel extends AbstractListModel<BigDecimal> {

    protected BigDecimal start;
    protected BigDecimal end;
    protected BigDecimal step;


    public NumberListModel(double start,double end,double step) {
        this.start = new BigDecimal(start);
        this.end = new BigDecimal(end);
        this.step = new BigDecimal(step);
    }

    @Override
    public int getSize() {
        int floor = (int) Math.floor(end.subtract(start).divide(step,2, RoundingMode.HALF_DOWN).doubleValue());
        return floor+1;
    }

    @Override
    public BigDecimal getElementAt(int index) {
        return BigDecimal.valueOf(index).multiply(step).add(start).setScale(1,RoundingMode.HALF_DOWN);
    }
}