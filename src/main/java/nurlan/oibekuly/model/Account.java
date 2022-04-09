package nurlan.oibekuly.model;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Scope("prototype")
@Component
@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ACCOUNTNUMBER")
    public Long accountNumber;

    @Column(name = "BALANCE")
    public double balance;

    @Column(name = "INTEREST")
    private double interest;
}
