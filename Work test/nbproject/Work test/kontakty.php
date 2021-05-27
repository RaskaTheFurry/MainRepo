<!DOCTYPE html>
<html>
    <head lang="cs">
        <meta charset="UTF-8">
        <title>Můj Den</title>
        <link rel="stylesheet" href="MainCss.css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <script>
            
        </script>
        
    </head>
    <body>
        <div class="root">
            <div class="sidebar">
                <img src="./img/logo-placeholder.png" alt="Placeholder logo" style="height:auto; width: 100%">
                <ul>
                    <li><a href="./index.php"><div>Hlavní stránka</div></a></li>
                    <li><a href="./index.php"><div>Důležité úkoly</div></a></li>
                    <li class="current"><a href="./konakty.php"><div>Kontakt</div></a></li>
                </ul>
            </div>
            <div class="main">
            <?php
            echo "<div style='display:flex'> <div class='Kontaktyleft'><h2>Obchodní oddělení</h2>"
            . "<p><i class='fas fa-phone-alt'></i> +420 604 229 222</p> <p><i class='far fa-envelope'></i> sales@lotraco.cz</p> <p><i class='fas fa-globe'></i> www.timeslotcontrol.com</p>"
            . "<h2>Technická podpora</h2>"
            . "<p><i class='fas fa-phone-alt'></i> +420 739 602 823</p> <p><i class='far fa-envelope'></i> support@timeslotcontrol.com</p>"
            . "<p>LOTRACO s.r.o.
Prokopa Holého 701/18
405 02, Děčín IV-Podmokly
Czech Republic
IČO 02897253
DIČ CZ02897253
POST ID ijhgzew</p>"
            . "</div> <div class='Kontaktyright'>"
                    ?>
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2523.047638059819!2d14.195013315515254!3d50.77469047952139!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47099fcabe763ded%3A0xebd210864ed72eef!2zUC4gSG9sw6lobyA3MDEvMTgsIFBvZG1va2x5LCA0MDUgMDIgRMSbxI3DrW4!5e0!3m2!1scs!2scz!4v1622150727060!5m2!1scs!2scz" width="400" height="250" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
            <?php
            echo "</div> </div>";
            
            ?>
            </div>
        </div>

    </body>
</html>