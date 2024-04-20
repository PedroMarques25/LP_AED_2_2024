package edu.ufp.inf.projeto;

import Integer;

public class BD implements BSTI, HashmapI{

  public Integer ArrayList;

  @override
  public void put(Key key, Value val) {
    root = put(root, key, val);
  }
  @override
  private Node put(Node x, Key key, Value val) {

    if (h == null) return new Node(key, val, RED);
    int cmp = key.compareTo(h.key);
    if (cmp < 0) h.left = put(h.left, key, val);
    else if (cmp > 0) h.right = put(h.right, key, val);
    else if (cmp == 0) h.val = val;
    if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
    if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
    if (isRed(h.left) && isRed(h.right)) flipColors(h);
    return h;
  }
  @override
  public Value get(Key key) {

    Node x = root;
    while (x != null)
    {
      int cmp = key.compareTo(x.key);
      if (cmp < 0) x = x.left;
      else if (cmp > 0) x = x.right;
      else if (cmp == 0) return x.val;
    }
    return null;
  }
  @override
  public void delete(Key key) {
    root = delete(root, key);
  }
  @override
  private boolean isRed(Node x) {

    if (x == null) return false;
    return x.color == RED;
  }
  @override
  private Node rotateLeft(Node h) {

    assert isRed(h.right);
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    return x;
  }
  @override
  private Node rotateRight(Node h) {

    assert isRed(h.left);
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    return x;
  }
  @override
  private void flipColors(Node h) {

    assert !isRed(h);
    assert isRed(h.left);
    assert isRed(h.right);
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
  }
  @override
  private Node delete(Node x, Key key) {
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp < 0) x.left = delete(x.left, key);
    else if (cmp > 0) x.right = delete(x.right, key);
    else {
      if (x.right == null) return x.left;
      if (x.left == null) return x.right;
      Node t = x;
      x = min(t.right);
      x.right = deleteMin(t.right);
      x.left = t.left;
    }
    x.count = size(x.left) + size(x.right) + 1;
    return x;
  }
  @override
  private int hash(K key) {
    return key.hashCode() % capacity;
  }

  @override
  public void put(K key, V value) {
    int index = hash(key);
    Node<K, V> node = table[index];
    while (node != null) {
      if (node.key.equals(key)) {
        node.value = value;
        return;
      }
      node = node.next;
    }
    Node<K, V> newNode = new Node<>(key, value);
    newNode.next = table[index];
    table[index] = newNode;
    size++;
    if (size > capacity * loadFactor) {
      resize();
    }
  }

  @override
  public V get(K key) {
    int index = hash(key);
    Node&lt;K, V&gt; node = table[index];
    while (node != null) {
      if (node.key.equals(key)) {
        return node.value;
      }
      node = node.next;
    }
    return null;
  }
  @override
  public void remove(K key) {
    int index = hash(key);
    Node&lt;K, V&gt; node = table[index];
    Node&lt;K, V&gt; prev = null;
    while (node != null) {
      if (node.key.equals(key)) {
        if (prev == null) {
          table[index] = node.next;
        } else {
          prev.next = node.next;
        }
        size--;
        return;
      }
      prev = node;
      node = node.next;
    }
  }
  @override
  private void resize() {
    int newCapacity = capacity * 2;
    Node<K, V>[] newTable = new Node[newCapacity];
    for (int i = 0; i < capacity; i++) {
      Node<K, V> node = table[i];
      while (node != null) {
        Node<K, V> next = node.next;
        int index = hash(node.key);
        node.next = newTable[index];
        newTable[index] = node;
        node = next;
      }
    }
    table = newTable;
    capacity = newCapacity;
  }


}