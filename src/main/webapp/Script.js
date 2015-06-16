

function fillArtikelVerwijderen() {
   var fields = document.getElementById("artikel").value.split(",");
   document.getElementById("artikelType").value = fields[1]; 
   document.getElementById("aantal").value = fields[2];
   document.getElementById("minimum").value = fields[3];
   document.getElementById("prijs").value = fields[4];
}