package br.ufop.tomaz.model;

import java.util.HashMap;
import java.util.Map;

public class Automaton {

    private Map<State, Token> finalStates;

    public Automaton() {
        finalStates = new HashMap<>();
        finalStates.put(State.Q1, Token.IDENTIFIER);
        finalStates.put(State.Q3, Token.STRING);
        finalStates.put(State.Q4, Token.INTEGER);
        finalStates.put(State.Q7, Token.FLOAT);
    }

    private State executeTransition(State currentState, char entry) {
        switch (currentState) {
            case INITIAL: {
                if ((entry >= 'A' && entry <= 'Z') || (entry >= 'a' && entry <= 'z'))
                    return State.Q1;
                else if (entry == '"')
                    return State.Q2;
                else if (entry >= '0' && entry <= '9')
                    return State.Q4;
                else if (entry == '+' || entry == '-')
                    return State.Q5;
                else
                    return State.INVALIDATION_STATE;
            }

            case Q1: {
                return (entry >= 'A' && entry <= 'Z')
                        || (entry >= 'a' && entry <= 'z')
                        || (entry >= '0' && entry <= '9')
                        ? State.Q1 : State.INVALIDATION_STATE;
            }

            case Q2: {
                return (entry == '"') ? State.Q3 : State.Q2;
            }

            case Q4: {
                if (entry == '.')
                    return State.Q6;
                else if (entry >= '0' && entry <= '9')
                    return State.Q4;
                else
                    return State.INVALIDATION_STATE;
            }

            case Q5: {
                return (entry >= '0' && entry <= '9') ? State.Q4 : State.INVALIDATION_STATE;
            }
            case Q6:

            case Q7: {
                return (entry >= '0' && entry <= '9') ? State.Q7 : State.INVALIDATION_STATE;
            }

            default:
                return State.INVALIDATION_STATE;
        }
    }

    public Token evaluate(String str){
        State state = State.INITIAL;
        for(char c : str.toCharArray()){
            state = executeTransition(state, c);
        }
        return finalStates.getOrDefault(state, Token.INVALID);
    }
}
