$(document).ready(() => {

    const avatarFile = $("#avatarFile");
    avatarFile.change(function (e) {

        const imgURL = URL.createObjectURL(e.target.files[0]);
        $("#avartarPriview").attr("src", imgURL).show();
    });
});