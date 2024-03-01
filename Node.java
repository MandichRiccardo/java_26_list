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
        info += "nome:\t" + nome + "\n";
        info += "valore:\t" + valore + "\n";
        info += "successivo:\t" + next + "\n";
        return info;
    }

    public boolean equals(Node n){
        if(!this.nome.equals(n.nome)) return false;
        if(this.valore != n.valore) return false;
        return true;
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
