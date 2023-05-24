package edu.uniupo.pissir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionTimeEntity implements Serializable {
    @NotNull
    @Column( name = "START_TIME" )
    private LocalTime startTime;
    @NotNull
    @Column( name = "END_TIME" )
    private LocalTime endTime;
}
