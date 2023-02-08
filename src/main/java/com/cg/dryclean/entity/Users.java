//package com.cg.dryclean.entity;
//import java.util.*;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name="Users")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Users {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;	
//	private String name;
//	private String email;
//	private String password;
//	private String contactNo;
//	private String role;
//
////	unidirectional
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//	private Addresses address;
//
////	bidirectional
//	@JsonBackReference
//	@OneToMany(mappedBy="users",cascade = CascadeType.ALL)
//	private List<Orders> orders;
//
//}
