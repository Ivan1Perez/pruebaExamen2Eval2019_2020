package modelA;

public class GenericQueue<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public GenericQueue(){

    }

    public void add(T info){

        Node<T> node = new Node<>(info);

        if(head==null){
            head = node;
            tail = node;
        }else {
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }

        size++;
    }

    public T remove(){
        Node<T> node = head;

        if(head==null)
            return null;
        else {
            return head.getInfo();
        }
    }

    @Override
    public String toString(){
        String output = "Generic Queue\n" +
                "Size = " + size + "\n";
        Node<T> aux = head;

        while(aux!=null){
            output += "{" + aux.getInfo() + "}";
            aux = aux.getNext();
            if(aux!=null)
                output += ", ";
        }

        return output;
    }

    class Node<T>{

        private T info;
        private Node<T> next;
        private Node<T> previous;

        public Node(T info){
            this.info = info;
        }

        public void setNext(Node<T> next){
            this.next = next;
        }

        public Node<T> getNext(){
            return next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public void setInfo(T info){
            this.info = info;
        }

        public T getInfo(){
            return info;
        }

        @Override
        public String toString(){
            return info.toString();
        }

    }

}
