package com.showcase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "bank_account")
    private String bankAccount;
    @Column(name = "status")
    private String status;

}
