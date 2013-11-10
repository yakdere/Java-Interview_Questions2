import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PostfixExpressionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		StackCalc c = new StackCalc();
		Assert.assertEquals("3 5 +", c.ComputePostFix("3+5"));
		Assert.assertEquals("3 5 x 4 +", c.ComputePostFix("3x5+4"));
		Assert.assertEquals("3 5 4 x +", c.ComputePostFix("3+5x4"));
		Assert.assertEquals("3 4 + 2 x", c.ComputePostFix("(3+4)x2"));
		Assert.assertEquals("3 5 x 7 2 x + 5 /", c.ComputePostFix("(3x5+7x2)/5"));
		Assert.assertEquals("3 5 + 8 x 2 3 x +", c.ComputePostFix("((3 + 5) x 8 + ( 2 x 3 ))"));
		Assert.assertEquals("30 50 44 x +", c.ComputePostFix("30 + 50 x 44"));
		Assert.assertEquals("1000 5 4 x +", c.ComputePostFix("1000 + 5 x 4"));
		Assert.assertEquals("3 50 4 x +", c.ComputePostFix("3+50x4"));
	}

}
