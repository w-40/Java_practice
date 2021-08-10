package Swing学习.列表框;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberComboBoxModel extends NumberListModel implements ComboBoxModel<BigDecimal> {
    //用于保存用户选中项的索引
    private int selectId = 0;

    public NumberComboBoxModel(double start, double end, double step) {
        super(start, end, step);
    }

    //设置选择项
    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof BigDecimal){
            BigDecimal target = (BigDecimal) anItem;
            selectId = target.subtract(super.start).divide(super.step,2, RoundingMode.HALF_DOWN).intValue();
        }
    }

    //获取选中项的索引
    @Override
    public BigDecimal getSelectedItem() {
        return BigDecimal.valueOf(selectId).multiply(step).add(start).setScale(1,RoundingMode.HALF_DOWN);

    }
}
