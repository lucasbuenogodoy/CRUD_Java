<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Ativo</title>
    </head>
    <body>
        <h1>Cadastro de Ativo</h1>
        <form name="cadastrar_ativo" action="CadastrarAtivo" method="post">
            Código do ativo: <input type="text" name="codigoAtivo" size="10" />
            <br>
            Nome da empresa/fundo: <input type="text" name="nomeEmpresa" size="40" />
            <br>
            Tipo de investimento:
            <select name="tipoInvestimento">
                <option value="Ações">Ações</option>
                <option value="FIIs">FIIs</option>
                <option value="Renda Fixa">Renda Fixa</option>
            </select>
            <br>
            Quantidade de cotas: <input type="number" name="quantidadeCotas" min="1" />
            <br>
            Preço unitário: <input type="number" name="precoUnitario" min="0" step="0.01" />
            <br>
            <input type="submit" value="Cadastrar" name="cadastrar" />
            <input type="reset" value="Limpar" name="limpar" />
        </form>
        ${sucesso}
        <br>
        <a href="ListarAtivo">Ver lista de ativos</a>
        <br>
        <a href="index.jsp">Voltar</a>
    </body>
</html>