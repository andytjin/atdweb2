

function fillArtikelVerwijderen() {
   var fields = document.getElementById("artikel").value.split(",");
   document.getElementById("artikelType").value = fields[1]; 
   document.getElementById("aantal").value = fields[2];
   document.getElementById("minimum").value = fields[3];
   document.getElementById("prijs").value = fields[4];
}

function fillOnderhoudsbeurt() {
   var fields = document.getElementById("onderhoudsbeurtID").value.split(",");
   document.getElementById("datum").value = fields[1]; 
   document.getElementById("auto").value = fields[2];
   document.getElementById("monteur").value = fields[3];
   document.getElementById("uur").value = fields[4];
}

function fillGebruikteArtikelen() {
   var fields = document.getElementById("gebruikteartikelen").value.split(",");
   document.getElementById("onderhoudsbeurt").value = fields[1]; 
   document.getElementById("artikel").value = fields[2];
   document.getElementById("ga").value = fields[3];
}