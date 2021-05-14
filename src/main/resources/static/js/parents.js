$(document).ready(function () {
    const log = console.log;

    let state = {
        value: "new"
    }

    function getParentsData() {
        switch (state.value) {
            case "new":
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
            case "edit":
                let dataq = {
                    idParents: $("#parentsID").text(),
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
                log(dataq);
                return dataq;
        }

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

    function goEdit() {
        state.value = "edit"
    }

    function injector(i) {
        $("#parentsID").text(i.idParents);

        $("#firstnameFather").val(i.firstnameFather);
        $("#lastnameFather").val(i.lastnameFather);
        $("#professionFather").val(i.professionFather);
        $("#addressFather").val(i.addressFather);
        $("#emailFather").val(i.emailFather);
        $("#phoneFather").val(i.phoneFather);
        $("#photoFather").val(i.photoFather);

        $("#firstnameMother").val(i.firstnameMother);
        $("#lastnameMother").val(i.lastnameMother);
        $("#professionMother").val(i.professionMother);
        $("#addressMother").val(i.addressMother);
        $("#emailMother").val(i.emailMother);
        $("#phoneMother").val(i.phoneMother);
        $("#photoMother").val(i.photoMother);
        goEdit();
    }

    function updateParent(u) {
        $.ajax({
            type: "GET",
            url: "/updateParents/" + u,
            success: (r) => {
                injector(r);
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

    $(".parents").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        deleteParents(value);
    });

    $(".parents_edit").on('click', (e) => {
        e.preventDefault();
        let value = e.currentTarget.title;
        //log(value);
        updateParent(value);
    })
})