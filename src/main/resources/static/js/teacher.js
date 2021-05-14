$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new",
    }

    function getTeacherDat() {
        switch (state.value) {
            case "new":
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
            case "edit":
                let dataq = {
                    idTeacher: $("#tID").text(),
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
                return dataq;
        }
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
    function goEdit() {
        state.value = "edit";
    }

    function iunjector(i) {
        $("#tID").text(i.idTeacher);
        $("#firstnameTeacher").val(i.firstnameTeacher);
        $("#lastnameTeacher").val(i.lastnameTeacher);
        $("#addressTeacher").val(i.addressTeacher);
        $("#sexTeacher").val(i.sexTeacher);
        $("#emailTeacher").val(i.emailTeacher);
        $("#phoneTeacher").val(i.phoneTeacher);
        $("#postboxTeacher").val(i.postboxTeacher);
        $("#serialnumberTeacher").val(i.serialnumberTeacher);
        $("#idnumberTeacher").val(i.idnumberTeacher);
        $("#typeidTeacher").val(i.typeidTeacher);
        $("#classroom_id").val(i.classroom.idClassroom);
        goEdit();
    }

    function updateTeachers(u) {
        $.ajax({
            type: "GET",
            url: "/updateTeacher/" + u,
            success: (r) => {
                iunjector(r);
            },
            error: (e) => {
                log(e);
            }
        });
    }

    $("#teacher").on('click', (e) => {
        e.preventDefault();
        sendInDB();
    });

    $(".teacher").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteTeacher(value);
    });

    $(".teacher_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updateTeachers(value);
    });



})
