package br.edu.ifsp.dsw3.mar1000tas.model.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "marmitas")
public class Marmita extends AbstractEntity<Long>{
     @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String alimentos;

    @Column(nullable = false)
    private String diaSemana;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(nullable = false, name = "data_entrega", columnDefinition = "DATE")
    private LocalDate dataEntrega;

    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getAlimentos() {
        return alimentos;
    }
    public void setAlimentos(String alimentos) {
        this.alimentos = alimentos;
    }
    public String getDiaSemana() {
        return diaSemana;
    }
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
    public LocalDate getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((alimentos == null) ? 0 : alimentos.hashCode());
        result = prime * result + ((diaSemana == null) ? 0 : diaSemana.hashCode());
        result = prime * result + ((dataEntrega == null) ? 0 : dataEntrega.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Marmita other = (Marmita) obj;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (alimentos == null) {
            if (other.alimentos != null)
                return false;
        } else if (!alimentos.equals(other.alimentos))
            return false;
        if (diaSemana == null) {
            if (other.diaSemana != null)
                return false;
        } else if (!diaSemana.equals(other.diaSemana))
            return false;
        if (dataEntrega == null) {
            if (other.dataEntrega != null)
                return false;
        } else if (!dataEntrega.equals(other.dataEntrega))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Marmita [tipo=" + tipo + ", alimentos=" + alimentos + ", diaSemana=" + diaSemana + ", dataEntrega="
                + dataEntrega + "]";
    }
}
