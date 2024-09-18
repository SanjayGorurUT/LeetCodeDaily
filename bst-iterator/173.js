/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

var elems = [];
var index = 0;
/**
 * @param {TreeNode} root
 */
var BSTIterator = function(root) {
    elems = [];
    index = 0;
    elems.push(root);
    for(let i = 0; i < elems.length; i++) {
        if(elems[i].left != null) {
            elems.push(elems[i].left);
        }
        if(elems[i].right != null) {
            elems.push(elems[i].right);
        }
    }
    elems.sort((a, b) => a.val - b.val);
};

/**
 * @return {number}
 */
BSTIterator.prototype.next = function() {
    let val = elems[index].val;
    index++;
    return val;
};

/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
    return index < elems.length;
};

/** 
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */