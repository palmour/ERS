document.getElementById("login").addEventListener("click", function(e){
    alert("event fired");
    let tabcontent = document.getElementsByName("tabcontent");
    let i;
    for(i=0; i<tabcontent.length; i++){
        tabcontent[i].style.display = "none";
    }

    for(i=0; i<tablinks.length; i++){
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    e.currentTarget.style.display = "block";
    e.currentTarget.className += " active";

});