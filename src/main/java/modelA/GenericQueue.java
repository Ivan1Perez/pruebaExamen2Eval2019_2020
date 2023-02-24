package modelA;

import java.io.*;
import java.util.Arrays;
import java.util.Queue;

public class GenericQueue<T> implements Serializable {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public GenericQueue(){

    }

    public int getSize() {
        return size;
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

    public boolean removeElementAtIndex(int index){
        Node<T> node = head;
        GenericQueue<T> aux = new GenericQueue<>();

        if(index > size || index <= 0)
            return false;

        else {
            for(int i = 1 ; i <= size ; i ++){
                if(i!=index){
                    aux.add(node.getInfo());
                }
                node = node.getNext();
            }
            size--;
            head = aux.head;
            return true;
        }

    }

    public String sort(){
        String text = "";
        Object[] o = new Object[size]; // Auxilary array to store students
        Node<T> n = head;

        // Add nodes to the array
        int i = 0;
        while (n != null) {
            o[i] = n.getInfo();
            n=n.getNext();
            i++;
        }

        // Sort the array using the interface Comparable
        Arrays.sort(o);

        // Generate the String
        for (int j = 0; j < o.length; j++) {
            text += o[j].toString() + "\n";
        }

        return text;
    }

    public void save(File f) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

        try{
            oos.writeObject(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public GenericQueue<T> load(File f) throws Exception{
        GenericQueue<T> queue = null;

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
            queue = (GenericQueue<T>)ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }

        return queue;
    }

    @Override
    public String toString(){
        String output = "Generic Queue\n" +
                "Size = " + size + "\n";
        Node<T> aux = head;

        while(aux!=null){
            output += aux.getInfo() + "\n";
            aux = aux.getNext();
        }

        return output;
    }

    static class Node<T> implements Serializable{

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
