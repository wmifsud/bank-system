package mt.com.bank.ws.pojo;

import org.joda.time.LocalDateTime;

import javax.validation.constraints.NotNull;

/**
 * @author Waylon.Mifsud
 * @since 22/10/2015
 */
public class Transaction
{
    private Long transactionId;
    @NotNull(message = "debit account id is mandatory")
    private Long debitAccountId;
    @NotNull(message = "credit account id is mandatory")
    private Long creditAccountId;
    @NotNull(message = "amount is mandatory")
    private Double amount;
    private String message;
    @NotNull(message = "date created is mandatory")
    private LocalDateTime dateCreated;

    public Transaction() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getDebitAccountId() {
        return debitAccountId;
    }

    public void setDebitAccountId(Long debitAccountId) {
        this.debitAccountId = debitAccountId;
    }

    public Long getCreditAccountId() {
        return creditAccountId;
    }

    public void setCreditAccountId(Long creditAccountId) {
        this.creditAccountId = creditAccountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}