@SuppressWarnings("unchecked")
public class DLList<E> {
  private Node<E> head;
  private Node<E> tail;
  private int size;

  public DLList() {
    head = new Node<E>(null);
    tail = new Node<E>(null);
    head.setPrev(null);
    head.setNext(tail);
    tail.setPrev(head);
    tail.setNext(null);
    size = 0;
  }

  public boolean add(E item) {
    Node<E> newNode = new Node<E>(item);
    Node<E> before = tail.prev();
    Node<E> after = tail;
    before.setNext(newNode);
    newNode.setPrev(before);
    newNode.setNext(after);
    after.setPrev(newNode);
    size ++;
    return true;
  }

  public void add(int index, E item) {
    Node<E> newNode = new Node<E>(item);
    Node<E> after = getNode(index);
    Node<E> before = getNode(index - 1);
    before.setNext(newNode);
    newNode.setPrev(before);
    newNode.setNext(after);
    after.setPrev(newNode);
    size ++;
  }
  
  public E get(int x){
    E result = (E) getNode(x).get();
    return result;
  }
  public E remove(int x){
    E removed = getNode(x).get();
    if (size == 1) {
      head.setNext(tail);
      tail.setPrev(head);
      size --;
      return removed;
    }
    if (x == 0) {
      Node<E> after = getNode(x + 1);
      head.setNext(after);
      after.setPrev(head);
      size --;
      return removed;
    }
    if (x == (size - 1)) {
      Node<E> before = getNode(x - 1);
      tail.setPrev(before);
      before.setNext(tail);
      size --;
      return removed;
    }
    Node<E> before = getNode(x - 1);
    Node<E> after = getNode(x + 1);
    before.setNext(after);
    after.setPrev(before);
    size --;
    return removed;
    
  }

  public boolean remove(Object o) {
    E obj = (E) o;
    for (int i = 0; i < size; i ++) {
      if (getNode(i).get().equals(obj)) {
        if (size == 1) {
          head.setNext(tail);
          tail.setPrev(head);
          size --;
          return true;
        }
        if (i == 0) {
          Node<E> after = getNode(i + 1);
          head.setNext(after);
          after.setPrev(head);
          size --;
          return true;
        }
        if (i == (size - 1)) {
          Node<E> before = getNode(i - 1);
          tail.setPrev(before);
          before.setNext(tail);
          size --;
          return true;
        }
        Node<E> before = getNode(i - 1);
        Node<E> after = getNode(i + 1);
        before.setNext(after);
        after.setPrev(before);
        size --;
        return true;
      }
    }
    return false;
  }

  public E set(int x, E y){
    E replaced = getNode(x).get();
    getNode(x).set(y);    
    return replaced;
    
  }
  public int size(){
    return size;
  }
  public String toString(){
    if (size == 0) {
      return "[]";
    }
    String result = "[" + head.next().get();
    for (int i = 1; i < size; i ++) {
      result += ", " + getNode(i).get().toString();
    }
    result += "]";
    return result;
  }

  public void clear() {
    head = new Node<E>(null);
    tail = new Node<E>(null);
    head.setPrev(null);
    head.setNext(tail);
    tail.setPrev(head);
    tail.setNext(null);
    size = 0;
  }
  
  private Node<E> getNode(int index) {
    Node<E> current = head.next();
    for (int i = 0; i < size; i ++) {
      if (i == index) {
        return current;
      }
      current = current.next();
    }
    return null;
  }
}