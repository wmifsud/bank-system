package mt.com.bank.data.repository;

import mt.com.bank.data.entity.TransactionE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Waylon.Mifsud
 * @since 24/10/2015
 */
public interface TransactionRepository extends JpaRepository<TransactionE, Long>
{
    List<TransactionE> findByDebitAccountIdOrCreditAccountId(Long accountId1, Long accountId2);
}