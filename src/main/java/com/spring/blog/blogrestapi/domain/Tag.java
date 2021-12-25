package com.spring.blog.blogrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String tagName;
    @JsonIgnoreProperties(ignoreUnknown = true,
            value = {"hibernateLazyInitializer", "handler","role"})
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "last_updated_by", referencedColumnName = "id")
    private User user;
    @JsonIgnore
    @ManyToMany(mappedBy ="tagSet", fetch = FetchType.LAZY)
    private Set<Blog> tagHashSet=new HashSet<>();
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;
}
