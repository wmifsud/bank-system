package mt.com.bank.ws.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Waylon.Mifsud
 * @since 22/10/2015
 */
public class Client
{
    private Long clientId;
    @NotNull(message = "name is mandatory")
    @Size(min = 1, message = "please enter name")
    private String name;
    @NotNull(message = "surname is mandatory")
    @Size(min = 1, message = "please enter surname")
    private String surname;
    @NotNull(message = "primary address is mandatory")
    private Address primaryAddress;
    private Address secondaryAddress;
    private List<Account> accountList = new ArrayList<>();

    public Client() {
    }

    public Client(Long clientId, String name, String surname, Address primaryAddress, Address secondaryAddress, List<Account> accountList) {
        this.clientId = clientId;
        this.name = name;
        this.surname = surname;
        this.primaryAddress = primaryAddress;
        this.secondaryAddress = secondaryAddress;
        this.accountList = accountList;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getSecondaryAddress() {
        return secondaryAddress;
    }

    public void setSecondaryAddress(Address secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}