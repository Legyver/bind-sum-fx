package com.legyver.fx.bind.sum;

import java.math.BigDecimal;
import javafx.beans.value.ObservableValue;

public class BigDecimalSumBinding extends SumBinding<BigDecimal> {

	public BigDecimalSumBinding() {
		super(BigDecimal.ZERO);
	}

	@Override
	protected BigDecimal add(BigDecimal tally, BigDecimal value) {
		return tally.add(value);
	}

	@Override
	protected void changed(ObservableValue<? extends BigDecimal> observable, BigDecimal oldValue, BigDecimal newValue) {
		BigDecimal temp = sum.getValue().subtract(oldValue).add(newValue);
		sum.set(temp);
	}
}
