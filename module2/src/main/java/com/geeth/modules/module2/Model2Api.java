package com.geeth.modules.module2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geeth.modules.module1.Model1;
import com.geeth.modules.module1.Model1Api;


/**
 * Hello world!
 *
 */
@Component
public class Model2Api 
{
	
	
	 private static Logger log = LoggerFactory.getLogger(Model2Api.class);
	    
	    @Autowired
	    Model2Repository model2Repo;
	    
	    
	    
	    @Autowired
	    Model1Api model1Api;
	    
	   
	    public Model2 addModel2(String val1, String val2) {
	        try {
	        	Model2 model2 = new Model2(val1, val2);
	        	Model2  model2Saved =  model2Repo.saveAndFlush(model2);
	        	
	        	Model1 model1 = new Model1(val1, val2);
	        	Model1  model1Saved =  model1Api.addModel1(val1, val2);
	        	
	        	return model2;
	        	
	        } catch (Exception e) {
	            log.error("Error saving model2.", e);
	            throw e;
	        }
	    }
	    
	    
	    public void getModel2ById(Long id) {
	        try {
	        	model2Repo.findById(id);
	        } catch (Exception e) {
	            log.error("Error fething model2.", e);
	            throw e;
	        }
	    }
	
	

}
