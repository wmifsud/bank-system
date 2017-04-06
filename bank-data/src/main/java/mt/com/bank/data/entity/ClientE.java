package mt.com.bank.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Waylon.Mifsud
 * @since 22/10/2015
 */
@Entity
@Table(name = "client")
public class ClientE implements Serializable
{
    @Id
    @SequenceGenerator(name="client_clientid_seq", sequenceName="client_clientid_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="client_clientid_seq")
    private Long clientId;
    private String name;
    private String surname;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "primaryaddressid")
    private AddressE primaryAddress;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "secondaryaddressid")
    private AddressE secondaryAddress;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name="clientaccountid")
    private List<AccountE> accountList = new ArrayList<>();

    public ClientE() {
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

    public AddressE getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(AddressE primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public AddressE getSecondaryAddress() {
        return secondaryAddress;
    }

    public void setSecondaryAddress(AddressE secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
    }

    public List<AccountE> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<AccountE> accountList) {
        this.accountList = accountList;
    }
}
