package parser;

import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;

import interpreter.Interpreter;

%%

%public
%class Lexer
%cup
%implements sym
%char
%line
%column

%{
    StringBuffer string = new StringBuffer();
    public Lexer(java.io.Reader in, ComplexSymbolFactory sf){
	this(in);
	symbolFactory = sf;
    }
    ComplexSymbolFactory symbolFactory;

  private Symbol symbol(String name, int sym) {
      return symbolFactory.newSymbol(name, sym, new Location(yyline+1,yycolumn+1,yyline+1), new Location(yyline+1,yycolumn+yylength(),yycolumn+1));
  }
  
  private Symbol symbol(String name, int sym, Object val) {
      Location left = new Location(yyline + 1, yycolumn + 1, yyline + 1);
      Location right = new Location(yyline + 1, yycolumn + yylength(), yycolumn + 1);
      return symbolFactory.newSymbol(name, sym, left, right, val);
  } 
%} 

%eofval{
     return symbolFactory.newSymbol("EOF", EOF, new Location(yyline + 1, yycolumn + 1, yychar), new Location(yyline + 1, yycolumn + 1, yychar + 1));
%eofval}

Ident = [a-zA-Z$_] [a-zA-Z0-9$_]*
IntLiteral = 0 | [1-9][0-9]*
FloatLiteral = [0-9]+ \. [0-9]*
new_line = \r|\n|\r\n;
white_space = {new_line} | [ \t\f]

%%

<YYINITIAL>{
/* keywords */
"int"             { return symbol("int",         INT); }
"float"           { return symbol("float",       FLOAT); }

/* literals */
{IntLiteral} { return symbol("Intconst", INTCONST, new Long(Long.parseLong(yytext()))); }
{FloatLiteral} { return symbol("Floatconst", FLOATCONST, new Double(Double.parseDouble(yytext()))); }

/* names */
{Ident}           { return symbol("ID", IDENT, yytext()); }

/* separators */
";"               { return symbol(";",  SEMICOLON); }
"("               { return symbol("(",  LPAREN); }
")"               { return symbol(")",  RPAREN); }
"="               { return symbol("=",  ASSIGN); }
"+"               { return symbol("+",  PLUS); }

"/*" [^*] ~"*/" | "/*" "*"+ "/"
                  { /* ignore comments */ }

{white_space}     { /* ignore */ }

}

/* error fallback */
[^]               { Interpreter.fatalError("Illegal character <" + yytext() + ">", Interpreter.EXIT_PARSING_ERROR); }
