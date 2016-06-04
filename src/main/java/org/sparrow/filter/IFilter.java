package org.sparrow.filter;

/**
 *
 * @author mauricio
 */
public interface IFilter {
    String getName();
    String getVersion();
    byte[] process(byte[] data) throws Exception;
}
