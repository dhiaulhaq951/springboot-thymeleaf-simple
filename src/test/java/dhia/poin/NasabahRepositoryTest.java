package dhia.poin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import dhia.poin.entity.Nasabah;
import dhia.poin.repository.NasabahRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class NasabahRepositoryTest {
	
	@Autowired
	private NasabahRepository nasrepo;
	
	@Test
	public void testCreateNasabah() {
		Nasabah n = new Nasabah();
		n.setAccountName("Customer1");
		
		Nasabah nsaved = nasrepo.save(n);
		assertThat(nsaved.getAccountId()).isGreaterThan(0);
	}

}
