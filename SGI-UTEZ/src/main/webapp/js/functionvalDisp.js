// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
function valDisp(){
    let bandera=true;
    const alfanumerico=/^[A-Za-z\d\-_\s]+$/;
    const letras = /^[A-ZÑa-zñáéíóúÁÉÍÓÚ'° ]+$/;
let marca= document.getElementById("marca").value;
let num_serie=document.getElementById("num_serie").value;
let modelo= document.getElementById("modelo").value;
let num_inv =document.getElementById("num_inv").value;
let tipo= document.getElementById("tipo").value;
let estatus= document.getElementById("estatus").value;
let categoria=document.getElementById("categoria").value;
let observaciones = document.getElementById("observacion").value;
    var inv = document.getElementsByName('inv[]');
    var serie = document.getElementsByName('serie[]');

if(categoria==""){
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Por favor, seleccione la categor\u00eda del dispositivo',
    })
    bandera=false
}

if(estatus==""){
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Por favor, seleccione el estatus del dispositivo',
    })
    bandera=false
}

if(tipo==""){
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Por favor, seleccione el tipo de dispositivo',
    })
    bandera=false
}
    if(!alfanumerico.test(modelo)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese el modelo del dispositivo correctamente',
        })
        bandera=false
    }
    if(!letras.test(marca)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese la marca del dispositivo correctamente',
        })
        bandera=false
    }
    if(!alfanumerico.test(num_inv)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese el n\u00famero de inventario del dispositivo correctamente',
        })
        bandera=false
    }
if(!alfanumerico.test(num_serie)){
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Por favor, ingrese el n\u00famero de serie del dispositivo correctamente',
    })
    bandera=false
}
    for (i = 0; i < serie.length; i++) {
        if (num_serie == serie[i].value) {
            Swal.fire(
                'N\u00famero de serie repetido',
                'El registro ya se encuentra en la base de datos',
                'question'
            );
            console.log(inv[i].value);
            console.log("Errorr!! son igualees");
            bandera=false

        }
    }
    for (i = 0; i < inv.length; i++) {
        if (num_inv == inv[i].value) {
            Swal.fire(
                'N\u00famero de inventario repetido',
                'El registro ya se encuentra en la base de datos',
                'question'
            );
            console.log(num[i].value);
            console.log("Errorr!! son igualees");
            bandera=false

        }
    }
if(bandera == true){
registrarDispo(num_inv, num_serie, modelo, marca,  estatus, observaciones, tipo, categoria);

}
    }
function registrarDispo(inven,serie,modelo,marca,estatus,observacion,tipo,categoria){
    var url = "ServletDisplay?accion=registrar&num_inv="+inven+"&num_serie="+serie+"&modelo="+modelo+"&marca="+marca+"&estatus="+estatus+"&observacion="+observacion+"&tipo="+tipo+"&categoria="+categoria;
    $.ajax({
        type: "POST",
        url: url,
        async: true,
    }).done(function(msg){
        if(msg=="true"){
            Swal.fire(
                'Dispositivo registrado',
                'El dispositivo ha sido registrado correctamente',
                'success'
            ).then(function(){
                window.location="viewDisplay"
            })
        }else{
            Swal.fire(
                'Error al registrar el dispositivo',
                'Verifique los datos ingresados',
                'error'
            ).then(function(){
                window.location="viewDisplay"
            })
        }
    })
}

