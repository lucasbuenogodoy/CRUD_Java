<%@page import="br.com.aporte.model.Ativo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alteração de Ativo</title>
    </head>
    <body>
        <%
            Ativo ativo = (Ativo) request.getAttribute("ativo");
        %>
        <h1>Alteração de Ativo</h1>
        <form name="alterar_ativo" action="AlterarAtivo" method="post">
            <input type="hidden" name="idAtivo" value="<%= ativo.getIdAtivo() %>" />
            Código do ativo: <input type="text" name="codigoAtivo" size="10"
                                    value="<%= ativo.getCodigoAtivo() %>" />
            <br>
            Nome da empresa/fundo: <input type="text" name="nomeEmpresa" size="40"
                                          value="<%= ativo.getNomeEmpresa() %>" />
            <br>
            Tipo de investimento:
            <select name="tipoInvestimento">
                <option value="Ações" <%= "Ações".equals(ativo.getTipoInvestimento()) ? "selected" : "" %>>Ações</option>
                <option value="FIIs" <%= "FIIs".equals(ativo.getTipoInvestimento()) ? "selected" : "" %>>FIIs</option>
                <option value="Renda Fixa" <%= "Renda Fixa".equals(ativo.getTipoInvestimento()) ? "selected" : "" %>>Renda Fixa</option>
            </select>
            <br>
            Quantidade de cotas: <input type="number" name="quantidadeCotas" min="1"
                                        value="<%= ativo.getQuantidadeCotas() %>" />
            <br>
            Preço unitário: <input type="number" name="precoUnitario" min="0" step="0.01"
                                   value="<%= ativo.getPrecoUnitario() %>" />
            <br>
            <input type="submit" value="Salvar" name="salvar" />
        </form>
        <br>
        <a href="ListarAtivo">Voltar</a>
    </body>
</html>