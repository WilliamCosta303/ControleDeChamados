package com.github.williamcosta303.modelo;

public class Registro {
    private int codigoRegistro;
    private String registro, autor, data, horario;
    private int codigoChamado;

    public int getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(int codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRegistro() {
        return registro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    
    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public int getCodigoChamado() {
        return codigoChamado;
    }

    public void setCodigoChamado(int codigoChamado) {
        this.codigoChamado = codigoChamado;
    }
    
    
}
