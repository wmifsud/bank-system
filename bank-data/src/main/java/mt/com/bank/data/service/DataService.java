package mt.com.bank.data.service;

import mt.com.bank.data.entity.AccountE;
import mt.com.bank.data.entity.ClientE;
import mt.com.bank.data.entity.TransactionE;
import mt.com.bank.data.repository.AccountRepository;
import mt.com.bank.data.repository.ClientRepository;
import mt.com.bank.data.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Waylon.Mifsud
 * @since 23/10/2015
 */
@Service
public class DataService
{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * Persists client to the database.
     * @param client {@link ClientE}
     * @return {@link ClientE}
     */
    public ClientE saveClient(ClientE client)
    {
        return clientRepository.save(client);
    }

    /**
     * Retrieves all clients from the database.
     * @return {@link List<ClientE>}
     */
    public List<ClientE> findAllClients()
    {
        return clientRepository.findAll();
    }

    /**
     * Retrieves a client from the database.
     * @param clientId {@link Long}
     * @return {@link ClientE}
     */
    public ClientE getClientById(Long clientId)
    {
        return clientRepository.findOne(clientId);
    }

    /**
     * Creates an account on the database for an existing client.
     * @param clientId {@link Long}
     * @param account {@link AccountE}
     * @return {@link AccountE}
     */
    public AccountE createAccountForClient(Long clientId, AccountE account)
    {
        account.setClientAccountId(clientId);
        return accountRepository.save(account);
    }

    /**
     * Retrieves all accounts related to a client.
     * @param clientId {@link Long}
     * @return {@link List<AccountE>}
     */
    public List<AccountE> getAccountsByClientId(Long clientId)
    {
        return accountRepository.findByClientAccountId(clientId);
    }

    /**
     * Registers transfer of funds to existing accounts on the database.
     * @param transaction {@link TransactionE}
     * @return {@link TransactionE}
     */
    public TransactionE transfer(TransactionE transaction)
    {
        AccountE fromAccount = accountRepository.findOne(transaction.getDebitAccountId());
        if (fromAccount == null)
        {
            throw new RuntimeException("Debit account does not exist: " + transaction.getDebitAccountId());
        }
        AccountE toAccount = accountRepository.findOne(transaction.getCreditAccountId());
        if (toAccount == null)
        {
            throw new RuntimeException("Credit account does not exist: " + transaction.getCreditAccountId());
        }
        fromAccount.setBalance(fromAccount.getBalance() - transaction.getAmount());
        accountRepository.save(fromAccount);
        toAccount.setBalance(toAccount.getBalance() + transaction.getAmount());
        accountRepository.save(toAccount);
        return transactionRepository.save(transaction);
    }

    /**
     * Retrieves all accounts related to an account.
     * @param accountId {@link Long}
     * @return {@link List<TransactionE>}
     */
    public List<TransactionE> getTransactionsByAccountId(Long accountId)
    {
        return transactionRepository.findByDebitAccountIdOrCreditAccountId(accountId, accountId);
    }
}
