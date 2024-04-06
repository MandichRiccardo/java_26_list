public class Test{
    public static void main(String[] args) {
        List l;
        System.out.println("vuoi recuperare una lista salvata su file?");
        if(getBoolean()) {
            Lettore_csv reader = new Lettore_csv();
            readFile(reader);
            reader.removeRow(0);
            l = new List(reader.tabel);
        }else{
            l = new List();
        }
        esecuzione(l);
        System.out.println("vuoi salvare questa lista su file?");
        if(getBoolean()) {
            System.out.println("inserisci il nome del file in cui savare questa lista");
            Scrittore_csv writer = new Scrittore_csv("csv\\" + Node.getString());
            writer.add(l.toFile());
            writer.close();
        }
        System.out.println("programma terminato");
    }

    public static List esecuzione(List l){
        System.out.println("stato attuale della lista:");
        l.printList();
        System.out.println("""
                cosa vuoi fare?
                    0)\tterminare il programma
                    1)\taggiungere un nodo
                    2)\trimuovere un nodo
                    3)\tordina la lista
                    4)\tsalva la lista su file""");
        switch(getInt(0, 4)){
            default -> {
                return l;
            }
            case 1 -> l.addNode(new Node());
            case 2 -> l.removeNode(new Node());
            case 3 -> l.order();
            case 4 -> {
                System.out.println("inserisci il nome del file in cui savare questa lista");
                Scrittore_csv writer = new Scrittore_csv("csv\\" + Node.getString());
                writer.add(l.toFile());
                writer.close();
            }
        }
        return esecuzione(l);
    }

    protected static int getInt(int min){
        int ret = Node.getInt();
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
    public static boolean getBoolean(){
        try{
            return new java.util.Scanner(System.in).nextBoolean();
        }catch (java.util.InputMismatchException e){
            System.out.println("devi inserire un booleano nel formato \"true\" o \"false\"");
            return getBoolean();
        }
    }

    public static void readFile(Lettore_csv reader){
        System.out.println("inserisci il nome del file di input");
        try{
            reader.getFile("csv\\" + Node.getString());
        }catch(java.io.FileNotFoundException e){
            System.out.println("questo file non esiste, controlla che sia presente nella cartella e di aver inserito correttamente il suo nome e il suo percorso partendo dalla cartella madre del progetto");
            readFile(reader);
        }
    }
}