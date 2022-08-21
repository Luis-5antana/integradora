// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
function valEntPresDisp(){
    var opcion=true;
    let disp= document.getElementById("disp").value;
    // id_prestamo
    let id= document.getElementById("id").value;
    let estatus= document.getElementById("estatus").value;
    let fecha= document.getElementById("fecha").value;
    let observaciones = document.getElementById("obser").value;

    if(fecha==""){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese la fecha de entrega del pr\u00e9stamo correctamente',
        })
        opcion = false;
    }
if(opcion==true){
        entPresDisp(disp,id,estatus,observaciones,fecha);
}

}
function entPresDisp(id_disp,id_pres,estatus,observaciones,fecha){
    var url = "EntregarPrestamo?disp="+id_disp+"&id="+id_pres+"&estatus="+estatus+"&obser="+observaciones+"&fecha="+fecha;
    $.ajax({
        type: "POST",
        url: url,
        async: true,
    }).done(function(msg){
        if(msg=="true"){
            Swal.fire(
                'Entrega registrada',
                'El dispositivo ha sido entregado correctamente',
                'success'
            ).then(function(){
                window.location="viewPrestamoUsu"
            })
        }else{
            Swal.fire(
                'Error al entregar el dispositivo',
                'Verifique los datos ingresados',
                'error'
            ).then(function(){
                window.location="viewPrestamoUsu"
            })
        }
    })
}