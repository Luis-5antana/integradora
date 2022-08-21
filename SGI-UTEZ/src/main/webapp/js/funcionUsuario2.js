// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
// ORTOGRAFÍA REVISADA 18/08/2022 (FINAL)
$(document).ready(function(){
    $(document).on("click","#btnDelete1", function(){
        const id = $(this).attr("data-id1");
        Swal.fire({
            title: '\u00bfDesea eliminar el malet\u00edn?',
            text: "El malet\u00edn ser\u00e1 eliminado permanentemente",
            icon: 'warning',
            showCancelButton: true,
            cancelButtonColor: '#3085d6',
            confirmButtonColor: '#d33',
            confirmButtonText: 'Eliminar',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: "deleteMaletin",
                    method: "POST",
                    data: {
                        // nombre: valor
                        id: id
                    }
                }).done(function(msg){
                    if(msg=="true"){
                        Swal.fire(
                            'Malet\u00edn eliminado',
                            'El malet\u00edn ha sido eliminado correctamente',
                            'success'
                        ).then(function(){
                            window.location="viewMaletin"
                        })
                    }else{
                        Swal.fire(
                            'Error al eliminar el malet\u00edn',
                            'No se pueden eliminar maletines prestados',
                            'error'
                        ).then(function(){
                            window.location="viewMaletin"
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

