function getImgPreview_profileUser(event) {
    var image = URL.createObjectURL(event.target.files[0]);
    var imagediv = document.getElementById("avatar");
    imagediv.setAttribute('src', image);
}
function getImgPreview_SubjectOverview(event) {
    var image = URL.createObjectURL(event.target.files[0]);
    var imagediv = document.getElementById("img_course");
    imagediv.setAttribute('src', image);
}

