$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new"
    }

    function getTeachingDegreData() {
        switch (state.value) {
            case "new":
                let data = {
                    orderDegre: $("#orderDegre").val(),
                }
                log(data);
                return data;

            case "edit":
                let dataq = {
                    idDegre: $("#academicID").text(),
                    orderDegre: $("#orderDegre").val(),
                }
                log(dataq);
                return dataq;
        }

    }

    function putItInDB(x) {
        x = getTeachingDegreData();
        log(x);
        $.ajax({
            type: 'POST',
            url: '/addNewTeachingDegre',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(x),
            success: (s) => {
                if (s) {
                    Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Dégre d'enseignement enregistrée avec succès !",
                        showConfirmButton: false,
                        timer: 1500,
                    }).then(() => {
                        window.location.href = window.location.href;
                        // window.location.reload();
                    });

                }
            },
            error: (e) => {
                log(e);
            },

        });
    }

    function getEdit() {
        state.value = "edit";
    }

    function injector(i) {
        $("#academicID").text(i.idDegre);
        $("#orderDegre").val(i.orderDegre);
        getEdit();
    }

    function updatingYear(u) {
        $.ajax({
            type: "GET",
            url: "/updateTeachingDegre/" + u,
            success: (t) => {
                injector(t);
            },
            error: (e) => {
                log(e);
            }
        })
    }
    function deleteTeachingDegre(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteTeachingDegre/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Dégré d'enseignement supprimée avec succès!!",
                        showConfirmButton: false,
                        timer: 1500,
                        backdrop: true,

                    }).then(() => {
                        window.location.reload();
                    });
                } else {
                    log(r);
                }
            },
            error: (e) => {
                log(e);
            }
        })
    }

    $("#degre").on('click', (e) => {
        e.preventDefault();
        //getRegistrationData();

        putItInDB();
    })


    $(".degre").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteTeachingDegre(value);
    })

    $(".degre_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updatingYear(value);
    })

})