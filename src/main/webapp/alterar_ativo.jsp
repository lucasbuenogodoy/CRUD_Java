<%@page import="br.com.aporte.model.Ativo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Ativo ativo = (Ativo) request.getAttribute("ativo");
    if (ativo == null) {
        response.sendRedirect("ListarAtivo");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Alteração de Ativo</title>
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

        <div class="container py-4" style="max-width: 600px;">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h1 class="h4 mb-4">Alteração de Ativo</h1>
                    <form name="editarativo" action="AlterarAtivo" method="post">
                        <input type="hidden" name="idAtivo" value="<%= ativo.getIdAtivo() %>" />
                        <div class="mb-3">
                            <label class="form-label">Código do ativo</label>
                            <input type="text" class="form-control" name="codigoAtivo"
                                   maxlength="10" required
                                   value="<%= ativo.getCodigoAtivo() %>"
                                   oninput="this.value = this.value.toUpperCase()" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Nome da empresa/fundo</label>
                            <input type="text" class="form-control" name="nomeEmpresa"
                                   maxlength="100" required
                                   value="<%= ativo.getNomeEmpresa() %>" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tipo de investimento</label>
                            <select class="form-select" name="tipoInvestimento" required>
                                <option value="Ações" <%= "Ações".equals(ativo.getTipoInvestimento()) ? "selected" : "" %>>Ações</option>
                                <option value="FIIs" <%= "FIIs".equals(ativo.getTipoInvestimento()) ? "selected" : "" %>>FIIs</option>
                                <option value="Renda Fixa" <%= "Renda Fixa".equals(ativo.getTipoInvestimento()) ? "selected" : "" %>>Renda Fixa</option>
                            </select>
                        </div>
                        <div class="row">
                            <div class="col-6 mb-3">
                                <label class="form-label">Quantidade de cotas</label>
                                <input type="number" class="form-control" name="quantidadeCotas"
                                       min="1" step="1" required
                                       value="<%= ativo.getQuantidadeCotas() %>" />
                            </div>
                            <div class="col-6 mb-3">
                                <label class="form-label">Preço unitário (R$)</label>
                                <input type="number" class="form-control" name="precoUnitario"
                                       min="0.01" step="0.01" required
                                       value="<%= ativo.getPrecoUnitario().toPlainString() %>" />
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Salvar</button>
                        <a class="btn btn-outline-secondary" href="ListarAtivo">Cancelar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>