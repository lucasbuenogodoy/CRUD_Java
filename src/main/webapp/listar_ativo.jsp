<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Locale"%>
<%@page import="br.com.aporte.model.Ativo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Ativo> ativos = (List<Ativo>) request.getAttribute("ativos");
    if (ativos == null) {
        response.sendRedirect("ListarAtivo");
        return;
    }
    NumberFormat moeda = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
    BigDecimal totalCarteira = BigDecimal.ZERO;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lista de Ativos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <nav class="navbar navbar-expand navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">Aporte</a>
                <div class="navbar-nav">
                    <a class="nav-link" href="index.jsp">Início</a>
                    <a class="nav-link" href="cadastrar_ativo.jsp">Cadastrar</a>
                    <a class="nav-link active" href="ListarAtivo">Listar</a>
                </div>
            </div>
        </nav>

        <div class="container py-4">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h1 class="h4 mb-0">Minha carteira</h1>
                <a class="btn btn-primary" href="cadastrar_ativo.jsp">Novo ativo</a>
            </div>

            <% if (ativos.isEmpty()) { %>
            <div class="alert alert-secondary">Nenhum ativo cadastrado ainda.</div>
            <% } else { %>
            <div class="card shadow-sm">
                <div class="table-responsive">
                    <table class="table table-striped table-hover align-middle mb-0">
                        <thead class="table-dark">
                            <tr>
                                <th>Código</th>
                                <th>Nome</th>
                                <th>Tipo</th>
                                <th class="text-end">Cotas</th>
                                <th class="text-end">Preço unitário</th>
                                <th class="text-end">Total</th>
                                <th class="text-center">Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Ativo ativo : ativos) {
                                    BigDecimal totalAtivo = ativo.getPrecoUnitario()
                                            .multiply(new BigDecimal(ativo.getQuantidadeCotas()));
                                    totalCarteira = totalCarteira.add(totalAtivo);
                            %>
                            <tr>
                                <td><strong><%= ativo.getCodigoAtivo() %></strong></td>
                                <td><%= ativo.getNomeEmpresa() %></td>
                                <td><span class="badge bg-secondary"><%= ativo.getTipoInvestimento() %></span></td>
                                <td class="text-end"><%= ativo.getQuantidadeCotas() %></td>
                                <td class="text-end"><%= moeda.format(ativo.getPrecoUnitario()) %></td>
                                <td class="text-end"><%= moeda.format(totalAtivo) %></td>
                                <td class="text-center">
                                    <a class="btn btn-sm btn-outline-primary"
                                       href="BuscarAtivo?idAtivo=<%= ativo.getIdAtivo() %>">Editar</a>
                                    <a class="btn btn-sm btn-outline-danger"
                                       href="ExcluirAtivo?idAtivo=<%= ativo.getIdAtivo() %>"
                                       onclick="return confirm('Excluir este ativo?')">Excluir</a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                        <tfoot class="table-light">
                            <tr>
                                <th colspan="5" class="text-end">Total da carteira</th>
                                <th class="text-end"><%= moeda.format(totalCarteira) %></th>
                                <th></th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
            <% } %>
        </div>
    </body>
</html>