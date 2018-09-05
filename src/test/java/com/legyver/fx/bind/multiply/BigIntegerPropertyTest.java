package com.legyver.fx.bind.multiply;

import com.legyver.fx.bind.math.BigIntegerProperty;
import java.math.BigInteger;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Ben
 */
public class BigIntegerPropertyTest {

	@Test
	public void negate() {
		BigIntegerProperty bigInteger = new BigIntegerProperty();
		BigIntegerProperty negativeOne = new BigIntegerProperty();
		bigInteger.set(BigInteger.TEN);
		negativeOne.set(BigInteger.valueOf(-1));
		BigIntegerProperty result = new BigIntegerProperty();

		result.bindMultiply(bigInteger, negativeOne);//sumBinding.sumProperty()
		assertThat(result.get(), is(BigInteger.valueOf(-10)));
	}

	@Test
	public void add() {
		BigIntegerProperty bigInteger = new BigIntegerProperty();
		BigIntegerProperty negativeOne = new BigIntegerProperty();
		bigInteger.set(BigInteger.TEN);
		negativeOne.set(BigInteger.valueOf(-1));
		BigIntegerProperty result = new BigIntegerProperty();

		result.bindAdd(bigInteger, negativeOne);//sumBinding.sumProperty()
		assertThat(result.get(), is(BigInteger.valueOf(9)));
	}

	@Test
	public void addChanged() {
		BigIntegerProperty bigInteger = new BigIntegerProperty();
		BigIntegerProperty negativeOne = new BigIntegerProperty();
		bigInteger.set(BigInteger.TEN);
		negativeOne.set(BigInteger.valueOf(-1));
		BigIntegerProperty result = new BigIntegerProperty();

		result.bindAdd(bigInteger, negativeOne);//sumBinding.sumProperty()
		bigInteger.set(BigInteger.valueOf(22));
		negativeOne.set(BigInteger.valueOf(3));
		assertThat(result.get(), is(BigInteger.valueOf(25)));
	}

	@Test
	public void subtract() {
		BigIntegerProperty bigInteger = new BigIntegerProperty();
		BigIntegerProperty negativeOne = new BigIntegerProperty();
		bigInteger.set(BigInteger.TEN);
		negativeOne.set(BigInteger.valueOf(-1));
		BigIntegerProperty result = new BigIntegerProperty();

		result.bindSubtract(bigInteger, negativeOne);//sumBinding.sumProperty()
		assertThat(result.get(), is(BigInteger.valueOf(11)));
	}

	@Test
	public void subtractChanged() {
		BigIntegerProperty bigInteger = new BigIntegerProperty();
		BigIntegerProperty negativeOne = new BigIntegerProperty();
		bigInteger.set(BigInteger.TEN);
		negativeOne.set(BigInteger.valueOf(-1));
		BigIntegerProperty result = new BigIntegerProperty();

		result.bindSubtract(bigInteger, negativeOne);//sumBinding.sumProperty()
		bigInteger.set(BigInteger.valueOf(22));
		negativeOne.set(BigInteger.valueOf(3));
		assertThat(result.get(), is(BigInteger.valueOf(19)));
	}

	@Test
	public void multiplyChanged() {
		BigIntegerProperty bigInteger = new BigIntegerProperty();
		BigIntegerProperty negativeOne = new BigIntegerProperty();
		bigInteger.set(BigInteger.TEN);
		negativeOne.set(BigInteger.valueOf(-1));
		BigIntegerProperty result = new BigIntegerProperty();

		result.bindMultiply(bigInteger, negativeOne);//sumBinding.sumProperty()
		bigInteger.set(BigInteger.valueOf(22));
		negativeOne.set(BigInteger.valueOf(3));
		assertThat(result.get(), is(BigInteger.valueOf(66)));
	}

	@Test
	public void divide() {
		BigIntegerProperty bigInteger = new BigIntegerProperty();
		BigIntegerProperty negativeOne = new BigIntegerProperty();
		bigInteger.set(BigInteger.TEN);
		negativeOne.set(BigInteger.valueOf(-1));
		BigIntegerProperty result = new BigIntegerProperty();

		result.bindDivide(bigInteger, negativeOne);//sumBinding.sumProperty()
		assertThat(result.get(), is(BigInteger.valueOf(-10)));
	}

	@Test
	public void divideChanged() {
		BigIntegerProperty bigInteger = new BigIntegerProperty();
		BigIntegerProperty negativeOne = new BigIntegerProperty();
		bigInteger.set(BigInteger.TEN);
		negativeOne.set(BigInteger.valueOf(-1));
		BigIntegerProperty result = new BigIntegerProperty();

		result.bindDivide(bigInteger, negativeOne);//sumBinding.sumProperty()
		bigInteger.set(BigInteger.valueOf(21));
		negativeOne.set(BigInteger.valueOf(3));
		assertThat(result.get(), is(BigInteger.valueOf(7)));
	}
}
