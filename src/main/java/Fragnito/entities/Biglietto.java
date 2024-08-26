package Fragnito.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Biglietto")
public class Biglietto extends Timbrabile {
    @Column(name = "data_vidimazione")
    private LocalDate dataVidimazione;

    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

    public Biglietto() {
    }

    public Biglietto(LocalDate dataEmissione, Distributore distributore, LocalDate dataVidimazione) {
        super(dataEmissione, distributore);
        this.dataVidimazione = dataVidimazione;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public LocalDate getDataVidimazione() {
        return dataVidimazione;
    }

    public void setDataVidimazione(LocalDate dataVidimazione) {
        this.dataVidimazione = dataVidimazione;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "dataVidimazione=" + dataVidimazione +
                ", viaggio=" + viaggio +
                "} " + super.toString();
    }
}
