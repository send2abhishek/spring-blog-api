package com.spring.blog.blogrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String categoryName;
    @JsonIgnoreProperties(ignoreUnknown = true,
            value = {"hibernateLazyInitializer", "handler","role"})
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "last_updated_by", referencedColumnName = "id")
    private User user;
    @JsonIgnore
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<Blog> students = new HashSet<>();
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return id != null && Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
