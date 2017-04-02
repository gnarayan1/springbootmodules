package com.geeth.modules.module2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Model2Repository extends JpaRepository<Model2, Long> {
	
	Model2 findById(int id);

}



