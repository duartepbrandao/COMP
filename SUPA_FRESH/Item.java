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
					type = ItemType.valueOf( _type.toLowerCase() );
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
					OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/index.html")	);

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
					OutFiles.add(	new java.io.PrintWriter("../" + foldername+"/mastersthesis.html")	);
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

						switch (i){
							case 0: //index.html
							out.println("<!DOCTYPE html>");
							out.println("<html>");
							out.println("<body>\n");
							out.println("test");
							out.println(""
							+"\n	<p>"
							+"\n	<a href=\"raw.html\"> All entries</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"article.html\">articles</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"book.html\">books</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"booklet.html\">booklets</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"conference.html\">conferences</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"electronic.html\">electronic</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"inbook.html\">inbook</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"incolection.html\">incolection</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"inproceedings.html\">inproceedings</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"manual.html\">manuals</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"mastersThesis.html\">master Thesis</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"misc.html\">Misc</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"patent.html\">patents</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"periodical.html\">periodicals</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"phdThesis.html\">PHD Thesis</a>"
							+"\n	</p>"
							+"\n	<p>"
							+"\n	<a href=\"proceedings.html\">proceedings</a>"
							+"\n	</p>"
							);
							break;


							case 1:
							out.println("<!DOCTYPE html>");
							out.println("<html>");
							out.println("<body>\n");


							case 2: //article.html
							out.println("<!DOCTYPE html>"
							+ "\n <html>"
							+ "\n <head>"
							+ "\n <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ "\n <link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ "\n <!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ "\n </script>  <!-- DataTables -->"
							+ "\n <script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ "\n <script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ "\n 	\"scrollY\": \"200px\","
							+ "\n 	\"paging\": false,"
							+ "\n"
							+ "\n 	\"columnDefs\": ["
							+ "\n 	{"
							+ "\n 		\"targets\": [ 5 ],"
							+ "\n 		\"visible\": false"
							+ "\n 	},"
							+ "\n 	{"
							+ "\n 		\"targets\": [ 6 ],"
							+ "\n 		\"visible\": false"
							+ "\n 	},"
							+ "\n 	{"
							+ "\n 		\"targets\": [ 7 ],"
							+ "\n 		\"visible\": false"
							+ "\n 	},"
							+ "\n 	{"
							+ "\n 		\"targets\": [ 8 ],"
							+ "\n 		\"visible\": false"
							+ "\n 	},"
							+ "\n 	{"
							+ "\n 		\"targets\": [ 9 ],"
							+ "\n 		\"visible\": false"
							+ "\n 	}, "
							+ "\n 	{ "
							+ "\n 		\"targets\": [ 10 ],"
							+ "\n 		\"visible\": false"
							+ "\n 	}"
							+ "\n 	]"
							+ "\n } );"
							+ "\n"
							+ "\n $('a.toggle-vis').on( 'click', function (e) {"
							+ "\n 	e.preventDefault();"
							+ "\n 	// Get the column API object"
							+ "\n 	var column = table.column( $(this).attr('data-column') );"
							+ "\n"
							+ "\n 	// Toggle the visibility"
							+ "\n 	column.visible( ! column.visible() );"
							+ "\n } );"
							+" \n	} );"
							+" \n	</script>"
							+" \n"
							+" \n	</head>"
							+" \n"
							+" \n	<body>"
							+" \n	<div>Filters"
							+" \n	<div> Required:"
							+" \n"
							+" \n	<a class=\"toggle-vis\" data-column=\"0\"> Crossref </a>"
							+" \n	<a class=\"toggle-vis\" data-column=\"1\"> Author </a>"
							+" \n	<a class=\"toggle-vis\" data-column=\"2\"> Title </a>"
							+" \n	<a class=\"toggle-vis\" data-column=\"3\"> Journal </a>"
							+" \n	<a class=\"toggle-vis\" data-column=\"4\"> Year </a>"
							+" \n"
							+" \n	</div>"
							+" \n	<div>Optional:"
							+" \n	<!--Optional Fields  -->"
							+" \n	<a class=\"toggle-vis\" data-column=\"5\"> Volume </a>"
							+" \n	<a class=\"toggle-vis\" data-column=\"6\"> Number </a>"
							+" \n	<a class=\"toggle-vis\" data-column=\"7\"> Pages </a>"
							+" \n	<a class=\"toggle-vis\" data-column=\"8\"> Month </a>"
							+" \n	<a class=\"toggle-vis\" data-column=\"9\"> Note </a>"
							+" \n	<a class=\"toggle-vis\" data-column=\"10\"> URL </a>"
							+" \n	</div>"
							+" \n	</div>"
							+" \n	<table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+" \n	<thead>"
							+" \n	<tr>"
							+" \n	<th>Crossref</th>"
							+" \n	<th>Author</th>"
							+" \n	<th>Title</th>"
							+" \n	<th>Journal</th>"
							+" \n	<th>Year</th>"
							+" \n	<th>Volume</th>"
							+" \n	<th>Number</th>"
							+" \n	<th>Pages</th>"
							+" \n	<th>Month</th>"
							+" \n	<th>Note</th>"
							+" \n	<th>URL</th>"
							+" \n	</tr>"
							+" \n	</thead> "
							+ " \n   <tbody>");
							break;

							case 3: //book.html
							out.println(" \n <!DOCTYPE html>"
							+ " \n <html>"
							+ " \n <head>"
							+ " \n <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n <link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n <!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n </script>  <!-- DataTables -->"
							+ " \n <script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n <script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n   \"scrollY\": \"200px\","
							+ " \n   \"paging\": false,"
							+ " \n "
							+ " \n   \"columnDefs\": ["
							+ " \n   {"
							+ " \n     \"targets\": [ 6 ],"
							+ " \n     \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 7 ],"
							+ " \n       \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 8 ],"
							+ " \n       \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 9 ],"
							+ " \n       \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 10 ],"
							+ " \n       \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 11 ],"
							+ " \n       \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 12 ],"
							+ " \n       \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 13 ],"
							+ " \n       \"visible\": false"
							+ " \n     }"
							+ " \n     ]"
							+ " \n   } );"
							+ " \n "
							+ " \n   $('a.toggle-vis').on( 'click', function (e) {"
							+ " \n     e.preventDefault();"
							+ " \n     // Get the column API object"
							+ " \n     var column = table.column( $(this).attr('data-column') );"
							+ " \n "
							+ " \n     // Toggle the visibility"
							+ " \n     column.visible( ! column.visible() );"
							+ " \n   } );"
							+ " \n "
							+ " \n "
							+ " \n } );"
							+ " \n </script>"
							+ " \n "
							+ " \n </head>"
							+ " \n "
							+ " \n <body>"
							+ " \n   <div>Filters"
							+ " \n     <div> Required:"
							+ " \n "
							+ " \n       <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"1\"> Author </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"2\"> Title </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"3\"> Editor </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"4\"> Year </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"5\"> Publisher</a>"
							+ " \n "
							+ " \n     </div>"
							+ " \n     <div>Optional:"
							+ " \n       <!--Optional Fields  -->"
							+ " \n       <a class=\"toggle-vis\" data-column=\"6\"> Volume </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"7\"> Number </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"8\"> Series </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"9\"> Address </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"10\"> Edition </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"11\"> Month </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"12\"> Note </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"13\"> URL </a>"
							+ " \n     </div>"
							+ " \n   </div>"
							+ " \n   <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n     <thead>"
							+ " \n       <tr>"
							+ " \n         <th>BibtexKey</th>"
							+ " \n         <th>Author</th>"
							+ " \n         <th>Title</th>"
							+ " \n         <th>Editor</th>"
							+ " \n         <th>Year</th>"
							+ " \n         <th>Publisher</th>"
							+ " \n         <th>Volume</th>"
							+ " \n         <th>Number</th>"
							+ " \n         <th>Series</th>"
							+ " \n         <th>Address</th>"
							+ " \n         <th>Edition</th>"
							+ " \n         <th>Month</th>"
							+ " \n         <th>Note</th>"
							+ " \n         <th>URL</th>"
							+ " \n       </tr>"
							+ " \n     </thead>"
							+ " \n   <tbody>"
							);
							break;


							case 4: //booklets
							out.println("<!DOCTYPE html>"
							+ " \n <html>"
							+ " \n <head>"
							+ " \n <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n <link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n <!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n </script>  <!-- DataTables -->"
							+ " \n <script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n <script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n   \"scrollY\": \"200px\","
							+ " \n   \"paging\": false,"
							+ " \n "
							+ " \n   \"columnDefs\": ["
							+ " \n   {"
							+ " \n     \"targets\": [ 2 ],"
							+ " \n     \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 3 ],"
							+ " \n       \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 4 ],"
							+ " \n       \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 5 ],"
							+ " \n       \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 6 ],"
							+ " \n       \"visible\": false"
							+ " \n     },"
							+ " \n     {"
							+ " \n       \"targets\": [ 7 ],"
							+ " \n       \"visible\": false"
							+ " \n     }"
							+ " \n     ]"
							+ " \n   } );"
							+ " \n "
							+ " \n   $('a.toggle-vis').on( 'click', function (e) {"
							+ " \n     e.preventDefault();"
							+ " \n     // Get the column API object"
							+ " \n     var column = table.column( $(this).attr('data-column') );"
							+ " \n "
							+ " \n     // Toggle the visibility"
							+ " \n     column.visible( ! column.visible() );"
							+ " \n   } );"
							+ " \n "
							+ " \n "
							+ " \n } );"
							+ " \n </script>"
							+ " \n "
							+ " \n </head>"
							+ " \n "
							+ " \n <body>"
							+ " \n   <div>Filters"
							+ " \n     <div> Required:"
							+ " \n "
							+ " \n       <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"1\"> Title </a>"
							+ " \n "
							+ " \n     </div>"
							+ " \n     <div>Optional:"
							+ " \n       <!--Optional Fields  -->"
							+ " \n       <a class=\"toggle-vis\" data-column=\"2\"> Author </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"3\"> HowPublished </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"4\"> Address </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"5\"> Month</a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"6\"> Year </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"7\"> Note </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"8\"> URL </a>"
							+ " \n     </div>"
							+ " \n   </div>"
							+ " \n   <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n     <thead>"
							+ " \n       <tr>"
							+ " \n         <th>BibtexKey</th>"
							+ " \n         <th>Title</th>"
							+ " \n         <th>Author</th>"
							+ " \n         <th>HowPublished</th>"
							+ " \n         <th>Address</th>"
							+ " \n         <th>Month</th>"
							+ " \n         <th>Year</th>"
							+ " \n         <th>Note</th>"
							+ " \n         <th>URL</th>"
							+ " \n       </tr>"
							+ " \n     </thead>"
							+ " \n   <tbody>");
							break;

							case 5: //conference
							out.println(" <!DOCTYPE html>"
							+ " \n<html>"
							+ " \n<head>"
							+ " \n<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n<link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n<!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n </script>  <!-- DataTables -->"
							+ " \n <script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n <script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n  \"scrollY\": \"200px\","
							+ " \n  \"paging\": false,"
							+ " \n"
							+ " \n  \"columnDefs\": ["
							+ " \n  {"
							+ " \n    \"targets\": [ 5 ],"
							+ " \n    \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 6 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 7 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 8 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 9 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 10 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 11 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 12 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 13 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 14 ],"
							+ " \n      \"visible\": false"
							+ " \n    }"
							+ " \n    ]"
							+ " \n  } );"
							+ " \n"
							+ " \n  $('a.toggle-vis').on( 'click', function (e) {"
							+ " \n    e.preventDefault();"
							+ " \n    // Get the column API object"
							+ " \n    var column = table.column( $(this).attr('data-column') );"
							+ " \n"
							+ " \n    // Toggle the visibility"
							+ " \n    column.visible( ! column.visible() );"
							+ " \n  } );"
							+ " \n"
							+ " \n"
							+ " \n} );"
							+ " \n</script>"
							+ " \n"
							+ " \n</head>"
							+ " \n"
							+ " \n<body>"
							+ " \n  <div>Filters"
							+ " \n    <div> Required:"
							+ " \n"
							+ " \n      <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"1\"> Title </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"2\"> Author </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"3\"> Booktitle </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"4\"> Year </a>"
							+ " \n"
							+ " \n    </div>"
							+ " \n    <div>Optional:"
							+ " \n      <!--Optional Fields  -->"
							+ " \n      <a class=\"toggle-vis\" data-column=\"5\"> Editor</a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"6\"> Volume </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"7\"> Number </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"8\"> Series </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"9\"> Pages </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"10\"> Address </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"11\"> Organization </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"12\"> Publisher </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"13\"> Note </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"14\"> URL </a>"
							+ " \n    </div>"
							+ " \n  </div>"
							+ " \n  <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n    <thead>"
							+ " \n      <tr>"
							+ " \n        <th>BibtexKey</th>"
							+ " \n        <th>Title</th>"
							+ " \n        <th>Author</th>"
							+ " \n        <th>Booktitle</th>"
							+ " \n        <th>Year</th>"
							+ " \n        <th>Editor</th>"
							+ " \n        <th>Volume</th>"
							+ " \n        <th>Series</th>"
							+ " \n        <th>Address</th>"
							+ " \n        <th>Organization</th>"
							+ " \n        <th>Publisher</th>"
							+ " \n        <th>Note</th>"
							+ " \n        <th>URL</th>"
							+ " \n      </tr>"
							+ " \n    </thead> "
							+ " \n   <tbody>"
							);
							break;


							case 6: // electronic
							out.println(" <!DOCTYPE html>"
							+ " \n<html>"
							+ " \n<head>"
							+ " \n  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n  <link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n  <!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n  </script>  <!-- DataTables -->"
							+ " \n  <script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n  <script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n    \"scrollY\": \"200px\","
							+ " \n    \"paging\": false,"
							+ " \n"
							+ " \n    \"columnDefs\": ["
							+ " \n    {"
							+ " \n      \"targets\": [ 1 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 2 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 3 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 4 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 5 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 6 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 7],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 8 ],"
							+ " \n      \"visible\": false"
							+ " \n    },"
							+ " \n    {"
							+ " \n      \"targets\": [ 9 ],"
							+ " \n      \"visible\": false"
							+ " \n    }"
							+ " \n    ]"
							+ " \n  } );"
							+ " \n"
							+ " \n  $('a.toggle-vis').on( 'click', function (e) {"
							+ " \n    e.preventDefault();"
							+ " \n    // Get the column API object"
							+ " \n    var column = table.column( $(this).attr('data-column') );"
							+ " \n"
							+ " \n    // Toggle the visibility"
							+ " \n    column.visible( ! column.visible() );"
							+ " \n  } );"
							+ " \n"
							+ " \n"
							+ " \n} );"
							+ " \n</script>"
							+ " \n"
							+ " \n</head>"
							+ " \n"
							+ " \n<body>"
							+ " \n  <div>Filters"
							+ " \n    <div> Required:"
							+ " \n"
							+ " \n      <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n"
							+ " \n"
							+ " \n    </div>"
							+ " \n    <div>Optional:"
							+ " \n      <!--Optional Fields  -->"
							+ " \n      <a class=\"toggle-vis\" data-column=\"1\"> Title </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"2\"> Author </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"3\"> Month </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"4\"> Year </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"5\"> Language</a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"6\"> HowPublished</a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"7\"> Organization </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"8\"> Note </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"9\"> URL </a>"
							+ " \n    </div>"
							+ " \n  </div>"
							+ " \n  <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n    <thead>"
							+ " \n      <tr>"
							+ " \n"
							+ " \n        <th>BibtexKey</th>"
							+ " \n        <th>Title</th>"
							+ " \n        <th>Author</th>"
							+ " \n        <th>Language</th>"
							+ " \n        <th>Month</th>"
							+ " \n        <th>Year</th>"
							+ " \n        <th>Organization</th>"
							+ " \n        <th>HowPublished</th>"
							+ " \n        <th>URL</th>"
							+ " \n        <th>Note</th>"
							+ " \n"
							+ " \n      </tr>"
							+ " \n    </thead>"
							+ " \n   <tbody>"
							);
							break;

							case 7: // inbook
							out.println("<!DOCTYPE html>"
							+ " \n<html>"
							+ " \n<head>"
							+ " \n<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n<link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n<!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n</script>  <!-- DataTables -->"
							+ " \n<script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n<script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n  \"scrollY\": \"200px\","
							+ " \n  \"paging\": false,"
							+ " \n"
							+ " \n  \"columnDefs\": ["
							+ " \n  {"
							+ " \n    \"targets\": [ 8 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 9 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 10 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 11 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 12 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 13 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 14],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 15 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 16 ],"
							+ " \n    \"visible\": false"
							+ " \n  }"
							+ " \n  ]}"
							+ " \n);"
							+ " \n"
							+ " \n$('a.toggle-vis').on( 'click', function (e) {"
							+ " \n  e.preventDefault();"
							+ " \n  // Get the column API object"
							+ " \n  var column = table.column( $(this).attr('data-column') );"
							+ " \n"
							+ " \n  // Toggle the visibility"
							+ " \n  column.visible( ! column.visible() );"
							+ " \n} );"
							+ " \n"
							+ " \n"
							+ " \n} );"
							+ " \n</script>"
							+ " \n"
							+ " \n</head>"
							+ " \n"
							+ " \n<body>"
							+ " \n  <div>Filters"
							+ " \n    <div> Required:"
							+ " \n"
							+ " \n      <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"1\"> Chapter </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"2\"> Pages </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"3\"> Title </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"4\"> Publisher </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"5\"> Year </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"6\"> Editor </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"7\"> Author </a>"
							+ " \n"
							+ " \n"
							+ " \n    </div>"
							+ " \n    <div>Optional:"
							+ " \n      <!--Optional Fields  -->"
							+ " \n      <a class=\"toggle-vis\" data-column=\"8\"> Volume </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"9\"> Number </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"10\"> Series </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"11\"> Type </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"12\"> Address </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"13\"> Edition</a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"14\"> Month </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"15\"> Note </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"16\"> URL </a>"
							+ " \n    </div>"
							+ " \n  </div>"
							+ " \n  <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n    <thead>"
							+ " \n      <tr>"
							+ " \n"
							+ " \n        <th>BibtexKey</th>"
							+ " \n        <th>Chapter</th>"
							+ " \n        <th>Pages</th>"
							+ " \n        <th>Title</th>"
							+ " \n        <th>Publisher</th>"
							+ " \n        <th>Year</th>"
							+ " \n        <th>Editor</th>"
							+ " \n        <th>Author</th>"
							+ " \n        <th>Volume</th>"
							+ " \n        <th>Number</th>"
							+ " \n        <th>Series</th>"
							+ " \n        <th>Type</th>"
							+ " \n        <th>Address</th>"
							+ " \n        <th>Edition</th>"
							+ " \n        <th>Month</th>"
							+ " \n        <th>URL</th>"
							+ " \n        <th>Note</th>"
							+ " \n"
							+ " \n      </tr>"
							+ " \n    </thead>"
							+ " \n   <tbody>"
							);
							break;

							case 8: //incolection
							out.println(" <!DOCTYPE html>"
							+ " \n<html>"
							+ " \n<head>"
							+ " \n<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n<link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n<!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n</script>  <!-- DataTables -->"
							+ " \n<script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n<script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n  \"scrollY\": \"200px\","
							+ " \n  \"paging\": false,"
							+ " \n"
							+ " \n  \"columnDefs\": ["
							+ " \n  {"
							+ " \n    \"targets\": [ 6 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 7 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 8 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 9 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 10 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 11 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 12 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 13 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 14],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 15 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 16 ],"
							+ " \n    \"visible\": false"
							+ " \n  }"
							+ " \n  ]}"
							+ " \n);"
							+ " \n"
							+ " \n$('a.toggle-vis').on( 'click', function (e) {"
							+ " \n  e.preventDefault();"
							+ " \n  // Get the column API object"
							+ " \n  var column = table.column( $(this).attr('data-column') );"
							+ " \n"
							+ " \n  // Toggle the visibility"
							+ " \n  column.visible( ! column.visible() );"
							+ " \n} );"
							+ " \n"
							+ " \n"
							+ " \n} );"
							+ " \n</script>"
							+ " \n"
							+ " \n</head>"
							+ " \n"
							+ " \n<body>"
							+ " \n  <div>Filters"
							+ " \n    <div> Required:"
							+ " \n"
							+ " \n      <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"1\"> Author </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"2\"> Title </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"3\"> Book Title </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"4\"> Publisher </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"5\"> Year </a>"
							+ " \n"
							+ " \n    </div>"
							+ " \n    <div>Optional:"
							+ " \n      <!--Optional Fields  -->"
							+ " \n      <a class=\"toggle-vis\" data-column=\"6\"> Editor </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"7\"> Volume </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"8\"> Number </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"9\"> Type </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"10\"> Chapter </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"11\"> Pages </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"12\"> Address </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"13\"> Edition </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"14\"> Month </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"15\"> Note </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"16\"> URL </a>"
							+ " \n    </div>"
							+ " \n  </div>"
							+ " \n  <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n    <thead>"
							+ " \n      <tr>"
							+ " \n"
							+ " \n        <th>BibtexKey</th>"
							+ " \n        <th>Author</th>"
							+ " \n        <th>Title</th>"
							+ " \n        <th>Book</th>"
							+ " \n        <th>Publisher</th>"
							+ " \n        <th>Year</th>"
							+ " \n        <th>Editor</th>"
							+ " \n        <th>Volume</th>"
							+ " \n        <th>Number</th>"
							+ " \n        <th>Type</th>"
							+ " \n        <th>Chapter</th>"
							+ " \n        <th>Pages</th>"
							+ " \n        <th>Address</th>"
							+ " \n        <th>Edition</th>"
							+ " \n        <th>Month</th>"
							+ " \n        <th>URL</th>"
							+ " \n        <th>Note</th>"
							+ " \n"
							+ " \n      </tr>"
							+ " \n    </thead>"
							+ " \n   <tbody>");
							break;

							case 9: //inproceedings
							out.println(" \n<!DOCTYPE html>"
							+ " \n<html>"
							+ " \n<head>"
							+ " \n<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n<link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n<!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n</script>  <!-- DataTables -->"
							+ " \n<script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n<script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n  \"scrollY\": \"200px\","
							+ " \n  \"paging\": false,"
							+ " \n"
							+ " \n  \"columnDefs\": ["
							+ " \n  {"
							+ " \n    \"targets\": [ 4 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 5 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 6 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 7 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 8 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 9 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 10 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 11 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 12],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 13 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 14 ],"
							+ " \n    \"visible\": false"
							+ " \n  }"
							+ " \n  ]}"
							+ " \n);"
							+ " \n"
							+ " \n$('a.toggle-vis').on( 'click', function (e) {"
							+ " \n  e.preventDefault();"
							+ " \n  // Get the column API object"
							+ " \n  var column = table.column( $(this).attr('data-column') );"
							+ " \n"
							+ " \n  // Toggle the visibility"
							+ " \n  column.visible( ! column.visible() );"
							+ " \n} );"
							+ " \n"
							+ " \n"
							+ " \n} );"
							+ " \n</script>"
							+ " \n"
							+ " \n</head>"
							+ " \n"
							+ " \n<body>"
							+ " \n  <div>Filters"
							+ " \n    <div> Required:"
							+ " \n"
							+ " \n      <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"1\"> Author </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"2\"> Title </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"3\"> Year </a>"
							+ " \n"
							+ " \n    </div>"
							+ " \n    <div>Optional:"
							+ " \n      <!--Optional Fields  -->"
							+ " \n      <a class=\"toggle-vis\" data-column=\"4\"> Editor </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"5\"> Volume </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"6\"> Number </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"7\"> Series </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"8\"> Pages </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"9\"> Address </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"10\"> Month </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"11\"> Organization </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"12\"> Publisher </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"13\"> Note </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"14\"> URL </a>"
							+ " \n    </div>"
							+ " \n  </div>"
							+ " \n  <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n    <thead>"
							+ " \n      <tr>"
							+ " \n        <th>BibtexKey</th>"
							+ " \n        <th>Author</th>"
							+ " \n        <th>Title</th>"
							+ " \n        <th>Year</th>"
							+ " \n        <th>Editor</th>"
							+ " \n        <th>Volume</th>"
							+ " \n        <th>Number</th>"
							+ " \n        <th>Series</th>"
							+ " \n        <th>Pages</th>"
							+ " \n        <th>Address</th>"
							+ " \n        <th>Month</th>"
							+ " \n        <th>Organization</th>"
							+ " \n        <th>Publisher</th>"
							+ " \n        <th>Note</th>"
							+ " \n        <th>URL</th>"
							+ " \n      </tr>"
							+ " \n    </thead>"
							+ " \n   <tbody>"
							);

							case 10: //manual
							out.println("<!DOCTYPE html>"
							+ "\n <html>"
							+ "\n <head>"
							+ "\n <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ "\n <link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ "\n <!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ "\n </script>  <!-- DataTables -->"
							+ "\n <script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ "\n <script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ "\n   \"scrollY\": \"200px\","
							+ "\n   \"paging\": false,"
							+ "\n "
							+ "\n   \"columnDefs\": ["
							+ "\n   {"
							+ "\n     \"targets\": [ 2 ],"
							+ "\n     \"visible\": false"
							+ "\n   },"
							+ "\n   {"
							+ "\n     \"targets\": [ 3 ],"
							+ "\n     \"visible\": false"
							+ "\n   },"
							+ "\n   {"
							+ "\n     \"targets\": [ 4 ],"
							+ "\n     \"visible\": false"
							+ "\n   },"
							+ "\n   {"
							+ "\n     \"targets\": [ 5 ],"
							+ "\n     \"visible\": false"
							+ "\n   },"
							+ "\n   {"
							+ "\n     \"targets\": [ 6 ],"
							+ "\n     \"visible\": false"
							+ "\n   },"
							+ "\n   {"
							+ "\n     \"targets\": [ 7 ],"
							+ "\n     \"visible\": false"
							+ "\n   },"
							+ "\n   {"
							+ "\n     \"targets\": [ 8 ],"
							+ "\n     \"visible\": false"
							+ "\n   },"
							+ "\n   {"
							+ "\n     \"targets\": [ 9 ],"
							+ "\n     \"visible\": false"
							+ "\n   }"
							+ "\n   ]}"
							+ "\n );"
							+ "\n "
							+ "\n $('a.toggle-vis').on( 'click', function (e) {"
							+ "\n   e.preventDefault();"
							+ "\n   // Get the column API object"
							+ "\n   var column = table.column( $(this).attr('data-column') );"
							+ "\n "
							+ "\n   // Toggle the visibility"
							+ "\n   column.visible( ! column.visible() );"
							+ "\n } );"
							+ "\n "
							+ "\n "
							+ "\n } );"
							+ "\n </script>"
							+ "\n "
							+ "\n </head>"
							+ "\n "
							+ "\n <body>"
							+ "\n   <div>Filters"
							+ "\n     <div> Required:"
							+ "\n "
							+ "\n       <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ "\n       <a class=\"toggle-vis\" data-column=\"1\"> Title </a>"
							+ "\n "
							+ "\n     </div>"
							+ "\n     <div>Optional:"
							+ "\n       <!--Optional Fields  -->"
							+ "\n       <a class=\"toggle-vis\" data-column=\"2\"> Author </a>"
							+ "\n       <a class=\"toggle-vis\" data-column=\"3\"> Organization </a>"
							+ "\n       <a class=\"toggle-vis\" data-column=\"4\"> Address </a>"
							+ "\n       <a class=\"toggle-vis\" data-column=\"5\"> Edition </a>"
							+ "\n       <a class=\"toggle-vis\" data-column=\"6\"> Month </a>"
							+ "\n       <a class=\"toggle-vis\" data-column=\"7\"> Year </a>"
							+ "\n       <a class=\"toggle-vis\" data-column=\"8\"> Note </a>"
							+ "\n       <a class=\"toggle-vis\" data-column=\"9\"> URL </a>"
							+ "\n     </div>"
							+ "\n   </div>"
							+ "\n   <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ "\n     <thead>"
							+ "\n       <tr>"
							+ "\n "
							+ "\n         <th>BibtexKey</th>"
							+ "\n         <th>Title</th>"
							+ "\n         <th>Author</th>"
							+ "\n         <th>Organization</th>"
							+ "\n         <th>Address</th>"
							+ "\n         <th>Edition</th>"
							+ "\n         <th>Month</th>"
							+ "\n         <th>Year</th>"
							+ "\n         <th>Note</th>"
							+ "\n         <th>URL</th>"
							+ "\n "
							+ "\n "
							+ "\n "
							+ "\n       </tr>"
							+ "\n     </thead>"
							+ " \n   <tbody>"
							);
							break;

							case 11: //masters thesis
							out.println(" <!DOCTYPE html>"
							+ " \n <html>"
							+ " \n <head>"
							+ " \n <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n <link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n <!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n </script>  <!-- DataTables -->"
							+ " \n <script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n <script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n   \"scrollY\": \"200px\","
							+ " \n   \"paging\": false,"
							+ " \n "
							+ " \n   \"columnDefs\": ["
							+ " \n   {"
							+ " \n     \"targets\": [ 5 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 6 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 7 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 8 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 9 ],"
							+ " \n     \"visible\": false"
							+ " \n   }"
							+ " \n   ]}"
							+ " \n );"
							+ " \n "
							+ " \n $('a.toggle-vis').on( 'click', function (e) {"
							+ " \n   e.preventDefault();"
							+ " \n   // Get the column API object"
							+ " \n   var column = table.column( $(this).attr('data-column') );"
							+ " \n "
							+ " \n   // Toggle the visibility"
							+ " \n   column.visible( ! column.visible() );"
							+ " \n } );"
							+ " \n "
							+ " \n "
							+ " \n } );"
							+ " \n </script>"
							+ " \n "
							+ " \n </head>"
							+ " \n "
							+ " \n <body>"
							+ " \n   <div>Filters"
							+ " \n     <div> Required:"
							+ " \n "
							+ " \n       <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"1\"> Author </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"2\"> Title </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"3\"> School </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"4\"> Year </a>"
							+ " \n "
							+ " \n     </div>"
							+ " \n     <div>Optional:"
							+ " \n       <!--Optional Fields  -->"
							+ " \n       <a class=\"toggle-vis\" data-column=\"5\"> Type </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"6\"> Address </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"7\"> Month </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"8\"> Note </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"9\"> URL </a>"
							+ " \n     </div>"
							+ " \n   </div>"
							+ " \n   <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n     <thead>"
							+ " \n       <tr>"
							+ " \n "
							+ " \n         <th>BibtexKey</th>"
							+ " \n         <th>Author</th>"
							+ " \n         <th>Title</th>"
							+ " \n         <th>School</th>"
							+ " \n         <th>Year</th>"
							+ " \n         <th>Type</th>"
							+ " \n         <th>Address</th>"
							+ " \n         <th>Month</th>"
							+ " \n         <th>Note</th>"
							+ " \n         <th>URL</th>"
							+ " \n "
							+ " \n "
							+ " \n "
							+ " \n       </tr>"
							+ " \n     </thead>"
							+ " \n   <tbody>"
							);
							break;

							case 12: //misc
							out.println("<!DOCTYPE html>"
							+ " \n <html>"
							+ " \n <head>"
							+ " \n <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n <link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n <!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n </script>  <!-- DataTables -->"
							+ " \n <script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n <script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n   \"scrollY\": \"200px\","
							+ " \n   \"paging\": false,"
							+ " \n "
							+ " \n   \"columnDefs\": ["
							+ " \n   {"
							+ " \n     \"targets\": [ 1 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 2 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 3 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 4 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 5 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 6 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 7 ],"
							+ " \n     \"visible\": false"
							+ " \n   }"
							+ " \n   ]}"
							+ " \n );"
							+ " \n "
							+ " \n $('a.toggle-vis').on( 'click', function (e) {"
							+ " \n   e.preventDefault();"
							+ " \n   // Get the column API object"
							+ " \n   var column = table.column( $(this).attr('data-column') );"
							+ " \n "
							+ " \n   // Toggle the visibility"
							+ " \n   column.visible( ! column.visible() );"
							+ " \n } );"
							+ " \n "
							+ " \n "
							+ " \n } );"
							+ " \n </script>"
							+ " \n "
							+ " \n </head>"
							+ " \n "
							+ " \n <body>"
							+ " \n   <div>Filters"
							+ " \n     <div> Required:"
							+ " \n "
							+ " \n       <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n "
							+ " \n "
							+ " \n     </div>"
							+ " \n     <div>Optional:"
							+ " \n       <!--Optional Fields  -->"
							+ " \n       <a class=\"toggle-vis\" data-column=\"1\"> Author </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"2\"> Title </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"3\"> HowPublished </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"4\"> Month </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"5\"> Year </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"6\"> Note </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"7\"> URL </a>"
							+ " \n     </div>"
							+ " \n   </div>"
							+ " \n   <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n     <thead>"
							+ " \n       <tr>"
							+ " \n "
							+ " \n         <th>BibtexKey</th>"
							+ " \n         <th>Author</th>"
							+ " \n         <th>Title</th>"
							+ " \n         <th>HowPublished</th>"
							+ " \n         <th>Month</th>"
							+ " \n         <th>Year</th>"
							+ " \n "
							+ " \n         <th>Note</th>"
							+ " \n         <th>URL</th>"
							+ " \n "
							+ " \n "
							+ " \n "
							+ " \n       </tr>"
							+ " \n     </thead>"
							+ " \n   <tbody>");
							break;

							case 13: // patent
							out.println(" <!DOCTYPE html>"
							+ " \n <html>"
							+ " \n <head>"
							+ " \n <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n <link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n <!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n </script>  <!-- DataTables -->"
							+ " \n <script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n <script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n   \"scrollY\": \"200px\","
							+ " \n   \"paging\": false,"
							+ " \n "
							+ " \n   \"columnDefs\": ["
							+ " \n   {"
							+ " \n     \"targets\": [ 5 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 6 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 7 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 8 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 9 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 10 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 11 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 12 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 13 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 14 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 15 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 16 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 17 ],"
							+ " \n     \"visible\": false"
							+ " \n   }"
							+ " \n   ]}"
							+ " \n );"
							+ " \n "
							+ " \n $('a.toggle-vis').on( 'click', function (e) {"
							+ " \n   e.preventDefault();"
							+ " \n   // Get the column API object"
							+ " \n   var column = table.column( $(this).attr('data-column') );"
							+ " \n "
							+ " \n   // Toggle the visibility"
							+ " \n   column.visible( ! column.visible() );"
							+ " \n } );"
							+ " \n "
							+ " \n "
							+ " \n } );"
							+ " \n </script>"
							+ " \n "
							+ " \n </head>"
							+ " \n "
							+ " \n <body>"
							+ " \n   <div>Filters"
							+ " \n     <div> Required:"
							+ " \n "
							+ " \n       <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"1\"> Nationality </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"2\"> Number </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"3\"> Year </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"4\"> YearFilled </a>"
							+ " \n "
							+ " \n "
							+ " \n     </div>"
							+ " \n     <div>Optional:"
							+ " \n       <!--Optional Fields  -->"
							+ " \n       <a class=\"toggle-vis\" data-column=\"5\"> Author </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"6\"> Title </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"7\"> Language </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"8\"> Assignee </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"9\"> Address </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"10\"> Type </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"11\"> Number </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"12\"> Day </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"13\"> DayFilled </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"14\"> Month </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"15\"> MonthFilled </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"16\"> Note </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"17\"> URL </a>"
							+ " \n     </div>"
							+ " \n   </div>"
							+ " \n   <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n     <thead>"
							+ " \n       <tr>"
							+ " \n "
							+ " \n         <th>BibtexKey</th>"
							+ " \n         <th>Nationality</th>"
							+ " \n         <th>Number</th>"
							+ " \n         <th>Year</th>"
							+ " \n         <th>YearFilled</th>"
							+ " \n         <th>Author</th>"
							+ " \n         <th>Title</th>"
							+ " \n         <th>Language</th>"
							+ " \n         <th>Assignee</th>"
							+ " \n         <th>Address</th>"
							+ " \n         <th>Type</th>"
							+ " \n         <th>Number</th>"
							+ " \n         <th>Day</th>"
							+ " \n         <th>DayFilled</th>"
							+ " \n         <th>Month</th>"
							+ " \n         <th>MonthFilled</th>"
							+ " \n "
							+ " \n         <th>Note</th>"
							+ " \n         <th>URL</th>"
							+ " \n "
							+ " \n "
							+ " \n "
							+ " \n       </tr>"
							+ " \n     </thead> "
							+ " \n   <tbody>"
							);
							break;

							case 14: //periodical
							out.println("<!DOCTYPE html>"
							+ " \n <html>"
							+ " \n <head>"
							+ " \n <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n <link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n <!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n </script>  <!-- DataTables -->"
							+ " \n <script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n <script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n   \"scrollY\": \"200px\","
							+ " \n   \"paging\": false,"
							+ " \n "
							+ " \n   \"columnDefs\": ["
							+ " \n   {"
							+ " \n     \"targets\": [ 3 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 4 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 5 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 6 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 7 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 8 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 9 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 10 ],"
							+ " \n     \"visible\": false"
							+ " \n   },"
							+ " \n   {"
							+ " \n     \"targets\": [ 11 ],"
							+ " \n     \"visible\": false"
							+ " \n   }"
							+ " \n   ]}"
							+ " \n );"
							+ " \n "
							+ " \n $('a.toggle-vis').on( 'click', function (e) {"
							+ " \n   e.preventDefault();"
							+ " \n   // Get the column API object"
							+ " \n   var column = table.column( $(this).attr('data-column') );"
							+ " \n "
							+ " \n   // Toggle the visibility"
							+ " \n   column.visible( ! column.visible() );"
							+ " \n } );"
							+ " \n "
							+ " \n "
							+ " \n } );"
							+ " \n </script>"
							+ " \n "
							+ " \n </head>"
							+ " \n "
							+ " \n <body>"
							+ " \n   <div>Filters"
							+ " \n     <div> Required:"
							+ " \n "
							+ " \n       <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"1\"> Title </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"2\"> Year </a>"
							+ " \n "
							+ " \n "
							+ " \n     </div>"
							+ " \n     <div>Optional:"
							+ " \n       <!--Optional Fields  -->"
							+ " \n       <a class=\"toggle-vis\" data-column=\"3\"> Editor </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"4\"> Language </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"5\"> Series </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"6\"> Volume </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"7\"> Number </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"8\"> Organization </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"9\"> Month </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"10\"> Note </a>"
							+ " \n       <a class=\"toggle-vis\" data-column=\"11\"> URL </a>"
							+ " \n     </div>"
							+ " \n   </div>"
							+ " \n   <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n     <thead>"
							+ " \n       <tr>"
							+ " \n "
							+ " \n         <th>BibtexKey</th>"
							+ " \n         <th>Title</th>"
							+ " \n         <th>Year</th>"
							+ " \n         <th>Editor</th>"
							+ " \n         <th>Language</th>"
							+ " \n         <th>Series</th>"
							+ " \n         <th>Volume</th>"
							+ " \n         <th>Number</th>"
							+ " \n         <th>Organization</th>"
							+ " \n         <th>Month</th>"
							+ " \n         <th>Note</th>"
							+ " \n         <th>URL</th>"
							+ " \n "
							+ " \n "
							+ " \n         <th>Note</th>"
							+ " \n         <th>URL</th>"
							+ " \n       </tr>"
							+ " \n     </thead>"
							+ " \n   <tbody>"
							);
							break;

							case 15: //phd thesis
							out.println("<!DOCTYPE html>"
							+ " \n<html>"
							+ " \n<head>"
							+ " \n<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n<link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n<!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n</script>  <!-- DataTables -->"
							+ " \n<script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n<script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n  \"scrollY\": \"200px\","
							+ " \n  \"paging\": false,"
							+ " \n"
							+ " \n  \"columnDefs\": ["
							+ " \n  {"
							+ " \n    \"targets\": [ 3 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 4 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 5 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 6 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 7 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 8 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 9 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 10 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 11 ],"
							+ " \n    \"visible\": false"
							+ " \n  }"
							+ " \n  ]}"
							+ " \n);"
							+ " \n"
							+ " \n$('a.toggle-vis').on( 'click', function (e) {"
							+ " \n  e.preventDefault();"
							+ " \n  // Get the column API object"
							+ " \n  var column = table.column( $(this).attr('data-column') );"
							+ " \n"
							+ " \n  // Toggle the visibility"
							+ " \n  column.visible( ! column.visible() );"
							+ " \n} );"
							+ " \n"
							+ " \n"
							+ " \n} );"
							+ " \n</script>"
							+ " \n"
							+ " \n</head>"
							+ " \n"
							+ " \n<body>"
							+ " \n  <div>Filters"
							+ " \n    <div> Required:"
							+ " \n"
							+ " \n      <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"1\"> Title </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"2\"> Year </a>"
							+ " \n"
							+ " \n"
							+ " \n    </div>"
							+ " \n    <div>Optional:"
							+ " \n      <!--Optional Fields  -->"
							+ " \n      <a class=\"toggle-vis\" data-column=\"3\"> Editor </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"4\"> Language </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"5\"> Series </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"6\"> Volume </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"7\"> Number </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"8\"> Organization </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"9\"> Month </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"10\"> Note </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"11\"> URL </a>"
							+ " \n    </div>"
							+ " \n  </div>"
							+ " \n  <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n    <thead>"
							+ " \n      <tr>"
							+ " \n"
							+ " \n        <th>BibtexKey</th>"
							+ " \n        <th>Title</th>"
							+ " \n        <th>Year</th>"
							+ " \n        <th>Editor</th>"
							+ " \n        <th>Language</th>"
							+ " \n        <th>Series</th>"
							+ " \n        <th>Volume</th>"
							+ " \n        <th>Number</th>"
							+ " \n        <th>Organization</th>"
							+ " \n        <th>Month</th>"
							+ " \n        <th>Note</th>"
							+ " \n        <th>URL</th>"
							+ " \n"
							+ " \n"
							+ " \n        <th>Note</th>"
							+ " \n        <th>URL</th>"
							+ " \n"
							+ " \n"
							+ " \n"
							+ " \n      </tr>"
							+ " \n    </thead>"
							+ " \n   <tbody>");
							break;

							case 16: //proceedings
							out.println("<!DOCTYPE html>"
							+ " \n<html>"
							+ " \n<head>"
							+ " \n<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>"
							+ " \n<link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css\">"
							+ " \n<!-- jQuery --><script type=\"text/javascript\" charset=\"utf8\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\">"
							+ " \n</script>  <!-- DataTables -->"
							+ " \n<script type=\"text/javascript\" charset=\"utf8\" src=\"http://cdn.datatables.net/1.10.7/js/jquery.dataTables.js\"></script>"
							+ " \n<script>$(document).ready( function() {   var table = $('#article').DataTable( {"
							+ " \n  \"scrollY\": \"200px\","
							+ " \n  \"paging\": false,"
							+ " \n"
							+ " \n  \"columnDefs\": ["
							+ " \n  {"
							+ " \n    \"targets\": [ 3 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 4 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 5 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 6 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 7 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 8 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 9 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 10 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 11 ],"
							+ " \n    \"visible\": false"
							+ " \n  },"
							+ " \n  {"
							+ " \n    \"targets\": [ 12 ],"
							+ " \n    \"visible\": false"
							+ " \n  }"
							+ " \n  ]}"
							+ " \n);"
							+ " \n"
							+ " \n$('a.toggle-vis').on( 'click', function (e) {"
							+ " \n  e.preventDefault();"
							+ " \n  // Get the column API object"
							+ " \n  var column = table.column( $(this).attr('data-column') );"
							+ " \n"
							+ " \n  // Toggle the visibility"
							+ " \n  column.visible( ! column.visible() );"
							+ " \n} );"
							+ " \n"
							+ " \n"
							+ " \n} );"
							+ " \n</script>"
							+ " \n"
							+ " \n</head>"
							+ " \n"
							+ " \n<body>"
							+ " \n  <div>Filters"
							+ " \n    <div> Required:"
							+ " \n"
							+ " \n      <a class=\"toggle-vis\" data-column=\"0\"> BibtexKey </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"1\"> Title </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"2\"> Year </a>"
							+ " \n"
							+ " \n"
							+ " \n    </div>"
							+ " \n    <div>Optional:"
							+ " \n      <!--Optional Fields  -->"
							+ " \n      <a class=\"toggle-vis\" data-column=\"3\"> Editor </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"4\"> Volume </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"5\"> Number </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"6\"> Series </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"7\"> Address </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"8\"> Publisher </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"9\"> Month</a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"10\"> Organization </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"11\"> Note </a>"
							+ " \n      <a class=\"toggle-vis\" data-column=\"12\"> URL </a>"
							+ " \n    </div>"
							+ " \n  </div>"
							+ " \n  <table id=\"article\" class=\"display\" cellspacing=\"0\" width=\"100%\">"
							+ " \n    <thead>"
							+ " \n      <tr>"
							+ " \n"
							+ " \n        <th>BibtexKey</th>"
							+ " \n        <th>Title</th>"
							+ " \n        <th>Year</th>"
							+ " \n"
							+ " \n        <th>Editor</th>"
							+ " \n        <th>Volume</th>"
							+ " \n        <th>Number</th>"
							+ " \n        <th>Series</th>"
							+ " \n        <th>Address</th>"
							+ " \n        <th>Publisher</th>"
							+ " \n        <th>Month</th>"
							+ " \n        <th>Organization</th>"
							+ " \n        <th>Note</th>"
							+ " \n        <th>URL</th>"
							+ " \n"
							+ " \n"
							+ " \n        <th>Note</th>"
							+ " \n        <th>URL</th>"
							+ " \n      </tr>"
							+ " \n    </thead>"
							+ " \n   <tbody>"
							);
							break;


							default:
							break;
						}
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
					case mastersthesis: return check4MandatoryEntry(TypeMandatoryEntries.nonOptional_masterthesis) + checkRepeatedEntries();
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

			static public String dateCheck(String str)
			{
				str = str.replace("jan","January").replace("feb","February").replace("mar","March");
				str = str.replace("apr","April"  ).replace("may","May"     ).replace("jun","June");
				str = str.replace("jul","July"   ).replace("aug","August"  ).replace("sep","September");
				str = str.replace("oct","October").replace("nov","November").replace("dec","December");
				return str;
			}

			public String replaceSpecialCharacteres(String str)
			{
				//(not used) javac -encoding UTF8
			str = str.replace("\\�a","�").replace("\\'a","�");
			str = str.replace("\\~a","�").replace("\\^a","�");
			str = str.replace("\\'e","�").replace("\\^e","�");
			str = str.replace("\\�{\\i}","�").replace("\\�I","�");
			str = str.replace("\\�o","�").replace("\\~o","õ");
			str = str.replace("\\^o","�").replace("\\�u","�");
			str = str.replace("\\\"u","�").replace("\\c{c}","�");
			str = str.replace("\\c{C}","�").replace("{\"}","\"");
			str = str.replace("\\endash","�").replace("\\emdash","�");
			str = str.replace("\\-","-").replace("\\#","#");
			str = str.replace("\\&","&").replace("\\$","$");
			str = str.replace("\\~n","�").replace("\\dots","...").replace("\\-","-");
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
						// ALGUMA ALTERA��O POR SEREM OPCIONAIS???
						case article:
						java.io.PrintWriter article =  OutFiles.get(2);
						article.println("<tr>"+
						"<td>" + id + "</td>" +
						"<td>" + getEntry("author") + "</td>" +
						"<td>" + getEntry("title") + "</td>" +
						"<td>" + getEntry("journal") + "</td>" +
						"<td>" + getEntry("year") + "</td>" +
						"<td>" + getEntry("volume") + "</td>" +
						"<td>" + getEntry("pages") + "</td>" +
						"<td>" + getEntry("month") + "</td>" +
						"<td>" + getEntry("note") + "</td>" +
						"<td>" + getEntry("url") + "</td>" +
						"</tr>" );

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
						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

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
						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

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

						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

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

						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

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

						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

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
						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

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

						case mastersthesis:
						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

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
						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

						outraw.println(
						getEntry("author")
						+ getEntry("title",true)
						+ getEntry("howpublished",true)
						+ getEntry("month",true)
						+ getEntry("year")+"."
						+ getEntry("note")+".");
						break;

						case phdthesis:
						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

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
						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

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
						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

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
						article.println("<tr>"+
						"<td>" + getEntry +"</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"<td>" + getEntry + "</td>" +
						"</tr>" );

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
