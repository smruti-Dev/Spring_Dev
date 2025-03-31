package spring.tutor.app.curd.example.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employees", schema = "spring_db", uniqueConstraints = {
		@UniqueConstraint(name = "uniqueue_constr", columnNames = { "email_id", "first_name" }) })

public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, precision = 10)
	private long id;
	
	//@NotEmpty(message = "The firstName is required.")
	//@Size(min = 2, max = 10, message = "The length of firstName must be between 2 and 10 characters.")
	@Column(name = "first_name", nullable = false)
	
	private String firstName;

	//@NotBlank(message = "The lastName is required.")
	@Column(name = "last_name", nullable = false)
	private String lastName;

	//@NotBlank(message = "The emailId is required.")
	//@Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
	@Column(name = "email_id", nullable = false)
	private String emailId;

	//@NotBlank(message = "The country is required.")
	@Column(name = "age", nullable = false)
	private int age;

	//@NotBlank(message = "The Zip code is required.")
	//@Pattern(regexp = "^\\d{1,5}$", flags = { Flag.CASE_INSENSITIVE,Flag.MULTILINE }, message = "The Zip code is invalid.")
	@Column(name = "zip_code", nullable = false)
	
	private String zipCode;

	@Column(name = "created_time")
	@CreationTimestamp
	private Date createdTimeStamp;

	@Column(name = "updated_time")
	@UpdateTimestamp
	private Date updatedTimeStamp;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}

}
