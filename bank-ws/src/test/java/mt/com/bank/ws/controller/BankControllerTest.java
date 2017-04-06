package mt.com.bank.ws.controller;

import com.google.gson.Gson;
import mt.com.bank.conf.PropertiesTest;
import mt.com.bank.ws.config.Application;
import mt.com.bank.ws.pojo.*;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Waylon.Mifsud
 * @since 23/10/2015
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class, PropertiesTest.class})
public class BankControllerTest
{
    @Autowired
    public WebApplicationContext wac;

    public MockMvc mockMvc;

    private static final String CREATE_CLIENT_URL = "/createClient";
    private static final String LIST_CLIENTS_URL = "/getClients";

    public static final String EMPTY_NAME_MSG = "please enter name";
    public static final String NAME_MANDATORY_MSG = "name is mandatory";
    public static final String EMPTY_SURNAME_MSG = "please enter surname";
    public static final String SURNAME_MANDATORY_MSG = "surname is mandatory";
    public static final String PRIMARY_ADDRESS_MANDATORY_MSG = "primary address is mandatory";
    public static final String CLIENT_DOES_NOT_EXIST = "java.lang.RuntimeException: Client with id: -1 does not exist";
    public static final String DEBIT_ACCOUNT_DOES_NOT_EXIST = "java.lang.RuntimeException: Debit account does not exist: -1";
    public static final String CREDIT_ACCOUNT_DOES_NOT_EXIST = "java.lang.RuntimeException: Credit account does not exist: -1";

    //Required to convert objects to json objects when sending rest requests.
    private static Gson gson = new Gson();

    private static String convertToJsonString(Object o)
    {
        return gson.toJson(o);
    }

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * Test should successfully manage to create
     * a new {@link Client} with its respective addresses
     * and accounts objects.
     * @throws Exception in case something goes wrong during execution.
     */
    @Test
    public void createClientTest() throws Exception
    {
        Client client = new Client
        (
            null,
            "waylon",
            "mifsud",
            new Address
            (
                null,
                "Triq",
                "Skuna",
                "Qawra",
                "Malta"
            ),
            new Address
            (
                null,
                "Pioneer",
                "Road",
                "London",
                "England"
            ),
            Arrays.asList
            (
                new Account
                (
                    null,
                    AccountType.SAVINGS,
                    100D,
                    BalanceStatus.CR,
                    LocalDateTime.now()
                ),
                new Account
                (
                    null,
                    AccountType.CURRENT,
                    100D,
                    BalanceStatus.DR,
                    LocalDateTime.now()
                )
            )
        );

        mockMvc.perform(post(CREATE_CLIENT_URL)
                .content(convertToJsonString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Test should successfully manage to create
     * a new {@link Client} with its respective addresses only.
     * @throws Exception in case something goes wrong during execution.
     */
    @Test
    public void createClientNoAccountsTest() throws Exception
    {
        Client client = new Client
        (
            null,
            "waylon",
            "mifsud",
            new Address
            (
                null,
                "Triq",
                "Skuna",
                "Qawra",
                "Malta"
            ),
            new Address
            (
                null,
                "Pioneer",
                "Road",
                "London",
                "England"
            ),
            null
        );

        mockMvc.perform(post(CREATE_CLIENT_URL)
                .content(convertToJsonString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Test should successfully return an error that the primary address is mandatory.
     * @throws Exception in case something goes wrong during execution.
     */
    @Test
    public void createClientNoPrimaryAddressTest() throws Exception
    {
        Client client = new Client
        (
            null,
            "waylon",
            "mifsud",
            null,
            new Address
            (
                null,
                "Pioneer",
                "Road",
                "London",
                "England"
            ),
            Arrays.asList
            (
                new Account
                (
                    null,
                    AccountType.SAVINGS,
                    100D,
                    BalanceStatus.CR,
                    LocalDateTime.now()
                ),
                new Account
                (
                    null,
                    AccountType.CURRENT,
                    100D,
                    BalanceStatus.DR,
                    LocalDateTime.now()
                )
            )
        );

        mockMvc.perform(post(CREATE_CLIENT_URL)
                .content(convertToJsonString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().string(PRIMARY_ADDRESS_MANDATORY_MSG))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test should return an error since mandatory name was not provided.
     * @throws Exception in case something goes wrong during execution.
     */
    @Test
    public void createClientNoNameTest() throws Exception
    {
        Client client = new Client
        (
            null,
            null,
            "mifsud",
            new Address
            (
                null,
                "Triq",
                "Skuna",
                "Qawra",
                "Malta"
            ),
            new Address
            (
                null,
                "Pioneer",
                "Road",
                "London",
                "England"
            ),
            null
        );

        mockMvc.perform(post(CREATE_CLIENT_URL)
                .content(convertToJsonString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().string(NAME_MANDATORY_MSG))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test should return an error since mandatory name was left empty.
     * @throws Exception in case something goes wrong during execution.
     */
    @Test
    public void createClientEmptyNameTest() throws Exception
    {
        Client client = new Client
        (
            null,
            "",
            "mifsud",
            new Address
            (
                null,
                "Triq",
                "Skuna",
                "Qawra",
                "Malta"
            ),
            new Address
            (
                null,
                "Pioneer",
                "Road",
                "London",
                "England"
            ),
            null
        );

        mockMvc.perform(post(CREATE_CLIENT_URL)
                .content(convertToJsonString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().string(EMPTY_NAME_MSG))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test should return an error since mandatory surname was not provided.
     * @throws Exception in case something goes wrong during execution.
     */
    @Test
    public void createClientNoSurnameTest() throws Exception
    {
        Client client = new Client
        (
            null,
            "waylon",
            null,
            new Address
            (
                null,
                "Triq",
                "Skuna",
                "Qawra",
                "Malta"
            ),
            new Address
            (
                null,
                "Pioneer",
                "Road",
                "London",
                "England"
            ),
            null
        );

        mockMvc.perform(post(CREATE_CLIENT_URL)
                .content(convertToJsonString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().string(SURNAME_MANDATORY_MSG))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test should return an error since mandatory surname was left empty.
     * @throws Exception in case something goes wrong during execution.
     */
    @Test
    public void createClientEmptySurnameTest() throws Exception
    {
        Client client = new Client
        (
            null,
            "waylon",
            "",
            new Address
            (
                null,
                "Triq",
                "Skuna",
                "Qawra",
                "Malta"
            ),
            new Address
            (
                null,
                "Pioneer",
                "Road",
                "London",
                "England"
            ),
            null
        );

        mockMvc.perform(post(CREATE_CLIENT_URL)
                .content(convertToJsonString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().string(EMPTY_SURNAME_MSG))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test asserts that successful response
     * is returned with list of clients.
     * @throws Exception
     */
    @Test
    public void getAllClientsTest() throws Exception
    {
        mockMvc.perform(get(LIST_CLIENTS_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Test asserts that successful response
     * is returned for a particular client.
     * @throws Exception
     */
    @Test
    public void getClientByIdTest() throws Exception
    {
        mockMvc.perform(get("/33/getClientDetails")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Test asserts that successful response
     * is returned when creating a new account for a particular client.
     * @throws Exception
     */
    @Test
    public void createClientAccountTest() throws Exception
    {
        Account account = new Account();
        account.setBalance(100D);
        account.setStatus(BalanceStatus.CR);
        account.setDateCreated(LocalDateTime.now());
        account.setType(AccountType.SAVINGS);
        System.out.println(convertToJsonString(account));
        mockMvc.perform(post("/36/createClientAccount")
                .content(convertToJsonString(account))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Test asserts that an error is returned since
     * account creation was done to a non existing client.
     * @throws Exception
     */
    @Test
    public void createAccountNonExistingClientTest() throws Exception
    {
        Account account = new Account();
        account.setBalance(100D);
        account.setStatus(BalanceStatus.CR);
        account.setDateCreated(LocalDateTime.now());
        account.setType(AccountType.SAVINGS);
        System.out.println(convertToJsonString(account));
        mockMvc.perform(post("/-1/createClientAccount")
                .content(convertToJsonString(account))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(CLIENT_DOES_NOT_EXIST))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * Test asserts that successful response
     * is returned when retrieving accounts for a particular client.
     * @throws Exception
     */
    @Test
    public void getAccountsByClientIdTest() throws Exception
    {
        mockMvc.perform(get("/33/getAccountsByClientId")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Test asserts that successful response
     * is returned when carrying out a transfer
     * between two retrieving accounts.
     * @throws Exception
     */
    @Test
    public void transferTest() throws Exception
    {
        Transaction transaction = new Transaction();
        transaction.setAmount(107.64896D);
        transaction.setCreditAccountId(74L);
        transaction.setDebitAccountId(75L);
        transaction.setMessage("transfer between accounts");
        transaction.setDateCreated(LocalDateTime.now());
        System.out.println(convertToJsonString(transaction));
        mockMvc.perform(post("/transfer")
                .content(convertToJsonString(transaction))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Test asserts that an error is returned
     * since the debit account does not exist.
     * @throws Exception
     */
    @Test
    public void transferDebitAccountNonExistingTest() throws Exception
    {
        Transaction transaction = new Transaction();
        transaction.setAmount(107.64896D);
        transaction.setCreditAccountId(74L);
        transaction.setDebitAccountId(-1L);
        transaction.setMessage("transfer between accounts");
        transaction.setDateCreated(LocalDateTime.now());
        System.out.println(convertToJsonString(transaction));
        mockMvc.perform(post("/transfer")
                .content(convertToJsonString(transaction))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(DEBIT_ACCOUNT_DOES_NOT_EXIST))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * Test asserts that an error is returned
     * since the credit account does not exist.
     * @throws Exception
     */
    @Test
    public void transferCreditAccountNonExistingTest() throws Exception
    {
        Transaction transaction = new Transaction();
        transaction.setAmount(107.64896D);
        transaction.setCreditAccountId(-1L);
        transaction.setDebitAccountId(75L);
        transaction.setMessage("transfer between accounts");
        transaction.setDateCreated(LocalDateTime.now());
        System.out.println(convertToJsonString(transaction));
        mockMvc.perform(post("/transfer")
                .content(convertToJsonString(transaction))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(CREDIT_ACCOUNT_DOES_NOT_EXIST))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * Test asserts that successful response
     * is returned when retrieving transactions
     * for a particular account.
     * @throws Exception
     */
    @Test
    public void getTransactionsByAccountIdTest() throws Exception
    {
        mockMvc.perform(get("/22/getAccountTransactions")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
