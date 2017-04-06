package mt.com.bank.ws.controller;

import mt.com.bank.ws.pojo.Account;
import mt.com.bank.ws.pojo.Client;
import mt.com.bank.ws.pojo.Transaction;
import mt.com.bank.ws.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Waylon.Mifsud
 * @since 22/10/2015
 *
 * This is the REST layer where requests are
 * received and processed via the bankService bean.
 */
@RestController
public class BankController
{
    private static final Logger LOG = LoggerFactory.getLogger(BankController.class);

    @Autowired
    private BankService bankService;

    /**
     * Method used to create a new client.
     * @param client the {@link Client} object having all client information.
     * @return the persisted {@link Client} object with its related id.
     */
    @RequestMapping(value = "/createClient", method = RequestMethod.POST)
    public Client createClient(@Validated @RequestBody Client client)
    {
        LOG.info("Received request to createClient with: {}", client);
        Client returned = bankService.createClient(client);
        LOG.debug("Successful request for createClient with: {}", returned);
        return returned;
    }

    /**
     * Method used to retrieve all clients.
     * @return {@link List<Client>}.
     */
    @RequestMapping(value = "/getClients", method = RequestMethod.GET)
    public List<Client> getClients()
    {
        LOG.info("Received request to getClients");
        return bankService.getClients();
    }

    /**
     * Method used to get client information using the provided client id.
     * @param clientId {@link Long}
     * @return {@link Client}
     */
    @RequestMapping(value = "/{clientId}/getClientDetails", method = RequestMethod.GET)
    public Client getClientDetails(@PathVariable Long clientId)
    {
        LOG.info("Received request to getClientDetails for clientId: {}", clientId);
        return bankService.getClientById(clientId);
    }

    /**
     * Method used to create an account for the provided client id.
     * @param clientId {@link Long} the client id for which the account needs to be created.
     * @param account {@link Account} the account object which needs to be created.
     * @return {@link Account} with its persisted account id.
     */
    @RequestMapping(value = "/{clientId}/createClientAccount", method = RequestMethod.POST)
    public Account createClientAccount(@PathVariable Long clientId, @Validated @RequestBody Account account)
    {
        LOG.info("Received request to createClientAccount for clientId: {} with account: {}", clientId, account);
        return bankService.createAccountByClientId(clientId, account);
    }

    /**
     * Method used to create an account for the provided client id.
     * @param transaction {@link Transaction} the transaction which needs to be processed.
     * @return {@link Transaction} with its persisted transaction id.
     */
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public Transaction transfer(@Validated @RequestBody Transaction transaction)
    {
        LOG.info("Received request to transfer funds with transaction: {}", transaction);
        return bankService.transfer(transaction);
    }

    /**
     * Method used to get all account related to a particular client.
     * @param clientId {@link Long}
     * @return {@link List<Account>}
     */
    @RequestMapping(value = "/{clientId}/getAccountsByClientId", method = RequestMethod.GET)
    public List<Account> getAccountsByClientId(@PathVariable Long clientId)
    {
        LOG.info("Received request to getAccountsByClientId with clientId: {}", clientId);
        return bankService.getAccountsByClientId(clientId);
    }

    /**
     * Method used to get all transaction related to a particular account.
     * @param accountId {@link Long}
     * @return {@link List<Transaction>}
     */
    @RequestMapping(value = "/{accountId}/getAccountTransactions", method = RequestMethod.GET)
    public List<Transaction> getAccountTransactions(@PathVariable Long accountId)
    {
        LOG.info("Received request to getAccountTransactions with accountId: {}", accountId);
        return bankService.getTransactionsByAccountId(accountId);
    }
}