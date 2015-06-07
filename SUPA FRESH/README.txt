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
	Duarte Brandão,
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

>Gerar o código Java com o JavaCC: javacc Exp1.jj;

>Compilar o código Java gerado:javac *.java;

//===================================================================================
	DESCRICAO DE UTILIZACAO
//===================================================================================

Executar o analisador sintáctico:java Exp1;

	Depois de executado Exp1:

>Inserir nome de fichero quando pedido com o respetivo path ou arrasta-lo para
a linha de consola e confirmar com tecla enter.
(é necessário indicar a extensão do ficheiro);

>duas secções de mensagem aparecerão divididas por separadores:
a primeira refere erros e avisos relativos ao parsing,
a segunda refere-se  uma análise posterior dos campos lidos;

>Será solicitada uma entry para ordenação dos itens alfabéticamente
(esta ordenação é opcional e afeta o output de raw.html);

>Por fim será solicitado  o nome da pasta de output a ser criada.
Na pasta de output podem ser encontrados diversos ficheiros do tipo html.
A fim de esclarecer o seu conteúdo pode verficar seguidamente uma breve descrição

>index.hml : 
Ligações para os outros ficheiros html.

>raw.html : 
Um output "genérico" da lista de referências bibliográficas. 
Poderá estar ordenado alfabeticamente segundo uma entry especificada pelo utilizador
antes de ser efetuado o output.

>"tipo de referência".html:
Tabelas com todas as referências de um tipo específico que permitem:
Ordenação por uma entry qualquer “on the fly”;
Ocultar ou mostrar tipos de entries específicos;
Pesquisar por palavras.

//===================================================================================
	ANALISE LEXICAL E SINTATICA
//===================================================================================

Toda a análise lexical e sintática é está feita no ficheiro Exp1.jj.

Para tornar possível/facilitar a análise lexical são usados diferentes estados que permitem
evitar a "colisão de tokens" (ex: TOKEN EXEMPLO2A:"aa" sobrepõe-se a TOKEN EXEMPLO1A:"a")
e estruturar a análise por "partes". Estas "partes" representam que o parser está a ler:
fora de um item, dentro de uma @string, dentro de um item ou o valor de uma entry.
Como a ordem sugere, conferem um certo "encapsulamento" à análise semelhante 
uma árvore de classes numa linguagem orientada a objectos cuja representação simplificada seria:

(+externo)                                FORA DE UM ITEM (DEFAULT)  -> pode encapsular com @tipo{
                                               /          \
                         encapsula com  <-   @string     @item type   -> pode encapsular com   
                            ={ ; ="                          |            = ; ={ ; =" ; # ; #" ; #{ 
(+encapsulado)                                          entry value 

Os entry values foram categorizados em values "entre aspas", "entre chavetas" e "outros".
Note-se que quando se usam aspas não é necessário realizar a contagem das chavetas e quando
se usam chavetas não é necessário usar {"} para escrever aspas (por default nos documentos
Bibtex usados com LateX). Ao Categorizar permitimos esta sintaxe standard incluindo também partes de 
texto a italico, negrito e sublinhado definidas em ambiente Latex.
"Outros" apresentam informações numéricas ou identificadores de @strings.


	TRATAMENTO DE ERROS E AVISOS

De uma forma geral os erros são tratados com blocos de try/catch, sendo imprimidas mensagens 
custumizadas sobre o possível erro em causa. O bloco que originou o erro é ignorado sendo por 
vezes realizada uma iteração dos tokens até se encontrar um ponto apartir do qual os dados passem 
a ser novamente válidos. O "encapsulamento" também facilita o tratamento de erros.
Ao ocorrer um erro dentro de um estado o parser vai tentar continuar a análise no mesmo, mas
caso isso não seja possível volta a um estado mais externo.
Outros error são apanhados com tokens como é o exemplo de <NOT_OPEN_ITEM>. Neste caso
não é dado um obtido uma excepção. em vez disso quando se obtém um token no estado fora
de item que é deste tipo realiza-se uma iteração até encontrar um token válido que inicie
o inicio de um novo item  indica-se ao utilizador os limited de input descartados.

	LISTA DE ERROS:

	>Item não aberto; Tipo de item inválido; Sem id (bibtexkey);
	(Descarta item inteiro)

	>Entry inválida; Entry value/info inválido;
	(Descarta entry)
	(Descarta informação de uma entry)
	(Podem causar erros de tipo item inválido)

	>Texto fora de contexto;
	(Não é usado, como se fossem comentários)

	>@string mal defenida;

	>@string referida em item não foi definida ante do mesmo;

	NOTA ADICIONAL SOBRE ERROS:

Erros do tipo:
	@tipo{id,entry="value 
		ou
	@string{id="value 
		etc...
... onde falta o fecho do valor/info da entry. São difíceis de notificar ao utilizador pois nada garante
que o que procede não é efectivamente a string pretendida. Assim sendo existe na maioria
das vezes a notificação de um erro que aparece consequentemente a este específico mas cuja identificação
poderá não ser muito perceptivel ao utilizador. Idealente talvez podessemos tentar identificá-los com
algumas considerações, como o comprimento do valor da entry, mas deixamos tal abordagem por implementar.
	
	AVISOS ADICIONAIS:

	>falta de '=' ao definir entry value/info
 
	>falta de entry qundo encontra por exemplo ",,"	

	>item não fecha com '}' (ocasionalmente aparecerá como consequência de outros erros)

//===================================================================================
	ANALISE SEMANTICA
//===================================================================================

A análise semântica é realizada no ficheiro Expq.jj e no ficheiro Item.java que 
utiliza os arrays definidos em TypeMandatoryEntries.java.

- TypeMandatoryEntries.java
Contém arrays que indicam quais as entries obrigatórias a cada tipo de item.

- StringOperator.java
Contém as @strings encontradas.

- Item.java 
Contém a maioria de funções auxiliares à verificação da semântica.

- Exp.jj 
Contém as iterações onde são chamadas as funções de Item.java e algumas verificações "hard-coded".

- - - While-Parsing - - -

>Verifica-se se um item referência o id de uma @string não declarada antes do item aparecer.
Se tal acontecer o item não poderá realizar subtituição e não aprsentará nenhum valor nesse campo. 
O utilizador é notificado com uma mensagem de erro na primeira secção de mensagens;
nota:
as substituições provenientes de @strings ocorrem durante o parsing;

- - - Pós-Parsing - - - 

>Verifica-se se um item apresenta entries repetidas. Apenas é usada a primeira;

>Verifica-se se existem items com o mesmo identificador/Bibtexkey;
(Apenas realiza output da primeria encontrada)

>Verifica-se se os items apresentam todos os entries obrigatórios.
Notifica o utilizador dos que faltam mas realiza o output à mesma;

>Verifica-se se as crossreferences usadas nos items existem;

>Verifica se existem @string repetidas;
(nota:
As @strings repetidas podem ser usadas à mesma. O item faz a substituição
com a última @string de id identificado antes de si. Imitando o que verificamos
com o output testado em alguns exemplos de Latex.)

>Subtituição de símbolos especiais;

//===================================================================================
	REPRESENTACAO INTERMEDIA
//===================================================================================

Uma classe denominada Item, definida no Item.java, contem a os parâmetros necessários para guardar
a informação de um item. 

As referencias bibliográficas são passadas para como sendo Items para um ArrayList 
à medida que são apanhados durante o Parsing. 

As @string são guardados em dois ArrayLists de Strings à medida que são apanhadas
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
Ele mistura os diversos tipos de error que podem aparecer, com subtituições de
@strings e items corretamente escritos. Analisando o output é possível verificar
que os items bem contruidos são apresentados nno output e que os outros são descartados.
Também podem ser verificados o tratamento de erros na compilação.


//===================================================================================
	NOTAS ADICIONAIS
//===================================================================================

Alguns promenores ficaram itencionalmente diferentes face ao Bibtex/Latex.
Achamos que não fazia sentido permitir newlines ou impedir a escrita de @ quando se usam chavetas.

//===================================================================================
	PONTOS POSITIVOS
//===================================================================================

Trabalho razoavelmente completo.
Apresenta ao utilizador feedback razoável sobre os erros encontrados e é compativel
com a maior parte das funcionalidades que podem já vir definidas para Latex.

//===================================================================================
	PONTOS NEGATIVOS
//===================================================================================

Não averiguamos o possível uso de @preambles.
Poderá não fazer sentido para o projeto em causa.


