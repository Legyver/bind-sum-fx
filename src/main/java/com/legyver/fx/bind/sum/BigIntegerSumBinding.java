package com.legyver.fx.bind.sum;

import com.legyver.fx.bind.math.BigIntegerProperty;
import java.math.BigInteger;
import javafx.beans.value.ObservableValue;

public class BigIntegerSumBinding extends SumBinding<BigInteger> {

	public BigIntegerSumBinding() {
		super(new BigIntegerProperty(), BigInteger.ZERO);
	}

	@Override
	protected void changed(ObservableValue<? extends BigInteger> observable, BigInteger oldValue, BigInteger newValue) {
		BigInteger temp = sum.getValue().subtract(oldValue).add(newValue);
		sum.setValue(temp);
	}

	@Override
	protected void add(BigInteger value) {
		sum.setValue(sum.getValue().add(value));
	}

	@Override
	protected void subtract(BigInteger value) {
		sum.setValue(sum.getValue().subtract(value));
	}

}
