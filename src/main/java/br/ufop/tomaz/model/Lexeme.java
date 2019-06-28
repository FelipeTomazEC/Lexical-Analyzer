package br.ufop.tomaz.model;

import javafx.beans.property.*;

public class Lexeme {

    private ObjectProperty<Token> token = new SimpleObjectProperty<>();
    private IntegerProperty line = new SimpleIntegerProperty();
    private StringProperty value = new SimpleStringProperty();

    public Lexeme(Token token, String value, Integer line){
        setToken(token);
        setValue(value);
        setLine(line);
    }

    public Token getToken() {
        return token.get();
    }

    public ObjectProperty<Token> tokenProperty() {
        return token;
    }

    public void setToken(Token token) {
        this.token.set(token);
    }

    public int getLine() {
        return line.get();
    }

    public IntegerProperty lineProperty() {
        return line;
    }

    public void setLine(int line) {
        this.line.set(line);
    }

    public String getValue() {
        return value.get();
    }

    public StringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }
}
