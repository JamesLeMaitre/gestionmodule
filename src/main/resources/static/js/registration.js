$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new"
    }

    function getRegistrationData() {
        switch (state.value) {
            case "new":
                let data = {
                    academical_id: $("#academical_id").val(),
                }
                log(data);
                return data;

            case "edit":
                let dataq = {
                    idRegistration: $("#rID").text(),
                    academical_id: $("#academical_id").val(),
                }
                log(dataq);
                return dataq;
        }

    }

    function push_in_db(x) {
        x = getRegistrationData();
        log(x);
        $.ajax({
            type: 'POST',
            url: '/addNewRegistration/' + x.academical_id,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(x),
            success: (s) => {
                if (s) {
                    Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Registration enregistrée avec succès !",
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

    function deleteRegistration(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteRegistration/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Registration supprimée avec succès!!",
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

    function goEdit() {
        state.value = "edit";
    }

    function injector(i) {
        $("#rID").text(i.idRegistration);
        $("#academical_id").val(i.academical.idAcademical);
        goEdit();
    }

    function updateRegistration(u) {
        $.ajax({
            type: "GET",
            url: "/updateRegistration/" + u,
            success: (s) => {
                injector(s);
            },
            error: (e) => {
                log(e);
            }
        })
    }

    $("#registration").on('click', (e) => {
        e.preventDefault();
        //getRegistrationData();
        push_in_db();
    })


    $(".registration").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteRegistration(value);
    })

    $(".registration_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updateRegistration(value);
    })
})