<%-- 
    Document   : testAddItem
    Created on : Jun 13, 2022, 5:06:42 PM
    Author     : pv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <input type = "text" name = "text" id = "txt"> <br>
            <button type="submit" class = "btn-list">X</button>
        </form>
        <form action = "a" method="get">
            <div class ="container">
                <ul>
                    <li><input type="text" hidden="hidden"  name = "b" value = "tuanthanhnghean123@gmail.com">tuanthanhnghean123@gmail.com <span>x</span></li>
                    <li><input type="text" hidden="hidden" name = "b" value = "tuanthanhnghean1234@gmail.com">tuanthanhnghean1234@gmail.com <span>x</span></li>
                </ul>
            </div>
            <input type = "submit" value ="submit" />
        </form>     
        
        <script>
            const inputText = document.querySelector('#txt');
            const myButton = document.querySelector('.btn-list');
            const list = document.querySelector('.container ul');
            myButton.addEventListener('click', (e)=>{
              if(inputText.value != ""){
                e.preventDefault();
                const myLi = document.createElement('li');
                myLi.innerHTML = inputText.value;
                list.appendChild(myLi);
                const myInput = document.createElement('input');
                myInput.setAttribute('type','text');
                myInput.setAttribute('name','b');
                myInput.setAttribute('value','test');
                myInput.setAttribute('hidden','hidden');
                myLi.appendChild(myInput);
                const mySpan = document.createElement('span');
                mySpan.innerHTML = 'x';
                myLi.appendChild(mySpan);  
              }
              var close = document.querySelectorAll('span');
                    var num = close.length;
                    for (let i in close) {
                        close[i].addEventListener('click', () => {
                            close[i].parentElement.style.opacity = 0;
                            setTimeout(() => {
                                close[i].parentElement.style.display = "none";
                            }, 500);
                        });
                        inputText.value = "";
                    }

              });
              var close = document.querySelectorAll('span');
                    var num = close.length;
                    for (let i in close) {
                        close[i].addEventListener('click', () => {
                            close[i].parentElement.style.opacity = 0;
                            setTimeout(() => {
                                close[i].parentElement.style.display = "none";
                                close[i].parentElement.remove();
                            }, 500);
                        });
                        inputText.value = "";
                    }
        </script>
    </body>
</html>
