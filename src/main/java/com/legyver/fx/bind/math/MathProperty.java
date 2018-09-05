package com.legyver.fx.bind.math;

import javafx.beans.value.ObservableValue;

/**
 * Unify handling of BigDecimal and BigIntegers
 */
public interface MathProperty<T extends Number> extends ObservableValue<T> {

	void setValue(T value);

}
