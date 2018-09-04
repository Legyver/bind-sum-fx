package com.legyver.fx.bind.sum;

import com.legyver.fx.bind.aware.BigDecimalPropertyAware;
import java.math.BigDecimal;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BigDecimalSumBindingTest {

	@Test
	public void sumStaticBigDecimal() {
		SumBinding sumBinding = new BigDecimalSumBinding();
		ObservableList<BigDecimalPropertyAware> list = FXCollections.observableArrayList();
		sumBinding.bind(list);

		list.addAll(
				set(new SimpleBigDecimalPropertyAware(), new BigDecimal(10.00)),
				set(new SimpleBigDecimalPropertyAware(), new BigDecimal(20.0)));
		assertThat(sumBinding.getSum(), is(new BigDecimal(30.00)));
	}

	@Test
	public void sumChangedBigDecimal() {
		SumBinding sumBinding = new BigDecimalSumBinding();
		ObservableList<BigDecimalPropertyAware> list = FXCollections.observableArrayList();
		sumBinding.bind(list);

		BigDecimalPropertyAware aware = set(new SimpleBigDecimalPropertyAware(), new BigDecimal(10.00));
		list.addAll(aware,
				set(new SimpleBigDecimalPropertyAware(), new BigDecimal(20.0)));
		assertThat(sumBinding.getSum(), is(new BigDecimal(30.00)));
		aware.numberProperty().setValue(new BigDecimal(5.0));
		assertThat(sumBinding.getSum(), is(new BigDecimal(25)));
	}

	@Test
	public void sumStaticAddedBigDecimal() {
		SumBinding sumBinding = new BigDecimalSumBinding();
		ObservableList<BigDecimalPropertyAware> list = FXCollections.observableArrayList();
		sumBinding.bind(list);

		list.addAll(
				set(new SimpleBigDecimalPropertyAware(), new BigDecimal(10.00)),
				set(new SimpleBigDecimalPropertyAware(), new BigDecimal(20.0)));
		assertThat(sumBinding.getSum(), is(new BigDecimal(30.00)));
		list.add(set(new SimpleBigDecimalPropertyAware(), new BigDecimal(30.00)));
		assertThat(sumBinding.getSum(), is(new BigDecimal(60.00)));
	}

	@Test
	public void sumStaticRemovedBigDecimal() {
		SumBinding sumBinding = new BigDecimalSumBinding();
		ObservableList<BigDecimalPropertyAware> list = FXCollections.observableArrayList();
		sumBinding.bind(list);

		list.addAll(
				set(new SimpleBigDecimalPropertyAware(), new BigDecimal(10.00)),
				set(new SimpleBigDecimalPropertyAware(), new BigDecimal(20.0)));
		assertThat(sumBinding.getSum(), is(new BigDecimal(30.00)));
		list.remove(0);
		assertThat(sumBinding.getSum(), is(new BigDecimal(20.00)));
	}

	private BigDecimalPropertyAware set(BigDecimalPropertyAware aware, BigDecimal decimal) {
		aware.numberProperty().setValue(decimal);
		return aware;
	}

	private class SimpleBigDecimalPropertyAware implements BigDecimalPropertyAware {

		private final ObjectProperty<BigDecimal> property = new SimpleObjectProperty<>(SimpleBigDecimalPropertyAware.this, "property", BigDecimal.ZERO);

		@Override
		public Property<BigDecimal> numberProperty() {
			return property;
		}
	}
}
