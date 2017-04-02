package com.geeth.modules.module2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Hello world!
 *
 */
public class Model2Api 
{
	
	
	 private static Logger log = LoggerFactory.getLogger(Model2Api.class);
	    
	    @Autowired
	    Model2Repository model2Repo;
	    
	   
	    public Model2 addModel2(int id, String val1, String val2) {
	        try {
	        	Model2 model2 = new Model2(id, val1, val2);
	        	return model2Repo.saveAndFlush(model2);
	        } catch (Exception e) {
	            log.error("Error saving model2.", e);
	            throw e;
	        }
	    }
	    
	    
	    public void getModel2ById(int id) {
	        try {
	        	model2Repo.findById(id);
	        } catch (Exception e) {
	            log.error("Error fething model2.", e);
	            throw e;
	        }
	    }
	
	

}
