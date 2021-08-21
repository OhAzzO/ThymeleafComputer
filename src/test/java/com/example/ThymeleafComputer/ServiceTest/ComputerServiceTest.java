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
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

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

}
