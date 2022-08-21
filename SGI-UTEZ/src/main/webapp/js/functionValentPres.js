// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
function functionValentPres(){
    let bandera=true;
    //id_dispo
    let disp= document.getElementById("disp").value;
// id_prestamo
let id= document.getElementById("id").value;
let dispo_estatus= document.getElementById("dispo_estatus").value;

let estatus= document.getElementById("estatus").value;
let fecha= document.getElementById("fecha").value;
let observaciones = document.getElementById("obser").value;
if(estatus==""){
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Por favor, seleccione el estatus del pr\u00e9stamo',
    })
bandera=false;
}
if(fecha==""){
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Por favor, ingrese la fecha del pr\u00e9stamo correctamente',
    })
bandera=false;
}
if(bandera){

}
}
function entPres(){
    var url = "ServletPerson?accion=registrar&user="+user+"&name="+name+"&apo_pto="+apo_pto+"&apo_mto="+apo_mto+"&pass="+pass+"&matri="+matri+"&tel="+tel+"&tipo_usuario="+tipo_usuario;
    $.ajax({
        type: "POST",
        url: url,
        async: true,
        success:function(content)
        {
            $('#center').html(content);
        }
    });   
}