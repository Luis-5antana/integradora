// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
function valMale(){
    let bandera=true;
    const alfanumerico=/^[A-Za-z\d\-_\s]+$/;
    const letras = /^\w+$/;
    let num_inv =document.getElementById("num_inventario").value;
    let estatus= document.getElementById("estatus1").value;
    let categoria=document.getElementById("categoria").value;
    let descripcion = document.getElementById("descripcion").value;
    let observaciones = document.getElementById("observacion1").value;
    var num = document.getElementsByName('num[]');
    if(!alfanumerico.test(num_inv)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese un n\u00famero de inventario v\u00e1lido',
        })
        bandera=false
    }
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

    //validar num_inventario
    for (i = 0; i < num.length; i++) {
        if (num_inv == num[i].value) {
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

if(bandera==true){
    registrarMale(categoria,descripcion,estatus,observaciones,num_inv);

}
}
function registrarMale(cta_male,descripcion,estatus,observacion,num_inventario){
    var url = "ServletMaletin?accion=registrar&categoria="+cta_male+"&descripcion="+descripcion+"&estatus="+estatus+"&observacion="+observacion+"&estatus="+estatus+"&num_inventario="+num_inventario;
    $.ajax({
        type: "POST",
        url: url,
        async: true,
    }).done(function(msg){
        if(msg=="true"){
            Swal.fire(
                'Malet\u00edn registrado',
                'El malet\u00edn ha sido registrado correctamente',
                'success'
            ).then(function(){
                window.location="viewMaletin"
            })
        }else{
            Swal.fire(
                'Error al registrar el malet\u00edn',
                'Verifique los datos ingresados',
                'error'
            ).then(function(){
                window.location="viewMaletin"
            })
        }

    })

}

