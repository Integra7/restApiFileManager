function handleMouseOver() {
    let spanWithImagePath = document.getElementById('spanWithImagePath')
    let imgPath = spanWithImagePath.innerHTML;
    let imageDiv = document.getElementById('imageDiv');
    let popupImage = document.getElementById('popupImage');


    popupImage.setAttribute("src", imgPath);

    imageDiv.style.display = 'block';

}
function handleMouseOut() {
    let imageDiv = document.getElementById('imageDiv');
    imageDiv.style.display = 'none';
}
document.addEventListener('DOMContentLoaded', function() {
    let eventDiv = document.getElementById('eventDiv');
    eventDiv.addEventListener('mouseover', handleMouseOver);
    eventDiv.addEventListener('mouseout', handleMouseOut);
});
