public class Item{
ItemType type;
String id;
java.util.List<String>  entries;

public Item crossref;

public Item(String _type, String _id)
{
	id = _id;
	
	try{
	type = ItemType.valueOf(_type);
	}catch(Exception e){
	type=ItemType.error;
	}
	
	entries = new java.util.ArrayList<String>();
	
	crossref = null;
}


public boolean check4Entry(String[] ent)
{
	boolean ret = true;
	for(int j = 0 ; j<ent.length;j++)
	{
		boolean doesNotHave=true;
		for(int i = 0; i<entries.size() ;i++)
			doesNotHave &= !entries.get(i).substring(0,entries.get(i).indexOf("=")).equals(ent[j]);//indexOf(ent[j]) == -1);
		
		if (doesNotHave) 
		{
			ret = false;
			System.out.println("Warning:Item <" + id +"> is missing mandatory entry:" + ent[j]);
		}
	}
	return ret;
}


public boolean validateItemNonOptionalFields()
{
	switch(type)
	{
	case article:return check4Entry(TypeMandatoryEntries.nonOptional_article); 
	case book:return check4Entry( TypeMandatoryEntries.nonOptional_book);
	case booklet:return check4Entry( TypeMandatoryEntries.nonOptional_booklet);
	case conference: check4Entry( TypeMandatoryEntries.nonOptional_conference);
	case electronic: return true; 
 	case inbook: return check4Entry(TypeMandatoryEntries.nonOptional_inbook);
	case incollection: return check4Entry( TypeMandatoryEntries.nonOptional_incollection);
	 case inproceedings: return check4Entry(TypeMandatoryEntries.nonOptional_inproceedings);
	 case manual: return check4Entry(TypeMandatoryEntries.nonOptional_manual);
	 case masterthesis: return check4Entry(TypeMandatoryEntries.nonOptional_masterthesis);
	 case misc: return true;
	 case other: return true;
	 case patent: return check4Entry(TypeMandatoryEntries.nonOptional_patent);
	 case periodical: return check4Entry(TypeMandatoryEntries.nonOptional_periodical);
	 case phdthesis: return check4Entry(TypeMandatoryEntries.nonOptional_phdthesis);
	 case proceedings: return check4Entry(TypeMandatoryEntries.nonOptional_proceedings);
	 case standard: return check4Entry(TypeMandatoryEntries.nonOptional_standard);
	 case techreport: return check4Entry(TypeMandatoryEntries.nonOptional_techreport);
	 case unpublished: return check4Entry(TypeMandatoryEntries.nonOptional_unpublished);
		default: return true;
	}
	//return true;
}

	public void addEntry(String entry)
{
	entries.add(entry.toLowerCase());
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
	entries.get(i).substring(entry.length()+2, entries.get(i).length()-1)
	);
	
	return "?";
}
public String getEntry(String entry,boolean addComma) //omit false
{
	for(int i = 0; i<entries.size() ;i++)
	if (entries.get(i).indexOf(entry) != -1)
		return  replaceSpecialCharacteres (
	addComma? "," + entries.get(i).substring(entry.length()+2, entries.get(i).length()-1) : entries.get(i).substring(entry.length()+2, entries.get(i).length()-1)
	);
	
	return ",?";
}
public String getEntry(String entry,boolean addComma,boolean omit)
{
	for(int i = 0; i<entries.size() ;i++)
	if (entries.get(i).indexOf(entry) != -1) 
		return replaceSpecialCharacteres (
	addComma? "," + entries.get(i).substring(entry.length()+2, entries.get(i).length()-1) : entries.get(i).substring(entry.length()+2, entries.get(i).length()-1)
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

}