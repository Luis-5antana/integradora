// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
function validarCampos() {
    let opcion = true;
    /* EXPRESIONES REGULARES*/
    let apellidos=   /^([A-Z]){1}[a-z]+$/;
    var matriculas = /^\d{5}\w{2}\d{3}$/;
    var telefonos = /^\d{10}$/;
    var nombres = /^([A-Z]{1}[a-z]+[\s]*)+$/;
    var correos = /\d{5}\w{2}\d{3}\@utez.edu.mx+$/;
    var contrasenas =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
    /* VALUES */
    var nombre = document.getElementById('name').value;
    var apo_pto = document.getElementById("apo_pto").value;
    var apo_mto = document.getElementById("apo_mto").value;
    var tel = document.getElementById("tel").value;
    var matri = document.getElementById("matri").value;
    var user = document.getElementById("user").value;
    var pass = document.getElementById("pass").value;
    var pass2 = document.getElementById("pass2").value;
    var user2 = document.getElementsByName('user[]');
var tele2= document.getElementsByName('tel[]');
var matri2=  document.getElementsByName("matricula[]");
    var tipo_usuario = document.getElementById("tipo_usuario").value;

    if(tipo_usuario==""){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, seleccione un tipo de usuario',
        })
        opcion = false;
    }
if(!contrasenas.test(pass2)){
 Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'La contrase\u00f1a no es segura',
        })
opcion=false;
}
if(pass!=pass2){
 Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'No coinciden las contrase\u00f1as',
        })
opcion=false;
}

    if(pass2==""){
 Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Falta confirmar la contrase\u00f1a',
        })
        opcion=false;
    }
  if(pass==""){
 Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Ingresa una contrase\u00f1a',
        })
      opcion=false;
  }
  if(!correos.test(user)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese un correo electr\u00f3nico v\u00e1lido',
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
    if(!telefonos.test(tel)){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese un n\u00famero de tel\u00e9fono v\u00e1lido',
        })
        opcion = false;
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
    //validar telefonto
    for (i = 0; i < tele2.length; i++) {
        if (tel == tele2[i].value) {
            Swal.fire(
                'N\u00famero de tel\u00e9fono repetido',
                'El registro ya se encuentra en la base de datos',
                'question'
            );
            console.log(tele2[i].value);
            console.log("Errorr!! son igualees");
            opcion=false;
        }
    }
    //validar matricula
    for (i = 0; i < matri2.length; i++) {
        if (matri == matri2[i].value) {
            Swal.fire(
                'Matr\u00edcula repetida',
                'El registro ya se encuentra en la base de datos',
                'question'
            );
            console.log(tele2[i].value);
            console.log("Errorr!! son igualees");
            opcion=false;
        }
    }
    //validar correoa
    for (i = 0; i < user2.length; i++) {
        if (user == user2[i].value) {
            Swal.fire(
                'Correo electr\u00f3nico repetido',
                'El registro ya se encuentra en la base de datos',
                'question'
            );
            console.log(user2[i].value);
            console.log("Errorr!! son igualees");
            opcion=false;
        }
    }
    if(opcion == true){
        registrarUsuario(nombre, apo_pto, apo_mto,user, matri,pass, tel, tipo_usuario);
    }
}
function registrarUsuario(name, apo_pto, apo_mto,user, matri,pass, tel, tipo_usuario){
    var url = "savePerson?user="+user+"&name="+name+"&apo_pto="+apo_pto+"&apo_mto="+apo_mto+"&pass="+pass+"&matri="+matri+"&tel="+tel+"&tipo_usuario="+tipo_usuario;
    $.ajax({
        contentType : "application/x-www-form-urlencoded; charset=iso-8859-1",
        type: "POST",
        url: url,
        async: true,
    }).done(function(msg){
        console.log("entra")
        if(msg=="true"){
            Swal.fire(
                'Usuario registrado',
                'El usuario ha sido registrado correctamente',
                'success'
            ).then(function(){
                window.location="ViewPerson"
            })
        }else{
            Swal.fire(
                'Error al registrar al usuario',
                'Verifique los datos ingresados',
                'error'
            ).then(function(){
                window.location="ViewPerson"
            })
        }
    })
}
/*
function validarCorreo(user,user2) {
bandera:
    for (i = 0; i < user2.length; i++) {
        if (user == user2[i].value) {

            console.log(user2[i].value);
            console.log("Errorr!! son igualees");
return true;
            break;
        }else{
return false;
        }

    }
}

function validarMatricula() {
    
    for (i = 0; i < user2.length; i++) {
        if (user == user2[i].value) {
            Swal.fire(
                'Error?',
                'El registro ya se encuentra en la BD',
                'question'
            )
            console.log(user2[i].value);
            console.log("Errorr!! son igualees");

        }
    }

}
function validarTelefono() {

    var user = document.getElementById("user").value;
    var user2 = document.getElementsByName('user[]');

    for (i = 0; i < user2.length; i++) {
        if (user == user2[i].value) {
            Swal.fire(
                'Error?',
                'El registro ya se encuentra en la BD',
                'question'
            )
            console.log(user2[i].value);
            console.log("Errorr!! son igualees");
            document.getElementById("user").disabled=true;
            document.getElementById("pass").disabled=true;

        }else{
            document.getElementById("user").disabled=false;
            document.getElementById("pass").disabled=false;

        }

    }


}

 */