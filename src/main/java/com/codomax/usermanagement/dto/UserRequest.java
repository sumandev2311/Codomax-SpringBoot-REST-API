package com.codomax.usermanagement.dto;
import jakarta.validation.constraints.*;
public class UserRequest {
    @NotBlank(message = "Name is required") @Size(max = 80) private String name;
    @NotBlank(message = "Email is required") @Email(message = "Email must be valid") @Size(max = 120) private String email;
    @Size(max = 20) private String phone;
    @NotNull(message = "Age is required") @Min(1) @Max(120) private Integer age;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}
