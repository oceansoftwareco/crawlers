package pro.ivanov.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class News extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String url;

    private LocalDateTime date;

    @ManyToOne
    private Source source;
}
