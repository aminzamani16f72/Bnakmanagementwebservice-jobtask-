package ir.mohaymen.javadevelopertask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String uniqueId;
    @Column(unique = true,nullable = true)
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String phoneNumber;
    private String address;
    private String postalCode;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<BankAccount> bankAccounts = new HashSet<>();



}
