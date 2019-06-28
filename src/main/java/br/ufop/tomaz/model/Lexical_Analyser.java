package br.ufop.tomaz.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Lexical_Analyser {

    private Map<String, Token> keywordsAndOperatorsMap;

    public Lexical_Analyser() {
        this.keywordsAndOperatorsMap = new HashMap<>();
        keywordsAndOperatorsMap.put("for", Token.KEYWORD);
        keywordsAndOperatorsMap.put("while", Token.KEYWORD);
        keywordsAndOperatorsMap.put("do", Token.KEYWORD);
        keywordsAndOperatorsMap.put("if", Token.KEYWORD);
        keywordsAndOperatorsMap.put("else", Token.KEYWORD);
        keywordsAndOperatorsMap.put("print", Token.KEYWORD);
        keywordsAndOperatorsMap.put("switch", Token.KEYWORD);
        keywordsAndOperatorsMap.put("case", Token.KEYWORD);
        keywordsAndOperatorsMap.put("default", Token.KEYWORD);
        keywordsAndOperatorsMap.put("null", Token.KEYWORD);
        keywordsAndOperatorsMap.put("+", Token.PLUS);
        keywordsAndOperatorsMap.put("-", Token.MINUS);
        keywordsAndOperatorsMap.put("*", Token.TIMES);
        keywordsAndOperatorsMap.put("/", Token.DIVIDE);
        keywordsAndOperatorsMap.put("..", Token.DOTDOT);
        keywordsAndOperatorsMap.put(".", Token.DOT);
        keywordsAndOperatorsMap.put(",", Token.COMMA);
        keywordsAndOperatorsMap.put("=", Token.EQUAL);
        keywordsAndOperatorsMap.put(":", Token.COLON);
        keywordsAndOperatorsMap.put(";", Token.SEMICOLON);
        keywordsAndOperatorsMap.put("(", Token.LP);
        keywordsAndOperatorsMap.put(")", Token.RP);
        keywordsAndOperatorsMap.put(">=", Token.GE);
        keywordsAndOperatorsMap.put("<=", Token.LE);
        keywordsAndOperatorsMap.put(">", Token.GT);
        keywordsAndOperatorsMap.put("<", Token.LT);
        keywordsAndOperatorsMap.put("<>", Token.NE);
        keywordsAndOperatorsMap.put(":=", Token.ASSIGN_OP);
        keywordsAndOperatorsMap.put("@", Token.ENDER);
    }

    public List<Lexeme> analyseCode(Map<Integer,String> lines) {

        List<Lexeme> lexemes = new ArrayList<>();
        lines.forEach((nLine, line ) ->{
            Map<String, Token> lexLine = analyseLine(line.strip());
            lexLine.forEach((value, token) -> lexemes.add(new Lexeme(token, value, nLine)));
        });

        return lexemes;
    }

    private Map<String, Token> analyseLine(String line) {

        Map<String, Token> lineTokens = new HashMap<>();
        Automaton automaton = new Automaton();

        for (String str : line.split(" ")) {
            if (keywordsAndOperatorsMap.containsKey(str.toLowerCase()))
                lineTokens.put(str, keywordsAndOperatorsMap.get(str.toLowerCase()));
            else
                lineTokens.put(str, automaton.evaluate(str));
        }

        return lineTokens;
    }
}
