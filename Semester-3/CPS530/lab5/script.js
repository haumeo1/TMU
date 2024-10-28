function validateAndDisplay() {
    const name = document.getElementById('name').value;
    const address = document.getElementById('email').value;
    const phone = document.getElementById('message').value;
    // change the style of the input if it is valid
    const doc = document.getElementsByClassName('form-control')
    const nameRegex = /^[A-Za-z\s]+$/;
    const phoneRegex = /^\d{3}\d{3}\d{4}$/;
    if (nameRegex.test(name) && phoneRegex.test(phone)) {
        const transformedPhone = phone.replace(/(\d{3})(\d{3})(\d{4})/, '$1-$2-$3');
        document.getElementById('name').value = name;
        document.getElementById('email').value = address;
        document.getElementById('message').value = transformedPhone;
        // add a class to doc
        for (let i = 0; i < doc.length; i++) {
            doc[i].classList.add('valid');
        }}

    // Validate name and phone
    if (!nameRegex.test(name)) {
        window.alert('Name can only contain letters.');
        return;
    }
    if (!phoneRegex.test(phone)) {
        window.alert('Phone number must be in the format 416-555-5555.\n10 digits only.');
        return;
    }
    
}

// Problem 2: Real-Time Character Count
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


// Problem 3: Full-Screen Image with jQuery
$('#image').on('click', function() {
    const imageUrl = $(this).attr('src');
    const fullscreenDiv = $('<div class="fullscreen"></div>');
    const fullScreenImage = $('<img>').attr('src', imageUrl);
    const closeButton = $('<i class="material-icons fullscreen-icon">close</i>');

    fullscreenDiv.append(fullScreenImage).append(closeButton);
    $('body').append(fullscreenDiv);

    // Animate image size
    fullScreenImage.css('transform', 'scale(1.5)');

    // Close fullscreen on button click
    closeButton.on('click', function() {
        fullscreenDiv.remove();
    });
});