$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new"
    };


    function getData() {
        switch (state.value) {
            case "new":
                let data = {
                    academicyear: $("#academicyear").val(),
                }
                log(data);
                return data;

            case "edit":
                let dataq = {
                    idAcademical: $("#monID").text(),
                    academicyear: $("#academicyear").val()
                }
                log(dataq);
                return dataq;

            default:
                break;
        }

    }

    function goEdit() {
        state.value = "edit";
    };

    function boostrapingData(b) {
        $("#monID").text(b.idAcademical);
        $("#academicyear").val(b.academicyear);
        goEdit();
    };

    updateAcademicalYear = (u) => {
        $.ajax({
            type: "GET",
            url: "/updateAcademicalYear/" + u,
            success: (r) => {
                boostrapingData(r);
            },
            error: (e) => {
                log(e);
            }
        })
    };


    function pushInDB(x) {
        x = getData();
        //log(x);
        $.ajax({
            type: 'POST',
            url: '/addNewAcademical',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(x),
            success: (s) => {
                if (s) {
                    Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Année académique enregistrée avec succès !",
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

    function deleteAcademicYear(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteAcademical/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Année académique supprimée avec succès!!",
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

    $("#yearAcademic").on('click', (e) => {
        e.preventDefault();
        pushInDB();
    });

    $(".academical").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteAcademicYear(value);
    });

    $(".academical_edit").on("click", (e) => {
        e.preventDefault();
        let val = e.currentTarget.title;
        //log(val);
        updateAcademicalYear(val);
    });
})