#!/usr/bin/perl -wT
use strict;
use warnings;
use CGI ':standard';
use CGI::Carp qw(warningsToBrowser fatalsToBrowser);
print "Content-type: text/html\n\n";
print <<'HTML';
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My First Perl Program</title>
    <!-- Link to Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }
        h1 {
            font-family: 'Pacifico', cursive;
            font-size: 3em;
            color: #3498db; /* A nice blue color */
        }
    </style>
</head>
<body>
    <h1>This is my first Perl program</h1>
</body>
</html>
HTML
