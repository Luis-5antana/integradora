// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
    $(document).ready(function(){
    $(document).on("click","#btnDelete", function(){
        const id = $(this).attr("data-id");

        Swal.fire({
            title: '\u00bfDesea eliminar al usuario?',
            text: "El usuario ser\u00e1 eliminado permanentemente",
            icon: 'warning',
            showCancelButton: true,
            cancelButtonColor: '#3085d6',
            confirmButtonColor: '#d33',
            confirmButtonText: 'Eliminar',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: "deletePerson",
                    method: "POST",
                    data: {
                        // nombre: valor
                        id: id
                    }
                }).done(function(msg){
                    if(msg=="true"){
                        Swal.fire(
                            'Usuario eliminado',
                            'El usuario ha sido eliminado correctamente',
                            'success'
                        ).then(function(){
                            window.location="ViewPerson"
                        })
                    }else{
                        Swal.fire(
                            'Error al eliminar el usuario',
                            'Ha ocurrido un error al eliminar el usuario',
                            'error'
                        ).then(function(){
                            window.location="ViewPerson"
                        })
                    }
                })
            }

        })
        /*const opcion = confirm("Estas seguro de querer eliminar?")
        if(opcion){
            $.ajax({
                url: "deletePerson",
                method: "POST",
                data: {
                    // nombre: valor
                    id: id
                }
            }).done(function(msg){
                alert(msg)
                window.location="ViewPerson"
            })
        }*/
    })
})

