package com.geeth.modules.module1;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import junit.framework.TestCase;



/**
 * Unit test for simple Model1Api.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Model1Config.class, loader = AnnotationConfigContextLoader.class)
public class Model1ApiTest extends TestCase {
	@Autowired
	Model1Api model1Api;


	/**
	 * 
	 */
	@Test
	public void testAddModel1() {
		String val1 = "val1";
		String val2 = "val2";
		Model1 model1 = model1Api.addModel1(1, val1, val2);
		assertEquals(model1.getSomeVal(), val1);
		assertEquals(model1.getSomeVal2(), val2);
	}
}
