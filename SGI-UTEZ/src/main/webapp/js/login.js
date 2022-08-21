// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
function validarAdmin(){
    let correo= document.getElementById("user").value;
let contras= document.getElementById("pass").value;

  login(correo,contras)  ;

}
function login(user,pass){
    var url = "iniciaresion?user="+user+"&pass="+pass;
    $.ajax({
        type: "POST",
        url: url,
        async: true,
    }).done(function(msg){
        if(msg=="true"){
            Swal.fire(
                'Inicio de sesi\u00f3n exitoso',
                'Bienvenido Administrador',
                'success'
            ).then(function(){
                window.location="AD_Perfil.jsp"
            })
        }
        if(msg=="true1"){
            Swal.fire(
                'Inicio de sesi\u00f3n exitoso',
                'Bienvenido Usuario',
                'success'
            ).then(function(){
                window.location="UE_perfil.jsp"
            })
        }
        if(msg=="false"){
            Swal.fire(
                'Error al iniciar sesi\u00f3n',
                'Correo electr\u00f3nico o contrase\u00f1a incorrectos. Verifique los datos ingresados',
                'error'
            ).then(function(){
                window.location="index.jsp"
            })
        }
    })
    }