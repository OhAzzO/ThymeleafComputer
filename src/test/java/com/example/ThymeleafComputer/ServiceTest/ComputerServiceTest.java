package com.example.ThymeleafComputer.ServiceTest;

import com.example.ThymeleafComputer.Entity.Computer;
import com.example.ThymeleafComputer.Repository.ComputerRepository;
import com.example.ThymeleafComputer.Service.ComputerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@ExtendWith(SpringExtension.class)
public class ComputerServiceTest {

    @MockBean
    private ComputerRepository computerRepository;

    private ComputerService fixture;

    @BeforeEach
    public void setUp() {
        fixture = new ComputerService(computerRepository);
    }

    // Test method to get and return computer when one exists.
    @Test
    public void getReturnComputer_WhenComputerExist() {
        final UUID computerId = randomUUID();

        final Computer computer = new Computer(randomUUID(), randomUUID().toString(), randomUUID().toString(), UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);

        final Optional<Computer> expected = Optional.of(computer);

        given(computerRepository.findById(computerId)).willReturn(expected);

        Optional<Computer> actual = fixture.getComputer(computerId);

        assertThat(actual).isEqualTo(expected);

        then(computerRepository).should().findById(computerId);
        then(computerRepository).shouldHaveNoMoreInteractions();
    }

    // Test method to get and return computer when one does not exist.
    @Test
    public void getReturnComputer_WhenComputerDoesNotExist() {
        final UUID computerId = randomUUID();

        final Optional<Computer> expected = Optional.empty();

        given(computerRepository.findById(computerId)).willReturn(expected);

        Optional<Computer> actual = fixture.getComputer(computerId);

        assertThat(actual).isEqualTo(expected);

        then(computerRepository).should().findById(computerId);
        then(computerRepository).shouldHaveNoMoreInteractions();
    }

    // Test method to save and return when record is created.
    @Test
    public void save_ReturnWhenComputerIsCreated() {

        final UUID computerId = randomUUID();

        final Computer expected = new Computer();
        expected.setOverview(randomUUID().toString());
        expected.setSystemComponents(randomUUID().toString());
        expected.setPrice(randomUUID().getMostSignificantBits());

        given(computerRepository.save(expected)).willAnswer(invocation -> {

           final Computer toSave = invocation.getArgument(0);

           toSave.setComputerId(computerId);

           return toSave;
        });

        final Computer actual = fixture.save(expected);

        assertThat(actual).isEqualTo(expected);

        then(computerRepository).should().save(expected);
        then(computerRepository).shouldHaveNoMoreInteractions();
    }

    // Test method to delete computers when exists.
    @Test
    public void deleteComputer_WhenExists() {

        final UUID computerId = randomUUID();

        willDoNothing().given(computerRepository).deleteById(computerId);

        fixture.delete(computerId);

        then(computerRepository).should().deleteById(computerId);
        then(computerRepository).shouldHaveNoMoreInteractions();
    }

}
