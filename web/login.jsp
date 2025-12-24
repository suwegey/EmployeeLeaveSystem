<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Login</title>

    <!-- Poppins Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500&display=swap" rel="stylesheet">

    <style>
        * {
            box-sizing: border-box;
            font-family: "Segoe UI", Arial, sans-serif;
        }

        body {
            margin: 0;
            height: 100vh;
            background: linear-gradient(to bottom, #4a4a4a, #d9d3d1);
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-container {
            width: 420px;
            text-align: center;
            color: #fff;
        }

        /* ===== USER ICON ===== */
        .user-icon {
            width: 90px;
            height: 90px;
            border: 4px solid #e6e6e6;
            border-radius: 50%;
            margin: 0 auto 25px;
            position: relative;
        }

        .user-icon::before {
            content: "";
            width: 26px;
            height: 26px;
            border: 3px solid #e6e6e6;
            border-radius: 50%;
            position: absolute;
            top: 14px;
            left: 50%;
            transform: translateX(-50%);
        }

        .user-icon::after {
            content: "";
            width: 44px;
            height: 22px;
            border: 3px solid #e6e6e6;
            border-bottom: none;
            border-top-left-radius: 22px;
            border-top-right-radius: 22px;
            position: absolute;
            bottom: 12px;
            left: 50%;
            transform: translateX(-50%);
        }

        h1 {
            font-family: "Poppins", sans-serif;
            font-weight: 300;
            letter-spacing: 4px;
            margin-bottom: 40px;
        }

        .input-group {
            display: flex;
            align-items: center;
            margin-bottom: 25px;
            border-bottom: 2px solid #222;
            padding-bottom: 8px;
        }

        .input-group span {
            font-size: 18px;
            margin-right: 10px;
            color: #222;
        }

        .input-group input {
            width: 100%;
            background: transparent;
            border: none;
            outline: none;
            color: #222;
            font-size: 16px;
        }

        button {
            width: 140px;
            padding: 12px;
            border: none;
            border-radius: 25px;
            background-color: #555;
            color: white;
            font-weight: bold;
            cursor: pointer;
            letter-spacing: 1px;
        }

        button:hover {
            background-color: #333;
        }

        /* ===== ERROR MESSAGE ===== */
        .error {
            color: #ff5252;
            margin-bottom: 15px;
            font-size: 14px;
        }
    </style>
</head>
<body>

<form action="<%= request.getContextPath()%>/LoginServlet" method="post">
    <div class="login-container">
        <div class="user-icon"></div>
        <h1>User Login</h1>

        <%-- ERROR MESSAGE --%>
        <%
            String error = request.getParameter("error");
            if (error != null && error.equals("invalid")) {
        %>
            <div class="error">Invalid email or password</div>
        <%
            }
        %>

        <div class="input-group">
            <span>👤</span>
            <input type="email" name="email" placeholder="Email" required>
        </div>

        <div class="input-group">
            <span>🔒</span>
            <input type="password" name="password" placeholder="Password" required>
        </div>

        <button type="submit">LOGIN</button>
    </div>
</form>

</body>
</html>
