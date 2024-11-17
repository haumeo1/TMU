#!/usr/bin/perl
use strict;
use warnings;
use CGI ':standard';
use CGI::Carp qw(warningsToBrowser fatalsToBrowser);

print "Content-type: text/html\n\n";





my $firstName  = param('firstName');
my $lastName   = param('lastName');
my $street     = param('street');
my $city       = param('city');
my $postalCode = param('postalCode');
my $province   = param('province');
my $phone      = param('phone');
my $email      = param('email');

my $safe_filename_characters = "a-zA-Z0-9_.-"; 
my $upload_dir = "/class-years/y2023/q1to/public_html/upload"; 
my $query = new CGI; 
my $filename = param("picture"); 
my ($path, $name, $extension);

if ($filename =~ m{^(.*/)?([^/]+?)(\.[^./]+)?$}) {
    $path      = $1 // '';  # Path before the file name
    $name      = $2 // '';  # File name without extension
    $extension = $3 // '';  # File extension (including the dot)
}
$filename = $name . $extension; 
$filename =~ tr/ /_/; 
$filename =~ s/[^$safe_filename_characters]//g; 

if ( $filename =~ /^([$safe_filename_characters]+)$/ ) { $filename = $1; }
my $upload_filehandle = $query->upload("picture"); 

open (UPLOADFILE, ">$upload_dir/$filename"); binmode UPLOADFILE; 
while ( <$upload_filehandle> ) { print UPLOADFILE; } 
close UPLOADFILE; 



my $phone_regex  = qr/^\d{10}$/;
my $postal_regex = qr/^[A-Za-z]\d[A-Za-z] \d[A-Za-z]\d$/;
my $email_regex  = qr/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

my ($phone_error, $postal_error, $email_error) = ("", "", "");
my ($phone_class, $postal_class, $email_class) = ("valid", "valid", "valid");


if ($phone !~ $phone_regex) {
    $phone_error = "Invalid phone number. Please enter a 10-digit phone number.";
    $phone_class = "invalid";
}


if ($postalCode !~ $postal_regex) {
    $postal_error = "Invalid postal code. Example: A1A 1A1 (7 characters).";
    $postal_class = "invalid";
}


if ($email !~ $email_regex) {
    $email_error = "Invalid email address. Please include @ and a domain (e.g., .com).";
    $email_class = "invalid";
}



# Display
print <<HTML;
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Rubik+Doodle+Shadow&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Honk&family=Rubik+Doodle+Shadow&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Protest+Guerrilla&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Rubik+Wet+Paint&display=swap" rel="stylesheet">
<link rel="icon" href="/image/lignt.png" type="image/png">
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght@100&icon_names=favorite,home,search,settings" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />
    <style>
        body{
    background-image: url(https://i.pinimg.com/originals/b1/0b/f4/b10bf456977f6b636dcda734f32b5f58.jpg);
    background-size: cover;
    background-repeat: repeat;
    background-position: center;
}
        .welcome { color: red; font-size: 50px; text-align: center; }
        .Address, .title { color: hwb(34 11% 23%); font-size: 40px; text-align: center; font-weight: bold; }
        .valid { color: black; }
        .invalid { color: red; font-weight: bold; }
        .error { font-size: 25px; color: red; text-align: center; }
        .address{ font-family: "Honk", system-ui;
  font-optical-sizing: auto;
  font-weight: 400;
  font-style: normal;
  font-variation-settings:
    "MORF" 15,
    "SHLN" 50;
    font-size: 25px;}
        .info{
            font-family: "Honk", system-ui;
  font-optical-sizing: auto;
  font-weight: 400;
  font-style: normal;
  font-variation-settings:
    "MORF" 15,
    "SHLN" 50;
    font-size: 40px;
    text-align: center;
        }
        .name{font-family: "Honk", system-ui;
  font-optical-sizing: auto;
  font-weight: 400;
  font-style: normal;
  font-variation-settings:
    "MORF" 15,
    "SHLN" 50;
    font-size: 50px;}
    </style>
</head>
<body>
    <h1 class="welcome">Welcome</h1>
    <p class="info name">$firstName $lastName</p>
    <br>
    <h2 class="title">Phone Number:</h2>
    <p class="$phone_class info">$phone</p>
    <p class="error">$phone_error</p>
    
    <h2 class="title">Email Address:</h2>
    <p class="$email_class info">$email</p>
    <p class="error">$email_error</p>
    
    <br>
    <div class="container text-center">
        <div class="row">
            <div class="col">
                <p class="Address">Street</p>
                <p class = "address">$street</p>
            </div>
            <div class="col">
                <p class="Address">City</p>
                <p class = "address">$city</p>
            </div>
            <div class="col">
                <p class="Address ">Postal Code</p>
                <p class="$postal_class address">$postalCode</p>
                <p class="error">$postal_error</p>
            </div>
            <div class="col">
                <p class="Address">Province</p>
                    <p class = "address">$province</p>
            </div>
        </div>
    </div>
    <br>
    <p><img src="https://cs.torontomu.ca/~q1to/upload//$filename" alt="Uploaded picture" style="max-width:90%; height:auto; border:9px double Olive;"></p> 
    <br>
    <a href="https://cs.torontomu.ca/~q1to/lab7/lab07b.html" class="btn btn-primary">Back</a>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
HTML
