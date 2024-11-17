/*
 * Copyright 2024 Andrew Rice <acr31@cam.ac.uk>, R. De
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.rd744.fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

@RunWith(JUnit4.class)
public class FibonacciTableTest {

  @Test
  public void fib_makesUseOfCache() {
    // Hint: use CountingMap!
    CountingMap countingMap = new CountingMap();
    FibonacciTable fib_table = new FibonacciTable(countingMap);

    FibonacciTable fibonacci = new FibonacciTable();
    int result1 = fibonacci.fib(9);
    int result2 = fibonacci.fib(7);
    int result3 = fibonacci.fib(11);
    assertThat(result1).isEqualTo(34);
    assertThat(result2).isEqualTo(13);
    assertThat(result3).isEqualTo(89);
  }
  @Test
  public void makesUseOfCache() {
    // Hint: use CountingMap!

    CountingMap countingMap = new CountingMap();

    FibonacciTable fibonacciTable = new FibonacciTable(countingMap);
    int result1 = fibonacciTable.fib(9);
    int result2 = fibonacciTable.fib(7);
    int result3 = fibonacciTable.fib(11);
    int result4 = fibonacciTable.fib(11);
    assertThat(result1).isEqualTo(34);
    assertThat(result2).isEqualTo(13);
    assertThat(result3).isEqualTo(89);
    assertThat(result4).isEqualTo(89);
    assertThat(countingMap.getCounter()).isEqualTo(17);

  }



  @Test
  public void fibonacci_returns1_for1() {
    // ARRANGE
    FibonacciTable fibonacci = new FibonacciTable();

    // ACT
    int result = fibonacci.fib(1);

    // ASSERT
    assertThat(result).isEqualTo(1);
  }
  @Test
  public void fibonacci_returns34_for9() {
    // ARRANGE
    FibonacciTable fibonacci = new FibonacciTable();

    // ACT
    int result = fibonacci.fib(9);

    // ASSERT
    assertThat(result).isEqualTo(34);
  }

  @Test
  public void fibonacci_returns34_for11() {
    // ARRANGE
    FibonacciTable fibonacci = new FibonacciTable();

    // ACT
    int result = fibonacci.fib(11);

    // ASSERT
    assertThat(result).isEqualTo(89);
  }
  @Test
  public void fibonacci_returns34_for7() {
    // ARRANGE
    FibonacciTable fibonacci = new FibonacciTable();

    // ACT
    int result = fibonacci.fib(7);

    // ASSERT
    assertThat(result).isEqualTo(13);
  }


  @Test
  public void fib_throwsIllegalArgumentException_atMinus1() {
    // ARRANGE
    FibonacciTable fibonacci = new FibonacciTable();

    // ACT
    // ASSERT
    assertThrows(IllegalArgumentException.class, () -> fibonacci.fib(-1));
  }
}
