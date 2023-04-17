package com.ny.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LruCache<K, V> {

    private final Map<K, Node<K, V>> map = new HashMap<>();
    private int usedCapacity;
    private final int totalCapacity;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LruCache(int totalCapacity) {
        this.totalCapacity = totalCapacity;
        this.usedCapacity = 0;
        this.head = new Node<>(null, null);//dummy head
        this.tail = new Node<>(null, null);//dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        V value;
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            value = node.val;
            moveToFrontOfQueue(node);
        } else {
            value = null;
        }
        return value;
    }

    public void put(K key, V value) {

        Node<K, V> existingNode = this.map.get(key);
        if (existingNode == null) {
            Node<K, V> node = new Node<>(key, value);
            map.put(key, node);
            addToFrontOfQueue(node);
            usedCapacity++;
            if (usedCapacity > totalCapacity) {
                Node<K, V> lastNode = tail.prev;
                removeFromQueue(lastNode);
                map.remove(lastNode.key);
                usedCapacity--;
            }
        } else {
            existingNode.val = value;
            moveToFrontOfQueue(existingNode);
        }
    }

    private void addToFrontOfQueue(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeFromQueue(Node<K, V> node) {
        Node<K, V> prevNode = node.prev;
        Node<K, V> nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void moveToFrontOfQueue(Node<K, V> node) {
        removeFromQueue(node);
        addToFrontOfQueue(node);
    }

    private static class Node<K, V> {
        K key;
        V val;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        Node<K, V> prev;
        Node<K, V> next;
    }
}
