import static org.junit.Assert.*;

import java.util.Random;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BinarySearchTreeTest {
	
	BinarySearchTree myTree = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		myTree = new BinarySearchTree();	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws EmptyException {
		Random r = new Random();
		for (int i = 0; i < 20; i++)
			myTree.Insert(r.nextInt() % 100);
		
		myTree.printTree();
		
		
		System.out.println("Max value in the Tree is: " +myTree.maxValue());
		System.out.println("Min value in the Tree is: " +myTree.minValue());
		Assert.assertEquals(myTree.minValue(), myTree.minValueThroughLeftNode());
		System.out.println("Size of Tree is: " +myTree.size());
		System.out.println("Level of Tree is: " +myTree.getLevel());
		
	}
}
