package mt.com.bank.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Waylon.Mifsud
 * @since 22/10/2015
 */
@Entity(name = "account")
public class AccountE implements Serializable
{
    @Id
    @SequenceGenerator(name="account_accountid_seq", sequenceName="account_accountid_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="account_accountid_seq")
    private Long accountId;
    private Double balance;
    private Timestamp dateCreated;
    @Enumerated(EnumType.STRING)
    private AccountTypeE type;
    private Long clientAccountId;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public AccountTypeE getType() {
        return type;
    }

    public void setType(AccountTypeE type) {
        this.type = type;
    }

    public Long getClientAccountId() {
        return clientAccountId;
    }

    public void setClientAccountId(Long clientAccountId) {
        this.clientAccountId = clientAccountId;
    }
}
