package bm.app.watercollector.service;

import bm.app.watercollector.exception.ArrayTooSmallException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WaterServiceTest {

    WaterService waterService;

    @Test
    void shouldReturnSeven() throws ArrayTooSmallException {
        //given
        int[] array = {3, 0, 2, 0, 4};
        //then
        assertThat(waterService.maxWater(array)).isEqualTo(7);
    }

    @Test
    void shouldReturnThree() throws ArrayTooSmallException {
        //given
        int[] array = {1, 2, 0, 4, 3, 1, 2};
        //then
        assertThat(waterService.maxWater(array)).isEqualTo(3);
    }

    @Test
    void shouldThrowArrayTooSmallException() {
        //given
        int[] array = {2};
        //then
        assertThatExceptionOfType(ArrayTooSmallException.class).isThrownBy(() ->
                waterService.maxWaterForRestApi(array));
    }

    @BeforeEach
    void setUp() {
        waterService = new WaterService();
    }

}