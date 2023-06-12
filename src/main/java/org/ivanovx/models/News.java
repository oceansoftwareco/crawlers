package org.ivanovx.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String url;

    private LocalDateTime date;

    private Source source;

    public News(String title, String content, String url, LocalDateTime date, Source source) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.date = date;
        this.source = source;
    }
}
