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
    @Column(unique = true,nullable = false)
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String phoneNumber;
    private String address;
    private String postalCode;
    @ManyToMany
    @JoinTable(
            name = "user_bank_account",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "bank_account_id")
    )
    private Set<BankAccount> bankAccounts = new HashSet<>();



}
