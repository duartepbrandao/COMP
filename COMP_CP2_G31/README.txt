                                                                        
                                                                        
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
	Duarte Brand�o,
	Pedro Ferreira
	em 12/05/2015
//=======================================================

//=======================================================
	COMO COMPILAR E EXECUTAR
//=======================================================

>Coloque todos os ficheiros da directotia source na pasta destino
onde pretende compilar/executar o BibTeX2HTML;

>Gerar o c�digo Java com o JavaCC: javacc Exp1.jj;

>Compilar o c�digo Java gerado:javac *.java;

>Executar o analisador sint�ctico:java Exp1;

	Depois de executado Exp1:

>Inserir nome de fichero quando pedido com o respetivo path ou arrasta-lo para
a linha de consola e confirmar com tecla enter.
(� necess�rio indicar a extens�o do ficheiro);

>duas sec��es de mensagem aparecer�o divididas por separadores:
a primeira refere erros e avisos relativos ao parsing,
a segunda refere-se  uma an�lise posterior dos campos lidos;

>Seguidamente ser� solicitado  o nome de ficheiro de output
(� necess�rio indicar a extens�o do ficheiro: .html);

//=======================================================
	LISTA DE VALIDA��ES SEM�NTICAS
//=======================================================

>Verifica se um item apresenta entries repetidas. (s� realiza output da primeria encontrada);

>Verifica se existem items com o mesmo identificador/bibteckey (s� realiza output do primeria encontrada);

>Verifica se os items apresentam todos os entries obrigat�rios;

>Verifica se as crossreferences usadas nos items existem;

//=======================================================
	FEATURES
//=======================================================

>Tentam-se descartar erros durante o parsing de modo a aproveitar a maior quantidade possivel do ficheiro de input;

>Pode usar items do tipo @string para realizar subtitui��es. (necessita de usar o caracter '"' nos items � mesma, dever� ser corrigo posteriormente);

>Pode usar no inicio do ficheiro input o nome de uma entry antecedida por "##" para ordenar o output dos items;



