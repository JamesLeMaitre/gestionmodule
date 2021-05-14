$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new"
    }

    function getTypeOfexaminationData() {
        switch (state.value) {
            case "new":
                let data = {
                    natureTypeexamination: $("#natureTypeexamination").val(),
                    monthTypeexamination: $("#monthTypeexamination").val(),
                }
                log(data);
                return data;
            case "edit":
                let dataq = {
                    idTypeexamination: $("#examenID").text(),
                    natureTypeexamination: $("#natureTypeexamination").val(),
                    monthTypeexamination: $("#monthTypeexamination").val(),
                }
                log(dataq);
                return dataq;
        }

    }
    function pushDataTypeOfExamination(o) {
        o = getTypeOfexaminationData();
        $.ajax({
            type: 'POST',
            url: '/addNewTypeOfExamination',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(o),
            success: (s) => {
                if (s) {
                    Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Type d'examen enregistrée avec succès !",
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

    function deleteExamination(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteTypeOfexamination/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Type d'examen supprimée avec succès!!",
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

    function goeEdit() {
        state.value = "edit"
    }

    function injector(i) {
        $("#examenID").text(i.idTypeexamination);
        $("#natureTypeexamination").val(i.natureTypeexamination);
        $("#monthTypeexamination").val(i.monthTypeexamination);
        goeEdit();
    }
    function updateExamination(u) {
        $.ajax({
            type: "GET",
            url: "/updateTypeOfExamination/" + u,
            success: (r) => {
                injector(r);
            },
            error: (e) => {
                log(e);
            }
        })
    }

    $("#typeofexamination").on('click', (e) => {
        e.preventDefault();
        pushDataTypeOfExamination();
    });

    $(".typeofexamination").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteExamination(value);
    });

    $(".typeofexamination_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updateExamination(value);
    });

})