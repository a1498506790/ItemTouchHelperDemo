package com.mir.itemtouchhelperdemo;

/**
 * @author by lx
 * @github https://github.com/a1498506790
 * @data 2018/2/2
 * @desc
 */

public interface ItemMoveListener {

    boolean onItemMove(int fromPosition, int toPosition);

    boolean onItemRemove(int position);

}
