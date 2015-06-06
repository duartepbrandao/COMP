public class Item{

public static java.util.List<Item> items;

ItemType type;//stores type (book,article,etc...
String id;//stokes bibteckey
java.util.List<String>  entries;//{stores entries

public Item crossref;//{stores crossref

static StringOperator subs;//(stores @string stuff

static java.util.ArrayList<java.io.PrintWriter> OutFiles;

public Item(String _type, String _id)
{
	if (subs==null) subs = new StringOperator();
	
	id = _id;
	
	try{
	type = ItemType.valueOf(_type);
	}catch(Exception e){
	type=ItemType.error;
	}
	
	entries = new java.util.ArrayList<String>();
	
	crossref = null;
}

static void create_n_open_files(String foldername)
{
	OutFiles = new java.util.ArrayList<java.io.PrintWriter>();
	try{
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/main.html")	);
	
	OutFiles.add( new java.io.PrintWriter("../" + foldername+"/raw.html")	);
	
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/article.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/book.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/booklet.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/conference.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/electronic.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/inbook.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/incollection.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/inproceedings.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/manual.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/masterthesis.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/misc.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/other.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/patent.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/periodical.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/phdthesis.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/proceedings.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/standard.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/techreport.html")	);
	OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/unpublished.html")	);
	
	for(int i = OutFiles.size()-1; i>=0;--i)
	{
	java.io.PrintWriter  out=  OutFiles.get(i);
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<body>\n");
	}
	} catch(Exception e) {
	System.out.println("FAILED 2 CREATE OUTPUT FILE");
	}
}

static void close_files()
{
	for(int i = OutFiles.size()-1; i>=0;--i)
	{
	java.io.PrintWriter  out=  OutFiles.get(i);
	out.println("</body>\n");
	out.println("</html>");
	out.close();
	}
}


//verify if has repeated entries
public int checkRepeatedEntries()
{
	java.util.List<String> foundEntries = new java.util.ArrayList<String>();
	foundEntries.add("@");//just to force iteration on for(String s : foundEntries)
	int ret=0;
	for(int i = 0; i<entries.size() ;i++)
	{
		boolean found=false;
		//System.out.println(foundEntries.size() );
		for(String s : foundEntries)
		{
		//	System.out.println( entries.get(i).substring(0,entries.get(i).indexOf("=")) + "---" + s);
		if(s.equals(entries.get(i).substring(0,entries.get(i).indexOf("="))) )
		{found=true; ret++; System.out.println("Warning:Item <" + id +"> has repeated entry:" + s);}
		}
		if (!found) foundEntries.add(entries.get(i).substring(0,entries.get(i).indexOf("=")));
	}
	return ret;
}

//verefy if it as mandatory entries
public int check4MandatoryEntry(String[] ent)
{	
	int ret = 0;
	for(int j = 0 ; j<ent.length;j++)
	{
		boolean doesNotHave=true;
		for(int i = 0; i<entries.size() ;i++)
			doesNotHave &= !entries.get(i).substring(0,entries.get(i).indexOf("=")).equals(ent[j]);//indexOf(ent[j]) == -1);
		
		if (doesNotHave) 
		{
			ret++;
			System.out.println("Warning:Item <" + id +"> is missing mandatory entry:" + ent[j]);
		}
	}
	//return true;
	return ret;
}

//check if item semantic is ok (return number of problems found)
public int validateItem()
{
	switch(type)
	{
	case article:return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_article) + checkRepeatedEntries(); 
	case book:return check4MandatoryEntry( TypeMandatoryEntries.nonOptional_book) + checkRepeatedEntries();
	case booklet:return check4MandatoryEntry( TypeMandatoryEntries.nonOptional_booklet) + checkRepeatedEntries();
	case conference: return check4MandatoryEntry( TypeMandatoryEntries.nonOptional_conference) + checkRepeatedEntries();
	case electronic: return checkRepeatedEntries(); 
 	case inbook: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_inbook) + checkRepeatedEntries();
	case incollection: return check4MandatoryEntry( TypeMandatoryEntries.nonOptional_incollection) + checkRepeatedEntries();
	 case inproceedings: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_inproceedings) + checkRepeatedEntries();
	 case manual: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_manual) + checkRepeatedEntries();
	 case masterthesis: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_masterthesis) + checkRepeatedEntries();
	 case misc: return checkRepeatedEntries();
	 case other: return checkRepeatedEntries();
	 case patent: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_patent)+ checkRepeatedEntries();
	 case periodical: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_periodical)+ checkRepeatedEntries();
	 case phdthesis: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_phdthesis)+ checkRepeatedEntries();
	 case proceedings: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_proceedings)+ checkRepeatedEntries();
	 case standard: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_standard)+ checkRepeatedEntries();
	 case techreport: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_techreport)+ checkRepeatedEntries();
	 case unpublished: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_unpublished)+ checkRepeatedEntries();
		default: return checkRepeatedEntries();
	}
	//return true;
}

	public void addEntry(String entry)
{
//note:removes closing info " or } but not the open info
	entries.add( 
	entry.substring(0,entry.indexOf("=")).toLowerCase() +
	entry.substring(entry.indexOf("="))//entry.substring(entry.indexOf("="), entry.length()-1)
	);
}


public String replaceSpecialCharacteres(String str)
{
	//(not used) javac -encoding UTF8
str = str.replace("\\´a","á");
str = str.replace("\\'a","à");
str = str.replace("\\~a","ã"); 
str = str.replace("\\^a","â");
str = str.replace("\\'e","é");
str = str.replace("\\^e","ê");
str = str.replace("\\´{\\i}","í");
str = str.replace("\\´I","Í");
str = str.replace("\\´o","õ");
str = str.replace("\\~o","Ãµ");
str = str.replace("\\^o","ô");
str = str.replace("\\´u","ú");
str = str.replace("\\\"u","ü");
str = str.replace("\\c{c}","ç"); 
str = str.replace("\\c{C}","Ç");
str = str.replace("{\"}","\"");
return str;
}
/*
getEntry()
return value of the given entry
params:
entry:entry's name
comma:inserts a comma before the entry
omit:if not found will not show anything
*/
public String getEntry(String entry)//addComma false, omit false
{
	for(int i = 0; i<entries.size() ;i++)
	if (entries.get(i).indexOf(entry) != -1) 
		return replaceSpecialCharacteres ( 
	entries.get(i).substring(entry.length()+1)
	);
	
	return "?";
}
public String getEntry(String entry,boolean addComma) //omit false
{
	for(int i = 0; i<entries.size() ;i++)
	if (entries.get(i).indexOf(entry) != -1)
		return  replaceSpecialCharacteres ( 
	addComma? "," + 
	entries.get(i).substring(entry.length()+1) :
	entries.get(i).substring(entry.length()+1)
	);
	
	return ",?";
}
public String getEntry(String entry,boolean addComma,boolean omit)
{
	for(int i = 0; i<entries.size() ;i++)
	if (entries.get(i).indexOf(entry) != -1) 
		return replaceSpecialCharacteres ( 
	addComma? "," + 
	entries.get(i).substring(entry.length()+1) :
	entries.get(i).substring(entry.length()+1)
	);
	
	if (omit) return "";
	return ",?";
}

public void save2HTML(int index)
{

java.io.PrintWriter outraw =  OutFiles.get(1);
		
			String url = getEntry("url",false,true);
try{
	outraw.println("<p id=\""+ (index+1) +"\">");
	if (url.length()>0) outraw.println("<a href="+url+">");
		
		outraw.println("["+ (index+1) +"] : ");
		
switch(type)
		{
		                // ALGUMA ALTERAÇÃO POR SEREM OPCIONAIS???
		    case article:
			outraw.println(
			getEntry("author")+"."
			+"<i>"+getEntry("title")+"</i>"+"."
			+"<i>"+getEntry("journal")+"</i>"
			+getEntry("volume",true) 
			+"(" + getEntry("number") + ")"
			+ ":"+ getEntry("pages",false,true)
			+ getEntry("month",true)
			+ getEntry("year")+"."
			+ getEntry("note")+".");
			
			break;
			
			case book:
			outraw.println(
			getEntry("author")+"."
			+ getEntry("title") 
			+ getEntry("volume",true)+"."
			+ getEntry("publisher",true)
			+ getEntry("address",true)
			+ getEntry("edition",true)
			+ getEntry("month",true)
			+ getEntry("year")+"."
			+ getEntry("note")+".");
			break;
			
			case booklet:
			outraw.println(
			getEntry("author")+"."
			+ getEntry("title") + "."
			+ getEntry("howpublished")
			+ getEntry("address",true)
			+ getEntry("month",true)
			+ getEntry("year")+"."
			+ getEntry("note")+".");
			break;
			
			case conference:
			outraw.println(
			getEntry("author")+"."
			+ getEntry("title") + "."
			+ getEntry("editor")
			+ getEntry("title",true)
			+ getEntry("volume",true)
			+ getEntry("pages",true)
			+ getEntry("address",true)
			+ getEntry("month",true)
			+ getEntry("year")+"."
			+ getEntry("organization")
			+ getEntry("publisher",true)
			+ getEntry("note")+".");
			break;
			
			case inbook:
			outraw.println(
			getEntry("author")+"."
			+ getEntry("title") 
			+ getEntry("volume",true)
			+ getEntry("chapter",true)
			+ getEntry("pages",true)+"."
			+ getEntry("publisher")
			+ getEntry("address",true)
			+ getEntry("edition",true)
			+ getEntry("month",true)
			+ getEntry("year")+"."
			+ getEntry("note")+".");
			break;
			
			case incollection:
			outraw.println(
			getEntry("author")+"."
			+ getEntry("title") + "."
			+ getEntry("editor")
			+ getEntry("title",true)
			+ getEntry("volume",true)
			+ getEntry("chapter",true)
			+ getEntry("pages",true)+"."
			+ getEntry("publisher")
			+ getEntry("address",true)+","
			+ getEntry("edition")
			+ getEntry("month",true)
			+ getEntry("year")+"."
			+ getEntry("note")+".");
			break;
			
		
			case manual:
			outraw.println(
			getEntry("author")+"."
			+"<i>"+getEntry("title")+"</i>"
			+ getEntry("organization",true)
			+ getEntry("address",true)
			+ getEntry("edition",true)
			+ getEntry("month",true)
			+ getEntry("year")+"."
			+ getEntry("note")+".");
			break;
			
			case masterthesis:
			outraw.println(
			getEntry("author")+"."
			+"<i>"+getEntry("title")+"</i>"+"."
			+ getEntry("school")
			+ getEntry("address",true)
			+ getEntry("month",true) 
			+ getEntry("year")+"."
			+ getEntry("note")+".");
			break;
			
			case misc:
			outraw.println(
			getEntry("author")
			+ getEntry("title",true)
			+ getEntry("howpublished",true)
			+ getEntry("month",true)
			+ getEntry("year")+"."
			+ getEntry("note")+".");
			break;
			
			case phdthesis:
			outraw.println(
			getEntry("author")+"."
			+"<i>"+getEntry("title")+"</i>"+"."
			+ getEntry("school")
			+ getEntry("address",true)
			+ getEntry("month",true) 
			+ getEntry("year")+"."
			+ getEntry("note")+".");
			break;
			
			case proceedings:
			outraw.println(
			getEntry("author")
		    + getEntry("editor",true)+"."
			+"<i>"+getEntry("title")+"</i>"+","
			+ getEntry("volume",true)
			+ getEntry("address",true)
			+ getEntry("month",true)
			+ getEntry("year")+"."
			+ getEntry("organization")
			+ getEntry("publisher",true)+ "."
			+ getEntry("note")+".");
			break;
			
				case techreport:
			outraw.println(
			getEntry("author")+"."
			+"<i>"+getEntry("title",true)+"</i>"
			+ getEntry("report")
			+ getEntry("institution",true)
			+ getEntry("address",true)
			+ getEntry("month",true)
			+ getEntry("year")+"."
			+ getEntry("note")+".");
			break;
			
				case unpublished:
			outraw.println(
			getEntry("author")+"."
			+"<i>"+getEntry("title")+"</i>"
			+ getEntry("month")
			+ getEntry("year")+".");
			break;

			default:
			break;
		}
		
			for(int i=items.size()-1; i>=0;--i){
		
		    if(getEntry("crossref").equals(items.get(i).id)){
			outraw.println("In "+items.get(i).getEntry("title")+ " [<a href=#"+ (i+1) +">" + (i+1) +"</a>]");
			break;
			}
		}
		
}catch(Exception e)
{	
System.out.println("FAILED 2 outrawPUT ITEM WITH ID:"+id);
}
	if (url.length()>0) outraw.println("</a>");
	outraw.println("</p>\n");
}

public void debugPrint()
{
	System.out.println("->" + type.name() + ":");
	if (type==ItemType.error) {System.out.println("ITEM ERROR"); return;}
	for (int i = 0; i<entries.size();i++) System.out.println(entries.get(i));
}

	public static String replaceStrings (String in,int line, int column) {
		
		/*int x;
		if((x =subs.originals.indexOf(in))!=-1){
				//System.out.println("debug!!!!!!!!!");
			return subs.replacements.get(x);
		}*/
		
		//should replace with last declaration
		for(int j = subs.originals.size()-1; j>=0; --j)
			{
				if(in.equals(subs.originals.get(j)) ) return subs.replacements.get(j);
			}
		//if not found
		System.out.println("Error:@string <" + in + "> not declared before line " + line + ", column " + column + ";");
		return "";
	}


}