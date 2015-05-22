public class Item{
ItemType type;//stores type (book,article,etc...
String id;//stokes bibteckey
java.util.List<String>  entries;//{stores entries

public Item crossref;//{stores crossref

static StringOperator subs;//(stores @string stuff

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
	entry.substring(entry.indexOf("="), entry.length()-1)
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
	entries.get(i).substring(entry.length()+2)
	);
	
	return "?";
}
public String getEntry(String entry,boolean addComma) //omit false
{
	for(int i = 0; i<entries.size() ;i++)
	if (entries.get(i).indexOf(entry) != -1)
		return  replaceSpecialCharacteres ( 
	addComma? "," + 
	entries.get(i).substring(entry.length()+2) :
	entries.get(i).substring(entry.length()+2)
	);
	
	return ",?";
}
public String getEntry(String entry,boolean addComma,boolean omit)
{
	for(int i = 0; i<entries.size() ;i++)
	if (entries.get(i).indexOf(entry) != -1) 
		return replaceSpecialCharacteres ( 
	addComma? "," + 
	entries.get(i).substring(entry.length()+2) :
	entries.get(i).substring(entry.length()+2)
	);
	
	if (omit) return "";
	return ",?";
}

public void save2HTML(java.io.PrintWriter out)
{

/*
for();
<body>
  <h1>This is a Heading</h1>
  <p>This is a paragraph.</p>
</body>
*/
		//italico >>  <i><\i>
		//bold >>     <b><\b>
		//<a href="url">link text</a>
		//url should have http://
		
			String url = getEntry("url",false,true);
try{
	out.println("<p>");
	if (url.length()>0) out.println("<a href="+url+">");
		
switch(type)
		{
			case book:
			/*ApelidoAutor, NomeAutor and outros? */
			/*(data),nome livro em italico,publisher*/
			out.println(
			getEntry("author")
			+"(" + getEntry("year") + ")"
			+"<i>"+getEntry("title",true)+"</i>"
			+getEntry("publisher",true)+".");
			break;
			
				case proceedings:
			out.println(
		    "<i>"+getEntry("title",true)+"</i>"
			+"(" + getEntry("year") + ")");
			break;

			case phdthesis:
			out.println(
			getEntry("author")
			+"(" + getEntry("year") + ")"
			+"<i>"+getEntry("title",true)+"</i>"
			+getEntry("school")+"."); // VERIFICAR
			break;

			case misc:
			//out.println(
			break;

			case article:
			out.println(
			getEntry("author")
			+"(" + getEntry("year") + ")"
			+"<i>"+getEntry("title",true)+"</i>"
			+"<i>"+getEntry("journal",true)+"</i>");
			break;

			case manual:
			out.println(
			"<i>"+getEntry("title",true)+"</i>");
			break;
			
			case masterthesis:
			out.println(
			getEntry("author")
			+"(" + getEntry("year") + ")"
			+"<i>"+getEntry("title",true)+"</i>"
			+getEntry("school")+"."); // VERIFICAR
			break;
			
			default:
			break;
		}
}catch(Exception e)
{	
System.out.println("FAILED 2 OUTPUT ITEM WITH ID:"+id);
}
	if (url.length()>0) out.println("</a>");
	out.println("</p>\n");
}

public void debugPrint()
{
	System.out.println("->" + type.name() + ":");
	if (type==ItemType.error) {System.out.println("ITEM ERROR"); return;}
	for (int i = 0; i<entries.size();i++) System.out.println(entries.get(i));
}

	public static String replaceStrings (String in,int line, int column) {
		int x;
			if((x =subs.originals.indexOf(in))!=-1){
				//System.out.println("debug!!!!!!!!!");
			return subs.replacements.get(x);
		}
		//if not found
		System.out.println("Warning:@string <" + in + "> not declared before line " + line + ", column " + column + ";");
		return "";
	}


}