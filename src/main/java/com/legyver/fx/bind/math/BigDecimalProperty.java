package com.legyver.fx.bind.math;

import java.math.BigDecimal;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * Adds multiply/divide/add/subtract for SimpleObjectProperty<BigDecimal>
 */
public class BigDecimalProperty extends SimpleObjectProperty<BigDecimal> implements MathProperty<BigDecimal> {

	public BigDecimalProperty() {
		super();
		super.setValue(BigDecimal.ZERO);
	}

	public void bindMultiply(MathProperty<BigDecimal> one, MathProperty<BigDecimal> two) {
		set(one.getValue().multiply(two.getValue()));
		one.addListener((ObservableValue<? extends BigDecimal> observable1, BigDecimal oldValue, BigDecimal newValue) -> {
			set(newValue.multiply(two.getValue()));
		});
		two.addListener((ObservableValue<? extends BigDecimal> observable1, BigDecimal oldValue, BigDecimal newValue) -> {
			set(newValue.multiply(one.getValue()));
		});
	}

	public void bindDivide(MathProperty<BigDecimal> numerator, MathProperty<BigDecimal> divisor) {
		set(numerator.getValue().divide(divisor.getValue()));
		numerator.addListener((ObservableValue<? extends BigDecimal> observable1, BigDecimal oldValue, BigDecimal newValue) -> {
			set(newValue.divide(divisor.getValue()));
		});
		divisor.addListener((ObservableValue<? extends BigDecimal> observable1, BigDecimal oldValue, BigDecimal newValue) -> {
			set(numerator.getValue().divide(newValue));
		});
	}

	public void bindAdd(MathProperty<BigDecimal> one, MathProperty<BigDecimal> two) {
		set(one.getValue().add(two.getValue()));
		one.addListener((ObservableValue<? extends BigDecimal> observable1, BigDecimal oldValue, BigDecimal newValue) -> {
			set(newValue.add(two.getValue()));
		});
		two.addListener((ObservableValue<? extends BigDecimal> observable1, BigDecimal oldValue, BigDecimal newValue) -> {
			set(newValue.add(one.getValue()));
		});
	}

	public void bindSubtract(MathProperty<BigDecimal> minuend, MathProperty<BigDecimal> subtrahend) {
		set(minuend.getValue().subtract(subtrahend.getValue()));
		minuend.addListener((ObservableValue<? extends BigDecimal> observable1, BigDecimal oldValue, BigDecimal newValue) -> {
			set(newValue.subtract(subtrahend.getValue()));
		});
		subtrahend.addListener((ObservableValue<? extends BigDecimal> observable1, BigDecimal oldValue, BigDecimal newValue) -> {
			set(minuend.getValue().subtract(newValue));
		});
	}

}
