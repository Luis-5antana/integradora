// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
function valRegPresUsu() {
    let opcion = true;
//expresiones
    const apellidos = /^[A-Z]{1}[a-zñáéíóú]+$/;
    const nombres = /^([A-Z]{1}[a-zñáéíóú]+[\s]*)+$/;
    var matriculas = /^([a-zA-Z0-9_-]){10}$/;
    var telefonos = /^\d{10}$/;
    var correos = /\d{5}\w{2}\d{3}\@utez.edu.mx+$/;

//obtener
       let nombre = document.getElementById("nom").value;
    let apo_pto = document.getElementById("apo_pto").value;
    let apo_mto = document.getElementById("apo_mto").value;


    let dispo_estatus = document.getElementById("disp_estatus").value;
    let estatus = document.getElementById("estatus").value;
    let tel = document.getElementById("tel").value;
    let matri = document.getElementById("matri").value;
    let email = document.getElementById("email").value;
    let disp = document.getElementById("disp").value;
    let fecha = document.getElementById("fecha").value;

    if (fecha == "") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese la fecha del pr\u00e9stamo correctamente',
        })
        opcion = false;
    }
    if (disp == "") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, seleccione el tipo de dispositivo',
        })
        opcion = false;
    
    }
    if(!telefonos.test(tel)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese un n\u00famero de tel\u00e9fono v\u00e1lido',
        })
        opcion = false;
    }
    if(!matriculas.test(matri)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese una matr\u00edcula v\u00e1lida',
        })
        opcion = false;
    }


    if(!correos.test(email)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese un correo electr\u00f3nico v\u00e1lido',
        })
        opcion = false;
    }
 /*
    if (!apellidos.test(apo_mto)) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'apellidoMto',
            footer: '<a href="">Why do I have this issue?</a>'
        })
        opcion = false;
    }

    if (!apellidos.test(apo_pto)) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'apellidoPto',
            footer: '<a href="">Why do I have this issue?</a>'
        })
        opcion = false;
    }
    if (!nombres.test(nombre)) {
        opcion = false;
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'nombre',
            footer: '<a href="">Why do I have this issue?</a>'
        })
    }

 */
    if (opcion == true) {
        regPres(nombre,apo_pto,apo_mto,email,matri,fecha,disp,estatus,dispo_estatus,tel);

    }
}
function regPres(nom,apo_pto,apo_mto,correo,matricula,fecha,id_disp,estatus,est_disp,tel) {
    var url = "ServletPrestamo?nom="+nom+"&apo_pto="+apo_pto+"&apo_mto="+apo_mto+"&email="+correo+"&matri="+matricula+"&fecha="+fecha+"&disp="+id_disp+"&estatus="+estatus+"&disp_estatus"+est_disp+"&tel="+tel;
    $.ajax({
        type: "POST",
        url: url,
        async: true,
    }).done(function(msg){
            if(msg=="true"){
                Swal.fire(
                    'Pr\u00e9stamo registrado',
                    'El pr\u00e9stamo ha sido registrado correctamente',
                    'success'
                ).then(function(){
                    window.location="viewPrestamoUsu1"
                })
            }else{
                Swal.fire(
                    'Error al registrar el pr\u00e9stamo',
                    'Verifique los datos ingresados',
                    'error'
                ).then(function(){
                    window.location="viewPrestamoUsu1"
                })
            }
        })
}