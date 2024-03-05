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
        try {
            if (start.equals(n)) start = start.next;
            else removeNextNode(start, n);
            size--;
        }catch (NullPointerException e){
            System.out.println("non ho potuto rimuovere questo nodo perché non lo ho trovato");
        }
    }

    protected void removeNextNode(Node current, Node n){
        if(current.next.equals(n)) current.next = current.next.next;
        else removeNextNode(current.next, n);
    }

    public String toString(){
        String info = "";
        info += "size:\t" + size + "\n";
        info += "\tlista iniziata\n";
        if(start != null) info += "\tstart:\n" + start + "\n";
        else info += "\tlista terminata\n";
        return info;
    }
}