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

    public void order(){
        int i=0;
        while (!ordered(start)) {
            if(this.start.valore>this.start.next.valore){
                Node start = this.start;
                this.start = start.next;
                start.next = this.start.next;
                this.start.next = start;
            }
            System.out.println((i+1) + ")\tgiro:\n" + this);
            i++;
            orderNext(start);
        }
    }

    public void orderNext(Node n){
        if(n.next != null && n.next.next != null) {
            if (n.next.valore > n.next.next.valore) {
                Node start = n.next;
                n.next = start.next;
                start.next = n.next.next;
                n.next.next = start;
                orderNext(n);
            }else orderNext(n.next);
        }
    }

    public boolean ordered(Node n){
        if(n.next != null){
            if(n.valore<=n.next.valore) return ordered(n.next);
            else return false;
        }else return true;
    }
}