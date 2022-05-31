function getImgPreview_profileUser(event) {
    var image = URL.createObjectURL(event.target.files[0]);
    var imagediv = document.getElementById("avatar");
    imagediv.setAttribute('src', image);
}

