package com.example.ThymeleafComputer.Repository;

import com.example.ThymeleafComputer.Entity.Computer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ComputerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ComputerRepository computerRepository;

    @Test
    public void save_StoredRecords() {
        final Computer expected = new Computer();
        expected.setOverview(randomUUID().toString());
        expected.setSystemComponents(randomUUID().toString());

        final Computer saved = computerRepository.save(expected);

        final Computer actual = entityManager.find(Computer.class, saved.getComputerId());


        assertThat(actual).isEqualTo(expected);
    }
}
