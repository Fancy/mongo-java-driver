/**
 *  See the NOTICE.txt file distributed with this work for
 *  information regarding copyright ownership.
 *
 *  The authors license this file to you under the
 *  Apache License, Version 2.0 (the "License"); you may not use
 *  this file except in compliance with the License.  You may
 *  obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.mongodb.mql;

public class JJTMQLState {
    private java.util.List nodes;
    private java.util.List marks;

    private int sp;        // number of nodes on stack
    private int mk;        // current mark
    private boolean node_created;

    public JJTMQLState() {
        nodes = new java.util.ArrayList();
        marks = new java.util.ArrayList();
        sp = 0;
        mk = 0;
    }

    /* Determines whether the current node was actually closed and
 pushed.  This should only be called in the final user action of a
 node scope.  */
    public boolean nodeCreated() {
        return node_created;
    }

    /* Call this to reinitialize the node stack.  It is called
automatically by the parser's ReInit() method. */
    public void reset() {
        nodes.clear();
        marks.clear();
        sp = 0;
        mk = 0;
    }

    /* Returns the root node of the AST.  It only makes sense to call
this after a successful parse. */
    public Node rootNode() {
        return (Node) nodes.get(0);
    }

    /* Pushes a node on to the stack. */
    public void pushNode(Node n) {
        nodes.add(n);
        ++sp;
    }

    /* Returns the node on the top of the stack, and remove it from the
  stack.  */
    public Node popNode() {
        if (--sp < mk) {
            mk = ((Integer) marks.remove(marks.size() - 1)).intValue();
        }
        return (Node) nodes.remove(nodes.size() - 1);
    }

    /* Returns the node currently on the top of the stack. */
    public Node peekNode() {
        return (Node) nodes.get(nodes.size() - 1);
    }

    /* Returns the number of children on the stack in the current node
   scope. */
    public int nodeArity() {
        return sp - mk;
    }


    public void clearNodeScope(Node n) {
        while (sp > mk) {
            popNode();
        }
        mk = ((Integer) marks.remove(marks.size() - 1)).intValue();
    }


    public void openNodeScope(Node n) {
        marks.add(new Integer(mk));
        mk = sp;
        n.jjtOpen();
    }


    /* A definite node is constructed from a specified number of
children.  That number of nodes are popped from the stack and
made the children of the definite node.  Then the definite node
is pushed on to the stack. */
    public void closeNodeScope(Node n, int num) {
        mk = ((Integer) marks.remove(marks.size() - 1)).intValue();
        while (num-- > 0) {
            Node c = popNode();
            c.jjtSetParent(n);
            n.jjtAddChild(c, num);
        }
        n.jjtClose();
        pushNode(n);
        node_created = true;
    }


    /* A conditional node is constructed if its condition is true.  All
the nodes that have been pushed since the node was opened are
made children of the conditional node, which is then pushed
on to the stack.  If the condition is false the node is not
constructed and they are left on the stack. */
    public void closeNodeScope(Node n, boolean condition) {
        if (condition) {
            int a = nodeArity();
            mk = ((Integer) marks.remove(marks.size() - 1)).intValue();
            while (a-- > 0) {
                Node c = popNode();
                c.jjtSetParent(n);
                n.jjtAddChild(c, a);
            }
            n.jjtClose();
            pushNode(n);
            node_created = true;
        } else {
            mk = ((Integer) marks.remove(marks.size() - 1)).intValue();
            node_created = false;
        }
    }
}
/* JavaCC - OriginalChecksum=bd41e031be991badd02f7b7471d5d3d4 (do not edit this line) */
