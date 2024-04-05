public class Scrittore_csv {
    java.io.FileWriter writer;

    public Scrittore_csv(String file){
        try {
            writer = new java.io.FileWriter(file);

            String info = "";
            info += "nome";
            info += ",valore";
            writer.write(info + "\n");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    public void add(String stringa) {
        try {
            writer.append(stringa);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            writer.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}