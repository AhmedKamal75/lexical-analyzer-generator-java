import LexicalAnalysisGenerator.Automaton.Automaton;
import LexicalAnalysisGenerator.Creation.LexicalRulesParser;
import LexicalAnalysisGenerator.Creation.Parsing;

import java.io.IOException;
import java.util.Map;

public class App {
    private static final LexicalRulesParser lexicalRulesParser = new LexicalRulesParser();
    private static final Parsing parse = new Parsing();

    public static void main(String[] args) throws IOException {
        String filePath = "inputs/temp_file.txt";
//        String filePath = "inputs/lexical_rules.txt";
        try {
            Map<String, Automaton> map = lexicalRulesParser.parseFile(filePath);
            for (Map.Entry<String, Automaton> entry:map.entrySet()) {
                System.out.println("Token: \"" + entry.getKey() +
                        "\", DFA Token: \"" + entry.getValue().getToken() + "\"" +
                        ", Regex: \"" + entry.getValue().getRegex() + "\"");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
