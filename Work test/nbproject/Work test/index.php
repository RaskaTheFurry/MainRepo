<!DOCTYPE html>
<html>
    <head lang="cs">
        <meta charset="UTF-8">
        <title>Můj Den</title>
        <link rel="stylesheet" href="MainCss.css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <script>
            let ukolyIds = [];
            let ukoly = [];
            let finishedUkoly = [];
            let finishedUkolyIds = [];
            
            let i = 0;
            
            function generateDiv(){
                //console.log("div Generated");
                
                let div = document.createElement('div');
                div.id = i;
                div.innerHTML = "<button type='button' onclick='moveToFinished("+i+")' style='position:relative;left:1em;margin-right: 1em; background-color: white; border: none;'><i class='far fa-circle'>Move</i></button><input value='ukol' id='ukol"+i+"' style='border: none;'></input><button type='button' onclick='deleteDiv("+i+",1)' style='position:absolute;right:1em; background-color: white; border: none;'><i class='far fa-trash-alt'>Delete</i></button>";
                ukolyIds.push(i);
                i = i + 1;
                div.setAttribute("style","background-color: rgba(255,255,255,1);padding: 0.5em;padding-left: 1em;position: relative;color:black;margin: 1em; border-radius: 10px;");
                document.getElementById("outerUkolDiv").appendChild(div);
            }
            
            function moveBack(numId){
//                console.log(ukoly);
//                console.log(ukolyIds);
//                console.log(finishedUkoly);
//                console.log(finishedUkolyIds);
                var mainDiv = document.getElementById(numId);
                var idIndex = finishedUkolyIds.indexOf(numId);
                var value = document.getElementById("ukol"+finishedUkolyIds[idIndex]).value;
                ukoly.push(value);
                ukolyIds.push(finishedUkolyIds[idIndex]);
                
                deleteDiv(numId,2);
                
                let div = document.createElement('div');
                div.id = ukolyIds[ukolyIds.length-1];
                div.innerHTML = "<button type='button' onclick='moveToFinished("+ukolyIds[ukolyIds.length-1]+")' id='ukolButton' style='position:relative;left:1em; margin-right: 1em; background-color: white; border: none;'><i class='far fa-circle'>Move</i></button><input value='"+ukoly[ukoly.length-1]+"' id='ukol"+div.id+"' style='border: none;'></input><button type='button' onclick='deleteDiv("+ukolyIds[ukolyIds.length-1]+",1)' style='position:absolute;right:1em; background-color: white; border: none;'><i class='far fa-trash-alt'>Delete</i></button>";
                div.setAttribute("style","background-color: rgba(255,255,255,1);padding: 0.5em;padding-left: 1em;position: relative;color:black;margin: 1em; border-radius: 10px;");
                document.getElementById("outerUkolDiv").appendChild(div);
            }
            
            function moveToFinished(numId){
                //console.log(ukoly);
                //console.log(ukolyIds);
                //console.log(finishedUkoly);
                //console.log(finishedUkolyIds);
                var mainDiv = document.getElementById(numId);
                var idIndex = ukolyIds.indexOf(numId);
                var value = document.getElementById("ukol"+ukolyIds[idIndex]).value;
                finishedUkoly.push(value);
                finishedUkolyIds.push(ukolyIds[idIndex]);
                deleteDiv(numId,1);
                
                let div = document.createElement('div');
                div.id = finishedUkolyIds[finishedUkolyIds.length-1];
                div.innerHTML = "<button type='button' onclick='moveBack("+finishedUkolyIds[finishedUkolyIds.length-1]+")' id='ukolButton' style='position:relative;left:1em; margin-right: 1em; background-color: white; border: none;'><i class='fas fa-check-circle'>Move</i></button><input value='"+finishedUkoly[finishedUkoly.length-1]+"' id='ukol"+div.id+"' style='border: none;'></input><button type='button' onclick='deleteDiv("+finishedUkolyIds[finishedUkolyIds.length-1]+",2)' style='position:absolute;right:1em; background-color: white; border: none;'><i class='far fa-trash-alt'>Delete</i></button>";
                div.setAttribute("style","background-color: rgba(255,255,255,1);padding: 0.5em;padding-left: 1em;position: relative;color:black;margin: 1em; border-radius: 10px;");
                document.getElementById("outerUkolDokoncenDiv").appendChild(div);
            }
            
            function deleteDiv(numId,i){
                var mainDiv = document.getElementById(numId);
                //console.log(numId);
                var idIndex = ukolyIds.indexOf(numId);
                //console.log("index ukoly: "+idIndex);
                if(i == 1){
                    if( idIndex > -1 ){
                        //console.log("Ukoly deleted");
                        ukoly.splice(idIndex,1);
                        ukolyIds.splice(idIndex,1);
                    }
                }
                if(i == 2){
                    //console.log("index finished ukoly: "+idIndex);
                    //console.log("Finished Ukoly Deleted");
                    var idIndex = finishedUkolyIds.indexOf(numId);
                    if( idIndex > -1 ){
                        finishedUkoly.splice(idIndex,1);
                        finishedUkolyIds.splice(idIndex,1);
                    }
                }
                //console.log(idIndex);
                //console.log("Ukoly: " + ukolyIds);
                mainDiv.remove();
            }
            
            function addUkol(){
                ukoly.push("ukol");
                //console.log("added Ukol");
                generateDiv()
            }
        </script>
        
    </head>
    <body>
        <div class="root">
            <div class="sidebar">
                <img src="./img/logo-placeholder.png" alt="Placeholder logo" style="height:auto; width: 100%">
                <ul>
                    <li class="current"><a href="./index.php"><div>Hlavní stránka</div></a></li>
                    <li><a href="./index.php"><div>Důležité úkoly</div></a></li>
                    <li><a href="./kontakty.php"><div>Kontakt</div></a></li>
                </ul>
            </div>
            <div class="main">
            <?php
            echo "<h1>Header</h1>";
            echo "<p>".date('l')." ".date('j').".".date('F')."</p>";
//            if(isset($_SESSION["dokoncene"])){
//                echo "<div class='dokonceno'>dokončeno".count($_SESSION["dokoncene"])."</div>";
//                foreach ($_SESSION["dokoncene"] as $dokoncene){
//                    echo "<div class='ukol'><p>$dokoncene</p></div>";
//                }
//            }
            
            ?>
                <div id="outerUkolDiv">
                <script>
                </script>
                </div>
                <div id="outerUkolDokoncenDiv">
                    <div class='dokonceno'>dokončeno</div>
                </div>
                <button type="button" onclick="addUkol()" class="pridatUkol"><i class='fas fa-plus'></i> Přidat úkol</button>
            <?php    
            //echo "<a href='./index.php?add=true' class='pridatUkolurl'><div class='pridatUkol'><i class='fas fa-plus'></i> Přidat úkol</div></a>";
            ?>
            </div>
        </div>

    </body>
</html>