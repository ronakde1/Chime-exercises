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
import java.util.Map;

/**
 * A class for computing Fibonacci numbers using the provided cache to reuse previously computed
 * values.
 */
class FibonacciTable {
  private final Map<Integer, Integer> cache;

  /** Constructs a new object with a default cache implementation. */
  FibonacciTable() {
    this(new HashMap<>());
  }

  /**
   * Constructs a new object using the provided cache implementation.
   *
   * @param cache the cache to use for storing computed values
   */
  FibonacciTable(Map<Integer, Integer> cache) {
    this.cache = cache;
  }

  /**
   * Compute a Fibonacci number.
   *
   * @param position the index in the Fibonacci sequence
   * @return the Fibonacci number for this index
   */
  int fib2(int x, int y, int left, int position) {
      if (left < 1) return x;
      int temp = x;

      x = y;
      y = temp + y;
      cache.put(position,x);
      cache.put(position+1,y);
      int check = cache.get(position);
      return fib2(x,y,(left-1),(position+1));

  }
  int fib(int i) {
      if (i<0) throw new IllegalArgumentException();
      int x = 0;
      int y = 1;
      int left = i;
      int currentposition = 0;

      for (int j = i ; j >= 0; j--){
      if (cache.containsKey(j)){
        x = cache.get(j-1);
        y = cache.get(j);
        currentposition = j;
        left = i - j;
        break;
      }
    }
      return fib2(x,y,(left),currentposition);


    // use the provided cache to reuse computed values
    // cache.containsKey(4) will return true if there is a value stored for the index 4
    // cache.get(4) will return the stored value for 4
    // cache.put(4,3) will store the value 3 for the index 4 in the cache
  }

}
