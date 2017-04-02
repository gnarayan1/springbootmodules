package com.geeth.modules.module1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 
 *
 */
@Component
public class Model1Api 
{
	private static Logger log = LoggerFactory.getLogger(Model1Api.class);
	
	 @Autowired
	 Model1Repository model1Repo;
	
	 public Model1Api() {
		// TODO Auto-generated constructor stub
	}
	 
	 
    public Model1 addModel1(int id, String val1, String val2) {
        try {
        	Model1 model1 = new Model1(val1, val2);
        	return model1Repo.saveAndFlush(model1);
        } catch (Exception e) {
            log.error("Error saving Model1.", e);
            throw e;
        }
    }
    
    
    public void getModel1ById(int id) {
        try {
        	model1Repo.findById(id);
        } catch (Exception e) {
            log.error("Error fetching Model1.", e);
            throw e;
        }
    }

	
}
