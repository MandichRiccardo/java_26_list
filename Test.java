public class Test{
    public static void main(String[] args) {
        esecuzione(new List());
        System.out.println("programma terminato");
    }

    public static void esecuzione(List l){
        System.out.println("stato attuale della lista:\n" + l);
        System.out.println("""
                cosa vuoi fare?
                    0)\tterminare il programma
                    1)\taggiungere un nodo
                    2)\trimuovere un nodo
                    3)\tordina la lista""");
        switch(getInt(0, 3)){
            default -> {
                return;
            }
            case 1 -> l.addNode(new Node());
            case 2 -> l.removeNode(new Node());
            case 3 -> l.order();
        }
        esecuzione(l);
    }

    protected static int getInt() {
        try{
            return new java.util.Scanner(System.in).nextInt();
        }catch (java.util.InputMismatchException e){
            System.out.println("devi inserire un numero intero");
            return getInt();
        }
    }

    protected static int getInt(int min){
        int ret = getInt();
        if (ret >= min) return ret;
        System.out.println("devi inserire un numero maggiore o uguale a " + min);
        return getInt(min);
    }
    protected static int getInt(int min, int max) {
        if (min > max) throw new RuntimeException("il numero minimo non può essere maggiore del massimo");
        int ret = getInt(min);
        if (ret <= max) return ret;
        System.out.println("devi inserire un numero minore o uguale a " + max);
        return getInt(min, max);
    }
}