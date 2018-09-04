package com.legyver.fx.bind.sum;

import javafx.beans.value.ObservableValue;

public class IntegerSumBinding extends SumBinding<Integer> {

	public IntegerSumBinding() {
		super(0);
	}

	@Override
	protected void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
		Integer temp = sum.getValue() - oldValue + newValue;
		sum.set(temp);
	}

	@Override
	protected Integer add(Integer tally, Integer value) {
		return tally + value;
	}

}
