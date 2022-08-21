// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
function valModMale(){
    let bandera=true;
    const alfanumerico=/^[A-Za-z\d\-_\s]+$/;
    const letras = /^\w+$/;
    let id= document.getElementById("id").value;
    let num_inv =document.getElementById("num_inventario").value;
    let estatus= document.getElementById("estatus").value;
    let categoria=document.getElementById("categoria").value;
    let descripcion = document.getElementById("descripcion").value;
    let observaciones = document.getElementById("observacion").value;


    if(categoria==""){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, seleccione la categor\u00eda del malet\u00edn',
        })
        bandera=false
    }

    if(estatus==""){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, seleccione el estatus del malet\u00edn',
        })
        bandera=false
    }
    if(descripcion==""){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese una descripci\u00f3n v\u00e1lida',
        })
        bandera=false
    }
    if(!alfanumerico.test(num_inv)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese un n\u00famero de inventario v\u00e1lido',
        })
        bandera=false
    }

    if(bandera==true){
        modMale(id,categoria,descripcion,estatus,observaciones,num_inv);

    }
}
function modMale(id,cta_male,descripcion,estatus,observacion,num_inventario){
    var url = "editMaletin2?id="+id+"&categoria="+cta_male+"&descripcion="+descripcion+"&estatus="+estatus+"&observacion="+observacion+"&estatus="+estatus+"&num_inventario="+num_inventario;
    $.ajax({
        type: "POST",
        url: url,
        async: true,
    }).done(function(msg){
        if(msg=="true"){
            Swal.fire(
                'Malet\u00edn modificado',
                'El malet\u00edn ha sido modificado correctamente',
                'success'
            ).then(function(){
                window.location="viewMaletin"
            })
        }else{
            Swal.fire(
                'Error al modificar el malet\u00edn',
                'Verifique los datos ingresados',
                'error'
            ).then(function(){
                window.location="viewMaletin"
            })
        }

    })

}

