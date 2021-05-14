$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new"
    }
    function getClassroomData() {
        switch (state.value) {
            case "new":
                let data = {
                    nameClassroom: $("#nameClassroom").val(),
                    acronymClassroom: $("#acronymClassroom").val(),
                    effectiveClassroom: $("#effectiveClassroom").val(),
                    seatbenchClassroom: $("#seatbenchClassroom").val(),
                    schoolfeesClassroom: $("#schoolfeesClassroom").val(),
                    membership_id: $("#membership_id").val(),
                    cycle_id: $("#cycle_id").val(),
                }
                log(data);
                return data;
            case "edit":
                let dataq = {
                    idClassroom: $("#classID").text(),
                    nameClassroom: $("#nameClassroom").val(),
                    acronymClassroom: $("#acronymClassroom").val(),
                    effectiveClassroom: $("#effectiveClassroom").val(),
                    seatbenchClassroom: $("#seatbenchClassroom").val(),
                    schoolfeesClassroom: $("#schoolfeesClassroom").val(),
                    membership_id: $("#membership_id").val(),
                    cycle_id: $("#cycle_id").val(),
                }
                log(dataq);
                return dataq;
        }

    }

    function pushClassroomDB(t) {
        t = getClassroomData();
        $.ajax({
            type: 'POST',
            url: '/addNewClassroom/' + t.cycle_id + '/' + t.membership_id,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(t),
            success: (s) => {
                if (s) {
                    Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Classroom enregistrée avec succès !",
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

    function deleteClassroom(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteClassroom/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Classroom supprimée avec succès!!",
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
        $("#classID").text(i.idClassroom);
        $("#nameClassroom").val(i.nameClassroom);
        $("#acronymClassroom").val(i.acronymClassroom);
        $("#effectiveClassroom").val(i.effectiveClassroom);
        $("#seatbenchClassroom").val(i.seatbenchClassroom);
        $("#schoolfeesClassroom").val(i.schoolfeesClassroom);
        $("#membership_id").val(i.membership.idMembership);
        $("#cycle_id").val(i.cycle.idCycle);
        goEdit();
    }

    function updateClass(b) {
        $.ajax({
            type: "GET",
            url: "/updateClassroom/" + b,
            success: (r) => {
                injector(r);
            },
            error: (e) => {
                log(e);
            }
        })
    }

    $("#classroom").on('click', (e) => {
        e.preventDefault();
        pushClassroomDB();
    });

    $(".classroom").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteClassroom(value);
    });

    $(".classroom_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updateClass(value);
    });
})