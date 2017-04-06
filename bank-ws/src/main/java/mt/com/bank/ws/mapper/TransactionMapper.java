package mt.com.bank.ws.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import mt.com.bank.data.entity.TransactionE;
import mt.com.bank.ws.pojo.Transaction;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DecimalFormat;

/**
 * @author Waylon.Mifsud
 * @since 24/10/2015
 *
 * Transaction mapping class using Orika.
 */
@Component
public class TransactionMapper extends CustomMapper<Transaction, TransactionE>
{
    @Override
    public void mapAtoB(Transaction source, TransactionE destination, MappingContext context)
    {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setGroupingUsed(false);
        source.setAmount(Double.valueOf(df.format(source.getAmount())));
        destination.setAmount(source.getAmount());
        destination.setDateCreated(new Timestamp(source.getDateCreated().toDate().getTime()));
        destination.setCreditAccountId(source.getCreditAccountId());
        destination.setDebitAccountId(source.getDebitAccountId());
        destination.setMessage(source.getMessage());
        destination.setTransactionId(source.getTransactionId());
    }

    @Override
    public void mapBtoA(TransactionE source, Transaction destination, MappingContext context)
    {
        destination.setAmount(source.getAmount());
        destination.setDateCreated(new LocalDateTime(source.getDateCreated()));
        destination.setCreditAccountId(source.getCreditAccountId());
        destination.setDebitAccountId(source.getDebitAccountId());
        destination.setMessage(source.getMessage());
        destination.setTransactionId(source.getTransactionId());
    }
}
