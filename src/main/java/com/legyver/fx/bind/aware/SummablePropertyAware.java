package com.legyver.fx.bind.aware;

import javafx.beans.property.Property;

public interface SummablePropertyAware<T extends Number> {

	Property<T> numberProperty();
}
