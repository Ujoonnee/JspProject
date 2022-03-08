<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>memberLoginForm.jsp</title>
    <style>
      * {
        margin: 0;
        padding: 0;
        font-family: sans-serif;
      }

      .wrap {
        height: 100%;
        width: 100%;
        background-image: url(images/loginBackground.jpg);
        background-position: center;
        background-size: cover;
        position: absolute;
      }

      .form-wrap {
        width: 380px;
        height: 480px;
        position: relative;
        margin: 6% auto;
        background: #fff;
        padding: 5px;
        overflow: hidden;
        border-radius: 30px;
        opacity: 95%;
      }

      #btn {
        top: 0;
        left: 0;
        position: absolute;
        width: 110px;
        height: 100%;
        background: linear-gradient(to right, #ff105f, #ffad06);
        border-radius: 30px;
        transition: 0.5s;
      }

      .input-group {
        top: 180px;
        position: absolute;
        width: 280px;
        transition: 0.5s;
      }

      .input-field {
        width: 100%;
        padding: 10px 0;
        margin: 5px 0;
        border: none;
        border-bottom: 1px solid #999;
        outline: none;
        background: transparent;
      }

      .button {
        width: 85%;
        padding: 10px 30px;
        cursor: pointer;
        display: block;
        margin: 20px 0;
        background: linear-gradient(to right, #ff105f, #ffad06);
        border: 0;
        outline: none;
        border-radius: 30px;
        font-size: 17px;
        font-weight: 700;
      }


      span {
        color: #777;
        font-size: 12px;
        bottom: 68px;
        position: absolute;
      }

	  
      #login {
        left: 50px;
      }

    </style>
  </head>

  <body>
  
    <div class="wrap">
      <div class="form-wrap">
        <div
          class="logo"
          style="display: flex; justify-content: center; margin-top: 50px"
        >
          <a href="main.do"><img src="img/core-img/logo.png" alt="" /></a>
        </div>

        <form id="login" action="userLogin.do" class="input-group" method="post">
          <input
            type="text"
            class="input-field"
            name="userId"
            placeholder="User name or Email"
            required
          />
          <input
            type="password"
            class="input-field"
            name="userPw"
            placeholder="Enter Password"
            style="margin-bottom: 30px;"
            required
          />
          <div id="btnBox" align="center">
	          <button class="button">Login</button>
	          <button class="button" onclick="location.href='userSignUpForm.do'">Sign Up</button>
          </div>
        </form>
      </div>
    </div>

    <script>
      function formCheck() {
        if (frm.userId.value == "") {
          alert("아이디를 입력하세요.");
          frm.userId.focus();
          return false;
        }
        if (frm.userPw.value == "") {
          alert("패스워드를 입력하세요.");
          frm.userPw.focus();
          return false;
        }

        frm.submit();
      }

      var x = document.getElementById("login");
      var y = document.getElementById("register");
      var z = document.getElementById("btn");

      function login() {
        x.style.left = "50px";
        y.style.left = "450px";
        z.style.left = "0";
      }

      function register() {
        x.style.left = "-400px";
        y.style.left = "50px";
        z.style.left = "110px";
      }
    </script>
  </body>
</html>
