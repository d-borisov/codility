package com.dborisov.lesson_01_task_01_binaryGap;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UtilsTest {

    @Test
    public void testIntsCreation() throws Exception {
        assertThat(0b0, is(0));
        assertThat(0b1, is(1));
        assertThat(0b10, is(2));
        assertThat(0b11, is(3));
        assertThat(0b100, is(4));
        assertThat(0b101, is(5));
        assertThat(0b110, is(6));
        assertThat(0b111, is(7));
        assertThat(0b1000, is(8));
        assertThat(0b1001, is(9));
        assertThat(0b1010, is(10));
        assertThat(0b1011, is(11));
        assertThat(0b1100, is(12));
        assertThat(0b1101, is(13));
        assertThat(0b1110, is(14));
        assertThat(0b1111, is(15));
    }

    @Test
    public void fewSituations() throws Exception {
        assertThat(Integer.toBinaryString(2_147_483_646), is("1111111111111111111111111111110"));
        assertThat(Integer.toBinaryString(2_147_483_647), is("1111111111111111111111111111111"));
    }
}
