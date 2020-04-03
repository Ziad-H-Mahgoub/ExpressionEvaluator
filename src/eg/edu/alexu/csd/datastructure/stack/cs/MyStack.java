package eg.edu.alexu.csd.datastructure.stack.cs;


public class MyStack implements IStack {



    private Node top;
    private int size;


    public MyStack() {
        top= new Node();
        size = 0;
    }

    /**
     * Removes the element at the top of stack and returns that element.
     *
     * @return top of stack element, or through exception if empty
     */
    @Override
    public Object pop() {
        if (isEmpty())
            throw new NullPointerException("Stack is empty");
        Node temp=top;
        top = top.getNext();
        size--;
        return temp.getElement();
    }

    /**
     * Get the element at the top of stack without removing it from stack.
     *
     * @return top of stack element, or through exception if empty
     */
    @Override
    public Object peek() {
        if (isEmpty())
            throw new NullPointerException("Stack is empty");
        return top.getElement();
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param element
     * to insert
     */
    @Override
    public void push(Object element) {
            Node temp = new Node();
            temp.setNext(top);
            temp.setElement(element);
            top=temp;
            size++;
    }

    /**
     * Tests if this stack is empty
     *
     * @return true if stack empty
     */
    public boolean isEmpty() {
        return top.getElement() == null;
    }
    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * this class is node class which implement stack by node
     */
    static class Node{

        private Object element;
        private Node next;

        /**
         * set the element to node
         *
         * @param element .
         */
        public void setElement(Object element) {

            this.element = element;
        }

        /**
         * proivde the next node
         *
         * @param next .
         */

        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * get the element of the node
         *
         * @return the elemnet
         */

        public Object getElement() {
            return element;
        }

        /**
         * get the next node of class
         *
         * @return the next node
         */

        public Node getNext() {
            return next;
        }
    }
}
