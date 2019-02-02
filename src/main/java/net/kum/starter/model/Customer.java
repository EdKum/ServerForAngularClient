package net.kum.starter.model;

public class Customer {

	private Long id;
	private String firstname;
	private String lastname;
	private int age;

	public Customer() {

	}

	public Customer(String firstname, String lastname, int age) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	public Customer(Long id, String firstname, String lastname, int age) {

		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
