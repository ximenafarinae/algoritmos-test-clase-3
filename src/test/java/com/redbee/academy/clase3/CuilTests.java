package com.redbee.academy.clase3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CuilTests {

    @Test
    void testCuil() {
        Assertions.assertEquals(6, Cuil.calcular(20, 12345678));
    }
}
