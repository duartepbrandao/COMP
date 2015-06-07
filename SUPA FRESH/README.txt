/|        .--./|                       __.....__                        
||        |__|||                   .-''         '.                      
||        .--.||             .|   /     .-''"'-.  `.                    
||  __    |  |||  __       .' |_ /     /________\   \ ____     _____    
||/'__ '. |  |||/'__ '.  .'     ||                  |`.   \  .'    /    
|:/`  '. '|  ||:/`  '. ''--.  .-'\    .-------------'  `.  `'    .'     
||     | ||  |||     | |   |  |   \    '-.____...---.    '.    .'       
||\    / '|__|||\    / '   |  |    `.             .'     .'     `.      
|/\'..' /     |/\'..' /    |  '.'    `''-...... -'     .'  .'`.   `.    
'  `'-'`      '  `'-'`     |   /     .-''-.          .'   /    `.   `.  
                           `'-'    .' .-.  )        '----'       '----' 
                                  / .'  / /                             
                                 (_/   / /                              
                                      / /                               
                                     / /                                
                                    . '                                 
                                   / /    _.-')                         
                                 .' '  _.'.-''           .---.          
                       .        /  /.-'_.'__  __   ___   |   |          
                     .'|       /    _.'  |  |/  `.'   `. |   |          
                    <  |      ( _.-' .|  |   .-.  .-.   '|   |          
                     | |           .' |_ |  |  |  |  |  ||   |          
                     | | .'''-.  .'     ||  |  |  |  |  ||   |          
                     | |/.'''. \'--.  .-'|  |  |  |  |  ||   |          
                     |  /    | |   |  |  |  |  |  |  |  ||   |          
                     | |     | |   |  |  |__|  |__|  |__||   |          
                     | |     | |   |  '.'                '---'          
                     | '.    | '.  |   /                                
                     '---'   '---' `'-'      
                                            $$$$$$$$\ $$$$$$$$\ $$\   $$\ $$$$$$$\  
                                            $$  _____|$$  _____|$$ |  $$ |$$  __$$\ 
                                            $$ |      $$ |      $$ |  $$ |$$ |  $$ |
                                            $$$$$\    $$$$$\    $$ |  $$ |$$$$$$$  |
                                            $$  __|   $$  __|   $$ |  $$ |$$  ____/ 
                                            $$ |      $$ |      $$ |  $$ |$$ |      
                                            $$ |      $$$$$$$$\ \$$$$$$  |$$ |       
//===================================================================================
//===================================================================================

	BibTeX2HTML

	Autoria de
	Bruno Madeira,
	Duarte Brand�o,
	Pedro Ferreira.
	Grupo G31 para a disciplina de Compiladores
	em 09/06/2015, 
	FEUP

//===================================================================================

//===================================================================================
	COMO COMPILAR E EXECUTAR
//===================================================================================

>Coloque todos os ficheiros da directotia source na pasta destino
onde pretende compilar/executar o BibTeX2HTML;

>Gerar o c�digo Java com o JavaCC: javacc Exp1.jj;

>Compilar o c�digo Java gerado:javac *.java;

//===================================================================================
	DESCRICAO DE UTILIZACAO
//===================================================================================

Executar o analisador sint�ctico:java Exp1;

	Depois de executado Exp1:

>Inserir nome de fichero quando pedido com o respetivo path ou arrasta-lo para
a linha de consola e confirmar com tecla enter.
(� necess�rio indicar a extens�o do ficheiro);

>duas sec��es de mensagem aparecer�o divididas por separadores:
a primeira refere erros e avisos relativos ao parsing,
a segunda refere-se  uma an�lise posterior dos campos lidos;

>Ser� solicitada uma entry para ordena��o dos itens alfab�ticamente
(esta ordena��o � opcional e afeta o output de raw.html);

>Por fim ser� solicitado  o nome da pasta de output a ser criada.
Na pasta de output podem ser encontrados diversos ficheiros do tipo html.
A fim de esclarecer o seu conte�do pode verficar seguidamente uma breve descri��o

>index.hml : 
Liga��es para os outros ficheiros html.

>raw.html : 
Um output "gen�rico" da lista de refer�ncias bibliogr�ficas. 
Poder� estar ordenado alfabeticamente segundo uma entry especificada pelo utilizador
antes de ser efetuado o output.

>"tipo de refer�ncia".html:
Tabelas com todas as refer�ncias de um tipo espec�fico que permitem:
Ordena��o por uma entry qualquer �on the fly�;
Ocultar ou mostrar tipos de entries espec�ficos;
Pesquisar por palavras.

//===================================================================================
	ANALISE LEXICAL E SINTATICA
//===================================================================================

Toda a an�lise lexical e sint�tica � est� feita no ficheiro Exp1.jj.

Para tornar poss�vel/facilitar a an�lise lexical s�o usados diferentes estados que permitem
evitar a "colis�o de tokens" (ex: TOKEN EXEMPLO2A:"aa" sobrep�e-se a TOKEN EXEMPLO1A:"a")
e estruturar a an�lise por "partes". Estas "partes" representam que o parser est� a ler:
fora de um item, dentro de uma @string, dentro de um item ou o valor de uma entry.
Como a ordem sugere, conferem um certo "encapsulamento" � an�lise semelhante 
uma �rvore de classes numa linguagem orientada a objectos cuja representa��o simplificada seria:

(+externo)                                FORA DE UM ITEM (DEFAULT)  -> pode encapsular com @tipo{
                                               /          \
                         encapsula com  <-   @string     @item type   -> pode encapsular com   
                            ={ ; ="                          |            = ; ={ ; =" ; # ; #" ; #{ 
(+encapsulado)                                          entry value 

Os entry values foram categorizados em values "entre aspas", "entre chavetas" e "outros".
Note-se que quando se usam aspas n�o � necess�rio realizar a contagem das chavetas e quando
se usam chavetas n�o � necess�rio usar {"} para escrever aspas (por default nos documentos
Bibtex usados com LateX). Ao Categorizar permitimos esta sintaxe standard incluindo tamb�m partes de 
texto a italico, negrito e sublinhado definidas em ambiente Latex.
"Outros" apresentam informa��es num�ricas ou identificadores de @strings.


	TRATAMENTO DE ERROS E AVISOS

De uma forma geral os erros s�o tratados com blocos de try/catch, sendo imprimidas mensagens 
custumizadas sobre o poss�vel erro em causa. O bloco que originou o erro � ignorado sendo por 
vezes realizada uma itera��o dos tokens at� se encontrar um ponto apartir do qual os dados passem 
a ser novamente v�lidos. O "encapsulamento" tamb�m facilita o tratamento de erros.
Ao ocorrer um erro dentro de um estado o parser vai tentar continuar a an�lise no mesmo, mas
caso isso n�o seja poss�vel volta a um estado mais externo.
Outros error s�o apanhados com tokens como � o exemplo de <NOT_OPEN_ITEM>. Neste caso
n�o � dado um obtido uma excep��o. em vez disso quando se obt�m um token no estado fora
de item que � deste tipo realiza-se uma itera��o at� encontrar um token v�lido que inicie
o inicio de um novo item  indica-se ao utilizador os limited de input descartados.

	LISTA DE ERROS:

	>Item n�o aberto; Tipo de item inv�lido; Sem id (bibtexkey);
	(Descarta item inteiro)

	>Entry inv�lida; Entry value/info inv�lido;
	(Descarta entry)
	(Descarta informa��o de uma entry)
	(Podem causar erros de tipo item inv�lido)

	>Texto fora de contexto;
	(N�o � usado, como se fossem coment�rios)

	>@string mal defenida;

	>@string referida em item n�o foi definida ante do mesmo;

	NOTA ADICIONAL SOBRE ERROS:

Erros do tipo:
	@tipo{id,entry="value 
		ou
	@string{id="value 
		etc...
... onde falta o fecho do valor/info da entry. S�o dif�ceis de notificar ao utilizador pois nada garante
que o que procede n�o � efectivamente a string pretendida. Assim sendo existe na maioria
das vezes a notifica��o de um erro que aparece consequentemente a este espec�fico mas cuja identifica��o
poder� n�o ser muito perceptivel ao utilizador. Idealente talvez podessemos tentar identific�-los com
algumas considera��es, como o comprimento do valor da entry, mas deixamos tal abordagem por implementar.
	
	AVISOS ADICIONAIS:

	>falta de '=' ao definir entry value/info
 
	>falta de entry qundo encontra por exemplo ",,"	

	>item n�o fecha com '}' (ocasionalmente aparecer� como consequ�ncia de outros erros)

//===================================================================================
	ANALISE SEMANTICA
//===================================================================================

A an�lise sem�ntica � realizada no ficheiro Expq.jj e no ficheiro Item.java que 
utiliza os arrays definidos em TypeMandatoryEntries.java.

- TypeMandatoryEntries.java
Cont�m arrays que indicam quais as entries obrigat�rias a cada tipo de item.

- StringOperator.java
Cont�m as @strings encontradas.

- Item.java 
Cont�m a maioria de fun��es auxiliares � verifica��o da sem�ntica.

- Exp.jj 
Cont�m as itera��es onde s�o chamadas as fun��es de Item.java e algumas verifica��es "hard-coded".

- - - While-Parsing - - -

>Verifica-se se um item refer�ncia o id de uma @string n�o declarada antes do item aparecer.
Se tal acontecer o item n�o poder� realizar subtitui��o e n�o aprsentar� nenhum valor nesse campo. 
O utilizador � notificado com uma mensagem de erro na primeira sec��o de mensagens;
nota:
as substitui��es provenientes de @strings ocorrem durante o parsing;

- - - P�s-Parsing - - - 

>Verifica-se se um item apresenta entries repetidas. Apenas � usada a primeira;

>Verifica-se se existem items com o mesmo identificador/Bibtexkey;
(Apenas realiza output da primeria encontrada)

>Verifica-se se os items apresentam todos os entries obrigat�rios.
Notifica o utilizador dos que faltam mas realiza o output � mesma;

>Verifica-se se as crossreferences usadas nos items existem;

>Verifica se existem @string repetidas;
(nota:
As @strings repetidas podem ser usadas � mesma. O item faz a substitui��o
com a �ltima @string de id identificado antes de si. Imitando o que verificamos
com o output testado em alguns exemplos de Latex.)

>Subtitui��o de s�mbolos especiais;

//===================================================================================
	REPRESENTACAO INTERMEDIA
//===================================================================================

Uma classe denominada Item, definida no Item.java, contem a os par�metros necess�rios para guardar
a informa��o de um item. 

As referencias bibliogr�ficas s�o passadas para como sendo Items para um ArrayList 
� medida que s�o apanhados durante o Parsing. 

As @string s�o guardados em dois ArrayLists de Strings � medida que s�o apanhadas
durante o Parsing.

//===================================================================================
	GERACAO DE CODIGO
//===================================================================================

TODO ... ... ...

//===================================================================================
	TESTES
//===================================================================================
A fim de mostrar as funcionalidades foram preparados diversos exemplos que podem ser 
encontrados na pasta examples:

TODO smaller specific tests...  ....

>test2.bib: 
Este ficheiro pretende demonstrar todas as funcionalidades do nosso projeto.
Ele mistura os diversos tipos de error que podem aparecer, com subtitui��es de
@strings e items corretamente escritos. Analisando o output � poss�vel verificar
que os items bem contruidos s�o apresentados nno output e que os outros s�o descartados.
Tamb�m podem ser verificados o tratamento de erros na compila��o.


//===================================================================================
	NOTAS ADICIONAIS
//===================================================================================

Alguns promenores ficaram itencionalmente diferentes face ao Bibtex/Latex.
Achamos que n�o fazia sentido permitir newlines ou impedir a escrita de @ quando se usam chavetas.

//===================================================================================
	PONTOS POSITIVOS
//===================================================================================

Trabalho razoavelmente completo.
Apresenta ao utilizador feedback razo�vel sobre os erros encontrados e � compativel
com a maior parte das funcionalidades que podem j� vir definidas para Latex.

//===================================================================================
	PONTOS NEGATIVOS
//===================================================================================

N�o averiguamos o poss�vel uso de @preambles.
Poder� n�o fazer sentido para o projeto em causa.


