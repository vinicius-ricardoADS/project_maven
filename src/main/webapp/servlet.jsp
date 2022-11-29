<%
    Pessoa p = (Pessoa) session.getAttribute("user");
    if (p == null)
        response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <main>
        <header>
            <h1>Bem vindo <% p.getName();%></h1>
        </header>
        <div>
            <a href="logar?op=deslogar&id=<%= p.getId() %>"></a>
        </div>
    </main>
</body>
</html>