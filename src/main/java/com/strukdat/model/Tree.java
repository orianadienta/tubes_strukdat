package com.strukdat.model;

import com.strukdat.gimmick.*;
import java.util.List;
import java.util.ArrayList;

public class Tree<K extends Comparable<K>, V> {
    public Node<K, V> root;
    private Node<K, V> TNULL; //leaf atau node kosong

    public Tree() {
        TNULL = new Node<>(null, null);
        TNULL.setRed(false); // TNULL berwarna hitam
        TNULL.setLeft(null);
        TNULL.setRight(null);
        this.root = TNULL;
    }

    public List<String> search(String searchKey) {
        List<String> results = new ArrayList<>();
        searchRecursive(root, searchKey, results);
        return results;
    }

    private void searchRecursive(Node<K, V> node, String searchKey, List<String> results) {
        if (node == TNULL) return;

        if (matchesSearchCriteria(node.getKey().toString(), searchKey)) {
            if (node.getGimmick() != null) {
                results.add(node.getGimmick().runGimmick());
            } else {
                results.add(node.getValue().toString());
            }
        }
        searchRecursive(node.getLeft(), searchKey, results);
        searchRecursive(node.getRight(), searchKey, results);
    }

    private boolean matchesSearchCriteria(String fullKey, String searchKey) {
        String lowerFullKey = fullKey.toLowerCase();
        String lowerSearchKey = searchKey.toLowerCase();
        if (lowerFullKey.equals(lowerSearchKey)) return true;
        if (lowerFullKey.startsWith(lowerSearchKey)) return true;
        if (lowerFullKey.contains(lowerSearchKey)) return true;

        return false;
    }

    // method add untuk node dengan gimmick
    public void add(K key, V value, GimmickInterface gimmick) {
        Node<K, V> newNode = new Node<>(key, value, gimmick);
        newNode.setLeft(TNULL);
        newNode.setRight(TNULL);
        newNode.setParent(null);
        newNode.setRed(true);

        Node<K, V> parent = null;
        Node<K, V> currentNode = this.root;

        while (currentNode != TNULL) {
            parent = currentNode;
            if (newNode.getKey().compareTo(currentNode.getKey()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        newNode.setParent(parent);
        if (parent == null) {
            root = newNode;
        } else if (newNode.getKey().compareTo(parent.getKey()) < 0) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }

        if (newNode.getParent() == null) {
            newNode.setRed(false);
            return;
        }

        if (newNode.getParent().getParent() == null) {
            return;
        }
        fixAdd(newNode);
    }

    public void add(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        newNode.setLeft(TNULL);
        newNode.setRight(TNULL);
        newNode.setParent(null);
        newNode.setRed(true);
        newNode.key = key;
        newNode.value = value;

        Node<K, V> parent = null;
        Node<K, V> currentNode = this.root;

        while (currentNode != TNULL) {
            parent = currentNode;
            if (newNode.getKey().compareTo(currentNode.getKey()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        newNode.setParent(parent);
        if (parent == null) {
            root = newNode;
        } else if (newNode.getKey().compareTo(parent.getKey()) < 0) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }

        if (newNode.getParent() == null) {
            newNode.setRed(false);
            return;
        }

        if (newNode.getParent().getParent() == null) {
            return;
        }
        fixAdd(newNode);
    }

    private void fixAdd(Node<K, V> newNode) {
        Node<K, V> uncle;
        while (newNode.getParent().isRed()) {
            if (newNode.getParent() == newNode.getParent().getParent().getRight()) {
                uncle = newNode.getParent().getParent().getLeft();
                if (uncle.isRed()) {
                    uncle.setRed(false);
                    newNode.getParent().setRed(false);
                    newNode.getParent().getParent().setRed(true);
                    newNode = newNode.getParent().getParent();
                } else {
                    if (newNode == newNode.getParent().getLeft()) {
                        newNode = newNode.getParent();
                        rotateRight(newNode);
                    }
                    newNode.getParent().setRed(false);
                    newNode.getParent().getParent().setRed(true);
                    rotateLeft(newNode.getParent().getParent());
                }
            } else {
                uncle = newNode.getParent().getParent().getRight();
                if (uncle.isRed()) {
                    uncle.setRed(false);
                    newNode.getParent().setRed(false);
                    newNode.getParent().getParent().setRed(true);
                    newNode = newNode.getParent().getParent();
                } else {
                    if (newNode == newNode.getParent().getRight()) {
                        newNode = newNode.getParent();
                        rotateLeft(newNode);
                    }
                    newNode.getParent().setRed(false);
                    newNode.getParent().getParent().setRed(true);
                    rotateRight(newNode.getParent().getParent());
                }
            }
            if (newNode == root) {
                break;
            }
        }
        root.setRed(false);
    }

    private void rotateLeft(Node<K, V> node) {
        Node<K, V> rightChild = node.getRight();
        node.setRight(rightChild.getLeft());
        if (rightChild.getLeft() != TNULL) {
            rightChild.getLeft().setParent(node);
        }
        rightChild.setParent(node.getParent());
        if (node.getParent() == null) {
            root = rightChild;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(rightChild);
        } else {
            node.getParent().setRight(rightChild);
        }
        rightChild.setLeft(node);
        node.setParent(rightChild);
    }

    private void rotateRight(Node<K, V> node) {
        Node<K, V> leftChild = node.getLeft();
        node.setLeft(leftChild.getRight());
        if (leftChild.getRight() != TNULL) {
            leftChild.getRight().setParent(node);
        }
        leftChild.setParent(node.getParent());
        if (node.getParent() == null) {
            root = leftChild;
        } else if (node == node.getParent().getRight()) {
            node.getParent().setRight(leftChild);
        } else {
            node.getParent().setLeft(leftChild);
        }
        leftChild.setRight(node);
        node.setParent(leftChild);
    }

    public void preOrderTraversal(Node<K, V> node) {
        if (node != TNULL) {
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    public void inOrderTraversal(Node<K, V> node) {
        if (node != TNULL) {
            inOrderTraversal(node.getLeft());
            inOrderTraversal(node.getRight());
        }
    }

    public void postOrderTraversal(Node<K, V> node) {
        if (node != TNULL) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
        }
    }

    public void printTree(Node node, int space) {
        if (node == TNULL) return;
        space += 4;
        printTree(node.getRight(), space);
        System.out.println();
        for (int i = 4; i < space; i++) {
            System.out.print(" ");
        }

        if (node.isRed()) {
            System.out.print("\033[1;31m" + node.getKey() + "\033[0m");
        } else {
            System.out.print(node.getKey());
        }
        printTree(node.getLeft(), space);
    }
}
