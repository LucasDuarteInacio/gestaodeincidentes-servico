package com.ITIL.GestaoDeIncidentes.exception;

public class ResponseException {
    private String mensagem;
    private String detalhe;
    private Long timesTamp;
    private String path;

    public ResponseException(String mensagem, String detalhe, Long timesTamp, String path) {
        this.mensagem = mensagem;
        this.detalhe = detalhe;
        this.timesTamp = timesTamp;
        this.path = path;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public Long getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(Long timesTamp) {
        this.timesTamp = timesTamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
