package mt.com.bank.data.entity;

import javax.persistence.*;

/**
 * @author Waylon.Mifsud
 * @since 22/10/2015
 */
@Entity(name = "address")
public class AddressE
{
    @Id
    @SequenceGenerator(name="address_addressid_seq", sequenceName="address_addressid_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="address_addressid_seq")
    private Long addressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
