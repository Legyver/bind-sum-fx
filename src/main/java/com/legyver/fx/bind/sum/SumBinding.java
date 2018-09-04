package com.legyver.fx.bind.sum;

import com.legyver.fx.bind.aware.SummablePropertyAware;
import java.util.Iterator;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public abstract class SumBinding<T extends Number> {

	private final T initialValue;
	protected final ObjectProperty<T> sum;
	private ObservableList<SummablePropertyAware<T>> collection;

	public SumBinding(T initialValue) {
		this.initialValue = initialValue;
		sum = new SimpleObjectProperty<>(SumBinding.this, "sum", initialValue);
	}

	public ObjectProperty<T> sumProperty() {
		return sum;
	}

	public T getSum() {
		return sum.get();
	}

	public void bind(final ObservableList<SummablePropertyAware<T>> collection) {
		this.collection = collection;
		collection.addListener(this::onChanged);
	}

	public void onChanged(ListChangeListener.Change<? extends SummablePropertyAware<T>> c) {
		T tally = initialValue;
		for (Iterator<SummablePropertyAware<T>> awareIt = collection.iterator(); awareIt.hasNext();) {
			SummablePropertyAware<T> aware = awareIt.next();
			//get new sum
			WritableValue<T> property = aware.numberProperty();
			tally = add(tally, property.getValue());
			//JavaFX collects events into batches so we have to re-register all the listeners every time
			aware.numberProperty().removeListener(this::changed);
			aware.numberProperty().addListener(this::changed);
		}
		sum.set(tally);
	}

	protected abstract void changed(ObservableValue<? extends T> observable, T oldValue, T newValue);

	protected abstract T add(T tally, T value);
}
