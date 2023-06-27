package pro.ivanov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Source extends BaseEntity {
    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    private String shortName;

    @Column(nullable = false)
    private String url;

    @OneToMany
    private Set<News> news = new HashSet<>();
}
