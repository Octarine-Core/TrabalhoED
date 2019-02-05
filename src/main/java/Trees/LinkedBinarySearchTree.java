package Trees;

public class LinkedBinarySearchTree<T extends Comparable<? super T>> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T>{
    @Override
    public void addElement(T element) {
        LinkedBinaryNode<T> current = root;
        LinkedBinaryNode<T> insertee = new LinkedBinaryNode<>(element);
        if(size() == 0){
            root = insertee;
            count++;
        }else {
            while (true) {

                if (element.compareTo(current.getElement()) >= 0) {
                    if (current.getRight() != null) {
                        current = current.getRight();
                    } else {
                        current.setRight(insertee);
                        count++;
                        break;
                    }
                } else {
                    if (current.getLeft() != null) {
                        current = current.getLeft();
                    } else {
                        current.setLeft(insertee);
                        count++;
                        break;
                    }
                }
            }
        }
    }
    @Override
    public T removeElement(T targetElement) {
        return null;
    }
    @Override
    public void removeAllOccurrences(T targetElement) {

    }
    @Override
    public T removeMin() {
        LinkedBinaryNode<T> current = root;
        LinkedBinaryNode<T> parent = new LinkedBinaryNode<>(null);
        T element;
        while (true){
            LinkedBinaryNode<T> leftChild = current.getLeft();
            if(leftChild != null){
                parent = current;
                current = leftChild;
            }
            else {
                element = current.getElement();
                parent.setLeft(null);
                return element;
            }
        }
    }
    @Override
    public T removeMax() {
        LinkedBinaryNode<T> current = root;
        LinkedBinaryNode<T> parent = new LinkedBinaryNode<>(null);
        T element;
        while (true){
            LinkedBinaryNode<T> rightChild = current.getRight();
            if(rightChild != null){
                parent = current;
                current = rightChild;
            }
            else {
                element = current.getElement();
                parent.setLeft(null);
                return element;
            }
        }
    }
    @Override
    public T findMin() {
        LinkedBinaryNode<T> current = root;
        while (true){
            LinkedBinaryNode<T> leftChild = current.getLeft();
            if(leftChild != null){
                current = leftChild;
            }
            else {
                return current.getElement();
            }
        }

    }
    @Override
    public T findMax() {
        LinkedBinaryNode<T> current = root;
        while (true){
            LinkedBinaryNode<T> rightChild = current.getRight();
            if(rightChild != null){
                current = rightChild;
            }
            else {
                return current.getElement();
            }
        }
    }
    private static void leftRotation(LinkedBinaryNode X){
        LinkedBinaryNode Z = X.getRight();
        LinkedBinaryNode pivotNode = Z.getLeft();
        X.setRight(pivotNode);
        Z.setLeft(X);
    }

    public static void main(String[] args) {
        LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();

        System.out.print(tree.count);

        tree.addElement(1);
        tree.addElement(4);
        tree.addElement(6);

        System.out.print(tree.findMax());
        System.out.print(tree.count);


    }
}
