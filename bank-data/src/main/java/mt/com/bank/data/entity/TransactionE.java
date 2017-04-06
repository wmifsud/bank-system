package mt.com.bank.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Waylon.Mifsud
 * @since 22/10/2015
 */
@Entity(name = "transaction")
public class TransactionE
{
    @Id
    @SequenceGenerator(name="transaction_transactionid_seq", sequenceName="transaction_transactionid_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="transaction_transactionid_seq")
    private Long transactionId;
    private Long debitAccountId;
    private Long creditAccountId;
    private Double amount;
    private String message;
    private Timestamp dateCreated;

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

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }
}
