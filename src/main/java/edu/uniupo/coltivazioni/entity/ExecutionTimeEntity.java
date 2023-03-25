package edu.uniupo.coltivazioni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ExecutionTimeEntity implements Serializable {
    @Column( name = "START_TIME" )
    private LocalTime startTime;
    @Column( name = "END_TIME" )
    private LocalTime endTime;
}
