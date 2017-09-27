package com.vips.datastructure.tree;

import com.vips.datastructure.list.Node;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 21/09/17
 **/
public interface Tree<T> {

    void insertElement(T element);
    T deleteElement(T element);
    T getMaxElement();
    T getMinElement();

}
