public class Item{
ItemType type;
String id;
java.util.List<String>  entries;

public Item(String _type, String _id)
{
	id = _id;
	
	try{
	type = ItemType.valueOf(_type);
	}catch(Exception e){
	type=ItemType.error;
	}

	
	entries = new java.util.ArrayList<String>();
}


	public void addEntry(String entry)
{
	entries.add(entry.toLowerCase());
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
	if (entries.get(i).indexOf(entry) != -1) return entries.get(i).substring(entry.length()+2, entries.get(i).length()-1);
	
	return "?";
}
public String getEntry(String entry,boolean addComma) //omit false
{
	for(int i = 0; i<entries.size() ;i++)
	if (entries.get(i).indexOf(entry) != -1) return addComma? "," + entries.get(i).substring(entry.length()+2, entries.get(i).length()-1) : entries.get(i).substring(entry.length()+2, entries.get(i).length()-1);
	
	return ",?";
}
public String getEntry(String entry,boolean addComma,boolean omit)
{
	for(int i = 0; i<entries.size() ;i++)
	if (entries.get(i).indexOf(entry) != -1) return addComma? "," + entries.get(i).substring(entry.length()+2, entries.get(i).length()-1) : entries.get(i).substring(entry.length()+2, entries.get(i).length()-1);
	
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

			case phdThesis:
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
			
			case masterThesis:
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