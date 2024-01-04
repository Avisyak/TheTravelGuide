package com.Phoenix.ProjectWork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="destination_tbl")
public class Destination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="destination_name",length=100,nullable = false)
	private String name;
	
	@Column(name="destination_location",length=100,nullable = false)
	private String location;
	
	@Column(name="destination_offers",length=100,nullable = false)
	private String offers;

}
