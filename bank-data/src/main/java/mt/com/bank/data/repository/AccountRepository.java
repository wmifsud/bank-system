package mt.com.bank.data.repository;

import mt.com.bank.data.entity.AccountE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Waylon.Mifsud
 * @since 24/10/2015
 */
public interface AccountRepository extends JpaRepository<AccountE, Long>
{
    List<AccountE> findByClientAccountId(Long clientId);
}