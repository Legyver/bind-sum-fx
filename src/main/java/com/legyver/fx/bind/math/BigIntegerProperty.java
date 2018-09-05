package com.legyver.fx.bind.math;

import java.math.BigInteger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * Adds multiply/divide/add/subtract for SimpleObjectProperty<BigInteger>
 */
public class BigIntegerProperty extends SimpleObjectProperty<BigInteger> implements MathProperty<BigInteger> {

	public BigIntegerProperty() {
		super();
		this.setValue(BigInteger.ZERO);
	}

	public void bindMultiply(MathProperty<BigInteger> one, MathProperty<BigInteger> two) {
		set(one.getValue().multiply(two.getValue()));
		one.addListener((ObservableValue<? extends BigInteger> observable1, BigInteger oldValue, BigInteger newValue) -> {
			set(newValue.multiply(two.getValue()));
		});
		two.addListener((ObservableValue<? extends BigInteger> observable1, BigInteger oldValue, BigInteger newValue) -> {
			set(newValue.multiply(one.getValue()));
		});
	}

	public void bindDivide(MathProperty<BigInteger> numerator, MathProperty<BigInteger> divisor) {
		set(numerator.getValue().divide(divisor.getValue()));
		numerator.addListener((ObservableValue<? extends BigInteger> observable1, BigInteger oldValue, BigInteger newValue) -> {
			set(newValue.divide(divisor.getValue()));
		});
		divisor.addListener((ObservableValue<? extends BigInteger> observable1, BigInteger oldValue, BigInteger newValue) -> {
			set(numerator.getValue().divide(newValue));
		});
	}

	public void bindAdd(MathProperty<BigInteger> one, MathProperty<BigInteger> two) {
		set(one.getValue().add(two.getValue()));
		one.addListener((ObservableValue<? extends BigInteger> observable1, BigInteger oldValue, BigInteger newValue) -> {
			set(newValue.add(two.getValue()));
		});
		two.addListener((ObservableValue<? extends BigInteger> observable1, BigInteger oldValue, BigInteger newValue) -> {
			set(newValue.add(one.getValue()));
		});
	}

	public void bindSubtract(MathProperty<BigInteger> minuend, MathProperty<BigInteger> subtrahend) {
		set(minuend.getValue().subtract(subtrahend.getValue()));
		minuend.addListener((ObservableValue<? extends BigInteger> observable1, BigInteger oldValue, BigInteger newValue) -> {
			set(newValue.subtract(subtrahend.getValue()));
		});
		subtrahend.addListener((ObservableValue<? extends BigInteger> observable1, BigInteger oldValue, BigInteger newValue) -> {
			set(minuend.getValue().subtract(newValue));
		});
	}
}
