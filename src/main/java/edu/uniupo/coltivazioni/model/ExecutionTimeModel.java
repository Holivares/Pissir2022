package edu.uniupo.coltivazioni.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ExecutionTimeModel {
    @NotNull( message = "Start time field can't be empty or null" )

    private LocalTime startTime;
    @NotNull( message = "End time field can't be empty or null" )

    private LocalTime endTime;

}
