$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new"
    }
    function getNote() {
        switch (state.value) {
            case "new":
                let data = {
                    student_id: $("#student_id").val(),
                    subject_id: $("#subject_id").val(),
                    note: $("#note").val(),
                    examination_id: $("#examination_id").val(),
                }
                log(data);
                return data;
            case "edit":
                let dataq = {
                    idNote: $("#noteID").text(),
                    student_id: $("#student_id").val(),
                    subject_id: $("#subject_id").val(),
                    note: $("#note").val(),
                    examination_id: $("#examination_id").val(),
                }
                log(dataq);
                return dataq;
        }
    }

    function saveNote(n) {
        n = getNote();
        $.ajax({
            type: 'POST',
            url: '/addNewNote/' + n.student_id + '/' + n.examination_id + '/' + n.subject_id,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(n),
            success: (s) => {
                if (s) {
                    Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Note enregistré avec succès !",
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

    function deleteStudentNote(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteNote/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Note supprimée avec succès!!",
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
    };

    function goEdit() {
        state.value = "edit"
    }

    function injector(n) {
        $("#noteID").text(n.idNote);
         $("#student_id").val(n.student.idStudent);
        $("#subject_id").val(n.subject.idSubject);
        $("#note").val(n.note);
        $("#examination_id").val(n.examination.idTypeexamination);
        goEdit();
    }

    function updateStudentNote(s) {
        $.ajax({
            type: "GET",
            url: "/updateNote/" + s,
            success: (s) => {
                injector(s);
            },
            error: (e) => {
                log(e);
            }
        })
    }

    $("#notes").on('click', (e) => {
        e.preventDefault();
        saveNote();
    });

    $(".notes").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteStudentNote(value);
    });

    $(".notes_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updateStudentNote(value);
    });
})