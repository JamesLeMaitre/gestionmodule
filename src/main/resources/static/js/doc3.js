$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new"
    }

    function getSubjectData() {
        switch (state.value) {
            case "new":
                let data = {
                    nameSubject: $("#nameSubject").val(),
                    notesurSubject: $("#notesurSubject").val(),
                    codecourseSubject: $("#codecourseSubject").val(),
                    coefficientSubject: $("#coefficientSubject").val(),
                    teacher_id: $("#teacher_id").val(),
                    classroom_id: $("#classroom_id").val(),

                };
                //log(data);
                return data;
            case "edit":
                let dataq = {
                    idSubject: $("#matID").text(),
                    nameSubject: $("#nameSubject").val(),
                    notesurSubject: $("#notesurSubject").val(),
                    codecourseSubject: $("#codecourseSubject").val(),
                    coefficientSubject: $("#coefficientSubject").val(),
                    teacher_id: $("#teacher_id").val(),
                    classroom_id: $("#classroom_id").val(),

                };
                log(dataq);
                return dataq;
        }

    }

    sendDataInDB = (m) => {
        m = getSubjectData();
        $.ajax({
            type: 'POST',
            url: '/addNewSubject/' + m.classroom_id + '/' + m.teacher_id,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(m),
            success: (s) => {
                if (s) {
                    Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Matière enregistrée avec succès !",
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

    deleteSubjectData = (id) => {
        $.ajax({
            type: 'GET',
            url: '/deleteSubject/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Matière supprimé avec succès!!",
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
        $("#matID").text(i.idSubject);
        $("#nameSubject").val(i.nameSubject);
        $("#notesurSubject").val(i.notesurSubject);
        $("#codecourseSubject").val(i.codecourseSubject);
        $("#coefficientSubject").val(i.coefficientSubject);
        $("#teacher_id").val(i.teacher.idTeacher);
        $("#classroom_id").val(i.classroom.idClassroom);
        goEdit();
    }

    function updateSubject(u) {
        $.ajax({
            type: "GET",
            url: "/updateSubject/" + u,
            success: (r) => {
                injector(r);
                //log(injector(r));
            },
            error: (e) => {
                log(e);
            }
        })
    }

    $("#subject").on('click', (e) => {
        e.preventDefault();
        sendDataInDB();
    });

    $(".subject").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteSubjectData(value);
    });

    $(".subject_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updateSubject(value);
    });

})
