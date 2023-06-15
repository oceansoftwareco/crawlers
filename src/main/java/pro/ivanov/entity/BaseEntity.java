package pro.ivanov.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PastOrPresent
    @Column(nullable = false, updatable = false)
    private LocalDateTime created = LocalDateTime.now();

    @PastOrPresent
    @Column(nullable = true)
    private LocalDateTime modified = null;
}
