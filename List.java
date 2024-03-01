public class List {
    protected int size;
    protected Node start;

    public List(){
        size = 0;
        start = null;
    }

    public void addNode(Node n){
        if (start != null) addNextNode(start, n);
        else start = n;
        size++;
    }

    protected void addNextNode(Node current, Node n){
        if(current.next != null) addNextNode(current.next, n);
        else current.next = n;
    }


    public void removeNode(Node n){
        if (!start.equals(n)) removeNextNode(start, n);
        else start = start.next;
        size--;
    }

    protected void removeNextNode(Node current, Node n){
        if(!current.next.equals(n)) removeNextNode(current.next, n);
        else current.next = current.next.next;
    }

    public String toString(){
        String info = "";
        info += "size:\t" + size + "\n";
        info += "start:\t" + start + "\n";
        return info;
    }
}