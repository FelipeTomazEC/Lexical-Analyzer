# Lexical Analyzer

The task of translates high level code, i.e., programming languages, into
a format that can be understand by a computer - binary code - is the
main job of a compiler. Speaking in a simple way, the compiler can be
split in 3 parts:
- Lexical Analyzer (LA)
- Syntax Analyzer (SA)
- Semantic Analyzer (SMA)

The Lexical Analyzer is responsible to separate the source code into
lexemes, which are the words that compose the code. After separate all
lexemes, the LA classify them using Token classification. **Keywords**,
**Special Symbols**, **Identifiers** and **Operators**, are examples of
tokens. Remove white spaces and comments of the compiled code is also a
role played by the Lexical Analyzer. The output of this process is a
table containing the lexemes and their token classification. Lexical
errors as invalid constructions of lexemes, *e.g. '12variableName'*,
*'na;;me'*, are also captured by the LA.

This project is an implementation of a **simple** Lexical Analyzer made in Java.
It provides a GUI where the user can type the code and get the tokens of it.
It is also possible load the code from a file and make the analysis.

### Recognized Tokens
The Lexical Analyzer of this project recognizes the following classes
of tokens:
- **IDENTIFIER** - Variable names;
- **STRING** - Words between double quotes "";
- **INTEGER** - Number with no dot ( . );
- **FLOAT** - Float point numbers;
- **PLUS** - ( + );
- **MINUS** - ( - );
- **TIMES** - ( * ),
- **DIVIDE** - ( / );
- **KEYWORD** - for, while, do, if, else, print, switch, case, default and
  null;
- **INVALID**;
- **ASSIGN_OP** - Assignment operator ( = );
- **SEMICOLON** - ( ; )
- **LEFT_PARENTHESIS** - '(';
- **RIGHT_PARENTHESIS** - ')';
- **LEFT_BRACE** - ( { );
- **RIGHT_BRACE** - ( } );
- **COMMA** - ( , );
- **DOT** - ( . );
- **DOTDOT** - ( .. );
- **COLON** - ( : );
- **EQUAL** - ( == );
- **LOWER_OR_EQUALS** - ( <= );
- **GREATER_OR_EQUALS** - ( >= );
- **NOT_EQUALS** - ( <> );
- **GREATER_THAN** - ( > );
- **LOWER_THAN** - ( < );
- **AT_SIGN** - ( @ ).


***P.S. 1**: Sentences initiated by // or chunks of sentences between /* */
are considered comments and are not mentioned in the output.*

***P.S. 2**: The lexemes must be separated by at least one white space(' ')
to be recognized as separated things.*

### Screenshot
<img src="https://user-images.githubusercontent.com/36672867/76977097-9eef4f00-6913-11ea-886a-8eae70a68ecc.jpeg" alt="drawing" width="600"/>

### Conclusion
This is a very simple example that demonstrates how a Lexical Analyzer
can be implemented. This project is also an usage example of
Finite-State Automata, a very powerful and useful tool.