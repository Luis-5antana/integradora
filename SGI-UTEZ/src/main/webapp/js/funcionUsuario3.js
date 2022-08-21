// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
$(document).ready(function(){
    $(document).on("click","#btnDelete2", function(){
        const id = $(this).attr("data-id2");

        Swal.fire({
            title: '\u00bfDesea eliminar el dispositivo?',
            text: "El dispositivo ser\u00e1 eliminado permanentemente",
            icon: 'warning',
            showCancelButton: true,
            cancelButtonColor: '#3085d6',
            confirmButtonColor: '#d33',
            confirmButtonText: 'Eliminar',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: "DeleteDisplay",
                    method: "POST",
                    data: {
                        // nombre: valor
                        id: id
                    }
                }).done(function(msg){
                    if(msg=="true"){
                        Swal.fire(
                            'Dispositivo eliminado',
                            'El dispositivo ha sido eliminado correctamente',
                            'success'
                        ).then(function(){
                            window.location="ViewPerson"
                        })
                    }else{
                        Swal.fire(
                            'Error al eliminar el dispositivo',
                            'Ha ocurrido un error al eliminar el dispositivo',
                            'error'
                        ).then(function(){
                            window.location="viewDisplay"
                        })
                    }
                })
            }

        })
    })
})

