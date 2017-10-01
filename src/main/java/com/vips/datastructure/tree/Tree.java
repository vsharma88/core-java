package com.vips.datastructure.tree;

import com.vips.datastructure.list.Node;

/**
 * @author Vipin Sharma
 * @category <blockquote></blockquote>
 * @DATE 21/09/17
 **/
public interface Tree<T> {

    enum Strategy {
      PRE_ORDER,POST_ORDER,IN_ORDER,LEVEL_ORDER
    };
    void insertElement(T element);
    T deleteElement(T element);
    T getMaxElement();
    T getMinElement();
    void traverse(Strategy strategy);

}
