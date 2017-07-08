package org.labun.rethrowables;

import java.util.function.Function;

/**
 * @author kulabun
 */
@FunctionalInterface
public interface RethrowableFunction<T, R> extends Function<T, R> {
    default R apply(T t) {
        try {
            return doApply(t);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    R doApply(T t) throws Exception;
}