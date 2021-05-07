$(document).ready(function () {
    const log = console.log;

    function getParentsData() {
        let data = {
            firstnameFather: $("#firstnameFather").val(),
            lastnameFather: $("#lastnameFather").val(),
            professionFather: $("#professionFather").val(),
            addressFather: $("#addressFather").val(),
            emailFather: $("#emailFather").val(),
            phoneFather: $("#phoneFather").val(),
            photoFather: $("#photoFather").val(),

            firstnameMother: $("#firstnameMother").val(),
            lastnameMother: $("#lastnameMother").val(),
            professionMother: $("#professionMother").val(),
            addressMother: $("#addressMother").val(),
            emailMother: $("#emailMother").val(),
            phoneMother: $("#phoneMother").val(),
            photoMother: $("#photoMother").val(),
        };
        log(data);
        return data;
    }

    function getSubjectData() {
        let data = {
            nameSubject: $("#nameSubject").val(),
            notesurSubject: $("#notesurSubject").val(),
            codecourseSubject: $("#codecourseSubject").val(),
            coefficientSubject: $("#coefficientSubject").val(),
            teacher_id: $("#teacher_id").val(),
           classroom_id: $("#classroom_id").val(),
           
        };
        log(data);
        return data;
    }


    function putInDB(t) {
        t = getParentsData();
        $.ajax({
            type: 'POST',
            url: '/addNewParents',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(t),
            success: (s) => {
                if (s) {
                    Swal.fire({
                        position: "center",
                        //toast: true,
                        icon: "success",
                        title: "Parents enregistrée avec succès !",
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


    sendDataInDB = (m)=> {
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

    function deleteParents(id) {
        $.ajax({
            type: 'GET',
            url: '/deleteParents/' + id,
            success: (r) => {
                if (r) {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "Parents supprimé avec succès!!",
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

    deleteSubjectData = (id) =>{
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


    $("#parents").on('click', (e) => {
        e.preventDefault();
        putInDB();
    });



    $("#subject").on('click', (e) => {
        e.preventDefault();
        sendDataInDB();
    });

    $(".parents").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteParents(value);
    })



    $(".subject").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteSubjectData(value);
    })
})