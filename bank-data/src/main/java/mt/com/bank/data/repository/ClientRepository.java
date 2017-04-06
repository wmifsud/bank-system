package mt.com.bank.data.repository;

import mt.com.bank.data.entity.ClientE;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Waylon.Mifsud
 * @since 23/10/2015
 */
public interface ClientRepository extends JpaRepository<ClientE, Long>
{

}
