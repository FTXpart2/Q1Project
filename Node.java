import java.io.Serializable;

public class Node<E> implements Serializable {
    private static final long serialVersionUID = 1L;
    private E data;
    private Node<E> next;
    private Node<E> prev;
  
    public Node(E d) {
      data = d;
    }
  
    public E get(){
      return data;
    }
  
    public void set(E d) {
      data = d;
    }
    
    public Node<E> prev(){
      return prev;
    }
    public Node<E> next(){
      return next;
    }
    public void setNext(Node<E> x){
      next=x;
    }
    public void setPrev(Node<E> x){
      prev=x;
    }
  }