$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new",
    }

    function getSchoolData() {
        switch (state.value) {
            case "new":
                let data = {
                    schoolname: $("#schoolname").val(),
                    levelSchool: $("#levelSchool").val(),
                    logoSchool: $("#logoSchool").val(),
                    mottoSchool: $("#mottoSchool").val(),
                    creationdateSchool: $("#creationdateSchool").val(),
                    founderSchool: $("#founderSchool").val(),
                    generalmanagerSchool: $("#generalmanagerSchool").val(),
                    emailSchool: $("#emailSchool").val(),
                    phoneSchool: $("#phoneSchool").val(),
                    academical_id: $("#academical_id").val(),
                }
                log(data);
                return data;

            case "edit":
                let dataq = {
                    idSchool: $("#schID").text(),
                    schoolname: $("#schoolname").val(),
                    levelSchool: $("#levelSchool").val(),
                    logoSchool: $("#logoSchool").val(),
                    mottoSchool: $("#mottoSchool").val(),
                    creationdateSchool: $("#creationdateSchool").val(),
                    founderSchool: $("#founderSchool").val(),
                    generalmanagerSchool: $("#generalmanagerSchool").val(),
                    emailSchool: $("#emailSchool").val(),
                    phoneSchool: $("#phoneSchool").val(),
                    academical_id: $("#academical_id").val(),
                }
                log(dataq);
                return dataq;
        }

    }

    function sendInDB(x) {
        x = getSchoolData();
        log(x);
        $.ajax({
            type: 'POST',
            url: '/addNewSchool/' + x.academical_id,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(x),
            success: (s) => {
                if (s) {
                    Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Nouvelle école enregistrée avec succès !",
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

    function deleteSchool(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteSchool/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Ecole supprimée avec succès!!",
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
        state.value = "edit"
    }

    function injector(i) {
        $("#schID").text(i.idSchool);
        $("#schoolname").val(i.schoolname);
        $("#levelSchool").val(i.levelSchool);
        $("#mottoSchool").val(i.mottoSchool);
        $("#logoSchool").val(i.logoSchool);
        $("#creationdateSchool").val(i.creationdateSchool);
        $("#founderSchool").val(i.founderSchool);
        $("#generalmanagerSchool").val(i.generalmanagerSchool);
        $("#emailSchool").val(i.emailSchool);
        $("#phoneSchool").val(i.phoneSchool);
        $("#academical_id").val(i.academical.idAcademical);
        goEdit();

    }

    function updateSchools(u) {
        $.ajax({
            type: "GET",
            url: "/updateSchool/" + u,
            success: (r) => {
                injector(r);
            },
             error: (e) => {
                log(e);
            }
        })
    }
    $("#school").on('click', (e) => {
        e.preventDefault();
        sendInDB();
    });

    $(".school").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteSchool(value);
    })

    $(".school_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updateSchools(value);
    })
})