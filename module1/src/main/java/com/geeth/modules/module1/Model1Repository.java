package com.geeth.modules.module1;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Model1Repository extends JpaRepository<Model1, Long> {
	
	Model1 findById(Long id);

}



