package uk.ac.cam.rd744.fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;


import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class lowestCommonTest {


    @Test
    public void comparebit_3_common_bit() {
        // ARRANGE
        lowestCommon bitsequence = new lowestCommon();

        // ACT
        int result = bitsequence.compare(14L,25L);

        // ASSERT
        assertThat(result).isEqualTo(3);
    }
    @Test
    public void comparebit_1_common_bit() {
        // ARRANGE
        lowestCommon bitsequence = new lowestCommon();

        // ACT
        int result = bitsequence.compare(155L,225L);

        // ASSERT
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void comparebit_no_common_bit() {
        // ARRANGE
        lowestCommon bitsequence = new lowestCommon();

        // ACT
        int result = bitsequence.compare(511L,512L);

        // ASSERT
        assertThat(result).isEqualTo(-1);
    }
    @Test
    public void comparebit_30_common_bit() {
        // ARRANGE
        lowestCommon bitsequence = new lowestCommon();

        // ACT
        int result = bitsequence.compare(1073741824L,1342177280L);

        // ASSERT
        assertThat(result).isEqualTo(30);
    }
    @Test
    public void comparebit_negatvie_common_bit() {
        // ARRANGE
        lowestCommon bitsequence = new lowestCommon();

        // ACT
        int result = bitsequence.compare(512L,-1L);

        // ASSERT
        assertThat(result).isEqualTo(9);
    }


}