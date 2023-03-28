package edu.uniupo.pissir.service.thrower;

public interface ServiceThrower<T extends Exception> {

    void thrower ( T exception ) throws T;

}
