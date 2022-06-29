package recovery;

import parser.*;

@SuppressWarnings("deprecation")
public class First { //implementa os conjuntos follows p/ alguns n.terminais

   static public final RecoverySet main = new RecoverySet();
   static public final RecoverySet inicioPrograma = new RecoverySet();
   static public final RecoverySet abreBloco = new RecoverySet();
   static public final RecoverySet fimBloco = new RecoverySet();
   static public final RecoverySet comando = new RecoverySet();
   static public final RecoverySet atribuir_ou_expressao = comando; 
   static public final RecoverySet declaracaoVariavel = comando;
   static public final RecoverySet if_funcao = comando;
   static public final RecoverySet for_funcao = comando;
   static public final RecoverySet do_funcao = comando;
   static public final RecoverySet id = new RecoverySet();		// colocar do variavel_if e nomeVariavel e extremidade_expressao
   static public final RecoverySet atribuicao = new RecoverySet(); // colocar do declararMais
   static public final RecoverySet expressao_matematica = new RecoverySet();
   static public final RecoverySet numero = new RecoverySet(); // colocar do variavel_for, variavel_if, extremidade_expressao
   static public final RecoverySet pontoVirgula = comando;
   static public final RecoverySet identificador_variaveis = new RecoverySet();
   static public final RecoverySet elseNaoTerminal = new RecoverySet();
   static public final RecoverySet doNaoTerminal = new RecoverySet();
   static public final RecoverySet letra = new RecoverySet();
   static public final RecoverySet falso = new RecoverySet();
   static public final RecoverySet verdadeiro = falso;
   static public final RecoverySet atribuir = new RecoverySet();
   static public final RecoverySet declararMais = new RecoverySet();
   static public final RecoverySet nomeVariavel = new RecoverySet();
   static public final RecoverySet virgula = new RecoverySet(); 
   
   static public final RecoverySet forNaoTerminal = new RecoverySet();
   static public final RecoverySet variavel_for = new RecoverySet();
   static public final RecoverySet ifNaoTerminal = new RecoverySet();
   static public final RecoverySet to = new RecoverySet();
   static public final RecoverySet expressao_logica = new RecoverySet();
   static public final RecoverySet variavel_if = new RecoverySet();
   static public final RecoverySet operador_logico = new RecoverySet();
   static public final RecoverySet and = operador_logico;
   static public final RecoverySet or = operador_logico;
   static public final RecoverySet palavra = new RecoverySet();
   static public final RecoverySet sinalMaior = operador_logico;
   static public final RecoverySet sinalMenor = operador_logico;
   static public final RecoverySet sinalMenorIgual = operador_logico;
   static public final RecoverySet sinalMaiorIgual = operador_logico;
   static public final RecoverySet sinalDiferente = operador_logico;
   static public final RecoverySet sinalIgual = operador_logico;
   static public final RecoverySet tipoDado = new RecoverySet();
   static public final RecoverySet inteiro = tipoDado;
   static public final RecoverySet booleana = tipoDado;
   static public final RecoverySet string = tipoDado;
   static public final RecoverySet operador_matematico = new RecoverySet();
   static public final RecoverySet extremidade_expressao = expressao_matematica;
   static public final RecoverySet soma = operador_matematico;
   static public final RecoverySet subtracao = operador_matematico;
   static public final RecoverySet multiplicacao = operador_matematico;
   static public final RecoverySet divisao = operador_matematico;
   
    
        
    static {
    	main.add(new Integer(CompiladorAulaConstants.EOF));
    	
    	inicioPrograma.add(new Integer(CompiladorAulaConstants.ABREBLOCO));
    	
    	abreBloco.add(new Integer(CompiladorAulaConstants.ID));
    	abreBloco.add(new Integer(CompiladorAulaConstants.SOMA));
    	abreBloco.add(new Integer(CompiladorAulaConstants.SUBTRACAO));
    	abreBloco.add(new Integer(CompiladorAulaConstants.MULTIPLICACAO));
    	abreBloco.add(new Integer(CompiladorAulaConstants.DIVISAO));
    	abreBloco.add(new Integer(CompiladorAulaConstants.NUMERO));
    	abreBloco.add(new Integer(CompiladorAulaConstants.INTEIRO));
    	abreBloco.add(new Integer(CompiladorAulaConstants.BOOLEANA));
    	abreBloco.add(new Integer(CompiladorAulaConstants.STRING));
    	abreBloco.add(new Integer(CompiladorAulaConstants.IF));
    	abreBloco.add(new Integer(CompiladorAulaConstants.FOR));
    	abreBloco.add(new Integer(CompiladorAulaConstants.DO));
    	abreBloco.add(new Integer(CompiladorAulaConstants.FIMBLOCO));
    	
    	
    	fimBloco.add(new Integer(CompiladorAulaConstants.EOF));
    	fimBloco.add(new Integer(CompiladorAulaConstants.ID));
    	fimBloco.add(new Integer(CompiladorAulaConstants.SOMA));
    	fimBloco.add(new Integer(CompiladorAulaConstants.SUBTRACAO));
    	fimBloco.add(new Integer(CompiladorAulaConstants.MULTIPLICACAO));
    	fimBloco.add(new Integer(CompiladorAulaConstants.DIVISAO));
    	fimBloco.add(new Integer(CompiladorAulaConstants.NUMERO));
    	fimBloco.add(new Integer(CompiladorAulaConstants.INTEIRO));
    	fimBloco.add(new Integer(CompiladorAulaConstants.BOOLEANA));
    	fimBloco.add(new Integer(CompiladorAulaConstants.STRING));
    	fimBloco.add(new Integer(CompiladorAulaConstants.IF));
    	fimBloco.add(new Integer(CompiladorAulaConstants.FOR));
    	fimBloco.add(new Integer(CompiladorAulaConstants.DO));
    	fimBloco.add(new Integer(CompiladorAulaConstants.FIMBLOCO));
    	
    	comando.add(new Integer(CompiladorAulaConstants.FIMBLOCO));
    	comando.add(new Integer(CompiladorAulaConstants.ID));
    	comando.add(new Integer(CompiladorAulaConstants.SOMA));
    	comando.add(new Integer(CompiladorAulaConstants.SUBTRACAO));
    	comando.add(new Integer(CompiladorAulaConstants.MULTIPLICACAO));
    	comando.add(new Integer(CompiladorAulaConstants.DIVISAO));
    	comando.add(new Integer(CompiladorAulaConstants.NUMERO));
    	comando.add(new Integer(CompiladorAulaConstants.INTEIRO));
    	comando.add(new Integer(CompiladorAulaConstants.BOOLEANA));
    	comando.add(new Integer(CompiladorAulaConstants.STRING));
    	comando.add(new Integer(CompiladorAulaConstants.IF));
    	comando.add(new Integer(CompiladorAulaConstants.FOR));
    	comando.add(new Integer(CompiladorAulaConstants.DO)); 	
    	
    	tipoDado.add(new Integer(CompiladorAulaConstants.ID));
    	tipoDado.add(new Integer(CompiladorAulaConstants.LETRA));
    	
    	id.add(new Integer(CompiladorAulaConstants.ATRIBUICAO));
    	id.add(new Integer(CompiladorAulaConstants.NUMERO));
    	id.add(new Integer(CompiladorAulaConstants.VIRGULA));
    	id.add(new Integer(CompiladorAulaConstants.PONTOVIRGULA));
    	
    	atribuicao.add(new Integer(CompiladorAulaConstants.PONTOVIRGULA));
    	
    	expressao_matematica.add(new Integer(CompiladorAulaConstants.PONTOVIRGULA));
    
    	numero.add(new Integer(CompiladorAulaConstants.VIRGULA));
    	numero.add(new Integer(CompiladorAulaConstants.PONTOVIRGULA));
    	numero.add(new Integer(CompiladorAulaConstants.MAIOR));
    	numero.add(new Integer(CompiladorAulaConstants.MENOR));
    	numero.add(new Integer(CompiladorAulaConstants.MENOR_IGUAL));
    	numero.add(new Integer(CompiladorAulaConstants.MAIOR_IGUAL));
    	numero.add(new Integer(CompiladorAulaConstants.DIFERENTE));
    	numero.add(new Integer(CompiladorAulaConstants.IGUAL));
    	numero.add(new Integer(CompiladorAulaConstants.AND));
    	numero.add(new Integer(CompiladorAulaConstants.OR));
    	numero.add(new Integer(CompiladorAulaConstants.FIMBLOCO));
    	numero.add(new Integer(CompiladorAulaConstants.ID));
    	numero.add(new Integer(CompiladorAulaConstants.SOMA));
    	numero.add(new Integer(CompiladorAulaConstants.SUBTRACAO));
    	numero.add(new Integer(CompiladorAulaConstants.MULTIPLICACAO));
    	numero.add(new Integer(CompiladorAulaConstants.DIVISAO));
    	numero.add(new Integer(CompiladorAulaConstants.NUMERO));
    	numero.add(new Integer(CompiladorAulaConstants.INTEIRO));
    	numero.add(new Integer(CompiladorAulaConstants.BOOLEANA));
    	numero.add(new Integer(CompiladorAulaConstants.STRING));
    	numero.add(new Integer(CompiladorAulaConstants.IF));
    	numero.add(new Integer(CompiladorAulaConstants.FOR));
    	numero.add(new Integer(CompiladorAulaConstants.DO));
    	numero.add(new Integer(CompiladorAulaConstants.TO));
    	numero.add(new Integer(CompiladorAulaConstants.ABREBLOCO));

    	identificador_variaveis.add(new Integer(CompiladorAulaConstants.PONTOVIRGULA));
    	
    	ifNaoTerminal.add(new Integer(CompiladorAulaConstants.ID));
    	ifNaoTerminal.add(new Integer(CompiladorAulaConstants.NUMERO));
    	ifNaoTerminal.add(new Integer(CompiladorAulaConstants.PALAVRA));
    	
    	expressao_logica.add(new Integer(CompiladorAulaConstants.ABREBLOCO));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.ID));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.SOMA));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.SUBTRACAO));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.MULTIPLICACAO));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.DIVISAO));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.NUMERO));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.INTEIRO));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.BOOLEANA));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.STRING));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.IF));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.FOR));
    	expressao_logica.add(new Integer(CompiladorAulaConstants.DO)); 	
    	expressao_logica.add(new Integer(CompiladorAulaConstants.FIMBLOCO));
    	
    	elseNaoTerminal.add(new Integer(CompiladorAulaConstants.ABREBLOCO));
    	
    	forNaoTerminal.add(new Integer(CompiladorAulaConstants.ID));
    	forNaoTerminal.add(new Integer(CompiladorAulaConstants.NUMERO));
    	
    	variavel_for.add(new Integer(CompiladorAulaConstants.TO));
    	variavel_for.add(new Integer(CompiladorAulaConstants.ABREBLOCO));
    	
    	doNaoTerminal.add(new Integer(CompiladorAulaConstants.ABREBLOCO));
    	
    	to.add(new Integer(CompiladorAulaConstants.ID));
    	to.add(new Integer(CompiladorAulaConstants.NUMERO));
    	to.add(new Integer(CompiladorAulaConstants.PALAVRA));
    	
    	letra.add(new Integer(CompiladorAulaConstants.LETRA));
    	letra.add(new Integer(CompiladorAulaConstants.DIGITO));
    	letra.add(new Integer(CompiladorAulaConstants.ATRIBUICAO));
    	letra.add(new Integer(CompiladorAulaConstants.VIRGULA));
    	letra.add(new Integer(CompiladorAulaConstants.UNDERLINE));
    	
    	falso.add(new Integer(CompiladorAulaConstants.PONTOVIRGULA));
    	falso.add(new Integer(CompiladorAulaConstants.VIRGULA));
    	
    	palavra.add(new Integer(CompiladorAulaConstants.MAIOR));
    	palavra.add(new Integer(CompiladorAulaConstants.MENOR));
    	palavra.add(new Integer(CompiladorAulaConstants.MENOR_IGUAL));
    	palavra.add(new Integer(CompiladorAulaConstants.MAIOR_IGUAL));
    	palavra.add(new Integer(CompiladorAulaConstants.DIFERENTE));
    	palavra.add(new Integer(CompiladorAulaConstants.IGUAL));
    	palavra.add(new Integer(CompiladorAulaConstants.AND));
    	palavra.add(new Integer(CompiladorAulaConstants.OR));
    	palavra.add(new Integer(CompiladorAulaConstants.ABREBLOCO));
    	palavra.add(new Integer(CompiladorAulaConstants.PONTOVIRGULA));
    	palavra.add(new Integer(CompiladorAulaConstants.FIMBLOCO));
    	palavra.add(new Integer(CompiladorAulaConstants.ID));
    	palavra.add(new Integer(CompiladorAulaConstants.SOMA));
    	palavra.add(new Integer(CompiladorAulaConstants.SUBTRACAO));
    	palavra.add(new Integer(CompiladorAulaConstants.MULTIPLICACAO));
    	palavra.add(new Integer(CompiladorAulaConstants.DIVISAO));
    	palavra.add(new Integer(CompiladorAulaConstants.NUMERO));
    	palavra.add(new Integer(CompiladorAulaConstants.INTEIRO));
    	palavra.add(new Integer(CompiladorAulaConstants.BOOLEANA));
    	palavra.add(new Integer(CompiladorAulaConstants.STRING));
    	palavra.add(new Integer(CompiladorAulaConstants.IF));
    	palavra.add(new Integer(CompiladorAulaConstants.FOR));
    	palavra.add(new Integer(CompiladorAulaConstants.DO)); 	
    	
    	atribuir.add(new Integer(CompiladorAulaConstants.ID)); 	
    	atribuir.add(new Integer(CompiladorAulaConstants.NUMERO)); 	
    	atribuir.add(new Integer(CompiladorAulaConstants.FALSE)); 	
    	atribuir.add(new Integer(CompiladorAulaConstants.TRUE)); 	
    	atribuir.add(new Integer(CompiladorAulaConstants.PALAVRA)); 	
    	
    	operador_matematico.add(new Integer(CompiladorAulaConstants.ID));
    	operador_matematico.add(new Integer(CompiladorAulaConstants.NUMERO));
    	
    	declararMais.add(new Integer(CompiladorAulaConstants.PONTOVIRGULA));

    	nomeVariavel.add(new Integer(CompiladorAulaConstants.ATRIBUICAO));
    	nomeVariavel.add(new Integer(CompiladorAulaConstants.VIRGULA));
    	
    	virgula.add(new Integer(CompiladorAulaConstants.ID));
    	virgula.add(new Integer(CompiladorAulaConstants.LETRA));
    	
    	variavel_if.add(new Integer(CompiladorAulaConstants.MAIOR));
    	variavel_if.add(new Integer(CompiladorAulaConstants.MENOR));
    	variavel_if.add(new Integer(CompiladorAulaConstants.MENOR_IGUAL));
    	variavel_if.add(new Integer(CompiladorAulaConstants.MAIOR_IGUAL));
    	variavel_if.add(new Integer(CompiladorAulaConstants.DIFERENTE));
    	variavel_if.add(new Integer(CompiladorAulaConstants.IGUAL));
    	variavel_if.add(new Integer(CompiladorAulaConstants.AND));
    	variavel_if.add(new Integer(CompiladorAulaConstants.OR));
    	variavel_if.add(new Integer(CompiladorAulaConstants.ABREBLOCO));
    	variavel_if.add(new Integer(CompiladorAulaConstants.FIMBLOCO));
    	variavel_if.add(new Integer(CompiladorAulaConstants.ID));
    	variavel_if.add(new Integer(CompiladorAulaConstants.SOMA));
    	variavel_if.add(new Integer(CompiladorAulaConstants.SUBTRACAO));
    	variavel_if.add(new Integer(CompiladorAulaConstants.MULTIPLICACAO));
    	variavel_if.add(new Integer(CompiladorAulaConstants.DIVISAO));
    	variavel_if.add(new Integer(CompiladorAulaConstants.NUMERO));
    	variavel_if.add(new Integer(CompiladorAulaConstants.INTEIRO));
    	variavel_if.add(new Integer(CompiladorAulaConstants.BOOLEANA));
    	variavel_if.add(new Integer(CompiladorAulaConstants.STRING));
    	variavel_if.add(new Integer(CompiladorAulaConstants.IF));
    	variavel_if.add(new Integer(CompiladorAulaConstants.FOR));
    	variavel_if.add(new Integer(CompiladorAulaConstants.DO)); 	
    	
    	operador_logico.add(new Integer(CompiladorAulaConstants.ID));
    	operador_logico.add(new Integer(CompiladorAulaConstants.NUMERO));
    	operador_logico.add(new Integer(CompiladorAulaConstants.PALAVRA));
    	
    	//-------------------------------------------------------------------
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	

    
    	
    	
    }
}
