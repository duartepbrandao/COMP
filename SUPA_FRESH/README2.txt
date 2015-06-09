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

A fim de esclarecer poss�veis equ�vocos:

Com base nos nomes que foram usados nas classes/tokens da implementa��o
As refer�ncias bibliogr�ficas podem aparecer referidas como items
A informa��o de um dos campos de uma refer�ncia bibliogr�fica podem aparecer referido como info ou valor de entry

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
Tabelas com todas as refer�ncias de um tipo espec�fico.
As tabelas fazem uso de uma FRAMEWORK ONLINE
e permitem:
Ordena��o por uma entry qualquer �on the fly�;
Ocultar ou mostrar tipos de entries espec�ficos;
Pesquisar por palavras.


//===================================================================================
	EXEMPLOS
//===================================================================================

A fim de mostrar as funcionalidades foram preparados diversos exemplos que podem ser 
encontrados na pasta examples:

	>test1.bib: 

Este ficheiro imprime um exemplo dado no site "https://verbosus.com/bibtex-style-examples.html".
Pretende mostrar um exemplo de compila��o de v�rios items de diferentes tipos sem erros.
Apresenta apenas um erro devido a primeira linha que faz refer�ncia ao sitio web e 
avisos face a algumas entries obrigat�rias estarem em falta.
	
	>test2.bib: 
	
Este ficheiro pretende demonstrar todas as funcionalidades do nosso projeto.
Ele mistura os diversos tipos de erros que podem aparecer com items corretamente escritos, 
com subtitui��es de @strings, crossreferences, concatena��es de @strings com texto e
texto a sublinhado, negrito e /ou it�lico. Analisando o output � poss�vel verificar
que os items bem contruidos s�o apresentados no output e que os outros s�o descartados.
Tamb�m podem ser verificados o tratamento de erros na compila��o.

	>Outros: some<theme> .bib
	Partes (algumas modificadas) de bibliografias presentes em "http://www.netlib.org/tex/bib/".
	Os exemplos podem ser encontrados na sua forma completa nas p�ginas:
		http://ftp.math.utah.edu/pub/tex/bib/csharp.html
		http://ftp.math.utah.edu/pub/tex/bib/fortran3.html
		http://ftp.math.utah.edu/pub/tex/bib/texbook3.html
		http://ftp.math.utah.edu/pub/tex/bib/elefunt.html
		http://ftp.math.utah.edu/pub/tex/bib/fparith.html

Este conjunto de ficheiros pretende demonstrar que o compilador consegue 
tratar bibliografias reais.
Alguns items apresentam entries n�o consideradas e tamb�m n�o s�o usados
@preambles, mas dentro dos poss�veis � realizado o output at� chegar ao
�ltimo item.


//===================================================================================
	ANALISE LEXICAL E SINTATICA
//===================================================================================

Toda a an�lise lexical e sint�tica � feita no ficheiro Exp1.jj.

Para tornar poss�vel/facilitar a an�lise lexical s�o usados diferentes estados que permitem
evitar a "colis�o de tokens" (ex: TOKEN EXEMPLO2A:"aa" sobrep�e-se a TOKEN EXEMPLO1A:"a")
e estruturar a an�lise por "partes". Estas "partes" representam que tipo de segmento 
o parser est� a ler, que podem ser:
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
se usam chavetas n�o � necess�rio usar {"} para escrever aspas.
Ao Categorizar permitimos esta sintaxe standard. 

Incluiu-se tamb�m produ��es que permitem considerar texto a it�lico, negrito e sublinhado 
definidos em contexto de Latex para estes dois estados.

"Outros" apresentam informa��es num�ricas, abreviaturas de meses ou identificadores de @strings.

Foram implementadas produ��es que permitem a concatena��o de diferentes tipos na obten��o do 
valor/info de uma entry. 
Exemplo de contena��o : string1 # " more text" # { plus the end} 

	TRATAMENTO DE ERROS E AVISOS

De uma forma geral os erros (tanto lexicais como de sintaxe) s�o tratados com blocos de try/catch, 
sendo imprimidas mensagens custumizadas sobre o poss�vel erro em causa. O bloco que originou o erro � 
ignorado sendo por vezes realizada uma itera��o dos tokens at� se encontrar um ponto apartir do qual 
os dados passem a ser novamente v�lidos. O "encapsulamento" tamb�m facilita o tratamento de erros.
Ao ocorrer um erro dentro de um estado o parser vai tentar continuar a an�lise no mesmo, mas
caso isso n�o seja poss�vel volta a um estado mais externo.

Outros error s�o apanhados com tokens como � o exemplo de <NOT_OPEN_ITEM>. Neste caso
n�o � usada excep��o. Em vez disso quando se obt�m um token no estado "fora
de item" que seja deste tipo realiza-se uma itera��o at� encontrar um token v�lido que indique
o inicio de um novo item descartando o input que se encontra fora de items. 
O utilizador � informado dos limites do input que foi descartado.

	LISTA DE ERROS:

	>Item n�o aberto; Tipo de item inv�lido; Sem id (bibtexkey);
	(Descarta item inteiro)

	>Entry inv�lida; Entry value/info inv�lido;
	(Descarta entry)
	(Descarta informa��o de uma entry)
	(Podem causar erros de tipo item inv�lido)

	>Texto fora de contexto;
	(N�o � usado. (como se fossem coment�rios))

	>@string mal definida;

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
Este erro pode descartar items que est�o correctamente escritos dado a serem considerados como parte
do texto n�o fechado.
	
	AVISOS ADICIONAIS:

	>falta de '=' ao definir entry value/info
 
	>falta de entry quando encontra por exemplo ",,"	

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

- Exp.jj (referente ao source antes de compilar)
Cont�m as itera��es onde s�o chamadas as fun��es de Item.java e algumas verifica��es "hard-coded".

- - - While-Parsing - - -

>Verifica-se se um item refer�ncia o id de uma @string n�o declarada antes do item aparecer.
Se tal acontecer o item n�o poder� realizar subtitui��o e n�o aprsentar� nenhum valor nesse campo. 
O utilizador � notificado com uma mensagem de erro na primeira sec��o de mensagens;
(nota: as substitui��es provenientes de @strings ocorrem durante o parsing)

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

//===================================================================================
	REPRESENTACAO INTERMEDIA
//===================================================================================

Classe Item, definida no Item.java, contem a os par�metros necess�rios para guardar
a informa��o de um item. 

As referencias bibliogr�ficas s�o passadas como sendo Items para um ArrayList 
� medida que s�o apanhados durante o Parsing. 
A lista de items encontra-se definida no Exp1.jj e ser� "actualizada" pelo mesmo.

As @string s�o guardados em dois ArrayLists de Strings � medida que s�o apanhadas
durante o Parsing. 
Estas listas encontra-se definidas na classe SringOperator.java, que por sua vez � 
instanciada na classe Item (em Item.java) com uma vari�vel est�tica. As listas s�o 
"actualizadas" no Exp1.jj;

Substitui��es de @string ou de abreviaturas de meses s�o realizadas durante o Parsing enquanto se passam os 
dados para a adi��o de um novo Item � lista de items. 

 ("actualizadas" refire-se aos blocos de c�digo do source antes de compilar)

//===================================================================================
	GERACAO DE CODIGO
//===================================================================================

	DESCRI��O:
	
>S�o criados diversos ficheiro html.

>Index.html serve de liga��o aos outros ficheiros e � gerado sempre com a mesma informa��o.

>Raw.html � criado vazio, apenas com o c�digo a abertura default de um html.

>Outros .html com o nome de cada tipo de item s�o criados com informa��o necess�ria para poder
gerar tabelas cujo conte�do ser� depois escrito. Casa tipo tem informa��o diferente.

>Caso o utilizador tenha indicado uma entry para ordena��o a lista items da "linguagem interm�dia" � ordenada.

>S�o percorridos os items, na lista de items, fazendo um output semelhante ao de uma bibliografia
para o raw.html. � tamb�m realizado outro output para tabelas html num ficheiro para o tipo espec�fico do item.

>� realizada a subtitui��o de s�mbolos especiais ao escrever o valor das entries nos ficheiros html;
		
		
//===================================================================================
	TESTES
//===================================================================================		
		
Os testes realizados tiveram que ser feitos � m�o ou usando exemplos j� existentes,
nomeadamente partes de bibliiografias reais que se podem encontram em 
"http://www.netlib.org/tex/bib/". 

N�o automatizamos o processo pois seria dif�cil de obter padr�es fora do vulgar
caso este fosse desenvolvido por n�s. Assim, considerando exemplos reais, conseguimos uma vis�o
mais realista do que o nosso compilador consegue ou n�o realizar.

//===================================================================================
	ARQUITETURA
//===================================================================================
		
� chamado o parser definido em javacc para realizar a an�lise sint�tica e l�xical,
passando os diversos items do ficheiro de input para as estruturas de representa��o interm�dia.

Como j� explicado anteriormente esta an�lise ocorre em "camadas".
Segmentos com problemas s�o descartados passando a an�lise para um bloco v�lido mais � frente. 

Ao analisar o valor/info de uma entry s�o usadas vari�veis auxiliares de modo a permitir 
a concatena��o de v�rios blocos de texto e/ou refer�ncias a @string.
Durante esta an�lise tamb�m se realizam algumas verifica��es sem�nticas, nomeadamente, verifica-se
se todas as refer�ncias a @strings s�o v�lidas analisando a lista de @strings actual. 
Se forem v�lidas o seu valor � adicionado ao valor/info da entry.

Terminada a an�lise procede-se a an�lise sem�nticas onde se percorrem todos os items para
encontrar poss�veis erros como falta de entries obrigat�rias, entries repetidas ou crossreferences 
a items n�o definidos. Neste �ltimo caso a lista precisa de ser percorrida para confirmar a exist�ncia
do item.

Depois da an�lise estar completa realiza-se o output dos items com a substitui��o de padr�es Latex para 
texto normal. 
		
//===================================================================================
	NOTAS ADICIONAIS
//===================================================================================

Consideramos a classifica��o das entries como sendo obrigat�rias ou n�o, segundo o JabRef 2.10.

Alguns pormenores ficaram itencionalmente diferentes face ao Bibtex/Latex.
Achamos que n�o fazia sentido permitir newlines ou impedir a escrita de @ quando se usam chavetas.
N�o achamos relevante considerar coment�rios dado que o pr�prio Bibtex tende a ignorar 
texto que esteja fora de items.

O output raw.html e as tabelas contemplam quase todos os tipos de items diferentes existentes mas n�o todos.

//===================================================================================
	PONTOS POSITIVOS
//===================================================================================

Trabalho razoavelmente completo.
Apresenta ao utilizador feedback razo�vel sobre os erros encontrados e � compat�vel
com algumas das funcionalidades que podem j� vir definidas para Latex. 

O output em tabelas permite ordena��o e pesquisa.

O output "cru" (raw.html) pode ser ordenado.

//===================================================================================
	PONTOS NEGATIVOS
//===================================================================================

>N�o averiguamos o poss�vel uso de @preambles.
Poder� n�o fazer sentido para o projeto em causa.

>Revocando o que foi referido na "NOTA ADICIONAL SOBRE ERROS"
talvez podessemos ter tratado este erro espec�fico com maior cuidado.

>O uso de funcionalidades do Latex para real�ar o texto s� pode ser feito
atrav�s do uso de prefixos. O Latex tamb�m permite incluir no inicio de chavetas.
exemplos:
 \underline{text} -> funciona ok
 {\underline text} -> devia funcionar mas n�o � contemplado

 >Algumas funcionlidades como a referida acima e alguns caracteres especiais
 n�o s�o considerados. A lista � extensa e depende sempre da vers�o do Latex considerada.
 
 >Um problema que foi descoberto na fase de testes � que "tags" (ex:\em) que n�o sejam 
 contempldas na nossa gram�tica provocam problemas (podendo descartar todo o output).
 