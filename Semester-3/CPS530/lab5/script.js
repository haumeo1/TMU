function validateAndDisplay() {
    const name = document.getElementById('name').value;
    const address = document.getElementById('email').value;
    const phone = document.getElementById('message').value;

   
    finalDisplay.textContent = '';

    const nameRegex = /^[A-Za-z\s]+$/;
    const phoneRegex = /^\d{3}\d{3}\d{4}$/;
    if (nameRegex.test(name) && phoneRegex.test(phone)) {
        const transformedPhone = phone.replace(/(\d{3})(\d{3})(\d{4})/, '$1-$2-$3');
        document.getElementById('name').value = name;
        document.getElementById('email').value = address;
        document.getElementById('message').value = transformedPhone;}

    // Validate name and phone
    if (!nameRegex.test(name)) {
        window.alert('Name can only contain letters.');
        return;
    }
    if (!phoneRegex.test(phone)) {
        window.alert('Phone number must be in the format 416-555-5555.');
        return;
    }
    
}

// Problem 2: Real-Time Character Count
document.getElementById('textArea').addEventListener('input', function() {
    const text = this.value;
    const charCount = text.length;
    const letterCount = text.replace(/[^A-Za-z]/g, '').length;

    document.getElementById('countDisplay').textContent = `Character Count: ${charCount}`;
    document.getElementById('letterCountDisplay').textContent = `Letter Count: ${letterCount}`;
});

// Problem 3: Full-Screen Image with jQuery
$('#img1').on('click', function() {
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