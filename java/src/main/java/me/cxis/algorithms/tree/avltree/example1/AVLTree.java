package me.cxis.algorithms.tree.avltree.example1;

public class AVLTree {

    private AVLTreeNode root;

    public AVLTree() {
    }

    /**
     * 左左单旋转
     * @param k2 失衡点
     * @return 旋转后的根节点
     */
    public AVLTreeNode leftLeftRotation(AVLTreeNode k2) {
        AVLTreeNode k1;

        k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);

        k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) + 1);
        k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) + 1);
        return k1;
    }

    /**
     * 右右单旋转
     * @param k1 失衡点
     * @return 旋转后的根节点
     */
    public AVLTreeNode rightRightRotation(AVLTreeNode k1) {
        AVLTreeNode k2;

        k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);

        k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight())) + 1);
        k2.setHeight(Math.max(height(k2.getRight()), k1.getHeight()) + 1);
        return k2;
    }

    /**
     * 左右旋转
     * 先右右旋转，变成了左失衡，继续进行左左旋转
     * @param k3
     * @return 旋转后的根节点
     */
    public AVLTreeNode leftRightRotation(AVLTreeNode k3) {
        k3.setLeft(rightRightRotation(k3.getLeft()));
        return leftLeftRotation(k3);
    }

    /**
     * 右左旋转
     * 先左左旋转，变成了右失衡，继续进行右右旋转
     * @param k1
     * @return
     */
    public AVLTreeNode rightLeftRotation(AVLTreeNode k1) {
        k1.setRight(leftRightRotation(k1.getRight()));
        return rightRightRotation(k1);
    }

    public int height(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }

        return node.getHeight();
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private AVLTreeNode insert(AVLTreeNode root, int key) {
        if (root == null) {
            return new AVLTreeNode(key, null, null);
        }

        if (key < root.getKey()) {
            root.setLeft(insert(root.getLeft(), key));
            if (height(root.getLeft()) - height(root.getRight()) == 2) {
                if (key < root.getLeft().getKey()) {
                    root = leftLeftRotation(root);
                } else {
                    root = leftRightRotation(root);
                }
            }
        } else if (key > root.getKey()) {
            root.setRight(insert(root.getRight(), key));
            if (height(root.getRight()) - height(root.getLeft()) == 2) {
                if (key > root.getRight().getKey()) {
                    root = rightRightRotation(root);
                } else {
                    root = rightLeftRotation(root);
                }
            }
        }

        root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);
        return root;
    }

    public AVLTreeNode search(int key) {
        return search(root, key);
    }

    private AVLTreeNode search(AVLTreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.getKey()) {
            return search(root.getLeft(), key);
        } else if (key > root.getKey()) {
            return search(root.getRight(), key);
        } else {
            return root;
        }
    }

    public void remove(int key) {
        AVLTreeNode node;

        if ((node = search(root, key)) != null) {
            root = remove(root, node);
        }
    }

    private AVLTreeNode remove(AVLTreeNode root, AVLTreeNode node) {
        if (root == null || node == null) {
            return null;
        }

        if (node.getKey() < root.getKey()) {
            // 要删除的在左子树
            node.setLeft(remove(root.getLeft(), node));

            // 删除节点后，看AVL是否失衡
            // TODO
        } else if (node.getKey() > root.getKey()) {
            // 要删除的在右子树
            node.setRight(remove(root.getRight(), node));

            // 删除结点后，看AVK是否失衡
            // TODO
        } else {
            // 找到了删除的结点
            // 要删除的节点root的左右结点都不为空
            if (root.getLeft() != null && root.getRight() != null) {
                if (height(root.getLeft()) > height(root.getRight())) {
                    // 要删除的节点的左子树比右子树高
                    // 找出root的左子树中的最大结点，并赋值给root
                    AVLTreeNode max = max(root.getLeft());
                    root.setKey(max.getKey());
                    root.setLeft(remove(root.getLeft(), max));
                }
            } else if (root.getLeft() == null && root.getRight() != null) {
                // 右结点不为空
                root = root.getRight();
            } else if (root.getLeft() != null && root.getRight() == null) {
                // 左结点不为空
                root = root.getLeft();
            } else if (root.getLeft() == null && root.getRight() == null);
        }
        return null;
    }

    public int max() {
        AVLTreeNode node = max(root);
        if (node != null) {
            return node.getKey();
        }
        return 0;
    }

    public AVLTreeNode max(AVLTreeNode node) {
        if (node == null) {
            return null;
        }

        while (node.getRight() != null) {
            node = node.getRight();
        }

        return node;
    }

    public int height() {
        return height(root);
    }

    public AVLTreeNode getRoot() {
        return root;
    }

    public void setRoot(AVLTreeNode root) {
        this.root = root;
    }
}
