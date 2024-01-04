package com.Phoenix.ProjectWork.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="booking_tbl")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="booking_name",length=50,nullable=false)
	private String name;
	
	@Column(name="booking_email",length=100,nullable=false)
	private String email;
	
	@Column(name="booking_date",length=100,nullable = false)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="destination_id",referencedColumnName = "id")
	private Destination destination;
	
	@Column(name="booking_request",length=100,nullable=false)
	private String Request;
	
	

}
