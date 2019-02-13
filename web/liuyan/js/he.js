
function addLoadEvent(func)
 {
       var oldonload = window.onload;
        if(typeof window.onload != 'function')
            {
                 window.onload = func;
            }
       else
       {
                window.onload = function()
                 {
                        oldonload();
                        func();
                     }
             }
     }
function getMessage(){
      var btn = document.getElementById("btn1");
      var message = document.getElementById("message");
       var name = document.getElementById("name");
      var nameValue = "";
        var messageValue = "";

        name.onfocus = function(){
                 name.value="";
             }
        message.onfocus = function(){
                message.value="";
           }

        btn.onclick = function(){
                messageValue =  message.value || "草泥马" ;
                 nameValue = name.value || "hehe";
                var msgList = document.getElementById("messageList");
              var msgDiv = document.createElement("div");
                 var msgTxt = document.createTextNode(nameValue+"说："+messageValue);
               msgDiv.appendChild(msgTxt);
                msgList.appendChild(msgDiv);
            }
     }
 addLoadEvent(getMessage);
