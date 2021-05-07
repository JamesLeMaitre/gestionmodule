$(document).ready(function () {
    const log = console.log;

    function getData() {
        let data = {
            academicyear: $("#academicyear").val(),
        }
        log(data);
        return data;
    }

    function getCycleData(){
        let data = {
            nameCycle: $("#cyclename").val(),
        }
        return data;
    }

    function getRegistrationData(){
        let data = {
            academical_id: $("#academical_id").val(),
        }
        log(data);
        return data;
    }

    function getTeachingDegreData(){
        let data = {
            orderDegre: $("#orderDegre").val(),
        }
        log(data);
        return data;
    }

    function getSchoolData(){
        let data = {
            schoolname:$("#schoolname").val(),
            levelSchool:$("#levelSchool").val(),
            logoSchool:$("#logoSchool").val(),
            mottoSchool:$("#mottoSchool").val(),
            creationdateSchool:$("#creationdateSchool").val(),
            founderSchool:$("#founderSchool").val(),
            generalmanagerSchool:$("#generalmanagerSchool").val(),
            emailSchool:$("#emailSchool").val(),
            phoneSchool:$("#phoneSchool").val(),
            academical_id: $("#academical_id").val(),
        }
        log(data);
        return data;
    }

    function pushDataBase(y){
        y = getCycleData();
        $.ajax({
            type:'POST',
            url:'/addNewCycle',
            contentType:'application/json',
            dataType:'json',
            data: JSON.stringify(y),
            success: (s) => {
                if (s) {
                   Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Cycle enregistrée avec succès !",
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
        })
    }
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

        })
    }

    function push_in_db(x) {
        x = getRegistrationData();
        log(x);
       $.ajax({
            type: 'POST',
            url: '/addNewRegistration/' + x.academical_id,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(x),
            success: (s) => {
                if (s) {
                   Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Registration enregistrée avec succès !",
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

    function putItInDB(x) {
        x = getTeachingDegreData();
        log(x);
       $.ajax({
            type: 'POST',
            url: '/addNewTeachingDegre',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(x),
            success: (s) => {
                if (s) {
                   Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Dégre d'enseignement enregistrée avec succès !",
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

    function deleteCycle(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteCycle/' + id,
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

    function deleteRegistration(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteRegistration/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Registration supprimée avec succès!!",
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

    function deleteTeachingDegre(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteTeachingDegre/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Dégré d'enseignement supprimée avec succès!!",
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

    $("#school").on('click', (e) => {
        e.preventDefault();
        sendInDB();
    });


    $("#cycle").on('click', (e) => {
        e.preventDefault();
        pushDataBase();
    });

    $("#registration").on('click', (e)=>{
        e.preventDefault();
        //getRegistrationData();
        push_in_db();
    })

    $("#degre").on('click', (e)=>{
        e.preventDefault();
        //getRegistrationData();
        putItInDB();
    })

    $(".academical").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteAcademicYear(value);
    });

    $(".cycle").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteCycle(value);
    });

    $(".registration").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteRegistration(value);
    })

    $(".school").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteSchool(value);
    })

    $(".degre").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteTeachingDegre(value);
    })
})