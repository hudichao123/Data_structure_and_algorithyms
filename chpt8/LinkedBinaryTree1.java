public class LinkedBinaryTree1<E> extends AbstractBinaryTree1<E> {
     protected static class Node<E> implements Position<E> {
        public E element;
        public Node<E> parent;
        public Node<E> left;
        public Node<E> right;
        
        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
        
        public E getElement() {
            return element;
        }
    }
    
        protected Node<E> root = null;
        private int size = 0;
        
        public LinkedBinaryTree1() {
        
        }
        
        protected Node<E> createNode(E element, Node<E> parent, Node<E> left, Node<E> right) {
            return new Node(element, parent, left, right);
        }
        
        public Node<E> validate(Position<E> p) {
            if (!(p instanceof Node)) {
                throw new IllegalArgumentException();
            }
            Node<E> n = (Node<E>) p;
            if (parent(p) == p) {
                throw new IllegalArgumentException();
            } else {
                return n;
            }
        }
        
        public int size() {
            return size;
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        public Position<E> root() {
            return root;
        }
        
        public Position<E> parent(Position<E> p) throws IllegalArgumentException {
            Node<E> n = validate(p);
            return n.parent;
        }
        
        public Position<E> left(Position<E> p) throws IllegalArgumentException {
            Node<E> n = validate(p);
            return n.left;
        }
        
        public Position<E> right(Position<E> p) throws IllegalArgumentException {
            Node<E> n = validate(p);
            return n.right;
        }
        
        public Position<E> addRoot(E e) {
            if (!isEmpty()) {
                throw new IllegalArgumentException();
            }
            Node<E> n = new Node<E> (e, null, null, null);
            root = n;
            size = 1;
            return n;
        }
        
        public Position<E> addLeft(Position<E> p, E e) {
            Node n1 = validate(p);
            if (n1.left != null) {
                throw new IllegalArgumentException();
            }
            
            Node n2 = createNode(e, n1, null, null);
            n1.left = n2;
            size++;
            return n2;
            
        }
        
        public Position<E> addRight(Position<E> p, E e) {
            Node n1 = validate(p);
            if (n1.right != null) {
                throw new IllegalArgumentException();
            }
            
            Node n2 = createNode(e, n1, null, null);
            n1.right = n2;
            size++;
            return n2;
        }
        
        public E set(Position<E> p, E e) {
            Node<E> n1 = validate(p);
            E temp = n1.element;
            n1.element = e;
            return temp;
        }
        
        public void attach(Position<E> p, LinkedBinaryTree1<E> t1, LinkedBinaryTree1<E> t2) {
            Node<E> n1 = validate(p);
            if (numChildren(n1) != 0) {
                throw new IllegalArgumentException();
            }
            size += t1.size() + t2.size();
            if (!t1.isEmpty()) {
                n1.left = t1.root;
                t1.root.parent = n1;
                t1.root = null;
                t1.size = 0;
            }
            
            if (!t2.isEmpty()) {
                n1.left = t2.root;
                t2.root.parent = n1;
                t2.root = null;
                t2.size = 0;
            }
            
        }
        
        public E remove(Position<E> p) {
            Node<E> n = validate(p);
            if (numChildren(n) == 2) {
                throw new IllegalArgumentException();
            }
            if (n.left != null) {
                if (n.parent.left == n) {
                    n.parent.left =n.left;
                    n.left.parent = n.parent;
                } else {
                    n.parent.right = n.left;
                    n.left.parent = n.parent;
                }
                
            } else if (n.right != null) {
                if (n.parent.left == n) {
                    n.parent.left = n.right;
                    n.right.parent = n.parent;
                } else {
                    n.parent.right = n.right;
                    n.right.parent = n.parent;
                }   
                        
            } else {
                if (n.parent.left == n) {
                    n.parent.left = null;
                } else {
                    n.parent.right = null;
                }
                
            }
            size--;
            n.parent = n;
            n.left =  null;
            n.right = null;
            E e = n.element;
            n.element = null;
            return e;
        }
        
        public class ElementIterator implements java.util.Iterator<E> {
            java.util.Iterator<Position<E>> posIterator = positions().iterator();
            public boolean hasNext() {
                return posIterator.hasNext();
            }
            
            public E next() {
                return posIterator.next().getElement();
            }
            
            public void remove() {
                posIterator.remove();
            }
        }

        public java.util.Iterator<E> iterator( ) {
            return new ElementIterator();
        }
        public Iterable<Position<E>> positions( ) {
            return preorder();
        }
        
        public Iterable<Position<E>> positions2() {
            return postorder();
        }
        
        public Iterable<Position<E>> position3() {
            return breathFirst();
        }
        
        public Iterable<Position<E>> position4() {
            return inorder();
        }
        
        public Iterable<Position<E>> preorder() {
            java.util.List<Position<E>> l = new java.util.ArrayList<>();
            if (!isEmpty()) {
                preorderSubtree(root(), l);
            }
            return l;
        }
        
        public Iterable<Position<E>> postorder() {
            java.util.List<Position<E>> l = new java.util.ArrayList<>();
            if (!isEmpty()) {
                postorderSubtree(root(), l);
            }
            return l;
        }
        
        public void preorderSubtree(Position<E> p, java.util.List<Position<E>> l) {
            l.add(p);
            for (Position<E> c: children(p)) {
                preorderSubtree(c, l);
            }
        }
        
        public void postorderSubtree(Position<E> p, java.util.List<Position<E>> l) {
            for (Position<E> c : children(p)) {
                postorderSubtree(c, l);
            }
            l.add(p);
        }
        
        public Iterable<Position<E>> breathFirst() {
            Queue1<Position<E>> q = new Queue1<>();
            java.util.List<Position<E>> l = new java.util.ArrayList<>();
            if (!isEmpty()) {
                q.enqueue(root());
                while (!q.isEmpty()) {
                    Position<E> p = q.dequeue();
                    l.add(p);
                    for (Position<E> c: children(p)) {
                        q.enqueue(c);
                    }
                }
                
                
            }
            return l;
        }
        
        public Iterable<Position<E>> inorder() {
            java.util.List<Position<E>> l = new java.util.ArrayList<>();
            if (!isEmpty()) {
                inorderSubtree(root(), l);
            }
            return l;
        }
        
        public void inorderSubtree(Position<E> p, java.util.List<Position<E>> l) {
            if (left(p) != null) {
                inorderSubtree(left(p), l);
            }
            l.add(p);
            if (right(p) != null) {
                inorderSubtree(right(p), l);
            }
        }
    }
