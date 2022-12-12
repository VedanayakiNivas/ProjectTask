
package com.te.validationAndException.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName= "build")
@NoArgsConstructor

public class UserRequest {

	@NotNull(message = "username should not be null")
	private String name;
	@Email(message = "invalid email address")
	private String email;
	@NotEmpty
	@Pattern(regexp= "^\\d{10}$",
			message="mobile number should be 0-9 numbers"
			)
	private String mobile;
	
	@NotNull
	private String gender;
	@Min(18)
	@Max(60)
	private Integer age;
	@NotBlank
	private String nationality;
}
