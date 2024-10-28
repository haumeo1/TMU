formatPhoneNumber();
function validateAndDisplay() {
    const name = document.getElementById('name').value;
    const address = document.getElementById('email').value;
    const phone = document.getElementById('message').value;
    const doc = document.getElementsByClassName('form-control');
    const nameRegex = /^[A-Za-z\s]+$/;
    const phoneRegex = /^\d{3}-\d{3}-\d{4}$/;
    if (nameRegex.test(name) && phoneRegex.test(phone)) {
        document.getElementById('name').value = name;
        document.getElementById('email').value = address;
        document.getElementById('message').value = phone;
        for (let i = 0; i < doc.length; i++) {
            doc[i].classList.add('valid');
        }erew
    }
    if (!nameRegex.test(name)) {
        window.alert('Name can only contain letters.');
        return;
    }
    if (!phoneRegex.test(phone)) {
        window.alert('Phone number must be in the format 555-555-5555.\n10 digits only.');
        return;
    }
    if (address === '') {
        window.alert('Address cannot be empty');
        return;
    }
}
function formatPhoneNumber() {
    const phoneInput = document.getElementById('message');
    phoneInput.addEventListener('input', function() {
        let phone = phoneInput.value.replace(/\D/g, '');
        if (phone.length > 3 && phone.length <= 6) {
            phone = phone.replace(/(\d{3})(\d+)/, '$1-$2');
        } else if (phone.length > 6) {
            phone = phone.replace(/(\d{3})(\d{3})(\d+)/, '$1-$2-$3');
        }
        phoneInput.value = phone;
    });
}

document.getElementById('email').addEventListener('input', function() {
    const text = this.value;
    const charCount = text.length;
    const letterCount = text.replace(/[^A-Za-z]/g, '').length;
    document.getElementsByClassName('countDisplay')[1].innerHTML = `Total:${charCount}`;
    document.getElementsByClassName('countDigit')[1].innerHTML = `Letter:${letterCount}`;
});
document.getElementById('name').addEventListener('input', function() {
    const text = this.value;
    const charCount = text.length;
    const letterCount = text.replace(/[^A-Za-z]/g, '').length;
    document.getElementsByClassName('countDisplay')[0].innerHTML = `Total:${charCount}`;
    document.getElementsByClassName('countDigit')[0].innerHTML = `Letter:${letterCount}`;
});
document.getElementById('message').addEventListener('input', function() {
    const text = this.value;
    const charCount = text.length;
    document.getElementsByClassName('countDisplay')[2].innerHTML = `Total:${charCount}`;
});


function imageChange() {
    $('#image').on('click', function() {
        const imageUrl = $(this).attr('src');
        const fullscreenDiv = $('<div class="fullscreen"></div>');
        const fullScreenImage = $('<img>').attr('src', imageUrl);
        // icon for close button
        const closeButton = $('<i class="material-icons fullscreen-icon"><span class="material-symbols-outlined">close</span></i>');

        fullscreenDiv.append(fullScreenImage).append(closeButton);
        $('body').append(fullscreenDiv);
        const originalWidth = fullScreenImage.width();
        const originalHeight = fullScreenImage.height();
        fullScreenImage.css({
            width: 0,
            height: 0
        });
        fullScreenImage.animate({
            width: originalWidth * 1.5,
            height: originalHeight * 1.5
        }, 5000);
        closeButton.on('click', function() {
            fullscreenDiv.remove();
        });
    });
}