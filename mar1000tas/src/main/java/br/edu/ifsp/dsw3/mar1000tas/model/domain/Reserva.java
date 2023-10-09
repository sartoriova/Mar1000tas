package br.edu.ifsp.dsw3.mar1000tas.model.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "usuario_id_fk")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "marmita_id_fk")
    private Marmita marmita;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(nullable = false, name = "dataHora", columnDefinition = "DATE")
    private LocalDate dataHora;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Marmita getMarmita() {
        return marmita;
    }

    public void setMarmita(Marmita marmita) {
        this.marmita = marmita;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((marmita == null) ? 0 : marmita.hashCode());
        result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
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
        Reserva other = (Reserva) obj;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (marmita == null) {
            if (other.marmita != null)
                return false;
        } else if (!marmita.equals(other.marmita))
            return false;
        if (dataHora == null) {
            if (other.dataHora != null)
                return false;
        } else if (!dataHora.equals(other.dataHora))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reserva [usuario=" + usuario + ", marmita=" + marmita + ", dataHora=" + dataHora + "]";
    }

}
