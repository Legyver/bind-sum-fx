package com.legyver.fx.bind.aware;

import com.legyver.fx.bind.math.MathProperty;

public interface SummablePropertyAware<T extends Number> {

	MathProperty<T> numberProperty();
}
