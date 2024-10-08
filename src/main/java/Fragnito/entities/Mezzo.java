package Fragnito.entities;


import Fragnito.enumClass.StatoMezzo;
import Fragnito.enumClass.TipoMezzo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mezzi")
public class Mezzo {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "tipo_mezzo")
    @Enumerated(EnumType.STRING)
    private TipoMezzo tipoMezzo;

    @Column(nullable = false)
    private int capacita;

    @Column(name = "stato_mezzo", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatoMezzo statoMezzo;

/*    @Column(name = "numero_giri", nullable = false)
    private int numeroGiri = 0;*/

   /* @Column(name = "media_tempo_effettivo", nullable = false)
    private double mediaTempoEffettivo = 0.0;*/

    //un veicolo può essere stato in manutenzione più volte
    @OneToMany(mappedBy = "mezzo")
    private List<Manutenzione> manutenzioni = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "tratta_id", nullable = false)
    private Tratta tratta;

    @OneToMany(mappedBy = "mezzo")
    private List<Viaggio> viaggi = new ArrayList<>();

    public Mezzo() {
    }

    public Mezzo(TipoMezzo tipoMezzo, Tratta tratta) {
        this.tipoMezzo = tipoMezzo;
        switch (tipoMezzo) {
            case BUS -> this.capacita = 30;
            case TRAM -> this.capacita = 50;
        }
        this.statoMezzo = StatoMezzo.IN_SERVIZIO;
        this.tratta = tratta;
    }


    //GETTER E SETTER

    public UUID getId() {
        return id;
    }


    public int getCapacita() {
        return capacita;
    }

    public void setCapacita(int capacita) {
        this.capacita = capacita;
    }

    public TipoMezzo getTipoMezzo() {
        return tipoMezzo;
    }

    public void setTipoMezzo(TipoMezzo tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }

    public StatoMezzo getStatoMezzo() {
        return statoMezzo;
    }

    public void setStatoMezzo(StatoMezzo statoMezzo) {
        this.statoMezzo = statoMezzo;
    }

    public List<Manutenzione> getManutenzioni() {
        return manutenzioni;
    }

    public void setManutenzioni(List<Manutenzione> manutenzioni) {
        this.manutenzioni = manutenzioni;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public List<Viaggio> getViaggi() {
        return viaggi;
    }

    public void setViaggi(List<Viaggio> viaggi) {
        this.viaggi = viaggi;
    }

    @Override
    public String toString() {
        return "Mezzo: " +
                "id =" + id +
                ", tipo mezzo = " + tipoMezzo +
                ", capacita = " + capacita +
                ", stato mezzo = " + statoMezzo +
                ", manutenzioni = " + manutenzioni;
    }
}
