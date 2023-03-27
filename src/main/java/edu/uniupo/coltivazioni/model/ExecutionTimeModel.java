package edu.uniupo.coltivazioni.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
