$(document).ready(function () {
    let log = console.log;

    let state = {
        value: "new"
    }

    function getCycleData() {
        switch (state.value) {
            case "new":
                let data = {
                    nameCycle: $("#nameCycle").val(),
                }
                log(data);
                return data;

            case "edit":
                let dataq = {
                    idCycle: $("#cycleID").text(),
                    nameCycle: $("#nameCycle").val()
                }
                log(dataq);
                return dataq;
            default:
                break;
        }
    }

    function pushDataBase(y) {
        y = getCycleData();
        $.ajax({
            type: 'POST',
            url: '/addNewCycle',
            contentType: 'application/json',
            dataType: 'json',
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

    function goEdit() {
        state.value = "edit"
    }

    function boostrapingData(b) {
        $("#cycleID").text(b.idCycle);
        $("#nameCycle").val(b.nameCycle);
        goEdit();
    }

    function updateCycle(u) {
        $.ajax({
            type: "GET",
            url: "/updateCycle/" + u,
            success: (r) => {
                boostrapingData(r);
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

    $("#cycle").on('click', (e) => {
        e.preventDefault();
        pushDataBase();
    });

    $(".cycle").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteCycle(value);
    });

    $(".cycle_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updateCycle(value);
    });



})