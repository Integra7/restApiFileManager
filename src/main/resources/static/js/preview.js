document.addEventListener('DOMContentLoaded', function() {
    let eventDivs = document.getElementsByClassName('image-info');
    for (let div of eventDivs) {
        div.addEventListener('mouseover', function () {

            let spanWithImagePath = div.querySelector('#spanWithImagePath');
            let imgPath = spanWithImagePath.innerHTML;
            let imageDiv = div.querySelector('#imageDiv');
            let popupImage = div.querySelector('#popupImage');

            //нужно чтобы элемент  был отрисован, с динамическими не получается(
            let size = div.querySelector('#sizetext');
            popupImage.setAttribute("src", imgPath);

            let divRect = size.getBoundingClientRect();
            let screenHeight = window.innerHeight;

            let imageTopPosition = divRect.top;

            //top border check
            if (imageTopPosition < window.scrollY) {
                imageDiv.style.top = window.scrollY + 'px';
            }

            // bottom border check
            //300 - maxHeight (CSS)
            if (imageTopPosition + 300 > screenHeight) {
                imageTopPosition = screenHeight - 300;
                imageDiv.style.top = imageTopPosition + 'px';
            }


            imageDiv.style.display = 'block';
        });

        div.addEventListener('mouseout', function ()
        {
            let imageDiv = div.querySelector('#imageDiv');
            imageDiv.style.display = 'none';
        });
    }
});
