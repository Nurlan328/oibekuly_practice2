package nurlan.oibekuly.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Scope("prototype")
@Component
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private int id;

    @NotNull
    @NotEmpty
    @Column(name = "BANKNAME")
    private String bankName;

    @Column(name = "CUSTOMERACCOUNTNUMBER")
    private int customerAccountNumber;

//    @OneToMany
//    private static List<Customers> customers = Customers.getAllCustomers();
}