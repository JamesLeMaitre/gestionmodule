$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new"
    }

    function getStudentData() {
        switch (state.value) {
            case "new":
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
            case "edit":
                let dataq = {
                    idStudent: $("#studentID").text(),
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
                log(dataq);
                return dataq;
        }
    };

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
    };

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
    };

    function goEdit() {
        state.value = "edit";
    }

    function injector(i) {
        $("#studentID").text(i.idStudent);
        $("#firstnameStudent").val(i.firstnameStudent);
        $("#lastnameStudent").val(i.lastnameStudent);
        $("#sexStudent").val(i.sexStudent);
        $("#birthdayStudent").val(i.birthdayStudent);
        $("#placeofbirthStudent").val(i.placeofbirthStudent);
        $("#statutStudent").val(i.statutStudent);
        $("#adressStudent").val(i.adressStudent);
        $("#serialnumberStudent").val(i.serialnumberStudent);
        $("#persontocontactStudent").val(i.persontocontactStudent);
        $("#physicalstateStudent").val(i.physicalstateStudent);
        $("#maritalstatusStudent").val(i.maritalstatusStudent);
        $("#schooloforiginStudent").val(i.schooloforiginStudent);
       
     
        $("#registration_id").val(i.registration.academical.idAcademical);
        $("#parents_id").val(i.parents.idParents);
        $("#classroom_id").val(i.classroom.idClassroom);
        $("#teacher_id").val(i.teacher.idTeacher);
        goEdit();
    }

    function updateStudentData(u) {
        $.ajax({
            type: "GET",
            url: "/updateStudent/" + u,
            success: (r) => {
                injector(r);
            },
            error: (e) => {
                log(e);
                injector(e);
            }
        });
    }

    $("#student").on('click', (e) => {
        e.preventDefault();
        saveINDB();
    });

    $(".student").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteStudent(value);
    });

    $(".student_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updateStudentData(value);
    });

})