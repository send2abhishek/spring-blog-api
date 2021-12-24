package com.spring.blog.blogrestapi.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;

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
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "last_updated_by", referencedColumnName = "id")
    private User user;
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;
}
