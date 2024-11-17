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

import java.util.LinkedList;
import java.util.NoSuchElementException;


public class LinkList {

  private static class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }

    Node(int value) {
      this.value = value;
      this.next = null;
    }

    @Override
    public String toString() {
      if (next == null) {
        return String.valueOf(value);
      }
      return value + "," + next;
    }
  }

  private Node head;

  LinkList() {
    this.head = null;
  }

  void addFirst(int element) {
    if (head == null) {
      head = new Node(element, null);
    } else {
      head = new Node(element, head);
    }
  }

  public int removeFirst() {
    if (head == null) {
      throw new NoSuchElementException();
    } else {
    }
    Node previous_head = head;
      head = head.next;
      return previous_head.value;
  }
  public int length(){
    int count = 0;
    while (head!= null){
      count+=1;
      head = head.next;
    }
    return count;
  }

  public int get(int position){
    //if (position < 0) {throw new NoSuchElementException();}
    if (position == 0) {
      Node current_value = head;
      return current_value.value;
    }
    else {
      removeFirst();
      get(position-1);
    }
    Node current_value = head;
    return current_value.value;
  }

  public static LinkList create(int[] elements){
      LinkList newlist = new LinkList();
      for (int i = elements.length -1; i >= 0; i--){
          newlist.addFirst(elements[i]);
      }
      return newlist;
  }

  ;
  @Override
  public String toString() {
    return String.format("[%s]", head == null ? "" : head.toString());
  }
}
