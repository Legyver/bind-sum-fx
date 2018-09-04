package com.legyver.fx.bind.sum;

import com.legyver.fx.bind.aware.SummablePropertyAware;
import java.util.Iterator;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public abstract class SumBinding<T extends Number> {

	protected final ObjectProperty<T> sum;

	public SumBinding(T initialValue) {
		sum = new SimpleObjectProperty<>(SumBinding.this, "sum", initialValue);
	}

	public ObjectProperty<T> sumProperty() {
		return sum;
	}

	public T getSum() {
		return sum.get();
	}

	public void bind(final ObservableList<SummablePropertyAware<T>> collection) {
		collection.addListener(this::onChanged);
	}

	public void onChanged(ListChangeListener.Change<? extends SummablePropertyAware<T>> c) {
		c.next();
		boolean removal = c.getRemovedSize() > 0;
		List<? extends SummablePropertyAware<T>> changedList = removal ? c.getRemoved() : c.getAddedSubList();
		for (Iterator<? extends SummablePropertyAware<T>> awareIt = changedList.iterator(); awareIt.hasNext();) {
			SummablePropertyAware<T> aware = awareIt.next();

			if (removal) {
				subtract(aware.numberProperty().getValue());
			} else {
				aware.numberProperty().addListener(this::changed);
				add(aware.numberProperty().getValue());
			}
		}
	}

	protected abstract void changed(ObservableValue<? extends T> observable, T oldValue, T newValue);

	protected abstract void add(T value);

	protected abstract void subtract(T value);
}
