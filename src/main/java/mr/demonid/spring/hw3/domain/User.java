package mr.demonid.spring.hw3.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@Schema(description = "Пользователь")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Schema(description = "Имя пользователя")
    @NotBlank
    private String name;

    @Column(name = "age")
    @Schema(description = "Возраст пользователя")
    private int age;

    @Column(name = "email")
    @Schema(description = "Электронная почта пользователя")
    private String email;

}
