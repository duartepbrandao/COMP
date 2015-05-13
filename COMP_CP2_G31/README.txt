                                                                        
                                                                        
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
//=======================================================
	BibTeX2HTML

	Autoria de
	Bruno Madeira,
	Duarte Brandão,
	Pedro Ferreira
	em 12/05/2015
//=======================================================

//=======================================================
	COMO COMPILAR E EXECUTAR
//=======================================================

>Coloque todos os ficheiros da directotia source na pasta destino
onde pretende compilar/executar o BibTeX2HTML;

>Gerar o código Java com o JavaCC: javacc Exp1.jj;

>Compilar o código Java gerado:javac *.java;

>Executar o analisador sintáctico:java Exp1;

	Depois de executado Exp1:

>Inserir nome de fichero quando pedido com o respetivo path ou arrasta-lo para
a linha de consola e confirmar com tecla enter.
(é necessário indicar a extensão do ficheiro);

>duas secções de mensagem aparecerão divididas por separadores:
a primeira refere erros e avisos relativos ao parsing,
a segunda refere-se  uma análise posterior dos campos lidos;

>Seguidamente será solicitado  o nome de ficheiro de output
(é necessário indicar a extensão do ficheiro: .html);

//=======================================================
	LISTA DE VALIDAÇÕES SEMÂNTICAS
//=======================================================

>Verifica se um item apresenta entries repetidas. (só realiza output da primeria encontrada);

>Verifica se existem items com o mesmo identificador/bibteckey (só realiza output do primeria encontrada);

>Verifica se os items apresentam todos os entries obrigatórios;

>Verifica se as crossreferences usadas nos items existem;

//=======================================================
	FEATURES
//=======================================================

>Tentam-se descartar erros durante o parsing de modo a aproveitar a maior quantidade possivel do ficheiro de input;

>Pode usar items do tipo @string para realizar subtituições. (necessita de usar o caracter '"' nos items à mesma, deverá ser corrigo posteriormente);

>Pode usar no inicio do ficheiro input o nome de uma entry antecedida por "##" para ordenar o output dos items;



