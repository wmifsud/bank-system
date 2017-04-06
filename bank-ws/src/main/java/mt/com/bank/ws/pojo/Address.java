package mt.com.bank.ws.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Waylon.Mifsud
 * @since 23/10/2015
 */
public class Address
{
    private Long addressId;
    @NotNull(message = "address line 1 is mandatory")
    @Size(min = 1, message = "please enter address line 1")
    private String addressLine1;
    private String addressLine2;
    @NotNull(message = "city is mandatory")
    @Size(min = 1, message = "please enter city")
    private String city;
    @NotNull(message = "country is mandatory")
    @Size(min = 1, message = "please enter country")
    private String country;

    public Address() {
    }

    public Address(Long addressId, String addressLine1, String addressLine2, String city, String country) {
        this.addressId = addressId;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
    }

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
