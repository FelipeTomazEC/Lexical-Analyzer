import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Digite o caminho do arquivo:");
        //String path = scanner.next();
        String path = Main.class.getResource("/TestFile.txt").getFile();
        File file = new File(path);
        evaluate(file);
    }

    private static void evaluate(File file) {
        Lexical_Analyser anaLex = new Lexical_Analyser();
        Map<Integer, Map<String, Token>> tokensTable = anaLex.analyseCode(file.toPath());
        tokensTable.forEach((k, v) ->
                v.forEach((str, token) ->
                        System.out.println("< Line: " + k + "   Token: " + token + "   Attribute: " + str)
                )
        );
    }
}
