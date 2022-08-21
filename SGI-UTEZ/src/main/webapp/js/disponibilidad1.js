function disponibilidad1(){
    let opcion = true;
    /* EXPRESIONES REGULARES*/
    let apellidos=   /^([A-Z]){1}[a-z]+$/;
    var nombres = /^([A-Z]{1}[a-z]+[\s]*)+$/;
    var nombre = document.getElementById('name').value;
    var apo_pto = document.getElementById("apo_pto").value;
    var apo_mto = document.getElementById("apo_mto").value;
    let tipo= document.getElementById("tipo").value;

    if(tipo==""){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, seleccione el tipo de dispositivo',
        })
        opcion=false
    }
    if(!apellidos.test(apo_mto)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese el apellido materno correctamente',
            footer: 'Nota:Sin acentos ni \u00f1'
        })
        opcion = false;
    }
    if(!apellidos.test(apo_pto)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese el apellido paterno correctamente',
            footer: 'Nota:Sin acentos ni \u00f1'
        })
        opcion = false;
    }
    if(!nombres.test(nombre)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese el nombre correctamente',
            footer: 'Nota:Sin acentos ni \u00f1'
        })
        opcion = false;
    }
   if(opcion==true){
       valDisponibilidad(nombre,apo_pto,apo_mto,tipo);
   }
}
function valDisponibilidad(name,apo_pto,apo_mto,tipo){
    const url = "viewDisplay1?name=" + name + "&apo_pto=" + apo_pto + "&apo_mto=" + apo_mto + "&tipo=" + tipo;
    $.ajax({
        type: "post",
        url: url,
        async: true,
    }).done(function(){
            Swal.fire(
                'Cargando',
                'Buscando Dispositivos Disponibles',
                'success'
            ).then(function(){
                window.location="AD_regPres1.jsp"
            })

        })
}