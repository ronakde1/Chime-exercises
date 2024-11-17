/*
 * Copyright 2024 Ben Philps <bp413@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, R. De
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

package uk.ac.cam.rd744.linkedlists;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

@RunWith(JUnit4.class)
public class LinkListTest {

  @Test
  public void linkList_from_empty_Array_to_linkList(){
    int[] elements = {};
    LinkList empty = LinkList.create(elements);
    assertThat(empty.toString()).isEqualTo("[]");
  }
  @Test
  public void linkList_from_full_Array_to_linkList(){
    int[] elements = {1,2,3,4};
    LinkList containsElements = LinkList.create(elements);
    assertThat(containsElements.toString()).isEqualTo("[1,2,3,4]");
  }
  @Test
  public void linkList_from_full_remove_element(){
    int[] elements = {1,2,3,4};
    LinkList containsElements = LinkList.create(elements);
    containsElements.removeFirst();
    assertThat(containsElements.toString()).isEqualTo("[2,3,4]");
  }

  @Test
  public void linkList_from_one_remove_element(){
    LinkList containsElements = new LinkList();
    containsElements.addFirst(1);
    containsElements.removeFirst();
    assertThat(containsElements.toString()).isEqualTo("[]");
  }
@Test
public void linkList_from_null_remove_element(){
  int[] elements = {};
  LinkList containsElements = LinkList.create(elements);
  assertThrows(NoSuchElementException.class, ()-> containsElements.removeFirst());

}
@Test
public void linkList_length(){
    int[] elements = {1,2,3,4};
  LinkList containsElements = LinkList.create(elements);
  int count = containsElements.length();
  assertThat(count).isEqualTo(4);
}

  @Test
  public void linkList_toStringIsEmptyList_whenListEmpty() {
    // ARRANGE
    LinkList empty = new LinkList();

    // ACT
    String value = empty.toString();

    // ASSERT
    assertThat(value).isEqualTo("[]");
  }

  @Test
  public void linkList_toStringIsSingleItem_whenListContainsOneItem() {
    // ARRANGE
    LinkList list = new LinkList();
    list.addFirst(1);



    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[1]");
  }

  @Test
  public void getcheckvalid(){
    int[] elements = {1,2,3,5,7,11};
    LinkList containsElements = LinkList.create(elements);
    int element = containsElements.get(4);
    assertThat(element).isEqualTo(7);
  }
  @Test
  public void getcheckinvalid(){
    int[] elements = {1,2,3,5,7,11};
    LinkList containsElements = LinkList.create(elements);
    assertThrows(NoSuchElementException.class, ()-> containsElements.get(11));
  }

  @Test
  public void linkList_toStringIsTwoThenOne_whenListHasOneThenTwoAdded() {
    // ARRANGE
    LinkList list = new LinkList();
    list.addFirst(1);
    list.addFirst(2);

    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[2,1]");
  }
}
