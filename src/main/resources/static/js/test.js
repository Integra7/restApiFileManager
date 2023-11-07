document.addEventListener('DOMContentLoaded', function() {
    let eventDivs = document.getElementsByClassName('image-info');
    for (let div of eventDivs) {
        div.addEventListener('mouseover', function () {

            let spanWithImagePath = div.querySelector('#spanWithImagePath');
            let imgPath = spanWithImagePath.innerHTML;
            let imageDiv = div.querySelector('#imageDiv');
            let popupImage = div.querySelector('#popupImage');

            popupImage.setAttribute("src", imgPath);
            imageDiv.style.display = 'block';
        });

        div.addEventListener('mouseout', function ()
        {
            let imageDiv = div.querySelector('#imageDiv');
            imageDiv.style.display = 'none';
        });
    }
});
