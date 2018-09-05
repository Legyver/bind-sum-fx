package com.legyver.fx.bind.multiply;

import com.legyver.fx.bind.math.BigDecimalProperty;
import java.math.BigDecimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class BigDecimalPropertyTest {

	@Test
	public void negate() {
		BigDecimalProperty bigDecimal = new BigDecimalProperty();
		BigDecimalProperty negativeOne = new BigDecimalProperty();
		bigDecimal.set(BigDecimal.TEN);
		negativeOne.set(new BigDecimal(-1));
		BigDecimalProperty result = new BigDecimalProperty();

		result.bindMultiply(bigDecimal, negativeOne);//sumBinding.sumProperty()
		assertThat(result.get(), is(new BigDecimal(-10.00)));
	}

	@Test
	public void add() {
		BigDecimalProperty bigDecimal = new BigDecimalProperty();
		BigDecimalProperty negativeOne = new BigDecimalProperty();
		bigDecimal.set(BigDecimal.TEN);
		negativeOne.set(new BigDecimal(-1));
		BigDecimalProperty result = new BigDecimalProperty();

		result.bindAdd(bigDecimal, negativeOne);//sumBinding.sumProperty()
		assertThat(result.get(), is(new BigDecimal(9.00)));
	}

	@Test
	public void addChanged() {
		BigDecimalProperty bigDecimal = new BigDecimalProperty();
		BigDecimalProperty negativeOne = new BigDecimalProperty();
		bigDecimal.set(BigDecimal.TEN);
		negativeOne.set(new BigDecimal(-1));
		BigDecimalProperty result = new BigDecimalProperty();

		result.bindAdd(bigDecimal, negativeOne);//sumBinding.sumProperty()
		bigDecimal.set(new BigDecimal(22));
		negativeOne.set(new BigDecimal(3));
		assertThat(result.get(), is(new BigDecimal(25.00)));
	}

	@Test
	public void subtract() {
		BigDecimalProperty bigDecimal = new BigDecimalProperty();
		BigDecimalProperty negativeOne = new BigDecimalProperty();
		bigDecimal.set(BigDecimal.TEN);
		negativeOne.set(new BigDecimal(-1));
		BigDecimalProperty result = new BigDecimalProperty();

		result.bindSubtract(bigDecimal, negativeOne);//sumBinding.sumProperty()
		assertThat(result.get(), is(new BigDecimal(11.00)));
	}

	@Test
	public void subtractChanged() {
		BigDecimalProperty bigDecimal = new BigDecimalProperty();
		BigDecimalProperty negativeOne = new BigDecimalProperty();
		bigDecimal.set(BigDecimal.TEN);
		negativeOne.set(new BigDecimal(-1));
		BigDecimalProperty result = new BigDecimalProperty();

		result.bindSubtract(bigDecimal, negativeOne);//sumBinding.sumProperty()
		bigDecimal.set(new BigDecimal(22));
		negativeOne.set(new BigDecimal(3));
		assertThat(result.get(), is(new BigDecimal(19.00)));
	}

	@Test
	public void multiplyChanged() {
		BigDecimalProperty bigDecimal = new BigDecimalProperty();
		BigDecimalProperty negativeOne = new BigDecimalProperty();
		bigDecimal.set(BigDecimal.TEN);
		negativeOne.set(new BigDecimal(-1));
		BigDecimalProperty result = new BigDecimalProperty();

		result.bindMultiply(bigDecimal, negativeOne);//sumBinding.sumProperty()
		bigDecimal.set(new BigDecimal(22));
		negativeOne.set(new BigDecimal(3));
		assertThat(result.get(), is(new BigDecimal(66.00)));
	}

	@Test
	public void divide() {
		BigDecimalProperty bigDecimal = new BigDecimalProperty();
		BigDecimalProperty negativeOne = new BigDecimalProperty();
		bigDecimal.set(BigDecimal.TEN);
		negativeOne.set(new BigDecimal(-1));
		BigDecimalProperty result = new BigDecimalProperty();

		result.bindDivide(bigDecimal, negativeOne);//sumBinding.sumProperty()
		assertThat(result.get(), is(new BigDecimal(-10.00)));
	}

	@Test
	public void divideChanged() {
		BigDecimalProperty bigDecimal = new BigDecimalProperty();
		BigDecimalProperty negativeOne = new BigDecimalProperty();
		bigDecimal.set(BigDecimal.TEN);
		negativeOne.set(new BigDecimal(-1));
		BigDecimalProperty result = new BigDecimalProperty();

		result.bindDivide(bigDecimal, negativeOne);//sumBinding.sumProperty()
		bigDecimal.set(new BigDecimal(21));
		negativeOne.set(new BigDecimal(3));
		assertThat(result.get(), is(new BigDecimal(7.00)));
	}

}
