<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" media="screen" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link rel="stylesheet" href="../webapp/css/style.css">
    <title>Legue of Legends</title>
</head>

<body>
  <header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container">
        <a class="navbar-brand" href="#">
          <img src="imagens/logo.png" width="" height="30" alt="Logo">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    
        <div class="collapse navbar-collapse d-lg-flex justify-content-end" id="navbarSupportedContent">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="cadastrar.jsp">Cadastrar</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="servlet.jsp">Servlet</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>
  <main>
    <section>
      <header>
        <h1>Servidor usando sessões</h1>
      </header>
      <div>
        <p>Neste servlet a principal funcionalidade é prover o cadastro de um usuário juntamente com sessões no sistema</p>
        <p>podendo acessar ou não determinados links se o usuário estiver logado ou não</p>
      </div>
    </section>
    <section class="layout-content">
      <div class="container" id="login">
          <form method="post" action="logar">
              <label for="nome">Usuário</label>
              <input type="text" class="form-control" id="nome" name="nome" placeholder="Usuário">
              <label for="email">Senha</label>
              <input type="email" class="form-control" id="email" name="email" placeholder="Senha">
              <button type="submit" class="btn btn-primary btn-sm">Entrar</button>
          </form>
      </div>
  </section>
  </main>
  <footer>
    <h5>Desenvolvido usando Servlets Java</h5>
  </footer>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>

</html>