package mt.com.bank.ws.pojo;

import org.joda.time.LocalDateTime;

import javax.validation.constraints.NotNull;

/**
 * @author Waylon.Mifsud
 * @since 22/10/2015
 */
public class Account
{
    private Long accountId;
    @NotNull(message = "account type is mandatory")
    private AccountType type;
    @NotNull(message = "balance is mandatory")
    private Double balance;
    private BalanceStatus status;
    @NotNull(message = "date created is mandatory")
    private LocalDateTime dateCreated;

    public Account() {
    }

    public Account(Long accountId, AccountType type, Double balance, BalanceStatus status, LocalDateTime dateCreated) {
        this.accountId = accountId;
        this.type = type;
        this.balance = balance;
        this.status = status;
        this.dateCreated = dateCreated;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public BalanceStatus getStatus() {
        return status;
    }

    public void setStatus(BalanceStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}