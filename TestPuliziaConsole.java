import java.io.IOException;
public class TestPuliziaConsole{
    public static void main(String[] args) {
        System.out.println("""
                ciao
                cia
                cèsdhg
                òBIUDH
                sbòh
                bhu
                ernughae
                aepfiungeèaruiherah
                eòiobheroiherqhpoj""");
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}