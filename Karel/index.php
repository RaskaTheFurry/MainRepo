<?php session_start() ?>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Minesweeper is life</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <?php
        define("MAX_X", 10);
        define("MAX_Y", 10);
        //if sessions are not set
        if (!isset($_SESSION["X"]) || !isset($_SESSION["Y"]) || !isset($_SESSION["S"])) {
            $_SESSION["X"] = 0;
            $_SESSION["Y"] = 0;
            $_SESSION["S"] = "j";
            $_SESSION["polozeno"] = [[]];
        }
        // textarea post get + commands
        if (!empty($_POST["commands"])) {
            $commands = filter_input(INPUT_POST, "commands");
            $commands = strtolower($commands);
            $commands = explode(PHP_EOL, $commands);
            

            foreach ($commands as $value) {
                $pocett = 0;

                $command = explode(" ", $value);
                //echo sizeof($command);

                foreach ($command as $comm) {
                    
//                    echo $comm . "-";
                    if(sizeof($command)>1){
                        if(!empty($command[$pocett+1])){
                    if (is_numeric($command[$pocett+1])) {
                        $times = (int) $command[$pocett+1];
                    }else{
                        $times = 1;
                    }
                        }
                    } else {
                        $times = 1;
                    }
                    

                    switch ($comm) {
                        case "krok":
                            for ($i = 0; $i < $times; $i++) {
                                if ($_SESSION["S"] == "j") {
                                    $_SESSION["Y"] ++;
                                    
                                }
                                if ($_SESSION["S"] == "v") {
                                    $_SESSION["X"] ++;
                                    
                                }
                                if ($_SESSION["S"] == "s") {
                                    $_SESSION["Y"] --;
                                    
                                }
                                if ($_SESSION["S"] == "z") {
                                    $_SESSION["X"] --;
                                    
                                }
                                if($_SESSION["X"]>MAX_X-1){
                                    $_SESSION["X"] = MAX_X-1;
                                }
                                if($_SESSION["Y"]>MAX_Y-1){
                                    $_SESSION["Y"] = MAX_Y-1;
                                }
                                if($_SESSION["X"]<0){
                                    $_SESSION["X"] = 0;
                                }
                                if($_SESSION["Y"]<0){
                                    $_SESSION["Y"] = 0;
                            }
                            }
                            break;
                        case "vlevobok":
                            for ($i = 0; $i < $times; $i++) {
                                $array = array("j" => "v", "v" => "s", "s" => "z", "z" => "j");
                                $_SESSION["S"] = $array[$_SESSION["S"]];
                            }
                            break;

                        case "reset":

                            $_SESSION["S"] = "j";
                            $_SESSION["X"] = 0;
                            $_SESSION["Y"] = 0;
                            $_SESSION["polozeno"] = array_fill(0, $_SESSION["X"] * $_SESSION["Y"], NULL);

                            break;
                        case "poloz":
                            if(sizeof($command)>1){
                                if($command[$pocett+1] != 'krok' && $command[$pocett+1] != 'poloz' && $command[$pocett+1] != 'vlevobok' && $command[$pocett+1] != 'reset'){
                                $_SESSION["polozeno"][$_SESSION["X"]][$_SESSION["Y"]] = $command[$pocett+1];
                                }
                                else{
                                    $_SESSION["polozeno"][$_SESSION["X"]][$_SESSION["Y"]] = 'X';
                                }
                                
                            }
                            else{
                            $_SESSION["polozeno"][$_SESSION["X"]][$_SESSION["Y"]] = 'X';
                            }
                            break;
                    }
                    $pocett++;
                }
            }
        }
        
        echo "<div>";
        if(isset($commands)){

        for($x=0 ;$x < sizeof($commands) ;$x++ ){
            echo $commands[$x]."<br>";
        }}
        echo "</div>";
        //table
        echo "<table>";
        for ($y = 0; $y < MAX_Y; $y++) {
            echo "<tr>";
            for ($x = 0; $x < MAX_X; $x++) {
                echo "<th>";
                if ($_SESSION["X"] == $x && $_SESSION["Y"] == $y) {
                    echo $_SESSION["S"];
                }
                if (isset($_SESSION["polozeno"][$x][$y])) {
                    if (!is_null($_SESSION["polozeno"][$x][$y])) {
                        echo $_SESSION["polozeno"][$x][$y];
                    }
                }
                echo "</th>";
            }
            echo "</tr>";
        }
        echo "</table>";
        
        
//         nahrávání souboru : $fd = fopen(cesta, format); fclose();
//        $fd = @file($_POST["cesta"]);
//        echo $fd;
//        $_POST["commands"]=$fd;
        
        $_POST["commands"] = "";
        ?>

        <form method="post" action="index.php">
            <textarea id="commands" name="commands"></textarea>
            <input type="submit" name="submit" value="Send" id="submit"/>
        </form>
<!--        <form method="post" action="index.php">
            <textarea id="cesta" name="cesta"></textarea>
            <input type="submit" name="submit" value="Send" id="submit"/>
        </form>-->
        <!--        <div>Proveď</div>-->
    </body>
</html>

