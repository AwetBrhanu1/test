package nahom.nahi.dto;

import jakarta.validation.constraints.*;

public record StudentDTO(
        @NotBlank
        @Size(min = 3, message = "Name must be at least 3 characters.")
        String name,

        @NotBlank
        @Email(message = "Email not valid.")
        String email,

        @NotBlank
        @Pattern(
                regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
                message = "Password must include at least one uppercase letter, one lowercase letter, one digit, one special character, and be at least eight characters long."
        )
        String password
) {
}
