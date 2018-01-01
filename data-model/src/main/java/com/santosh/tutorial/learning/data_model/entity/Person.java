/**
 * 
 */
package com.santosh.tutorial.learning.data_model.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @author santgup
 *
 */

@Data
public class Person implements BaseEntity,Serializable {
	
	private static final long serialVersionUID=1254879535;
	private Integer id;
	
	private Long salary;
	
	private String name;
	
	private String adress;
	
	private String email;
	
	
	@Override
	public  Object regionKey() {
		
		return new StringBuilder().append(this.id).append(":").append(this.name).toString();
		
		
		
	}
	
	
	
	
	
	
	

}
