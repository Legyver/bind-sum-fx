package com.legyver.fx.bind.sum;

import java.math.BigInteger;
import javafx.beans.value.ObservableValue;

public class BigIntegerSumBinding extends SumBinding<BigInteger> {

	public BigIntegerSumBinding() {
		super(BigInteger.ZERO);
	}

	@Override
	protected void changed(ObservableValue<? extends BigInteger> observable, BigInteger oldValue, BigInteger newValue) {
		BigInteger temp = sum.getValue().subtract(oldValue).add(newValue);
		sum.set(temp);
	}

	@Override
	protected BigInteger add(BigInteger tally, BigInteger value) {
		return tally.add(value);
	}

}
