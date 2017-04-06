package mt.com.bank.ws.service;

import ma.glasnost.orika.MapperFacade;
import mt.com.bank.data.entity.AccountE;
import mt.com.bank.data.entity.ClientE;
import mt.com.bank.data.entity.TransactionE;
import mt.com.bank.data.service.DataService;
import mt.com.bank.ws.pojo.Account;
import mt.com.bank.ws.pojo.Client;
import mt.com.bank.ws.pojo.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Waylon.Mifsud
 * @since 23/10/2015
 */
@Service
public class BankService
{
    @Autowired
    private MapperFacade mapper;
    @Autowired
    private DataService dataService;

    /**
     * Maps and sends the request to the data service layer to create a client.
     * @param client {@link Client}
     * @return {@link Client}
     */
    public Client createClient(Client client)
    {
        return mapper.map(dataService.saveClient(mapper.map(client, ClientE.class)), Client.class);
    }

    /**
     * Maps and sends the request to the data service layer to retrieve all clients.
     * @return {@link List<Client>}
     */
    public List<Client> getClients()
    {
        return mapper.mapAsList(dataService.findAllClients(), Client.class);
    }

    /**
     * Maps and sends the request to the data service layer to retrieve client by id.
     * @param clientId {@link Long}
     * @return {@link Client}
     */
    public Client getClientById(Long clientId)
    {
        return mapper.map(dataService.getClientById(clientId), Client.class);
    }

    /**
     * Maps and sends the request to the data service
     * layer to create an account for the provided clientId.
     * @param clientId {@link Long}
     * @param account {@link Account}
     * @return {@link Account}
     */
    public Account createAccountByClientId(Long clientId, Account account)
    {
        Client client = mapper.map(dataService.getClientById(clientId), Client.class);
        if (client == null)
        {
            throw new RuntimeException("Client with id: " + clientId + " does not exist");
        }
        return mapper.map(dataService.createAccountForClient(clientId, mapper.map(account, AccountE.class)), Account.class);
    }

    /**
     * Maps and sends the request to the data service
     * to retrieve all accounts for a particular client.
     * @param clientId {@link Long}
     * @return {@link List<Account>}
     */
    public List<Account> getAccountsByClientId(Long clientId)
    {
        return mapper.mapAsList(dataService.getAccountsByClientId(clientId), Account.class);
    }

    /**
     * Maps and sends the request to the data service
     * to execute a transfer between two accounts.
     * @param transaction {@link Transaction}
     * @return {@link Transaction}
     */
    public Transaction transfer(Transaction transaction)
    {
        return mapper.map(dataService.transfer(mapper.map(transaction, TransactionE.class)), Transaction.class);
    }

    /**
     * Maps and sends the request to the data service
     * to retrieve all transactions for a particular account.
     * @param accountId {@link Long}
     * @return {@link List<Transaction>}
     */
    public List<Transaction> getTransactionsByAccountId(Long accountId)
    {
        return mapper.mapAsList(dataService.getTransactionsByAccountId(accountId), Transaction.class);
    }
}
