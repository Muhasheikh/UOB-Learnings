package com.selenium.learnings.iocDI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ComputerTest {
    @Mock
    Keyboard keyboard;

    @InjectMocks
    Computer computer;

//    @BeforeEach
//    void setUp() {
//        computer = new Computer(keyboard);
//    }

    @Test
    void start() {
        computer.start();

    }
}