package ru.mamsta.gridapp.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table
public class User {
	
	private Long id;
	private String name;
	private Integer age;
	
	public User() {
		super();
	}

	public User(Long id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

//	@Id
//	@Column
//	@GeneratedValue(strategy = GenerationType.AUTO)
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

//	@Column
	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}
	
//	@Column
	public void setAge(Integer age) {
		this.age = age;
	}

//	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
