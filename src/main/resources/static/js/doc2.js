$(document).ready(function() {
    const log = console.log;

    function getCurrentData() {
        let data = {
            nameMembership:$("#nameMembership").val(),
            teachdegre_id:$("#teachdegre_id").val(),
        };
        log(data);
        return data;
    }

    function getClassroomData(){
        let data = {
            nameClassroom:$("#nameClassroom").val(),
            acronymClassroom:$("#acronymClassroom").val(),
            effectiveClassroom:$("#effectiveClassroom").val(),
            seatbenchClassroom:$("#seatbenchClassroom").val(),
            schoolfeesClassroom:$("#schoolfeesClassroom").val(),
            membership_id:$("#membership_id").val(),
            cycle_id:$("#cycle_id").val(),
        }
        log(data);
        return data;
    }

    getTypeOfexaminationData =() =>{
        let data = {
            natureTypeexamination: $("#natureTypeexamination").val(),
            monthTypeexamination:$("#monthTypeexamination").val(),
        }
        log(data);
        return data;
    }

    function pushData(o){
        o = getCurrentData();
        $.ajax({
            type: 'POST',
            url: '/addNewSchoolMembership/' + o.teachdegre_id,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(o),
            success: (s) => {
                if (s) {
                   Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Membership enregistrée avec succès !",
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

    function pushDataTypeOfExamination(o){
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


    function pushClassroomDB(t){
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

    function deleteSchoolMembership(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteSchoolMembership/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Membership supprimée avec succès!!",
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

    $("#membership").on('click', (e) => {
        e.preventDefault();
        pushData();
    });

    $("#typeofexamination").on('click', (e) => {
        e.preventDefault();
        pushDataTypeOfExamination();
    });

    $("#classroom").on('click', (e) => {
        e.preventDefault();
        pushClassroomDB();
    });

    $(".membership").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteSchoolMembership(value);
    })

    $(".classroom").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteClassroom(value);
    })

    $(".typeofexamination").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteExamination(value);
    })
})