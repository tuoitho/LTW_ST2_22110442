<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link href="https://fonts.googleapis.com/css?family=Arimo|Playfair+Display" rel="stylesheet">
    <style>
        .form-container {
            width: 400px; /* Adjust the width of the form */
            margin: 0 auto; /* Center the form horizontally */
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            background-color: #f9f9f9;
        }

        input[type="text"], input[type="password"] {
            width: 100%; /* Make input fields take full width */
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .radio-group {
            display: flex;
            flex-wrap: wrap; /* Allow radios to wrap if they overflow */
            gap: 10px;
            margin-top: 10px;
        }

        .radio-group label {
            font-family: Arial, sans-serif;
            font-size: 14px;
            display: flex;
            align-items: center;
            gap: 5px;
        }

        input[type="radio"] {
            cursor: pointer;
        }

        button {
            width: 100%; /* Full-width button */
            padding: 10px 0;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>

<body>
<div class="container">
    <i class="fa fa-bars" style="display:none"></i>

    <form class="register" method="post" action="${pageContext.request.contextPath}/register">
        <c:if test="${alert !=null}">
        <div class="alert alert-danger" role="alert">
                ${alert}
        </div>
        </c:if>
        <h2>Register</h2>
        <input type="text" placeholder="UserName" name="uname"/>
        <input type="text" placeholder="Email" name="email"/>
        <input type="password" placeholder="Password" name="password"/>
        <div class="radio-group">
            <label><input type="radio" name="role" value="1" required> USER</label>
            <label><input type="radio" name="role" value="2" required> ADMIN</label>
            <label><input type="radio" name="role" value="3" required> MANAGER</label>
            <label><input type="radio" name="role" value="4" required> SELLER</label>
            <label><input type="radio" name="role" value="5" required> SHIPPER</label>
        </div>

        <button>Register</button>
    </form>

</div>
</body>

</html>