package com.bilgeadam.student.man.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
	@NotBlank(message="ad boş geçilemez")
	private String name;
	@NotBlank(message="ad boş geçilemez")
	private String surname;
	@Min(0)
	@Max(4)
	private Double grade;
	@Email(message="hatalı email")
	private String email;
}
