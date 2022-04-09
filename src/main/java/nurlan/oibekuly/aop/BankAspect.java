package nurlan.oibekuly.aop;

import nurlan.oibekuly.model.Bank;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BankAspect {

    @Before("execution( * listOffBanks())")
    public String bankDetails() {
        Bank bank = new Bank();
        String bankInfo = "";
        bankInfo += "Bank id: "  + bank.getId() +
                "\n Bank name: " + bank.getBankName() +
                "\n Number of customer account " + bank.getCustomerAccountNumber();
        System.out.println("Method bankDetails() has worked");
        return bankInfo;
    }
}
