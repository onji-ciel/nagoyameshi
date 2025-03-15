package com.example.nagoyamashi.entity;

import java.sql.Timestamp;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurants")
@Data

public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String image;

	@Column(name = "description")
	private String description;

	@Column(name = "lowestPrice")
	private Integer lowest_price;

	@Column(name = "highestPrice")
	private Integer highest_price;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "address")
	private String address;

	@Column(name = "openingTime")
	private LocalTime opening_time;

	@Column(name = "closingTime")
	private LocalTime closing_time;

	@Column(name = "seatingCapacity")
	private String seating_capacity;

	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;
}
