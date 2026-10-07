package br.com.aporte.model;

import java.math.BigDecimal;

public class Ativo {

    private Integer idAtivo;
    private String codigoAtivo;
    private String nomeEmpresa;
    private String tipoInvestimento;
    private Integer quantidadeCotas;
    private BigDecimal precoUnitario;

    public Ativo() {
    }

    public Ativo(Integer idAtivo, String codigoAtivo, String nomeEmpresa,
                 String tipoInvestimento, Integer quantidadeCotas, BigDecimal precoUnitario) {
        this.idAtivo = idAtivo;
        this.codigoAtivo = codigoAtivo;
        this.nomeEmpresa = nomeEmpresa;
        this.tipoInvestimento = tipoInvestimento;
        this.quantidadeCotas = quantidadeCotas;
        this.precoUnitario = precoUnitario;
    }

    public Integer getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(Integer idAtivo) {
        this.idAtivo = idAtivo;
    }

    public String getCodigoAtivo() {
        return codigoAtivo;
    }

    public void setCodigoAtivo(String codigoAtivo) {
        this.codigoAtivo = codigoAtivo;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public Integer getQuantidadeCotas() {
        return quantidadeCotas;
    }

    public void setQuantidadeCotas(Integer quantidadeCotas) {
        this.quantidadeCotas = quantidadeCotas;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}