public class Node{
    protected String nome;
    protected int valore;
    protected Node next;

    public Node(String nome, int valore) {
        this.nome = nome;
        this.valore = valore;
        next = null;
    }
    public Node() {
        System.out.println("inserisci il nome di questo nodo");
        this.nome = getString();
        System.out.println("inserisci il valore di questo nodo");
        this.valore = getInt();
        next = null;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        String info ="";
        info += "\t\tnome:\t" + nome + "\n";
        info += "\tvalore:\t" + valore + "\n";
        if(next != null) info += "\tsuccessivo:\n" + next;
        else info += "\tlista terminata\n";
        return info;
    }

    public boolean equals(Node n){
        if(!this.nome.equals(n.nome)) return false;
        return this.valore == n.valore;
    }

    private String getString() {
        try{
            return new java.util.Scanner(System.in).nextLine();
        }catch (java.util.InputMismatchException e){
            return getString();
        }
    }
    private int getInt() {
        try{
            return new java.util.Scanner(System.in).nextInt();
        }catch (java.util.InputMismatchException e){
            return getInt();
        }
    }
}
