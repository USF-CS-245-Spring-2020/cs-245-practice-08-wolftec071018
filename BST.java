
public class BST<T extends Comparable> {
    // this is the root... the begining, can set to null if i want
    private Node<T> root;
    // the nodes, what they have and left and right
    class Node<T extends Comparable> {
        T data;
        Node<T> left;
        Node<T> right;

    }
    // if item is in return true or false
    public boolean find(Comparable item) {
        return find(item);
    }
    // the function
    protected boolean find(Node<T> node, Comparable item) {

        if (node == null) {
            return false;
        }
        if (item == node.data) {
            return true;
        } else if (item < node.data)
            return find(item.node.left);
        else
            return find(item.node.right);
    }
    // find the place to insert
    public void insert(Comparable item) {
        root = insert(item);
    }

    protected Node<T> insert(Node<T> node, Comparable key) {
        if (node == null)
            newNode = new Node(key);
            return newNode;

        if (key < node.data)
            node.left = insert(node.left, key);

        else
            node.right = insert(node.right, key);

        
    }
    //prints
    public void print() {
        print(root);

    }
    // doesnt stop till its null
    protected void print(Node<T> node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.data);
            print(node.right);
        }
    }

    public void delete(Comparable key) {
        root = delete(root, key);
    }

    protected Node delete(Node<T> node, Comparable key) {
        //if thers nothing its do nothing
        if (node == null)
            return null;
        // find where to delete accorind to < >
        if (node.data < key) {
            node.right = delete(node.right, key);
            return node;
        } else if (node.data > key) {
            node.left = delete(node.left, key);
            return node;
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                if (node.right.left == null) {
                    node.data = node.right.data;
                    node.right = node.right.right;
                } else {
                    node.data = removeSmallest(node, right);
                }
                return node;
            }
        }
    }// end delete
    // find the smallest node.
    public Comparable<T> removeSmallest(Node<T> node) {
        if (node.left.left == null) {
            Comparable<T> smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        } else {
            return removeSmallest(node.left);
        }
    }
}
