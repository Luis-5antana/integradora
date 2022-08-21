// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
function valModDisp(){
    let bandera=true;
    const alfanumerico=/^[A-Za-z\d\-_\s]+$/;
    const letras = /^[A-ZÑa-zñáéíóúÁÉÍÓÚ'° ]+$/;
    let id=document.getElementById("id").value;
    let marca= document.getElementById("marca").value;
    let num_serie=document.getElementById("num_serie").value;
    let modelo= document.getElementById("modelo").value;
    let num_inv =document.getElementById("num_inv").value;
    let tipo= document.getElementById("tipo").value;
    let estatus= document.getElementById("estatus").value;
    let categoria=document.getElementById("categoria").value;
    let observaciones = document.getElementById("observacion").value;


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
            text: 'modelo',
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
    } console.log(modelo);
    console.log(marca);
    if(bandera==true){


        modDisp(id,num_serie,num_inv,modelo,marca,estatus,observaciones,tipo,categoria);
    }
}
function modDisp(id,serie,inven,modelo,marca,estatus,observacion,tipo,categoria){
    var url = "editDisplay2?id="+id+"&num_inv="+inven+"&num_serie="+serie+"&modelo="+modelo+"&marca="+marca+"&estatus="+estatus+"&observacion="+observacion+"&tipo="+tipo+"&categoria="+categoria;
    $.ajax({
        type: "POST",
        url: url,
        async: true,
    }).done(function(msg){
            if(msg=="false"){
                Swal.fire(
                    'Dispositivo modificado',
                    'El dispositivo ha sido modificado correctamente',
                    'success'
                ).then(function(){
                    window.location="viewDisplay"
                })
            }else{
                Swal.fire(
                    'Error al modificar el dispositivo',
                    'Verifique los datos ingresados',
                    'error'
                ).then(function(){
                    window.location="viewDisplay"
                })
            }
        })

}