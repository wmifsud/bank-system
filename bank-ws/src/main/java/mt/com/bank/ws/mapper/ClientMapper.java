package mt.com.bank.ws.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MappingContext;
import mt.com.bank.data.entity.AccountE;
import mt.com.bank.data.entity.AddressE;
import mt.com.bank.data.entity.ClientE;
import mt.com.bank.ws.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Waylon.Mifsud
 * @since 24/10/2015
 *
 * Client mapping class using Orika.
 */
@Component
public class ClientMapper extends CustomMapper<Client, ClientE>
{
    @Autowired
    private MapperFacade mapper;

    @Override
    public void mapAtoB(Client source, ClientE destination, MappingContext context)
    {
        destination.setClientId(source.getClientId());
        destination.setName(source.getName());
        destination.setSurname(source.getSurname());
        destination.setPrimaryAddress(mapper.map(source.getPrimaryAddress(), AddressE.class));
        destination.setSecondaryAddress(mapper.map(source.getSecondaryAddress(), AddressE.class));
        if (source.getAccountList() != null)
        {
            destination.setAccountList(mapper.mapAsList(source.getAccountList(), AccountE.class));
        }
    }

    @Override
    public void mapBtoA(ClientE source, Client destination, MappingContext context)
    {
        destination.setClientId(source.getClientId());
        destination.setName(source.getName());
        destination.setSurname(source.getSurname());
        destination.setPrimaryAddress(mapper.map(source.getPrimaryAddress(), Address.class));
        destination.setSecondaryAddress(mapper.map(source.getSecondaryAddress(), Address.class));
        if (source.getAccountList() != null)
        {
            destination.setAccountList(mapper.mapAsList(source.getAccountList(), Account.class));
        }
    }
}
