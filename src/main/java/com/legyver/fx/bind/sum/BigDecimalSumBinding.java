package com.legyver.fx.bind.sum;

import com.legyver.fx.bind.math.BigDecimalProperty;
import java.math.BigDecimal;
import javafx.beans.value.ObservableValue;

public class BigDecimalSumBinding extends SumBinding<BigDecimal> {

	public BigDecimalSumBinding() {
		super(new BigDecimalProperty(), BigDecimal.ZERO);
	}

	@Override
	protected void add(BigDecimal value) {
		sum.setValue(sum.getValue().add(value));
	}

	@Override
	protected void subtract(BigDecimal value) {
		sum.setValue(sum.getValue().subtract(value));
	}

	@Override
	protected void changed(ObservableValue<? extends BigDecimal> observable, BigDecimal oldValue, BigDecimal newValue) {
		BigDecimal temp = sum.getValue().subtract(oldValue).add(newValue);
		sum.setValue(temp);
	}

}
