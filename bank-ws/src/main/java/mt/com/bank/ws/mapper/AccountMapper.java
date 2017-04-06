package mt.com.bank.ws.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import mt.com.bank.data.entity.AccountE;
import mt.com.bank.data.entity.AccountTypeE;
import mt.com.bank.ws.pojo.Account;
import mt.com.bank.ws.pojo.AccountType;
import mt.com.bank.ws.pojo.BalanceStatus;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DecimalFormat;

/**
 * @author Waylon.Mifsud
 * @since 24/10/2015
 *
 * Account mapping class using Orika.
 */
@Component
public class AccountMapper extends CustomMapper<Account, AccountE>
{
    @Override
    public void mapAtoB(Account source, AccountE destination, MappingContext context)
    {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setGroupingUsed(false);
        source.setBalance(Double.valueOf(df.format(source.getBalance())));
        destination.setAccountId(source.getAccountId());
        destination.setDateCreated(new Timestamp(source.getDateCreated().toDate().getTime()));
        destination.setType(AccountTypeE.valueOf(source.getType().toString()));
        destination.setBalance(source.getStatus() == BalanceStatus.DR ? source.getBalance() * -1 : source.getBalance());
    }

    @Override
    public void mapBtoA(AccountE source, Account destination, MappingContext context)
    {
        destination.setAccountId(source.getAccountId());
        destination.setDateCreated(new LocalDateTime(source.getDateCreated()));
        destination.setType(AccountType.valueOf(source.getType().toString()));
        destination.setStatus(source.getBalance() < 0 ? BalanceStatus.DR : BalanceStatus.CR);
        destination.setBalance(Math.abs(source.getBalance()));
    }
}
