<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Aporte</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <nav class="navbar navbar-expand navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">Aporte</a>
                <div class="navbar-nav">
                    <a class="nav-link" href="index.jsp">Início</a>
                    <a class="nav-link" href="cadastrar_ativo.jsp">Cadastrar</a>
                    <a class="nav-link" href="ListarAtivo">Listar</a>
                </div>
            </div>
        </nav>

        <div class="container py-5 text-center">
            <h1 class="mb-3">Aporte</h1>
            <p class="lead text-muted">Controle da sua carteira de investimentos</p>
            <a class="btn btn-primary btn-lg me-2" href="cadastrar_ativo.jsp">Cadastrar Ativo</a>
            <a class="btn btn-outline-primary btn-lg" href="ListarAtivo">Listar Ativos</a>
        </div>
    </body>
</html>