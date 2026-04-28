package entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eventos")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Evento {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false, name = "fecha_evento")
    private LocalDate fechaEvento;

    @Column(nullable = false, name = "precio_entrada")
    private Double precioEntrada;

    @Enumerated(EnumType.STRING)
    private EstadoEvento estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recinto_id") //FK
    @ToString.Exclude
    private Recinto recinto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "evento_asistente", joinColumns = @JoinColumn(name = "evento_id"), inverseJoinColumns = @JoinColumn(name = "asistente_id"))
    @ToString.Exclude
    private List<Asistente> asistentes = new ArrayList<>();



}
