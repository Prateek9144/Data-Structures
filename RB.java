public class RB {
    RBnode root;

    RB(int val) {
        root = new RBnode(val);
        root.colour = false;
    }

    void insert(int val) {
        root = Insertelement(root, val);
        root.colour = false;
    }

    RBnode Insertelement(RBnode rt, int a) {
        if (rt == null) {
            rt = new RBnode(a);
        } else if (rt.value < a) {
            rt.rc = Insertelement(rt.rc, a);
            if (rt.rc.lc != null) {                         //  case of right left case
                if (rt.rc.lc.colour == true && rt.rc.colour == true) {
                    if (rt.lc != null && rt.lc.colour == true) {
                        rt.colour = true;
                        rt.lc.colour = false;
                        rt.rc.colour = false;
                    } else {
                        rt = rightleftrotation(rt);
                    }
                }
            } else if (rt.rc.rc != null) {                          // case of left left rotation case
                if (rt.rc.rc.colour == true && rt.rc.colour == true) {
                    if (rt.lc != null && rt.lc.colour == true) {
                        rt.colour = true;
                        rt.lc.colour = false;
                        rt.rc.colour = false;
                    } else {
                        rt = leftleftrotation(rt);
                    }
                }
            }

        } else if (rt.value > a) {
            rt.lc = Insertelement(rt.lc, a);
            if (rt.lc.lc != null) {                                     // case of right right case 
                if (rt.lc.lc.colour == true && rt.lc.colour == true) {
                    if (rt.rc != null && rt.rc.colour == true) {
                        rt.colour = true;
                        rt.rc.colour = false;
                        rt.lc.colour = false;
                    } else {
                        rt = rightrightrotation(rt);
                    }
                }
            } else if (rt.lc.rc != null) {                      // case of left right rotation case
                if (rt.lc.rc.colour == true && rt.lc.colour == true) {
                    if (rt.rc != null && rt.rc.colour == true) {
                        rt.colour = true;
                        rt.lc.colour = false;
                        rt.rc.colour = false;
                    } else {
                        rt = leftrightrotation(rt);
                    }
                }
            }
        }
        return rt;
    }
    
    RBnode rightrightrotation(RBnode x) {
        RBnode temp;
        temp = x.lc;
        x.lc = temp.rc;
        temp.rc = x;
        x.colour = true;
        temp.colour = false;
        temp.rc.colour = true;
        return temp;
    }

    RBnode leftleftrotation(RBnode x) {
        RBnode temp;
        temp = x.rc;
        x.rc = temp.lc;
        temp.lc = x;
        x.colour = true;
        temp.colour = false;
        temp.lc.colour = true;
        return temp;
    }

    RBnode leftrightrotation(RBnode x) {
        RBnode temp = x.lc;
        temp = leftleftrotation(temp);
        return rightleftrotation(x);
    }

    RBnode rightleftrotation(RBnode x) {
        RBnode temp = x.rc;
        temp = rightrightrotation(temp);
        return leftleftrotation(x);
    }

    void InOrderTraverse(RBnode rt) {
        if (rt != null) {
            InOrderTraverse(rt.lc);
            System.out.print(rt.value + ", ");
            InOrderTraverse(rt.rc);
        }
    }

    void InOrderTraverseColour(RBnode rt) {
        if (rt != null) {
            InOrderTraverse(rt.lc);
            System.out.print(rt.colour + ", ");
            InOrderTraverse(rt.rc);
        }
    }
}
