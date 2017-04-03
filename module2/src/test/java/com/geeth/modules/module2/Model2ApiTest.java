package com.geeth.modules.module2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import junit.framework.TestCase;

/**
 * Unit test for simple Model2Api.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Model2Config.class, loader = AnnotationConfigContextLoader.class)
public class Model2ApiTest 
    extends TestCase
{
	@Autowired
	Model2Api model2Api;
	
  

    @Test
	public void testAddModel2() {
		String val1 = "val1";
		String val2 = "val2";
		Model2 model2 = model2Api.addModel2(val1, val2);
		assertEquals(model2.getSomeVal(), val1);
		assertEquals(model2.getSomeVal2(), val2);
	}
}
