package com.legyver.fx.bind.sum;

import com.legyver.fx.bind.aware.BigIntegerPropertyAware;
import com.legyver.fx.bind.math.BigIntegerProperty;
import com.legyver.fx.bind.math.MathProperty;
import java.math.BigInteger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BigIntegerSumBindingTest {

	@Test
	public void sumStaticBigInteger() {
		SumBinding sumBinding = new BigIntegerSumBinding();
		ObservableList<BigIntegerPropertyAware> list = FXCollections.observableArrayList();
		sumBinding.bind(list);

		list.addAll(
				set(new SimpleBigIntegerPropertyAware(), BigInteger.valueOf(10)),
				set(new SimpleBigIntegerPropertyAware(), BigInteger.valueOf(20)));
		assertThat(sumBinding.getSum(), is(BigInteger.valueOf(30)));
	}

	@Test
	public void sumChangedBigInteger() {
		SumBinding sumBinding = new BigIntegerSumBinding();
		ObservableList<BigIntegerPropertyAware> list = FXCollections.observableArrayList();
		sumBinding.bind(list);

		BigIntegerPropertyAware aware = set(new SimpleBigIntegerPropertyAware(), BigInteger.valueOf(10));
		list.addAll(aware,
				set(new SimpleBigIntegerPropertyAware(), BigInteger.valueOf(20)));
		assertThat(sumBinding.getSum(), is(BigInteger.valueOf(30)));
		aware.numberProperty().setValue(BigInteger.valueOf(5));
		assertThat(sumBinding.getSum(), is(BigInteger.valueOf(25)));
	}

	@Test
	public void sumStaticAddedBigInteger() {
		SumBinding sumBinding = new BigIntegerSumBinding();
		ObservableList<BigIntegerPropertyAware> list = FXCollections.observableArrayList();
		sumBinding.bind(list);

		list.addAll(
				set(new SimpleBigIntegerPropertyAware(), BigInteger.valueOf(10)),
				set(new SimpleBigIntegerPropertyAware(), BigInteger.valueOf(20)));
		assertThat(sumBinding.getSum(), is(BigInteger.valueOf(30)));
		list.add(set(new SimpleBigIntegerPropertyAware(), BigInteger.valueOf(30)));
		assertThat(sumBinding.getSum(), is(BigInteger.valueOf(60)));
	}

	@Test
	public void sumStaticRemovedBigInteger() {
		SumBinding sumBinding = new BigIntegerSumBinding();
		ObservableList<BigIntegerPropertyAware> list = FXCollections.observableArrayList();
		sumBinding.bind(list);

		list.addAll(
				set(new SimpleBigIntegerPropertyAware(), BigInteger.valueOf(10)),
				set(new SimpleBigIntegerPropertyAware(), BigInteger.valueOf(20)));
		assertThat(sumBinding.getSum(), is(BigInteger.valueOf(30)));
		list.remove(0);
		assertThat(sumBinding.getSum(), is(BigInteger.valueOf(20)));
	}

	@Test
	public void sumStaticSeparateAddsBigInteger() {
		SumBinding sumBinding = new BigIntegerSumBinding();
		ObservableList<BigIntegerPropertyAware> list = FXCollections.observableArrayList();
		sumBinding.bind(list);

		BigIntegerPropertyAware awareA = set(new SimpleBigIntegerPropertyAware(), BigInteger.valueOf(10));
		BigIntegerPropertyAware awareB = set(new SimpleBigIntegerPropertyAware(), BigInteger.valueOf(20));
		list.add(awareA);
		awareA.numberProperty().setValue(BigInteger.valueOf(5));
		list.add(awareB);
		awareB.numberProperty().setValue(BigInteger.valueOf(35));
		assertThat(sumBinding.getSum(), is(BigInteger.valueOf(40)));
	}

	private BigIntegerPropertyAware set(BigIntegerPropertyAware aware, BigInteger decimal) {
		aware.numberProperty().setValue(decimal);
		return aware;
	}

	private class SimpleBigIntegerPropertyAware implements BigIntegerPropertyAware {

		private final BigIntegerProperty property = new BigIntegerProperty();

		@Override
		public MathProperty<BigInteger> numberProperty() {
			return property;
		}
	}
}
