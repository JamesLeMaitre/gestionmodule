$(document).ready(function () {
    const log = console.log;

    function getTeacherDat() {
        let data = {
            firstnameTeacher: $("#firstnameTeacher").val(),
            lastnameTeacher: $("#lastnameTeacher").val(),
            addressTeacher: $("#addressTeacher").val(),
            sexTeacher: $("#sexTeacher").val(),
            emailTeacher: $("#emailTeacher").val(),
            phoneTeacher: $("#phoneTeacher").val(),
            postboxTeacher: $("#postboxTeacher").val(),
            serialnumberTeacher: $("#serialnumberTeacher").val(),
            idnumberTeacher: $("#idnumberTeacher").val(),
            typeidTeacher: $("#typeidTeacher").val(),
            classroom_id: $("#classroom_id").val(),
        }
        //   log(data);
        return data;
    }

    function getStudentData() {
        let data = {
            firstnameStudent: $("#firstnameStudent").val(),
            lastnameStudent: $("#lastnameStudent").val(),
            sexStudent: $("#sexStudent").val(),
            birthdayStudent: $("#birthdayStudent").val(),
            placeofbirthStudent: $("#placeofbirthStudent").val(),
            statutStudent: $("#statutStudent").val(),
            adressStudent: $("#adressStudent").val(),
            serialnumberStudent: $("#serialnumberStudent").val(),
            persontocontactStudent: $("#persontocontactStudent").val(),
            physicalstateStudent: $("#physicalstateStudent").val(),
            maritalstatusStudent: $("#maritalstatusStudent").val(),
            schooloforiginStudent: $("#schooloforiginStudent").val(),
            classroom_id: $("#classroom_id").val(),
            teacher_id: $("#teacher_id").val(),
            registration_id: $("#registration_id").val(),
            parents_id: $("#parents_id").val(),
        }
        log(data);
        return data;
    }

    function getNote() {
        let data = {
            student_id: $("#student_id").val(),
            subject_id: $("#subject_id").val(),
            note: $("#note").val(),
            examination_id: $("#examination_id").val(),
        }
        log(data);
        return data;
    }

    function sendInDB(t) {
        t = getTeacherDat();
        $.ajax({
            type: 'POST',
            url: '/addNewTeacher/' + t.classroom_id,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(t),
            success: (s) => {
                if (s) {
                    Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Teacher enregistrée avec succès !",
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

    function saveINDB(s) {
        s = getStudentData();
        $.ajax({
            type: 'POST',
            url: '/addNewStudent/' + s.registration_id + '/' + s.parents_id + '/' + s.classroom_id + '/' + s.teacher_id,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(s),
            success: (s) => {
                if (s) {
                    Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Student enregistré avec succès !",
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

    function deleteTeacher(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteTeacher/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Teacher supprimé avec succès!!",
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
    }

    function deleteStudent(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteStudent/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Elève supprimé avec succès!!",
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

    $("#teacher").on('click', (e) => {
        e.preventDefault();
        sendInDB();
    });


    $("#student").on('click', (e) => {
        e.preventDefault();
        saveINDB();
    });

    $("#notes").on('click', (e) => {
        e.preventDefault();
        saveNote();
    });


    $(".teacher").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteTeacher(value);
    })

    $(".student").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteStudent(value);
    })

    $(".notes").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteStudentNote(value);
    })
})
