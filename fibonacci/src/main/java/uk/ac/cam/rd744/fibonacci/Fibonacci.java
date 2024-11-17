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

import java.util.HashMap;

/** A class to compute Fibonacci numbers using a simple recursive approach. */
class Fibonacci {
  HashMap<Integer,Integer> map = new HashMap<>();  // 2
  public int fib() {
    map.put(1, 2); // 3
    map.put(3, 4);
    map.put(1, 5);
    return map.get(1);
  }
  /**
   * Compute a Fibonacci number.
   *
   * @param i the index in the Fibonacci sequence
   * @return the Fibonacci number for this index
   */
  //Plan: if there is no value, null pointer exception. if there is, use 2 previous ones and go from there




  int fib(int i) {
    if (i<0) throw new IllegalArgumentException();
    if (i < 3) return 1;


    return fib(i-1) + fib(i-2);
  }
}
