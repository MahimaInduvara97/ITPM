
$(document).on("click", "#btnSave", function(event)
{
if(document.getElementById("NR").value == line.getLineNumber()){
	
	
	 		}
else
	 	{	
			var x = line.getLineNumber()  * document.getElementById("NR").value;
			 document.getElementById('t').innerHTML = x;
	 	}
});
