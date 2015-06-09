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

A fim de esclarecer possíveis equívocos:

Com base nos nomes que foram usados nas classes/tokens da implementação
As referências bibliográficas podem aparecer referidas como items
A informação de um dos campos de uma referência bibliográfica podem aparecer referido como info ou valor de entry

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
Tabelas com todas as referências de um tipo específico.
As tabelas fazem uso de uma FRAMEWORK ONLINE
e permitem:
Ordenação por uma entry qualquer “on the fly”;
Ocultar ou mostrar tipos de entries específicos;
Pesquisar por palavras.


//===================================================================================
	EXEMPLOS
//===================================================================================

A fim de mostrar as funcionalidades foram preparados diversos exemplos que podem ser 
encontrados na pasta examples:

	>test1.bib: 

Este ficheiro imprime um exemplo dado no site "https://verbosus.com/bibtex-style-examples.html".
Pretende mostrar um exemplo de compilação de vários items de diferentes tipos sem erros.
Apresenta apenas um erro devido a primeira linha que faz referência ao sitio web e 
avisos face a algumas entries obrigatórias estarem em falta.
	
	>test2.bib: 
	
Este ficheiro pretende demonstrar todas as funcionalidades do nosso projeto.
Ele mistura os diversos tipos de erros que podem aparecer com items corretamente escritos, 
com subtituições de @strings, crossreferences, concatenações de @strings com texto e
texto a sublinhado, negrito e /ou itálico. Analisando o output é possível verificar
que os items bem contruidos são apresentados no output e que os outros são descartados.
Também podem ser verificados o tratamento de erros na compilação.

	>Outros: some<theme> .bib
	Partes (algumas modificadas) de bibliografias presentes em "http://www.netlib.org/tex/bib/".
	Os exemplos podem ser encontrados na sua forma completa nas páginas:
		http://ftp.math.utah.edu/pub/tex/bib/csharp.html
		http://ftp.math.utah.edu/pub/tex/bib/fortran3.html
		http://ftp.math.utah.edu/pub/tex/bib/texbook3.html
		http://ftp.math.utah.edu/pub/tex/bib/elefunt.html
		http://ftp.math.utah.edu/pub/tex/bib/fparith.html

Este conjunto de ficheiros pretende demonstrar que o compilador consegue 
tratar bibliografias reais.
Alguns items apresentam entries não consideradas e também não são usados
@preambles, mas dentro dos possíveis é realizado o output até chegar ao
último item.


//===================================================================================
	ANALISE LEXICAL E SINTATICA
//===================================================================================

Toda a análise lexical e sintática é feita no ficheiro Exp1.jj.

Para tornar possível/facilitar a análise lexical são usados diferentes estados que permitem
evitar a "colisão de tokens" (ex: TOKEN EXEMPLO2A:"aa" sobrepõe-se a TOKEN EXEMPLO1A:"a")
e estruturar a análise por "partes". Estas "partes" representam que tipo de segmento 
o parser está a ler, que podem ser:
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
se usam chavetas não é necessário usar {"} para escrever aspas.
Ao Categorizar permitimos esta sintaxe standard. 

Incluiu-se também produções que permitem considerar texto a itálico, negrito e sublinhado 
definidos em contexto de Latex para estes dois estados.

"Outros" apresentam informações numéricas, abreviaturas de meses ou identificadores de @strings.

Foram implementadas produções que permitem a concatenação de diferentes tipos na obtenção do 
valor/info de uma entry. 
Exemplo de contenação : string1 # " more text" # { plus the end} 

	TRATAMENTO DE ERROS E AVISOS

De uma forma geral os erros (tanto lexicais como de sintaxe) são tratados com blocos de try/catch, 
sendo imprimidas mensagens custumizadas sobre o possível erro em causa. O bloco que originou o erro é 
ignorado sendo por vezes realizada uma iteração dos tokens até se encontrar um ponto apartir do qual 
os dados passem a ser novamente válidos. O "encapsulamento" também facilita o tratamento de erros.
Ao ocorrer um erro dentro de um estado o parser vai tentar continuar a análise no mesmo, mas
caso isso não seja possível volta a um estado mais externo.

Outros error são apanhados com tokens como é o exemplo de <NOT_OPEN_ITEM>. Neste caso
não é usada excepção. Em vez disso quando se obtém um token no estado "fora
de item" que seja deste tipo realiza-se uma iteração até encontrar um token válido que indique
o inicio de um novo item descartando o input que se encontra fora de items. 
O utilizador é informado dos limites do input que foi descartado.

	LISTA DE ERROS:

	>Item não aberto; Tipo de item inválido; Sem id (bibtexkey);
	(Descarta item inteiro)

	>Entry inválida; Entry value/info inválido;
	(Descarta entry)
	(Descarta informação de uma entry)
	(Podem causar erros de tipo item inválido)

	>Texto fora de contexto;
	(Não é usado. (como se fossem comentários))

	>@string mal definida;

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
Este erro pode descartar items que estão correctamente escritos dado a serem considerados como parte
do texto não fechado.
	
	AVISOS ADICIONAIS:

	>falta de '=' ao definir entry value/info
 
	>falta de entry quando encontra por exemplo ",,"	

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

- Exp.jj (referente ao source antes de compilar)
Contém as iterações onde são chamadas as funções de Item.java e algumas verificações "hard-coded".

- - - While-Parsing - - -

>Verifica-se se um item referência o id de uma @string não declarada antes do item aparecer.
Se tal acontecer o item não poderá realizar subtituição e não aprsentará nenhum valor nesse campo. 
O utilizador é notificado com uma mensagem de erro na primeira secção de mensagens;
(nota: as substituições provenientes de @strings ocorrem durante o parsing)

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

//===================================================================================
	REPRESENTACAO INTERMEDIA
//===================================================================================

Classe Item, definida no Item.java, contem a os parâmetros necessários para guardar
a informação de um item. 

As referencias bibliográficas são passadas como sendo Items para um ArrayList 
à medida que são apanhados durante o Parsing. 
A lista de items encontra-se definida no Exp1.jj e será "actualizada" pelo mesmo.

As @string são guardados em dois ArrayLists de Strings à medida que são apanhadas
durante o Parsing. 
Estas listas encontra-se definidas na classe SringOperator.java, que por sua vez é 
instanciada na classe Item (em Item.java) com uma variável estática. As listas são 
"actualizadas" no Exp1.jj;

Substituições de @string ou de abreviaturas de meses são realizadas durante o Parsing enquanto se passam os 
dados para a adição de um novo Item à lista de items. 

 ("actualizadas" refire-se aos blocos de código do source antes de compilar)

//===================================================================================
	GERACAO DE CODIGO
//===================================================================================

	DESCRIÇÃO:
	
>São criados diversos ficheiro html.

>Index.html serve de ligação aos outros ficheiros e é gerado sempre com a mesma informação.

>Raw.html é criado vazio, apenas com o código a abertura default de um html.

>Outros .html com o nome de cada tipo de item são criados com informação necessária para poder
gerar tabelas cujo conteúdo será depois escrito. Casa tipo tem informação diferente.

>Caso o utilizador tenha indicado uma entry para ordenação a lista items da "linguagem intermédia" é ordenada.

>São percorridos os items, na lista de items, fazendo um output semelhante ao de uma bibliografia
para o raw.html. É também realizado outro output para tabelas html num ficheiro para o tipo específico do item.

>É realizada a subtituição de símbolos especiais ao escrever o valor das entries nos ficheiros html;
		
		
//===================================================================================
	TESTES
//===================================================================================		
		
Os testes realizados tiveram que ser feitos à mão ou usando exemplos já existentes,
nomeadamente partes de bibliiografias reais que se podem encontram em 
"http://www.netlib.org/tex/bib/". 

Não automatizamos o processo pois seria difícil de obter padrões fora do vulgar
caso este fosse desenvolvido por nós. Assim, considerando exemplos reais, conseguimos uma visão
mais realista do que o nosso compilador consegue ou não realizar.

//===================================================================================
	ARQUITETURA
//===================================================================================
		
É chamado o parser definido em javacc para realizar a análise sintática e léxical,
passando os diversos items do ficheiro de input para as estruturas de representação intermédia.

Como já explicado anteriormente esta análise ocorre em "camadas".
Segmentos com problemas são descartados passando a análise para um bloco válido mais à frente. 

Ao analisar o valor/info de uma entry são usadas variáveis auxiliares de modo a permitir 
a concatenação de vários blocos de texto e/ou referências a @string.
Durante esta análise também se realizam algumas verificações semânticas, nomeadamente, verifica-se
se todas as referências a @strings são válidas analisando a lista de @strings actual. 
Se forem válidas o seu valor é adicionado ao valor/info da entry.

Terminada a análise procede-se a análise semânticas onde se percorrem todos os items para
encontrar possíveis erros como falta de entries obrigatórias, entries repetidas ou crossreferences 
a items não definidos. Neste último caso a lista precisa de ser percorrida para confirmar a existência
do item.

Depois da análise estar completa realiza-se o output dos items com a substituição de padrões Latex para 
texto normal. 
		
//===================================================================================
	NOTAS ADICIONAIS
//===================================================================================

Consideramos a classificação das entries como sendo obrigatórias ou não, segundo o JabRef 2.10.

Alguns pormenores ficaram itencionalmente diferentes face ao Bibtex/Latex.
Achamos que não fazia sentido permitir newlines ou impedir a escrita de @ quando se usam chavetas.
Não achamos relevante considerar comentários dado que o próprio Bibtex tende a ignorar 
texto que esteja fora de items.

O output raw.html e as tabelas contemplam quase todos os tipos de items diferentes existentes mas não todos.

//===================================================================================
	PONTOS POSITIVOS
//===================================================================================

Trabalho razoavelmente completo.
Apresenta ao utilizador feedback razoável sobre os erros encontrados e é compatível
com algumas das funcionalidades que podem já vir definidas para Latex. 

O output em tabelas permite ordenação e pesquisa.

O output "cru" (raw.html) pode ser ordenado.

//===================================================================================
	PONTOS NEGATIVOS
//===================================================================================

>Não averiguamos o possível uso de @preambles.
Poderá não fazer sentido para o projeto em causa.

>Revocando o que foi referido na "NOTA ADICIONAL SOBRE ERROS"
talvez podessemos ter tratado este erro específico com maior cuidado.

>O uso de funcionalidades do Latex para realçar o texto só pode ser feito
através do uso de prefixos. O Latex também permite incluir no inicio de chavetas.
exemplos:
 \underline{text} -> funciona ok
 {\underline text} -> devia funcionar mas não é contemplado

 >Algumas funcionlidades como a referida acima e alguns caracteres especiais
 não são considerados. A lista é extensa e depende sempre da versão do Latex considerada.
 
 >Um problema que foi descoberto na fase de testes é que "tags" (ex:\em) que não sejam 
 contempldas na nossa gramática provocam problemas (podendo descartar todo o output).
 