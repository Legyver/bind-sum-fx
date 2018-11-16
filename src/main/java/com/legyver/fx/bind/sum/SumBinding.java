package com.legyver.fx.bind.sum;

import com.legyver.fx.bind.aware.SummablePropertyAware;
import com.legyver.fx.bind.math.MathProperty;
import java.util.Iterator;
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public abstract class SumBinding<T extends Number> {

	protected final MathProperty<T> sum;

	protected SumBinding(MathProperty<T> mathProperty, T initialValue) {
		sum = mathProperty;
		sum.setValue(initialValue);
	}

	public MathProperty<T> sumProperty() {
		return sum;
	}

	public T getSum() {
		return sum.getValue();
	}

	public void bind(final ObservableList<? extends SummablePropertyAware<T>> collection) {
		update(collection, false);
		collection.addListener(this::onChanged);
	}

	public void onChanged(ListChangeListener.Change<? extends SummablePropertyAware<T>> c) {
		c.next();
		boolean removal = c.getRemovedSize() > 0;
		List<? extends SummablePropertyAware<T>> changedList = removal ? c.getRemoved() : c.getAddedSubList();
		update((List<SummablePropertyAware<T>>) changedList, removal);
	}

	private void update(List<? extends SummablePropertyAware<T>> changedList, boolean removal) {
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
