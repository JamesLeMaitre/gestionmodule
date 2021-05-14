$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new"
    }

    function getCurrentData() {
        switch (state.value) {
            case "new":
                let data = {
                    nameMembership: $("#nameMembership").val(),
                    teachdegre_id: $("#teachdegre_id").val(),
                };
                log(data);
                return data;
            case "edit":
                let dataq = {
                    idMembership: $("#mID").text(),
                    nameMembership: $("#nameMembership").val(),
                    teachdegre_id: $("#teachdegre_id").val(),
                };
                log(dataq);
                return dataq;
        }

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


    function pushData(o) {
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

    function goEdit() {
        state.value = "edit"
    }

    function injector(i) {
        $("#mID").text(i.idMembership);
        $("#nameMembership").val(i.nameMembership);
        $("#teachdegre_id").val(i.degre.idDegre);
        goEdit();
    }

    function updateMembership(u) {
        $.ajax({
            type: "GET",
            url: "/updateSchoolMembership/" + u,
            success: (r) => {
                injector(r);
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

    $(".membership").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteSchoolMembership(value);
    });

    $(".membership_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updateMembership(value);
    })
})