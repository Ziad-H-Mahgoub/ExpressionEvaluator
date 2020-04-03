package eg.edu.alexu.csd.datastructure.stack.cs;

public class SingleLinked {


    private Node head;
    private int size=0;


    /**
     * intialze the class
     */
    public SingleLinked(){
        head= new Node();
    }
    //Now the List is initialized.

    /**
     * Inserts the specified element at the end of the list.
     *
     * @param element .
     */
    public void add(Object element) {
        size++;
        if(isEmpty())
            head.setElement(element);
        else{
            Node temp;
            temp=head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(new Node());
            temp.getNext().setElement(element);
        }
    }

    /**
     * Inserts a specified element at the specified position in the list.
     *
     * @param index .
     * @param element .
     */

    public void add(int index, Object element) {
        if(index==size)
            add(element);
        checkIndex(index);
        size++;
        if(index==0){
            //Insert at head.
            Node temp= new Node();
            temp.setElement(element);
            temp.setNext(head);
            head=temp;
            return;
        }
        Node before=getNode(index-1);
        Node after=getNode(index);
        Node temp= new Node();
        temp.setElement(element);
        temp.setNext(after);
        before.setNext(temp);
    }

    /**
     * get the sepific node if placed in the list
     *
     * @param index .
     * @return the node we want
     */
    private Node getNode(int index){
        int i=0;
        Node temp=head;
        while(i!=index){
            i++;
            temp=temp.getNext();
        }
        return temp;
    }

    /**
     * @param index .
     * @return the element at the specified position in this list.
     */

    public Object get(int index) {
        checkIndex(index);
        return getNode(index).getElement();
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index .
     * @param element .
     */

    public void set(int index, Object element)  {
        checkIndex(index);
        getNode(index).setElement(element);
    }

    /**
     * Removes all of the elements from this list.
     */

    public void clear() {
        size=0;
        if(isEmpty())
            return;
        head.setNext(null);
        head.setElement(null);

    }

    /**
     * check wether the index exist or not
     * @param index .
     */
    public void checkIndex(int index)  {
        if(index<0)
            throw new ArithmeticException("Index is negative.");
        if(index>size-1)
            throw new NullPointerException("Index out of bounds");
    }

    /**
     * @return true if this list contains no elements.
     */

    public boolean isEmpty() {
        return head.getElement() == null;
    }


    /**
     * Removes the element at the specified position in this list.
     *
     * @param index .
     */

    public void remove(int index) {
        checkIndex(index);
        size--;
        if(index==0)//The head node
        {
            head=head.getNext();
            return;
        }
        Node before=getNode(index-1);
        if(index+1<size) {
            Node after = getNode(index + 1);
            before.setNext(after);
        }
        else
            before.setNext(null);
        //At the end of the list
    }

    /**
     * @return the number of elements in this list.
     */


    public int size() {
        return size;
    }




    public boolean contains(Object o) {
        Node temp=head;
        while(temp.getNext()!=null){
            if(temp.getElement().equals(o))
                return true;
            temp=temp.getNext();
        }
        return false;
    }


    public String toString() {
        String list="{ ";
        if(isEmpty())
            throw new NullPointerException("List is empty .");
        Node temp=head;
        while(temp!=null){
            list+=temp.getElement().toString();
            list+=" ,";
            temp=temp.getNext();
        }
        list+=" }";
        return list;
    }
    public boolean hasNext (int x){
        if(getNode(x).getNext() != null)
            return true;
        else
            return false;
    }


    static class Node{//The list's element.

        private Object element;
        private Node next;

        /**
         * set the element to node
         * @param element .
         */

        public void setElement(Object element) {

            this.element = element;
        }

        /**
         * proivde the next node
         *
         * @param next ,
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
