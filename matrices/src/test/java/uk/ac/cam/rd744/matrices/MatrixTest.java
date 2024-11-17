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

package uk.ac.cam.rd744.matrices;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MatrixTest {

  @Test
  public void add_producesCorrectAnswer() {
    // ARRANGE
    Matrix a =
        new Matrix(
            new double[][] {
              {1, 2, 3}, //
              {4, 5, 6}
            });
    Matrix b =
        new Matrix(
            new double[][] {
              {7, 8, 9}, //
              {10, 11, 12},
            });

    // ACT
    Matrix c = a.add(b);

    // ASSERT
    assertThat(c.get(0, 0)).isWithin(1E-7).of(8);
    assertThat(c.get(0, 1)).isWithin(1E-7).of(10);
    assertThat(c.get(0, 2)).isWithin(1E-7).of(12);
    assertThat(c.get(1, 0)).isWithin(1E-7).of(14);
    assertThat(c.get(1, 1)).isWithin(1E-7).of(16);
    assertThat(c.get(1, 2)).isWithin(1E-7).of(18);
  }
  @Test
  public void transpose_producesCorrectAnswer() {
    // ARRANGE
    Matrix a =
            new Matrix(
                    new double[][]{
                            {1, 2, 3}, //
                            {4, 5, 6}
                    });

    Matrix b = a.transpose();

    assertThat(b.get(0, 0)).isEqualTo(1);
    assertThat(b.get(1, 0)).isEqualTo(2);
    assertThat(b.get(2, 0)).isEqualTo(3);
    assertThat(b.get(0, 1)).isEqualTo(4);
    assertThat(b.get(1, 1)).isEqualTo(5);
    assertThat(b.get(2, 1)).isEqualTo(6);
  }


@Test
  public void multiply_producesCorrectAnswer2x3with3x2() {
    // ARRANGE
    Matrix a =
            new Matrix(
                    new double[][]{
                            {1, 2, 3}, //
                            {4, 5, 6}
                    });
  Matrix b =
          new Matrix(
                  new double[][] {
                          {7,  8}, //
                          {9,  10},
                          {11, 12}
                  });

    Matrix c = a.mult(b);


  assertThat(c.get(0, 0)).isWithin(1E-7).of(58);
  assertThat(c.get(0, 1)).isWithin(1E-7).of(64);
  assertThat(c.get(1, 0)).isWithin(1E-7).of(139);
  assertThat(c.get(1, 1)).isWithin(1E-7).of(154);

  }

@Test
  public void multiply_producesCorrectAnswer3x2with2x3() {
    // ARRANGE
    Matrix a =
            new Matrix(
                    new double[][]{
                            {1, 2, 3}, //
                            {4, 5, 6}
                    });
    Matrix b =
            new Matrix(
                    new double[][] {
                            {7,  8}, //
                            {9,  10},
                            {11, 12}
                    });

    Matrix c = b.mult(a);

  assertThat(c.get(0, 0)).isWithin(1E-7).of(39);
  assertThat(c.get(0, 1)).isWithin(1E-7).of(54);
  assertThat(c.get(0, 2)).isWithin(1E-7).of(69);
  assertThat(c.get(1, 0)).isWithin(1E-7).of(49);
  assertThat(c.get(1, 1)).isWithin(1E-7).of(68);
  assertThat(c.get(1, 2)).isWithin(1E-7).of(87);
  assertThat(c.get(2, 0)).isWithin(1E-7).of(59);
  assertThat(c.get(2, 1)).isWithin(1E-7).of(82);
  assertThat(c.get(2, 2)).isWithin(1E-7).of(105);

  }
  @Test
    public void multiply_mismatched_dimensions(){
      Matrix a =
              new Matrix(
                      new double[][]{
                              {1, 2, 3}, //
                              {4, 5, 6}
                      });
      Matrix b =
              new Matrix(
                      new double[][] {
                              {7, 8, 9}, //
                              {10, 11, 12},
                      });
      assertThrows(IllegalArgumentException.class, () -> b.mult(a));
    }
  @Test
  public void add_mismatched_dimensions(){
    Matrix a =
            new Matrix(
                    new double[][]{
                            {1, 2, 3}, //
                            {4, 5, 6}
                    });
    Matrix b =
            new Matrix(
                    new double[][] {
                            {7,  8}, //
                            {9,  10},
                            {11, 12}
                    });
    assertThrows(IllegalArgumentException.class, () -> b.add(a));
  }
  @Test
  public void immutabilitytest(){
    Matrix a = new Matrix(
            new double[][]{
                    {1.0, 2.0, 3.0},
                    {4.0, 5.0, 6.0}
            });
    Matrix b =
            new Matrix(
                    new double[][] {
                            {7, 8, 9}, //
                            {10, 11, 12},
                    });
    b = a;
    assertThat(b.get(0, 0)).isEqualTo(1);

  }


  @Test
  public void tostring(){
    Matrix a = new Matrix(
            new double[][]{
                    {1.0, 2.0, 3.0},
                    {4.0, 5.0, 6.0}
            });
    String tostring = a.toString();
    String expected = "[[1.0, 2.0, 3.0], [4.0, 5.0, 6.0]]";
    assertThat(tostring).isEqualTo(expected);
  }
}
//  assertThrows(NoSuchElementException.class, ()-> containsElements.removeFirst());