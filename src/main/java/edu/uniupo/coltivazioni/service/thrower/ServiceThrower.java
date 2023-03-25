package edu.uniupo.coltivazioni.service.thrower;

public interface ServiceThrower<T extends Exception> {

    void thrower ( T exception ) throws T;

}
