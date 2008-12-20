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

import java.io.StringReader;

import org.mongodb.mql.nodes.*;
import org.mongodb.driver.impl.DriverQueryInfo;
import org.mongodb.driver.MongoDBException;

/**
 * @nojavadoc
 */
public class MQL/*@bgen(jjtree)*/ implements MQLTreeConstants, MQLConstants {/*@bgen(jjtree)*/
    protected JJTMQLState jjtree = new JJTMQLState();
    String mql;
    boolean inEnumPath;

    public MQL(String mql) {
        this(new StringReader(mql));
        this.mql = mql;
    }

    public void populateQueryInfo(QueryInfo qi) throws MongoDBException {

        try {
            SimpleNode ast = (SimpleNode) parseQuery();
            ast.generateQuery(qi);
        }
        catch (ParseException pe) {
            throw new MongoDBException("Parse exception :", pe);
        }
    }

    public static void main(String[] args) throws Exception {

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                MQL parser = new MQL(args[i]);
                SimpleNode ast = (SimpleNode) parser.parseQuery();
                ast.dump("");
                QueryInfo qi = new QueryInfo();

                ast.generateQuery(qi);

                System.out.println(qi.toString());
            }
        } else {
            MQL parser = new MQL(System.in);

            while (true) {
                System.out.print("Enter Expression: ");
                System.out.flush();

                try {
                    SimpleNode ast = (SimpleNode) parser.parseQuery();

                    if (ast == null) {
                        return;
                    } else {
                        ast.dump("");
                    }
                }
                catch (Throwable x) {
                    x.printStackTrace();
                    return;
                }
            }
        }
    }

    final public Node parseQuery() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case SELECT:
                select_statement();
                break;
            case UPDATE:
                update_statement();
                break;
            case DELETE:
                delete_statement();
                break;
            default:
                jj_la1[0] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        jj_consume_token(0);
        {
            if (true) return jjtree.rootNode();
        }
        throw new Error("Missing return statement in function");
    }

    final public void select_statement() throws ParseException {
        /*@bgen(jjtree) SELECT */
        MQLSELECT jjtn000 = new MQLSELECT(this, JJTSELECT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            select_clause();
            from_clause();
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case WHERE:
                    where_clause();
                    break;
                default:
                    jj_la1[1] = jj_gen;
                    ;
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case GROUP:
                    groupby_clause();
                    break;
                default:
                    jj_la1[2] = jj_gen;
                    ;
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case HAVING:
                    having_clause();
                    break;
                default:
                    jj_la1[3] = jj_gen;
                    ;
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case ORDER:
                    orderby_clause();
                    break;
                default:
                    jj_la1[4] = jj_gen;
                    ;
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case SKIPPER:
                    skip_clause();
                    break;
                default:
                    jj_la1[5] = jj_gen;
                    ;
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case LIMIT:
                    limit_clause();
                    break;
                default:
                    jj_la1[6] = jj_gen;
                    ;
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void update_statement() throws ParseException {
        /*@bgen(jjtree) UPDATE */
        MQLUPDATE jjtn000 = new MQLUPDATE(this, JJTUPDATE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            update_clause();
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case WHERE:
                    where_clause();
                    break;
                default:
                    jj_la1[7] = jj_gen;
                    ;
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void delete_statement() throws ParseException {
        /*@bgen(jjtree) DELETE */
        MQLDELETE jjtn000 = new MQLDELETE(this, JJTDELETE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(DELETE);
            jj_consume_token(FROM);
            MQLFROM jjtn001 = new MQLFROM(this, JJTFROM);
            boolean jjtc001 = true;
            jjtree.openNodeScope(jjtn001);
            try {
                from_item();
            } catch (Throwable jjte001) {
                if (jjtc001) {
                    jjtree.clearNodeScope(jjtn001);
                    jjtc001 = false;
                } else {
                    jjtree.popNode();
                }
                if (jjte001 instanceof RuntimeException) {
                    {
                        if (true) throw (RuntimeException) jjte001;
                    }
                }
                if (jjte001 instanceof ParseException) {
                    {
                        if (true) throw (ParseException) jjte001;
                    }
                }
                {
                    if (true) throw (Error) jjte001;
                }
            } finally {
                if (jjtc001) {
                    jjtree.closeNodeScope(jjtn001, true);
                }
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case WHERE:
                    where_clause();
                    break;
                default:
                    jj_la1[8] = jj_gen;
                    ;
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void from_clause() throws ParseException {
        /*@bgen(jjtree) FROM */
        MQLFROM jjtn000 = new MQLFROM(this, JJTFROM);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(FROM);
            identification_variable_declaration();
            label_1:
            while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case COMMA:
                        ;
                        break;
                    default:
                        jj_la1[9] = jj_gen;
                        break label_1;
                }
                jj_consume_token(COMMA);
                if (jj_2_1(2147483647)) {
                    collection_member_declaration();
                } else if (jj_2_2(2147483647)) {
                    identification_variable_declaration();
                } else {
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void identification_variable_declaration() throws ParseException {
        from_item();
        label_2:
        while (true) {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case LEFT:
                case INNER:
                case JOIN:
                    ;
                    break;
                default:
                    jj_la1[10] = jj_gen;
                    break label_2;
            }
            if (jj_2_3(2147483647)) {
                fetch_join();
            } else if (jj_2_4(2147483647)) {
                inner_join();
            } else if (jj_2_5(2147483647)) {
                outer_join();
            } else {
                jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }

    final public void from_item() throws ParseException {
        /*@bgen(jjtree) FROMITEM */
        MQLFROMITEM jjtn000 = new MQLFROMITEM(this, JJTFROMITEM);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            abstract_schema_name();
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case AS:
                    jj_consume_token(AS);
                    break;
                default:
                    jj_la1[11] = jj_gen;
                    ;
            }
            if (jj_2_6(2147483647)) {
                identification_variable();
            } else {
                ;
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void subquery_from_clause() throws ParseException {
        /*@bgen(jjtree) FROM */
        MQLFROM jjtn000 = new MQLFROM(this, JJTFROM);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(FROM);
            subquery_from_item();
            label_3:
            while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case COMMA:
                        ;
                        break;
                    default:
                        jj_la1[12] = jj_gen;
                        break label_3;
                }
                jj_consume_token(COMMA);
                subquery_from_item();
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void subquery_from_item() throws ParseException {
        if (jj_2_7(2147483647)) {
            collection_member_declaration();
        } else if (jj_2_8(2147483647)) {
            identification_variable_declaration();
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    final public void inner_join() throws ParseException {
        /*@bgen(jjtree) INNERJOIN */
        MQLINNERJOIN jjtn000 = new MQLINNERJOIN(this, JJTINNERJOIN);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case INNER:
                    jj_consume_token(INNER);
                    break;
                default:
                    jj_la1[13] = jj_gen;
                    ;
            }
            jj_consume_token(JOIN);
            path();
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case AS:
                    jj_consume_token(AS);
                    break;
                default:
                    jj_la1[14] = jj_gen;
                    ;
            }
            identification_variable();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void collection_member_declaration() throws ParseException {
        /*@bgen(jjtree) INNERJOIN */
        MQLINNERJOIN jjtn000 = new MQLINNERJOIN(this, JJTINNERJOIN);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(IN);
            jj_consume_token(87);
            path();
            jj_consume_token(88);
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case AS:
                    jj_consume_token(AS);
                    break;
                default:
                    jj_la1[15] = jj_gen;
                    ;
            }
            identification_variable();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void outer_join() throws ParseException {
        /*@bgen(jjtree) OUTERJOIN */
        MQLOUTERJOIN jjtn000 = new MQLOUTERJOIN(this, JJTOUTERJOIN);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(LEFT);
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case OUTER:
                    jj_consume_token(OUTER);
                    break;
                default:
                    jj_la1[16] = jj_gen;
                    ;
            }
            jj_consume_token(JOIN);
            path();
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case AS:
                    jj_consume_token(AS);
                    break;
                default:
                    jj_la1[17] = jj_gen;
                    ;
            }
            identification_variable();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void fetch_join() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case LEFT:
                outer_fetch_join();
                break;
            case INNER:
            case JOIN:
                inner_fetch_join();
                break;
            default:
                jj_la1[18] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void outer_fetch_join() throws ParseException {
        /*@bgen(jjtree) OUTERFETCHJOIN */
        MQLOUTERFETCHJOIN jjtn000 = new MQLOUTERFETCHJOIN(this, JJTOUTERFETCHJOIN);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(LEFT);
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case OUTER:
                    jj_consume_token(OUTER);
                    break;
                default:
                    jj_la1[19] = jj_gen;
                    ;
            }
            jj_consume_token(JOIN);
            jj_consume_token(FETCH);
            path();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void inner_fetch_join() throws ParseException {
        /*@bgen(jjtree) INNERFETCHJOIN */
        MQLINNERFETCHJOIN jjtn000 = new MQLINNERFETCHJOIN(this, JJTINNERFETCHJOIN);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case INNER:
                    jj_consume_token(INNER);
                    break;
                default:
                    jj_la1[20] = jj_gen;
                    ;
            }
            jj_consume_token(JOIN);
            jj_consume_token(FETCH);
            path();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void path() throws ParseException {
        /*@bgen(jjtree) PATH */
        MQLPATH jjtn000 = new MQLPATH(this, JJTPATH);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            identification_variable();
            label_4:
            while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case DOT:
                        ;
                        break;
                    default:
                        jj_la1[21] = jj_gen;
                        break label_4;
                }
                jj_consume_token(DOT);
                path_component();
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void update_clause() throws ParseException {
        jj_consume_token(UPDATE);
        MQLFROM jjtn001 = new MQLFROM(this, JJTFROM);
        boolean jjtc001 = true;
        jjtree.openNodeScope(jjtn001);
        try {
            from_item();
        } catch (Throwable jjte001) {
            if (jjtc001) {
                jjtree.clearNodeScope(jjtn001);
                jjtc001 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte001 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte001;
                }
            }
            if (jjte001 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte001;
                }
            }
            {
                if (true) throw (Error) jjte001;
            }
        } finally {
            if (jjtc001) {
                jjtree.closeNodeScope(jjtn001, true);
            }
        }
        set_clause();
    }

    final public void set_clause() throws ParseException {
        jj_consume_token(SET);
        update_item();
        label_5:
        while (true) {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case COMMA:
                    ;
                    break;
                default:
                    jj_la1[22] = jj_gen;
                    break label_5;
            }
            jj_consume_token(COMMA);
            update_item();
        }
    }

    final public void update_item() throws ParseException {
        /*@bgen(jjtree) UPDATEITEM */
        MQLUPDATEITEM jjtn000 = new MQLUPDATEITEM(this, JJTUPDATEITEM);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            path();
            EQ();
            new_value();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void new_value() throws ParseException {
        /*@bgen(jjtree) UPDATEVALUE */
        MQLUPDATEVALUE jjtn000 = new MQLUPDATEVALUE(this, JJTUPDATEVALUE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            if (jj_2_9(2147483647)) {
                arithmetic_expression();
            } else if (jj_2_10(2147483647)) {
                string_primary();
            } else if (jj_2_11(2147483647)) {
                datetime_primary();
            } else if (jj_2_12(2147483647)) {
                boolean_primary();
            } else if (jj_2_13(2147483647)) {
                enum_primary();
            } else if (jj_2_14(2147483647)) {
                simple_entity_expression();
            } else {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case NULL:
                        jj_consume_token(NULL);
                        break;
                    default:
                        jj_la1[23] = jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void simple_entity_expression() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case IDENTIFIER:
                identification_variable();
                break;
            case 89:
            case 90:
                input_parameter();
                break;
            default:
                jj_la1[24] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void select_clause() throws ParseException {
        /*@bgen(jjtree) SELECTCLAUSE */
        MQLSELECTCLAUSE jjtn000 = new MQLSELECTCLAUSE(this, JJTSELECTCLAUSE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(SELECT);
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case DISTINCT:
                    distinct();
                    break;
                default:
                    jj_la1[25] = jj_gen;
                    ;
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case NEW:
                case AVG:
                case MIN:
                case MAX:
                case SUM:
                case COUNT:
                case CONCAT:
                case SUBSTRING:
                case TRIM:
                case LOWER:
                case UPPER:
                case LENGTH:
                case LOCATE:
                case ABS:
                case SQRT:
                case MOD:
                case SIZE:
                case CURRENT_DATE:
                case CURRENT_TIME:
                case CURRENT_TIMESTAMP:
                case OBJECT:
                case IDENTIFIER:
                    select_expressions();
                    break;
                default:
                    jj_la1[26] = jj_gen;
                    ;
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void simple_select_clause() throws ParseException {
        /*@bgen(jjtree) SELECTCLAUSE */
        MQLSELECTCLAUSE jjtn000 = new MQLSELECTCLAUSE(this, JJTSELECTCLAUSE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(SELECT);
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case DISTINCT:
                    distinct();
                    break;
                default:
                    jj_la1[27] = jj_gen;
                    ;
            }
            subselect_expressions();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void select_expressions() throws ParseException {
        /*@bgen(jjtree) SELECTEXPRESSIONS */
        MQLSELECTEXPRESSIONS jjtn000 = new MQLSELECTEXPRESSIONS(this, JJTSELECTEXPRESSIONS);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            select_expression();
            label_6:
            while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case COMMA:
                        ;
                        break;
                    default:
                        jj_la1[28] = jj_gen;
                        break label_6;
                }
                jj_consume_token(COMMA);
                select_expression();
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void select_expression() throws ParseException {
        /*@bgen(jjtree) SELECTEXPRESSION */
        MQLSELECTEXPRESSION jjtn000 = new MQLSELECTEXPRESSION(this, JJTSELECTEXPRESSION);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case AVG:
                case MIN:
                case MAX:
                case SUM:
                case COUNT:
                    aggregate_select_expression();
                    break;
                default:
                    jj_la1[29] = jj_gen;
                    if (jj_2_15(2147483647)) {
                        path();
                    } else {
                        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                            case IDENTIFIER:
                                identification_variable();
                                break;
                            case OBJECT:
                                jj_consume_token(OBJECT);
                                jj_consume_token(87);
                                identification_variable();
                                jj_consume_token(88);
                                break;
                            case NEW:
                                constructor_expression();
                                break;
                            case CONCAT:
                            case SUBSTRING:
                            case TRIM:
                            case LOWER:
                            case UPPER:
                            case LENGTH:
                            case LOCATE:
                            case ABS:
                            case SQRT:
                            case MOD:
                            case SIZE:
                            case CURRENT_DATE:
                            case CURRENT_TIME:
                            case CURRENT_TIMESTAMP:
                                select_extension();
                                break;
                            default:
                                jj_la1[30] = jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                        }
                    }
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void select_extension() throws ParseException {
        /*@bgen(jjtree) SELECTEXTENSION */
        MQLSELECTEXTENSION jjtn000 = new MQLSELECTEXTENSION(this, JJTSELECTEXTENSION);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            scalar_function();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void subselect_expressions() throws ParseException {
        /*@bgen(jjtree) SELECTEXPRESSIONS */
        MQLSELECTEXPRESSIONS jjtn000 = new MQLSELECTEXPRESSIONS(this, JJTSELECTEXPRESSIONS);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            subselect_expression();
            label_7:
            while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case COMMA:
                        ;
                        break;
                    default:
                        jj_la1[31] = jj_gen;
                        break label_7;
                }
                jj_consume_token(COMMA);
                subselect_expression();
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void subselect_expression() throws ParseException {
        /*@bgen(jjtree) SELECTEXPRESSION */
        MQLSELECTEXPRESSION jjtn000 = new MQLSELECTEXPRESSION(this, JJTSELECTEXPRESSION);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            if (jj_2_16(2147483647)) {
                path();
            } else {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case AVG:
                    case MIN:
                    case MAX:
                    case SUM:
                    case COUNT:
                        aggregate_select_expression();
                        break;
                    case IDENTIFIER:
                        identification_variable();
                        break;
                    default:
                        jj_la1[32] = jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void constructor_expression() throws ParseException {
        /*@bgen(jjtree) CONSTRUCTOR */
        MQLCONSTRUCTOR jjtn000 = new MQLCONSTRUCTOR(this, JJTCONSTRUCTOR);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(NEW);
            classname();
            constructor_parameters();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void classname() throws ParseException {
        /*@bgen(jjtree) CLASSNAME */
        MQLCLASSNAME jjtn000 = new MQLCLASSNAME(this, JJTCLASSNAME);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            identification_variable();
            label_8:
            while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case DOT:
                        ;
                        break;
                    default:
                        jj_la1[33] = jj_gen;
                        break label_8;
                }
                jj_consume_token(DOT);
                identification_variable();
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void constructor_parameters() throws ParseException {
        /*@bgen(jjtree) CONSTRUCTORPARAMS */
        MQLCONSTRUCTORPARAMS jjtn000 = new MQLCONSTRUCTORPARAMS(this, JJTCONSTRUCTORPARAMS);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(87);
            constructor_parameter();
            label_9:
            while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case COMMA:
                        ;
                        break;
                    default:
                        jj_la1[34] = jj_gen;
                        break label_9;
                }
                jj_consume_token(COMMA);
                constructor_parameter();
            }
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void constructor_parameter() throws ParseException {
        /*@bgen(jjtree) CONSTRUCTORPARAM */
        MQLCONSTRUCTORPARAM jjtn000 = new MQLCONSTRUCTORPARAM(this, JJTCONSTRUCTORPARAM);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case IDENTIFIER:
                    path();
                    break;
                case AVG:
                case MIN:
                case MAX:
                case SUM:
                case COUNT:
                    aggregate_select_expression();
                    break;
                default:
                    jj_la1[35] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    /* rewritten to reduce lookaheads */
    final public void aggregate_select_expression() throws ParseException {
        /*@bgen(jjtree) AGGREGATE */
        MQLAGGREGATE jjtn000 = new MQLAGGREGATE(this, JJTAGGREGATE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case AVG:
                    avg();
                    break;
                case MAX:
                    max();
                    break;
                case MIN:
                    min();
                    break;
                case SUM:
                    sum();
                    break;
                case COUNT:
                    count();
                    break;
                default:
                    jj_la1[36] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void distinct() throws ParseException {
        /*@bgen(jjtree) DISTINCT */
        MQLDISTINCT jjtn000 = new MQLDISTINCT(this, JJTDISTINCT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(DISTINCT);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void aggregate_path() throws ParseException {
        jj_consume_token(87);
        if (jj_2_17(2147483647)) {
            arithmetic_expression();
        } else if (jj_2_18(2147483647)) {
            distinct_path();
        } else if (jj_2_19(2147483647)) {
            path();
        } else if (jj_2_20(2147483647)) {
            identification_variable();
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
        jj_consume_token(88);
    }

    final public void distinct_path() throws ParseException {
        /*@bgen(jjtree) DISTINCTPATH */
        MQLDISTINCTPATH jjtn000 = new MQLDISTINCTPATH(this, JJTDISTINCTPATH);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(DISTINCT);
            if (jj_2_21(2147483647)) {
                path();
            } else {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case IDENTIFIER:
                        identification_variable();
                        break;
                    default:
                        jj_la1[37] = jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void count() throws ParseException {
        /*@bgen(jjtree) COUNT */
        MQLCOUNT jjtn000 = new MQLCOUNT(this, JJTCOUNT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(COUNT);
            jj_consume_token(87);
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case TIMES:
                    jj_consume_token(TIMES);
                    break;
                default:
                    jj_la1[38] = jj_gen;
                    ;
            }
            jj_consume_token(88);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void avg() throws ParseException {
        /*@bgen(jjtree) AVERAGE */
        MQLAVERAGE jjtn000 = new MQLAVERAGE(this, JJTAVERAGE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(AVG);
            aggregate_path();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void max() throws ParseException {
        /*@bgen(jjtree) MAX */
        MQLMAX jjtn000 = new MQLMAX(this, JJTMAX);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(MAX);
            aggregate_path();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void min() throws ParseException {
        /*@bgen(jjtree) MIN */
        MQLMIN jjtn000 = new MQLMIN(this, JJTMIN);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(MIN);
            aggregate_path();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void sum() throws ParseException {
        /*@bgen(jjtree) SUM */
        MQLSUM jjtn000 = new MQLSUM(this, JJTSUM);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(SUM);
            aggregate_path();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void where_clause() throws ParseException {
        /*@bgen(jjtree) WHERE */
        MQLWHERE jjtn000 = new MQLWHERE(this, JJTWHERE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(WHERE);
            conditional_expression();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void groupby_clause() throws ParseException {
        /*@bgen(jjtree) GROUPBY */
        MQLGROUPBY jjtn000 = new MQLGROUPBY(this, JJTGROUPBY);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(GROUP);
            jj_consume_token(BY);
            groupby_item();
            label_10:
            while (true) {
                if (jj_2_22(2)) {
                    ;
                } else {
                    break label_10;
                }
                jj_consume_token(COMMA);
                groupby_item();
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void groupby_item() throws ParseException {
        if (jj_2_23(2147483647)) {
            path();
        } else {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case IDENTIFIER:
                    identification_variable();
                    break;
                case CONCAT:
                case SUBSTRING:
                case TRIM:
                case LOWER:
                case UPPER:
                case LENGTH:
                case LOCATE:
                case ABS:
                case SQRT:
                case MOD:
                case SIZE:
                case CURRENT_DATE:
                case CURRENT_TIME:
                case CURRENT_TIMESTAMP:
                    groupby_extension();
                    break;
                default:
                    jj_la1[39] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    final public void groupby_extension() throws ParseException {
        /*@bgen(jjtree) GROUPBYEXTENSION */
        MQLGROUPBYEXTENSION jjtn000 = new MQLGROUPBYEXTENSION(this, JJTGROUPBYEXTENSION);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            scalar_function();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void having_clause() throws ParseException {
        /*@bgen(jjtree) HAVING */
        MQLHAVING jjtn000 = new MQLHAVING(this, JJTHAVING);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(HAVING);
            conditional_expression();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void subquery() throws ParseException {
        /*@bgen(jjtree) SUBSELECT */
        MQLSUBSELECT jjtn000 = new MQLSUBSELECT(this, JJTSUBSELECT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            simple_select_clause();
            subquery_from_clause();
            if (jj_2_24(2147483647)) {
                where_clause();
            } else {
                ;
            }
            if (jj_2_25(2147483647)) {
                groupby_clause();
            } else {
                ;
            }
            if (jj_2_26(2147483647)) {
                having_clause();
            } else {
                ;
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    /* changed to eliminate left recursion */
    final public void conditional_expression() throws ParseException {
        conditional_term();
        label_11:
        while (true) {
            if (jj_2_27(2)) {
                ;
            } else {
                break label_11;
            }
            jj_consume_token(OR);
            MQLOR jjtn001 = new MQLOR(this, JJTOR);
            boolean jjtc001 = true;
            jjtree.openNodeScope(jjtn001);
            try {
                conditional_expression();
            } catch (Throwable jjte001) {
                if (jjtc001) {
                    jjtree.clearNodeScope(jjtn001);
                    jjtc001 = false;
                } else {
                    jjtree.popNode();
                }
                if (jjte001 instanceof RuntimeException) {
                    {
                        if (true) throw (RuntimeException) jjte001;
                    }
                }
                if (jjte001 instanceof ParseException) {
                    {
                        if (true) throw (ParseException) jjte001;
                    }
                }
                {
                    if (true) throw (Error) jjte001;
                }
            } finally {
                if (jjtc001) {
                    jjtree.closeNodeScope(jjtn001, 2);
                }
            }
        }
    }

    /* changed to eliminate left recursion */
    final public void conditional_term() throws ParseException {
        conditional_factor();
        label_12:
        while (true) {
            if (jj_2_28(2)) {
                ;
            } else {
                break label_12;
            }
            jj_consume_token(AND);
            MQLAND jjtn001 = new MQLAND(this, JJTAND);
            boolean jjtc001 = true;
            jjtree.openNodeScope(jjtn001);
            try {
                conditional_term();
            } catch (Throwable jjte001) {
                if (jjtc001) {
                    jjtree.clearNodeScope(jjtn001);
                    jjtc001 = false;
                } else {
                    jjtree.popNode();
                }
                if (jjte001 instanceof RuntimeException) {
                    {
                        if (true) throw (RuntimeException) jjte001;
                    }
                }
                if (jjte001 instanceof ParseException) {
                    {
                        if (true) throw (ParseException) jjte001;
                    }
                }
                {
                    if (true) throw (Error) jjte001;
                }
            } finally {
                if (jjtc001) {
                    jjtree.closeNodeScope(jjtn001, 2);
                }
            }
        }
    }

    final public void conditional_factor() throws ParseException {
        if (jj_2_29(2147483647)) {
            jj_consume_token(NOT);
            MQLNOT jjtn001 = new MQLNOT(this, JJTNOT);
            boolean jjtc001 = true;
            jjtree.openNodeScope(jjtn001);
            try {
                conditional_primary();
            } catch (Throwable jjte001) {
                if (jjtc001) {
                    jjtree.clearNodeScope(jjtn001);
                    jjtc001 = false;
                } else {
                    jjtree.popNode();
                }
                if (jjte001 instanceof RuntimeException) {
                    {
                        if (true) throw (RuntimeException) jjte001;
                    }
                }
                if (jjte001 instanceof ParseException) {
                    {
                        if (true) throw (ParseException) jjte001;
                    }
                }
                {
                    if (true) throw (Error) jjte001;
                }
            } finally {
                if (jjtc001) {
                    jjtree.closeNodeScope(jjtn001, true);
                }
            }
        } else {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case PLUS:
                case MINUS:
                case NEW:
                case ALL:
                case ANY:
                case EXISTS:
                case SOME:
                case EMPTY:
                case ASC:
                case DESC:
                case ORDER:
                case BY:
                case IS:
                case MEMBER:
                case OF:
                case LIKE:
                case ESCAPE:
                case BETWEEN:
                case NULL:
                case AVG:
                case MIN:
                case MAX:
                case SUM:
                case COUNT:
                case OR:
                case AND:
                case NOT:
                case CONCAT:
                case SUBSTRING:
                case TRIM:
                case LOWER:
                case UPPER:
                case LEADING:
                case TRAILING:
                case BOTH:
                case LENGTH:
                case LOCATE:
                case ABS:
                case SQRT:
                case MOD:
                case SIZE:
                case CURRENT_DATE:
                case CURRENT_TIME:
                case CURRENT_TIMESTAMP:
                case SELECT:
                case DISTINCT:
                case FROM:
                case UPDATE:
                case DELETE:
                case WHERE:
                case GROUP:
                case HAVING:
                case AS:
                case LEFT:
                case OUTER:
                case INNER:
                case JOIN:
                case FETCH:
                case IN:
                case SET:
                case OBJECT:
                case INTEGER_LITERAL:
                case DECIMAL_LITERAL:
                case STRING_LITERAL:
                case BOOLEAN_LITERAL:
                case IDENTIFIER:
                case 87:
                case 89:
                case 90:
                    conditional_primary();
                    break;
                default:
                    jj_la1[40] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    final public void conditional_primary() throws ParseException {
        if (jj_2_30(2147483647)) {
            simple_cond_expression();
        } else {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case 87:
                    jj_consume_token(87);
                    conditional_expression();
                    jj_consume_token(88);
                    break;
                default:
                    jj_la1[41] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    final public void simple_cond_expression() throws ParseException {
        if (jj_2_31(2147483647)) {
            exists_expression();
        } else if (jj_2_32(2147483647)) {
            comparison_expression();
        } else if (jj_2_33(2147483647)) {
            between_expression();
        } else if (jj_2_34(2147483647)) {
            like_expression();
        } else if (jj_2_35(2147483647)) {
            in_expression();
        } else if (jj_2_36(2147483647)) {
            null_comparison_expression();
        } else if (jj_2_37(2147483647)) {
            empty_collection_comparison_expression();
        } else if (jj_2_38(2147483647)) {
            collection_member_expression();
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    final public void between_expression() throws ParseException {
        /*@bgen(jjtree) BETWEEN */
        MQLBETWEEN jjtn000 = new MQLBETWEEN(this, JJTBETWEEN);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            if (jj_2_39(6)) {
                arithmetic_expression();
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case NOT:
                        jj_consume_token(NOT);
                        jjtn000.not = true;
                        break;
                    default:
                        jj_la1[42] = jj_gen;
                        ;
                }
                jj_consume_token(BETWEEN);
                arithmetic_expression();
                jj_consume_token(AND);
                arithmetic_expression();
            } else if (jj_2_40(6)) {
                string_expression();
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case NOT:
                        jj_consume_token(NOT);
                        jjtn000.not = true;
                        break;
                    default:
                        jj_la1[43] = jj_gen;
                        ;
                }
                jj_consume_token(BETWEEN);
                string_expression();
                jj_consume_token(AND);
                string_expression();
            } else if (jj_2_41(6)) {
                datetime_expression();
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case NOT:
                        jj_consume_token(NOT);
                        jjtn000.not = true;
                        break;
                    default:
                        jj_la1[44] = jj_gen;
                        ;
                }
                jj_consume_token(BETWEEN);
                datetime_expression();
                jj_consume_token(AND);
                datetime_expression();
            } else {
                jj_consume_token(-1);
                throw new ParseException();
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void in_expression() throws ParseException {
        /*@bgen(jjtree) IN */
        MQLIN jjtn000 = new MQLIN(this, JJTIN);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            path();
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case NOT:
                    jj_consume_token(NOT);
                    jjtn000.not = true;
                    break;
                default:
                    jj_la1[45] = jj_gen;
                    ;
            }
            jj_consume_token(IN);
            jj_consume_token(87);
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case PLUS:
                case MINUS:
                case INTEGER_LITERAL:
                case DECIMAL_LITERAL:
                case STRING_LITERAL:
                case BOOLEAN_LITERAL:
                case 89:
                case 90:
                    literal_or_param();
                    label_13:
                    while (true) {
                        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                            case COMMA:
                                ;
                                break;
                            default:
                                jj_la1[46] = jj_gen;
                                break label_13;
                        }
                        jj_consume_token(COMMA);
                        literal_or_param();
                    }
                    break;
                case SELECT:
                    subquery();
                    break;
                default:
                    jj_la1[47] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void literal_or_param() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case PLUS:
            case MINUS:
            case INTEGER_LITERAL:
            case DECIMAL_LITERAL:
                numeric_literal();
                break;
            case STRING_LITERAL:
                string_literal();
                break;
            case BOOLEAN_LITERAL:
                boolean_literal();
                break;
            case 89:
            case 90:
                input_parameter();
                break;
            default:
                jj_la1[48] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void like_expression() throws ParseException {
        /*@bgen(jjtree) LIKE */
        MQLLIKE jjtn000 = new MQLLIKE(this, JJTLIKE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            string_expression();
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case NOT:
                    jj_consume_token(NOT);
                    jjtn000.not = true;
                    break;
                default:
                    jj_la1[49] = jj_gen;
                    ;
            }
            jj_consume_token(LIKE);
            pattern_value();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void null_comparison_expression() throws ParseException {
        /*@bgen(jjtree) ISNULL */
        MQLISNULL jjtn000 = new MQLISNULL(this, JJTISNULL);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case 89:
                case 90:
                    input_parameter();
                    break;
                case IDENTIFIER:
                    path();
                    break;
                default:
                    jj_la1[50] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
            jj_consume_token(IS);
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case NOT:
                    jj_consume_token(NOT);
                    jjtn000.not = true;
                    break;
                default:
                    jj_la1[51] = jj_gen;
                    ;
            }
            jj_consume_token(NULL);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void empty_collection_comparison_expression() throws ParseException {
        /*@bgen(jjtree) ISEMPTY */
        MQLISEMPTY jjtn000 = new MQLISEMPTY(this, JJTISEMPTY);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            path();
            jj_consume_token(IS);
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case NOT:
                    jj_consume_token(NOT);
                    jjtn000.not = true;
                    break;
                default:
                    jj_la1[52] = jj_gen;
                    ;
            }
            jj_consume_token(EMPTY);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void collection_member_expression() throws ParseException {
        /*@bgen(jjtree) MEMBEROF */
        MQLMEMBEROF jjtn000 = new MQLMEMBEROF(this, JJTMEMBEROF);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            if (jj_2_42(2147483647)) {
                path();
            } else {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case 89:
                    case 90:
                        input_parameter();
                        break;
                    case NEW:
                    case ALL:
                    case ANY:
                    case EXISTS:
                    case SOME:
                    case EMPTY:
                    case ASC:
                    case DESC:
                    case ORDER:
                    case BY:
                    case IS:
                    case MEMBER:
                    case OF:
                    case LIKE:
                    case ESCAPE:
                    case BETWEEN:
                    case NULL:
                    case AVG:
                    case MIN:
                    case MAX:
                    case SUM:
                    case COUNT:
                    case OR:
                    case AND:
                    case NOT:
                    case CONCAT:
                    case SUBSTRING:
                    case TRIM:
                    case LOWER:
                    case UPPER:
                    case LEADING:
                    case TRAILING:
                    case BOTH:
                    case LENGTH:
                    case LOCATE:
                    case ABS:
                    case SQRT:
                    case MOD:
                    case SIZE:
                    case CURRENT_DATE:
                    case CURRENT_TIME:
                    case CURRENT_TIMESTAMP:
                    case SELECT:
                    case DISTINCT:
                    case FROM:
                    case UPDATE:
                    case DELETE:
                    case WHERE:
                    case GROUP:
                    case HAVING:
                    case AS:
                    case LEFT:
                    case OUTER:
                    case INNER:
                    case JOIN:
                    case FETCH:
                    case IN:
                    case SET:
                    case OBJECT:
                    case IDENTIFIER:
                        path_component();
                        break;
                    default:
                        jj_la1[53] = jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case NOT:
                    jj_consume_token(NOT);
                    jjtn000.not = true;
                    break;
                default:
                    jj_la1[54] = jj_gen;
                    ;
            }
            jj_consume_token(MEMBER);
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case OF:
                    jj_consume_token(OF);
                    break;
                default:
                    jj_la1[55] = jj_gen;
                    ;
            }
            path();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void exists_expression() throws ParseException {
        /*@bgen(jjtree) EXISTS */
        MQLEXISTS jjtn000 = new MQLEXISTS(this, JJTEXISTS);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case NOT:
                    jj_consume_token(NOT);
                    jjtn000.not = true;
                    break;
                default:
                    jj_la1[56] = jj_gen;
                    ;
            }
            jj_consume_token(EXISTS);
            jj_consume_token(87);
            subquery();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void all_or_any_expression() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case ANY:
                any_expression();
                break;
            case SOME:
                some_expression();
                break;
            case ALL:
                all_expression();
                break;
            default:
                jj_la1[57] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void any_expression() throws ParseException {
        /*@bgen(jjtree) ANY */
        MQLANY jjtn000 = new MQLANY(this, JJTANY);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(ANY);
            jj_consume_token(87);
            subquery();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void some_expression() throws ParseException {
        /*@bgen(jjtree) ANY */
        MQLANY jjtn000 = new MQLANY(this, JJTANY);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(SOME);
            jj_consume_token(87);
            subquery();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void all_expression() throws ParseException {
        /*@bgen(jjtree) ALL */
        MQLALL jjtn000 = new MQLALL(this, JJTALL);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(ALL);
            jj_consume_token(87);
            subquery();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void comparison_expression() throws ParseException {
        if (jj_2_43(2147483647)) {
            arithmetic_comp();
        } else if (jj_2_44(2147483647)) {
            string_comp();
        } else if (jj_2_45(2147483647)) {
            boolean_comp();
        } else if (jj_2_46(2147483647)) {
            enum_comp();
        } else if (jj_2_47(2147483647)) {
            datetime_comp();
        } else if (jj_2_48(2147483647)) {
            entity_comp();
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    final public void string_comp() throws ParseException {
        string_expression();
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case EQ:
                jj_consume_token(EQ);
                MQLEQUALS jjtn001 = new MQLEQUALS(this, JJTEQUALS);
                boolean jjtc001 = true;
                jjtree.openNodeScope(jjtn001);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CONCAT:
                        case SUBSTRING:
                        case TRIM:
                        case LOWER:
                        case UPPER:
                        case STRING_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            string_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[58] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte001) {
                    if (jjtc001) {
                        jjtree.clearNodeScope(jjtn001);
                        jjtc001 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte001 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte001;
                        }
                    }
                    if (jjte001 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte001;
                        }
                    }
                    {
                        if (true) throw (Error) jjte001;
                    }
                } finally {
                    if (jjtc001) {
                        jjtree.closeNodeScope(jjtn001, 2);
                    }
                }
                break;
            case NE:
                jj_consume_token(NE);
                MQLNOTEQUALS jjtn002 = new MQLNOTEQUALS(this, JJTNOTEQUALS);
                boolean jjtc002 = true;
                jjtree.openNodeScope(jjtn002);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CONCAT:
                        case SUBSTRING:
                        case TRIM:
                        case LOWER:
                        case UPPER:
                        case STRING_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            string_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[59] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte002) {
                    if (jjtc002) {
                        jjtree.clearNodeScope(jjtn002);
                        jjtc002 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte002 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte002;
                        }
                    }
                    if (jjte002 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte002;
                        }
                    }
                    {
                        if (true) throw (Error) jjte002;
                    }
                } finally {
                    if (jjtc002) {
                        jjtree.closeNodeScope(jjtn002, 2);
                    }
                }
                break;
            case GT:
                jj_consume_token(GT);
                MQLGREATERTHAN jjtn003 = new MQLGREATERTHAN(this, JJTGREATERTHAN);
                boolean jjtc003 = true;
                jjtree.openNodeScope(jjtn003);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CONCAT:
                        case SUBSTRING:
                        case TRIM:
                        case LOWER:
                        case UPPER:
                        case STRING_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            string_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[60] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte003) {
                    if (jjtc003) {
                        jjtree.clearNodeScope(jjtn003);
                        jjtc003 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte003 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte003;
                        }
                    }
                    if (jjte003 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte003;
                        }
                    }
                    {
                        if (true) throw (Error) jjte003;
                    }
                } finally {
                    if (jjtc003) {
                        jjtree.closeNodeScope(jjtn003, 2);
                    }
                }
                break;
            case GE:
                jj_consume_token(GE);
                MQLGREATEROREQUAL jjtn004 = new MQLGREATEROREQUAL(this, JJTGREATEROREQUAL);
                boolean jjtc004 = true;
                jjtree.openNodeScope(jjtn004);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CONCAT:
                        case SUBSTRING:
                        case TRIM:
                        case LOWER:
                        case UPPER:
                        case STRING_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            string_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[61] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte004) {
                    if (jjtc004) {
                        jjtree.clearNodeScope(jjtn004);
                        jjtc004 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte004 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte004;
                        }
                    }
                    if (jjte004 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte004;
                        }
                    }
                    {
                        if (true) throw (Error) jjte004;
                    }
                } finally {
                    if (jjtc004) {
                        jjtree.closeNodeScope(jjtn004, 2);
                    }
                }
                break;
            case LT:
                jj_consume_token(LT);
                MQLLESSTHAN jjtn005 = new MQLLESSTHAN(this, JJTLESSTHAN);
                boolean jjtc005 = true;
                jjtree.openNodeScope(jjtn005);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CONCAT:
                        case SUBSTRING:
                        case TRIM:
                        case LOWER:
                        case UPPER:
                        case STRING_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            string_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[62] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte005) {
                    if (jjtc005) {
                        jjtree.clearNodeScope(jjtn005);
                        jjtc005 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte005 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte005;
                        }
                    }
                    if (jjte005 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte005;
                        }
                    }
                    {
                        if (true) throw (Error) jjte005;
                    }
                } finally {
                    if (jjtc005) {
                        jjtree.closeNodeScope(jjtn005, 2);
                    }
                }
                break;
            case LE:
                jj_consume_token(LE);
                MQLLESSOREQUAL jjtn006 = new MQLLESSOREQUAL(this, JJTLESSOREQUAL);
                boolean jjtc006 = true;
                jjtree.openNodeScope(jjtn006);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CONCAT:
                        case SUBSTRING:
                        case TRIM:
                        case LOWER:
                        case UPPER:
                        case STRING_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            string_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[63] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte006) {
                    if (jjtc006) {
                        jjtree.clearNodeScope(jjtn006);
                        jjtc006 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte006 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte006;
                        }
                    }
                    if (jjte006 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte006;
                        }
                    }
                    {
                        if (true) throw (Error) jjte006;
                    }
                } finally {
                    if (jjtc006) {
                        jjtree.closeNodeScope(jjtn006, 2);
                    }
                }
                break;
            default:
                jj_la1[64] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void boolean_comp() throws ParseException {
        boolean_expression();
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case EQ:
                jj_consume_token(EQ);
                MQLEQUALS jjtn001 = new MQLEQUALS(this, JJTEQUALS);
                boolean jjtc001 = true;
                jjtree.openNodeScope(jjtn001);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case BOOLEAN_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            boolean_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[65] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte001) {
                    if (jjtc001) {
                        jjtree.clearNodeScope(jjtn001);
                        jjtc001 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte001 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte001;
                        }
                    }
                    if (jjte001 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte001;
                        }
                    }
                    {
                        if (true) throw (Error) jjte001;
                    }
                } finally {
                    if (jjtc001) {
                        jjtree.closeNodeScope(jjtn001, 2);
                    }
                }
                break;
            case NE:
                jj_consume_token(NE);
                MQLNOTEQUALS jjtn002 = new MQLNOTEQUALS(this, JJTNOTEQUALS);
                boolean jjtc002 = true;
                jjtree.openNodeScope(jjtn002);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case BOOLEAN_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            boolean_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[66] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte002) {
                    if (jjtc002) {
                        jjtree.clearNodeScope(jjtn002);
                        jjtc002 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte002 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte002;
                        }
                    }
                    if (jjte002 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte002;
                        }
                    }
                    {
                        if (true) throw (Error) jjte002;
                    }
                } finally {
                    if (jjtc002) {
                        jjtree.closeNodeScope(jjtn002, 2);
                    }
                }
                break;
            default:
                jj_la1[67] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void enum_comp() throws ParseException {
        enum_expression();
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case EQ:
                jj_consume_token(EQ);
                MQLEQUALS jjtn001 = new MQLEQUALS(this, JJTEQUALS);
                boolean jjtc001 = true;
                jjtree.openNodeScope(jjtn001);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            enum_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[68] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte001) {
                    if (jjtc001) {
                        jjtree.clearNodeScope(jjtn001);
                        jjtc001 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte001 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte001;
                        }
                    }
                    if (jjte001 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte001;
                        }
                    }
                    {
                        if (true) throw (Error) jjte001;
                    }
                } finally {
                    if (jjtc001) {
                        jjtree.closeNodeScope(jjtn001, 2);
                    }
                }
                break;
            case NE:
                jj_consume_token(NE);
                MQLNOTEQUALS jjtn002 = new MQLNOTEQUALS(this, JJTNOTEQUALS);
                boolean jjtc002 = true;
                jjtree.openNodeScope(jjtn002);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            enum_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[69] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte002) {
                    if (jjtc002) {
                        jjtree.clearNodeScope(jjtn002);
                        jjtc002 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte002 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte002;
                        }
                    }
                    if (jjte002 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte002;
                        }
                    }
                    {
                        if (true) throw (Error) jjte002;
                    }
                } finally {
                    if (jjtc002) {
                        jjtree.closeNodeScope(jjtn002, 2);
                    }
                }
                break;
            default:
                jj_la1[70] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void entity_comp() throws ParseException {
        entity_bean_expression();
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case EQ:
                jj_consume_token(EQ);
                MQLEQUALS jjtn001 = new MQLEQUALS(this, JJTEQUALS);
                boolean jjtc001 = true;
                jjtree.openNodeScope(jjtn001);
                try {
                    if (jj_2_49(2147483647)) {
                        all_or_any_expression();
                    } else {
                        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                            case NEW:
                            case ALL:
                            case ANY:
                            case EXISTS:
                            case SOME:
                            case EMPTY:
                            case ASC:
                            case DESC:
                            case ORDER:
                            case BY:
                            case IS:
                            case MEMBER:
                            case OF:
                            case LIKE:
                            case ESCAPE:
                            case BETWEEN:
                            case NULL:
                            case AVG:
                            case MIN:
                            case MAX:
                            case SUM:
                            case COUNT:
                            case OR:
                            case AND:
                            case NOT:
                            case CONCAT:
                            case SUBSTRING:
                            case TRIM:
                            case LOWER:
                            case UPPER:
                            case LEADING:
                            case TRAILING:
                            case BOTH:
                            case LENGTH:
                            case LOCATE:
                            case ABS:
                            case SQRT:
                            case MOD:
                            case SIZE:
                            case CURRENT_DATE:
                            case CURRENT_TIME:
                            case CURRENT_TIMESTAMP:
                            case SELECT:
                            case DISTINCT:
                            case FROM:
                            case UPDATE:
                            case DELETE:
                            case WHERE:
                            case GROUP:
                            case HAVING:
                            case AS:
                            case LEFT:
                            case OUTER:
                            case INNER:
                            case JOIN:
                            case FETCH:
                            case IN:
                            case SET:
                            case OBJECT:
                            case IDENTIFIER:
                            case 89:
                            case 90:
                                entity_bean_expression();
                                break;
                            default:
                                jj_la1[71] = jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                        }
                    }
                } catch (Throwable jjte001) {
                    if (jjtc001) {
                        jjtree.clearNodeScope(jjtn001);
                        jjtc001 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte001 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte001;
                        }
                    }
                    if (jjte001 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte001;
                        }
                    }
                    {
                        if (true) throw (Error) jjte001;
                    }
                } finally {
                    if (jjtc001) {
                        jjtree.closeNodeScope(jjtn001, 2);
                    }
                }
                break;
            case NE:
                jj_consume_token(NE);
                MQLNOTEQUALS jjtn002 = new MQLNOTEQUALS(this, JJTNOTEQUALS);
                boolean jjtc002 = true;
                jjtree.openNodeScope(jjtn002);
                try {
                    if (jj_2_50(2147483647)) {
                        all_or_any_expression();
                    } else {
                        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                            case NEW:
                            case ALL:
                            case ANY:
                            case EXISTS:
                            case SOME:
                            case EMPTY:
                            case ASC:
                            case DESC:
                            case ORDER:
                            case BY:
                            case IS:
                            case MEMBER:
                            case OF:
                            case LIKE:
                            case ESCAPE:
                            case BETWEEN:
                            case NULL:
                            case AVG:
                            case MIN:
                            case MAX:
                            case SUM:
                            case COUNT:
                            case OR:
                            case AND:
                            case NOT:
                            case CONCAT:
                            case SUBSTRING:
                            case TRIM:
                            case LOWER:
                            case UPPER:
                            case LEADING:
                            case TRAILING:
                            case BOTH:
                            case LENGTH:
                            case LOCATE:
                            case ABS:
                            case SQRT:
                            case MOD:
                            case SIZE:
                            case CURRENT_DATE:
                            case CURRENT_TIME:
                            case CURRENT_TIMESTAMP:
                            case SELECT:
                            case DISTINCT:
                            case FROM:
                            case UPDATE:
                            case DELETE:
                            case WHERE:
                            case GROUP:
                            case HAVING:
                            case AS:
                            case LEFT:
                            case OUTER:
                            case INNER:
                            case JOIN:
                            case FETCH:
                            case IN:
                            case SET:
                            case OBJECT:
                            case IDENTIFIER:
                            case 89:
                            case 90:
                                entity_bean_expression();
                                break;
                            default:
                                jj_la1[72] = jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                        }
                    }
                } catch (Throwable jjte002) {
                    if (jjtc002) {
                        jjtree.clearNodeScope(jjtn002);
                        jjtc002 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte002 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte002;
                        }
                    }
                    if (jjte002 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte002;
                        }
                    }
                    {
                        if (true) throw (Error) jjte002;
                    }
                } finally {
                    if (jjtc002) {
                        jjtree.closeNodeScope(jjtn002, 2);
                    }
                }
                break;
            default:
                jj_la1[73] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void arithmetic_comp() throws ParseException {
        arithmetic_expression();
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case EQ:
                jj_consume_token(EQ);
                MQLEQUALS jjtn001 = new MQLEQUALS(this, JJTEQUALS);
                boolean jjtc001 = true;
                jjtree.openNodeScope(jjtn001);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case PLUS:
                        case MINUS:
                        case AVG:
                        case MIN:
                        case MAX:
                        case SUM:
                        case COUNT:
                        case LENGTH:
                        case LOCATE:
                        case ABS:
                        case SQRT:
                        case MOD:
                        case SIZE:
                        case SELECT:
                        case INTEGER_LITERAL:
                        case DECIMAL_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            arithmetic_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[74] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte001) {
                    if (jjtc001) {
                        jjtree.clearNodeScope(jjtn001);
                        jjtc001 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte001 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte001;
                        }
                    }
                    if (jjte001 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte001;
                        }
                    }
                    {
                        if (true) throw (Error) jjte001;
                    }
                } finally {
                    if (jjtc001) {
                        jjtree.closeNodeScope(jjtn001, 2);
                    }
                }
                break;
            case GT:
                jj_consume_token(GT);
                MQLGREATERTHAN jjtn002 = new MQLGREATERTHAN(this, JJTGREATERTHAN);
                boolean jjtc002 = true;
                jjtree.openNodeScope(jjtn002);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case PLUS:
                        case MINUS:
                        case AVG:
                        case MIN:
                        case MAX:
                        case SUM:
                        case COUNT:
                        case LENGTH:
                        case LOCATE:
                        case ABS:
                        case SQRT:
                        case MOD:
                        case SIZE:
                        case SELECT:
                        case INTEGER_LITERAL:
                        case DECIMAL_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            arithmetic_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[75] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte002) {
                    if (jjtc002) {
                        jjtree.clearNodeScope(jjtn002);
                        jjtc002 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte002 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte002;
                        }
                    }
                    if (jjte002 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte002;
                        }
                    }
                    {
                        if (true) throw (Error) jjte002;
                    }
                } finally {
                    if (jjtc002) {
                        jjtree.closeNodeScope(jjtn002, 2);
                    }
                }
                break;
            case GE:
                jj_consume_token(GE);
                MQLGREATEROREQUAL jjtn003 = new MQLGREATEROREQUAL(this, JJTGREATEROREQUAL);
                boolean jjtc003 = true;
                jjtree.openNodeScope(jjtn003);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case PLUS:
                        case MINUS:
                        case AVG:
                        case MIN:
                        case MAX:
                        case SUM:
                        case COUNT:
                        case LENGTH:
                        case LOCATE:
                        case ABS:
                        case SQRT:
                        case MOD:
                        case SIZE:
                        case SELECT:
                        case INTEGER_LITERAL:
                        case DECIMAL_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            arithmetic_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[76] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte003) {
                    if (jjtc003) {
                        jjtree.clearNodeScope(jjtn003);
                        jjtc003 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte003 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte003;
                        }
                    }
                    if (jjte003 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte003;
                        }
                    }
                    {
                        if (true) throw (Error) jjte003;
                    }
                } finally {
                    if (jjtc003) {
                        jjtree.closeNodeScope(jjtn003, 2);
                    }
                }
                break;
            case LT:
                jj_consume_token(LT);
                MQLLESSTHAN jjtn004 = new MQLLESSTHAN(this, JJTLESSTHAN);
                boolean jjtc004 = true;
                jjtree.openNodeScope(jjtn004);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case PLUS:
                        case MINUS:
                        case AVG:
                        case MIN:
                        case MAX:
                        case SUM:
                        case COUNT:
                        case LENGTH:
                        case LOCATE:
                        case ABS:
                        case SQRT:
                        case MOD:
                        case SIZE:
                        case SELECT:
                        case INTEGER_LITERAL:
                        case DECIMAL_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            arithmetic_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[77] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte004) {
                    if (jjtc004) {
                        jjtree.clearNodeScope(jjtn004);
                        jjtc004 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte004 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte004;
                        }
                    }
                    if (jjte004 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte004;
                        }
                    }
                    {
                        if (true) throw (Error) jjte004;
                    }
                } finally {
                    if (jjtc004) {
                        jjtree.closeNodeScope(jjtn004, 2);
                    }
                }
                break;
            case LE:
                jj_consume_token(LE);
                MQLLESSOREQUAL jjtn005 = new MQLLESSOREQUAL(this, JJTLESSOREQUAL);
                boolean jjtc005 = true;
                jjtree.openNodeScope(jjtn005);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case PLUS:
                        case MINUS:
                        case AVG:
                        case MIN:
                        case MAX:
                        case SUM:
                        case COUNT:
                        case LENGTH:
                        case LOCATE:
                        case ABS:
                        case SQRT:
                        case MOD:
                        case SIZE:
                        case SELECT:
                        case INTEGER_LITERAL:
                        case DECIMAL_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            arithmetic_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[78] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte005) {
                    if (jjtc005) {
                        jjtree.clearNodeScope(jjtn005);
                        jjtc005 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte005 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte005;
                        }
                    }
                    if (jjte005 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte005;
                        }
                    }
                    {
                        if (true) throw (Error) jjte005;
                    }
                } finally {
                    if (jjtc005) {
                        jjtree.closeNodeScope(jjtn005, 2);
                    }
                }
                break;
            case NE:
                jj_consume_token(NE);
                MQLNOTEQUALS jjtn006 = new MQLNOTEQUALS(this, JJTNOTEQUALS);
                boolean jjtc006 = true;
                jjtree.openNodeScope(jjtn006);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case PLUS:
                        case MINUS:
                        case AVG:
                        case MIN:
                        case MAX:
                        case SUM:
                        case COUNT:
                        case LENGTH:
                        case LOCATE:
                        case ABS:
                        case SQRT:
                        case MOD:
                        case SIZE:
                        case SELECT:
                        case INTEGER_LITERAL:
                        case DECIMAL_LITERAL:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            arithmetic_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[79] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte006) {
                    if (jjtc006) {
                        jjtree.clearNodeScope(jjtn006);
                        jjtc006 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte006 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte006;
                        }
                    }
                    if (jjte006 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte006;
                        }
                    }
                    {
                        if (true) throw (Error) jjte006;
                    }
                } finally {
                    if (jjtc006) {
                        jjtree.closeNodeScope(jjtn006, 2);
                    }
                }
                break;
            default:
                jj_la1[80] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void datetime_comp() throws ParseException {
        datetime_expression();
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case EQ:
                jj_consume_token(EQ);
                MQLEQUALS jjtn001 = new MQLEQUALS(this, JJTEQUALS);
                boolean jjtc001 = true;
                jjtree.openNodeScope(jjtn001);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CURRENT_DATE:
                        case CURRENT_TIME:
                        case CURRENT_TIMESTAMP:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            datetime_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[81] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte001) {
                    if (jjtc001) {
                        jjtree.clearNodeScope(jjtn001);
                        jjtc001 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte001 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte001;
                        }
                    }
                    if (jjte001 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte001;
                        }
                    }
                    {
                        if (true) throw (Error) jjte001;
                    }
                } finally {
                    if (jjtc001) {
                        jjtree.closeNodeScope(jjtn001, 2);
                    }
                }
                break;
            case GT:
                jj_consume_token(GT);
                MQLGREATERTHAN jjtn002 = new MQLGREATERTHAN(this, JJTGREATERTHAN);
                boolean jjtc002 = true;
                jjtree.openNodeScope(jjtn002);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CURRENT_DATE:
                        case CURRENT_TIME:
                        case CURRENT_TIMESTAMP:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            datetime_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[82] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte002) {
                    if (jjtc002) {
                        jjtree.clearNodeScope(jjtn002);
                        jjtc002 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte002 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte002;
                        }
                    }
                    if (jjte002 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte002;
                        }
                    }
                    {
                        if (true) throw (Error) jjte002;
                    }
                } finally {
                    if (jjtc002) {
                        jjtree.closeNodeScope(jjtn002, 2);
                    }
                }
                break;
            case GE:
                jj_consume_token(GE);
                MQLGREATEROREQUAL jjtn003 = new MQLGREATEROREQUAL(this, JJTGREATEROREQUAL);
                boolean jjtc003 = true;
                jjtree.openNodeScope(jjtn003);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CURRENT_DATE:
                        case CURRENT_TIME:
                        case CURRENT_TIMESTAMP:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            datetime_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[83] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte003) {
                    if (jjtc003) {
                        jjtree.clearNodeScope(jjtn003);
                        jjtc003 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte003 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte003;
                        }
                    }
                    if (jjte003 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte003;
                        }
                    }
                    {
                        if (true) throw (Error) jjte003;
                    }
                } finally {
                    if (jjtc003) {
                        jjtree.closeNodeScope(jjtn003, 2);
                    }
                }
                break;
            case LT:
                jj_consume_token(LT);
                MQLLESSTHAN jjtn004 = new MQLLESSTHAN(this, JJTLESSTHAN);
                boolean jjtc004 = true;
                jjtree.openNodeScope(jjtn004);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CURRENT_DATE:
                        case CURRENT_TIME:
                        case CURRENT_TIMESTAMP:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            datetime_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[84] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte004) {
                    if (jjtc004) {
                        jjtree.clearNodeScope(jjtn004);
                        jjtc004 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte004 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte004;
                        }
                    }
                    if (jjte004 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte004;
                        }
                    }
                    {
                        if (true) throw (Error) jjte004;
                    }
                } finally {
                    if (jjtc004) {
                        jjtree.closeNodeScope(jjtn004, 2);
                    }
                }
                break;
            case LE:
                jj_consume_token(LE);
                MQLLESSOREQUAL jjtn005 = new MQLLESSOREQUAL(this, JJTLESSOREQUAL);
                boolean jjtc005 = true;
                jjtree.openNodeScope(jjtn005);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CURRENT_DATE:
                        case CURRENT_TIME:
                        case CURRENT_TIMESTAMP:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            datetime_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[85] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte005) {
                    if (jjtc005) {
                        jjtree.clearNodeScope(jjtn005);
                        jjtc005 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte005 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte005;
                        }
                    }
                    if (jjte005 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte005;
                        }
                    }
                    {
                        if (true) throw (Error) jjte005;
                    }
                } finally {
                    if (jjtc005) {
                        jjtree.closeNodeScope(jjtn005, 2);
                    }
                }
                break;
            case NE:
                jj_consume_token(NE);
                MQLNOTEQUALS jjtn006 = new MQLNOTEQUALS(this, JJTNOTEQUALS);
                boolean jjtc006 = true;
                jjtree.openNodeScope(jjtn006);
                try {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CURRENT_DATE:
                        case CURRENT_TIME:
                        case CURRENT_TIMESTAMP:
                        case IDENTIFIER:
                        case 87:
                        case 89:
                        case 90:
                            datetime_expression();
                            break;
                        case ALL:
                        case ANY:
                        case SOME:
                            all_or_any_expression();
                            break;
                        default:
                            jj_la1[86] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                } catch (Throwable jjte006) {
                    if (jjtc006) {
                        jjtree.clearNodeScope(jjtn006);
                        jjtc006 = false;
                    } else {
                        jjtree.popNode();
                    }
                    if (jjte006 instanceof RuntimeException) {
                        {
                            if (true) throw (RuntimeException) jjte006;
                        }
                    }
                    if (jjte006 instanceof ParseException) {
                        {
                            if (true) throw (ParseException) jjte006;
                        }
                    }
                    {
                        if (true) throw (Error) jjte006;
                    }
                } finally {
                    if (jjtc006) {
                        jjtree.closeNodeScope(jjtn006, 2);
                    }
                }
                break;
            default:
                jj_la1[87] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void scalar_function() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case LENGTH:
            case LOCATE:
            case ABS:
            case SQRT:
            case MOD:
            case SIZE:
                functions_returning_numerics();
                break;
            case CURRENT_DATE:
            case CURRENT_TIME:
            case CURRENT_TIMESTAMP:
                functions_returning_datetime();
                break;
            case CONCAT:
            case SUBSTRING:
            case TRIM:
            case LOWER:
            case UPPER:
                functions_returning_strings();
                break;
            default:
                jj_la1[88] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void arithmetic_value() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case IDENTIFIER:
                path();
                break;
            case LENGTH:
            case LOCATE:
            case ABS:
            case SQRT:
            case MOD:
            case SIZE:
                functions_returning_numerics();
                break;
            case 87:
                jj_consume_token(87);
                subquery();
                jj_consume_token(88);
                break;
            default:
                jj_la1[89] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    /* changed to eliminate left recursion */
    final public void arithmetic_expression() throws ParseException {
        arithmetic_term();
        label_14:
        while (true) {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case PLUS:
                case MINUS:
                    ;
                    break;
                default:
                    jj_la1[90] = jj_gen;
                    break label_14;
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case PLUS:
                    jj_consume_token(PLUS);
                    MQLADD jjtn001 = new MQLADD(this, JJTADD);
                    boolean jjtc001 = true;
                    jjtree.openNodeScope(jjtn001);
                    try {
                        arithmetic_expression();
                    } catch (Throwable jjte001) {
                        if (jjtc001) {
                            jjtree.clearNodeScope(jjtn001);
                            jjtc001 = false;
                        } else {
                            jjtree.popNode();
                        }
                        if (jjte001 instanceof RuntimeException) {
                            {
                                if (true) throw (RuntimeException) jjte001;
                            }
                        }
                        if (jjte001 instanceof ParseException) {
                            {
                                if (true) throw (ParseException) jjte001;
                            }
                        }
                        {
                            if (true) throw (Error) jjte001;
                        }
                    } finally {
                        if (jjtc001) {
                            jjtree.closeNodeScope(jjtn001, 2);
                        }
                    }
                    break;
                case MINUS:
                    jj_consume_token(MINUS);
                    MQLSUBTRACT jjtn002 = new MQLSUBTRACT(this, JJTSUBTRACT);
                    boolean jjtc002 = true;
                    jjtree.openNodeScope(jjtn002);
                    try {
                        arithmetic_expression();
                    } catch (Throwable jjte002) {
                        if (jjtc002) {
                            jjtree.clearNodeScope(jjtn002);
                            jjtc002 = false;
                        } else {
                            jjtree.popNode();
                        }
                        if (jjte002 instanceof RuntimeException) {
                            {
                                if (true) throw (RuntimeException) jjte002;
                            }
                        }
                        if (jjte002 instanceof ParseException) {
                            {
                                if (true) throw (ParseException) jjte002;
                            }
                        }
                        {
                            if (true) throw (Error) jjte002;
                        }
                    } finally {
                        if (jjtc002) {
                            jjtree.closeNodeScope(jjtn002, 2);
                        }
                    }
                    break;
                default:
                    jj_la1[91] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    /* changed to eliminate left recursion */
    final public void arithmetic_term() throws ParseException {
        arithmetic_factor();
        label_15:
        while (true) {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case TIMES:
                case DIV:
                    ;
                    break;
                default:
                    jj_la1[92] = jj_gen;
                    break label_15;
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case TIMES:
                    jj_consume_token(TIMES);
                    MQLMULTIPLY jjtn001 = new MQLMULTIPLY(this, JJTMULTIPLY);
                    boolean jjtc001 = true;
                    jjtree.openNodeScope(jjtn001);
                    try {
                        arithmetic_term();
                    } catch (Throwable jjte001) {
                        if (jjtc001) {
                            jjtree.clearNodeScope(jjtn001);
                            jjtc001 = false;
                        } else {
                            jjtree.popNode();
                        }
                        if (jjte001 instanceof RuntimeException) {
                            {
                                if (true) throw (RuntimeException) jjte001;
                            }
                        }
                        if (jjte001 instanceof ParseException) {
                            {
                                if (true) throw (ParseException) jjte001;
                            }
                        }
                        {
                            if (true) throw (Error) jjte001;
                        }
                    } finally {
                        if (jjtc001) {
                            jjtree.closeNodeScope(jjtn001, 2);
                        }
                    }
                    break;
                case DIV:
                    jj_consume_token(DIV);
                    MQLDIVIDE jjtn002 = new MQLDIVIDE(this, JJTDIVIDE);
                    boolean jjtc002 = true;
                    jjtree.openNodeScope(jjtn002);
                    try {
                        arithmetic_term();
                    } catch (Throwable jjte002) {
                        if (jjtc002) {
                            jjtree.clearNodeScope(jjtn002);
                            jjtc002 = false;
                        } else {
                            jjtree.popNode();
                        }
                        if (jjte002 instanceof RuntimeException) {
                            {
                                if (true) throw (RuntimeException) jjte002;
                            }
                        }
                        if (jjte002 instanceof ParseException) {
                            {
                                if (true) throw (ParseException) jjte002;
                            }
                        }
                        {
                            if (true) throw (Error) jjte002;
                        }
                    } finally {
                        if (jjtc002) {
                            jjtree.closeNodeScope(jjtn002, 2);
                        }
                    }
                    break;
                default:
                    jj_la1[93] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    final public void arithmetic_factor() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case PLUS:
            case MINUS:
            case INTEGER_LITERAL:
            case DECIMAL_LITERAL:
                numeric_literal();
                break;
            case 89:
            case 90:
                input_parameter();
                break;
            case IDENTIFIER:
                path();
                break;
            default:
                jj_la1[94] = jj_gen;
                if (jj_2_51(2)) {
                    jj_consume_token(87);
                    arithmetic_expression();
                    jj_consume_token(88);
                } else {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case LENGTH:
                        case LOCATE:
                        case ABS:
                        case SQRT:
                        case MOD:
                        case SIZE:
                            functions_returning_numerics();
                            break;
                        case AVG:
                        case MIN:
                        case MAX:
                        case SUM:
                        case COUNT:
                            aggregate_select_expression();
                            break;
                        case SELECT:
                            subquery();
                            break;
                        default:
                            jj_la1[95] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                }
        }
    }

    final public void negative() throws ParseException {
        /*@bgen(jjtree) NEGATIVE */
        MQLNEGATIVE jjtn000 = new MQLNEGATIVE(this, JJTNEGATIVE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(MINUS);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void string_value() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case IDENTIFIER:
                path();
                break;
            case CONCAT:
            case SUBSTRING:
            case TRIM:
            case LOWER:
            case UPPER:
                functions_returning_strings();
                break;
            case 87:
                jj_consume_token(87);
                subquery();
                jj_consume_token(88);
                break;
            default:
                jj_la1[96] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void string_expression() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case 89:
            case 90:
                input_parameter();
                break;
            case CONCAT:
            case SUBSTRING:
            case TRIM:
            case LOWER:
            case UPPER:
            case STRING_LITERAL:
            case IDENTIFIER:
            case 87:
                string_primary();
                break;
            default:
                jj_la1[97] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void string_primary() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case STRING_LITERAL:
                string_literal();
                break;
            case IDENTIFIER:
                path();
                break;
            default:
                jj_la1[98] = jj_gen;
                if (jj_2_52(2)) {
                    jj_consume_token(87);
                    string_expression();
                    jj_consume_token(88);
                } else {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case CONCAT:
                        case SUBSTRING:
                        case TRIM:
                        case LOWER:
                        case UPPER:
                            functions_returning_strings();
                            break;
                        default:
                            jj_la1[99] = jj_gen;
                            if (jj_2_53(2)) {
                                jj_consume_token(87);
                                subquery();
                                jj_consume_token(88);
                            } else {
                                jj_consume_token(-1);
                                throw new ParseException();
                            }
                    }
                }
        }
    }

    final public void datetime_expression() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case CURRENT_DATE:
            case CURRENT_TIME:
            case CURRENT_TIMESTAMP:
            case IDENTIFIER:
            case 89:
            case 90:
                datetime_primary();
                break;
            case 87:
                jj_consume_token(87);
                subquery();
                jj_consume_token(88);
                break;
            default:
                jj_la1[100] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void datetime_primary() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case IDENTIFIER:
                path();
                break;
            case CURRENT_DATE:
            case CURRENT_TIME:
            case CURRENT_TIMESTAMP:
                functions_returning_datetime();
                break;
            case 89:
            case 90:
                input_parameter();
                break;
            default:
                jj_la1[101] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void boolean_value() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case IDENTIFIER:
                path();
                break;
            case 87:
                jj_consume_token(87);
                subquery();
                jj_consume_token(88);
                break;
            default:
                jj_la1[102] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void boolean_expression() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case BOOLEAN_LITERAL:
            case IDENTIFIER:
            case 89:
            case 90:
                boolean_primary();
                break;
            case 87:
                jj_consume_token(87);
                subquery();
                jj_consume_token(88);
                break;
            default:
                jj_la1[103] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void boolean_primary() throws ParseException {
        if (jj_2_54(2)) {
            path();
        } else {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case BOOLEAN_LITERAL:
                    boolean_literal();
                    break;
                case 89:
                case 90:
                    input_parameter();
                    break;
                default:
                    jj_la1[104] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    final public void enum_expression() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case IDENTIFIER:
            case 89:
            case 90:
                enum_primary();
                break;
            case 87:
                jj_consume_token(87);
                subquery();
                jj_consume_token(88);
                break;
            default:
                jj_la1[105] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void enum_primary() throws ParseException {
        if (jj_2_55(2)) {
            path();
        } else if (jj_2_56(2147483647)) {
            enum_literal();
        } else if (jj_2_57(2147483647)) {
            input_parameter();
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    final public void enum_literal() throws ParseException {
        inEnumPath = true;
        path();
        inEnumPath = false;
    }

    final public void entity_bean_value() throws ParseException {
        if (jj_2_58(2147483647)) {
            path();
        } else {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case NEW:
                case ALL:
                case ANY:
                case EXISTS:
                case SOME:
                case EMPTY:
                case ASC:
                case DESC:
                case ORDER:
                case BY:
                case IS:
                case MEMBER:
                case OF:
                case LIKE:
                case ESCAPE:
                case BETWEEN:
                case NULL:
                case AVG:
                case MIN:
                case MAX:
                case SUM:
                case COUNT:
                case OR:
                case AND:
                case NOT:
                case CONCAT:
                case SUBSTRING:
                case TRIM:
                case LOWER:
                case UPPER:
                case LEADING:
                case TRAILING:
                case BOTH:
                case LENGTH:
                case LOCATE:
                case ABS:
                case SQRT:
                case MOD:
                case SIZE:
                case CURRENT_DATE:
                case CURRENT_TIME:
                case CURRENT_TIMESTAMP:
                case SELECT:
                case DISTINCT:
                case FROM:
                case UPDATE:
                case DELETE:
                case WHERE:
                case GROUP:
                case HAVING:
                case AS:
                case LEFT:
                case OUTER:
                case INNER:
                case JOIN:
                case FETCH:
                case IN:
                case SET:
                case OBJECT:
                case IDENTIFIER:
                    path_component();
                    break;
                default:
                    jj_la1[106] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    final public void entity_bean_expression() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case 89:
            case 90:
                input_parameter();
                break;
            case NEW:
            case ALL:
            case ANY:
            case EXISTS:
            case SOME:
            case EMPTY:
            case ASC:
            case DESC:
            case ORDER:
            case BY:
            case IS:
            case MEMBER:
            case OF:
            case LIKE:
            case ESCAPE:
            case BETWEEN:
            case NULL:
            case AVG:
            case MIN:
            case MAX:
            case SUM:
            case COUNT:
            case OR:
            case AND:
            case NOT:
            case CONCAT:
            case SUBSTRING:
            case TRIM:
            case LOWER:
            case UPPER:
            case LEADING:
            case TRAILING:
            case BOTH:
            case LENGTH:
            case LOCATE:
            case ABS:
            case SQRT:
            case MOD:
            case SIZE:
            case CURRENT_DATE:
            case CURRENT_TIME:
            case CURRENT_TIMESTAMP:
            case SELECT:
            case DISTINCT:
            case FROM:
            case UPDATE:
            case DELETE:
            case WHERE:
            case GROUP:
            case HAVING:
            case AS:
            case LEFT:
            case OUTER:
            case INNER:
            case JOIN:
            case FETCH:
            case IN:
            case SET:
            case OBJECT:
            case IDENTIFIER:
                entity_bean_value();
                break;
            default:
                jj_la1[107] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void functions_returning_strings() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case CONCAT:
                concat();
                break;
            case SUBSTRING:
                substring();
                break;
            case TRIM:
                trim();
                break;
            case LOWER:
                lower();
                break;
            case UPPER:
                upper();
                break;
            default:
                jj_la1[108] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void concat() throws ParseException {
        /*@bgen(jjtree) CONCAT */
        MQLCONCAT jjtn000 = new MQLCONCAT(this, JJTCONCAT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(CONCAT);
            jj_consume_token(87);
            string_expression();
            jj_consume_token(COMMA);
            string_expression();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void substring() throws ParseException {
        /*@bgen(jjtree) SUBSTRING */
        MQLSUBSTRING jjtn000 = new MQLSUBSTRING(this, JJTSUBSTRING);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(SUBSTRING);
            jj_consume_token(87);
            string_expression();
            jj_consume_token(COMMA);
            arithmetic_expression();
            jj_consume_token(COMMA);
            arithmetic_expression();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void trim() throws ParseException {
        /*@bgen(jjtree) TRIM */
        MQLTRIM jjtn000 = new MQLTRIM(this, JJTTRIM);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(TRIM);
            jj_consume_token(87);
            if (jj_2_59(2)) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case LEADING:
                    case TRAILING:
                    case BOTH:
                        trim_specification();
                        break;
                    default:
                        jj_la1[109] = jj_gen;
                        ;
                }
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case STRING_LITERAL:
                        trim_character();
                        break;
                    default:
                        jj_la1[110] = jj_gen;
                        ;
                }
                jj_consume_token(FROM);
            } else {
                ;
            }
            string_expression();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void lower() throws ParseException {
        /*@bgen(jjtree) LOWER */
        MQLLOWER jjtn000 = new MQLLOWER(this, JJTLOWER);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(LOWER);
            jj_consume_token(87);
            string_expression();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void upper() throws ParseException {
        /*@bgen(jjtree) UPPER */
        MQLUPPER jjtn000 = new MQLUPPER(this, JJTUPPER);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(UPPER);
            jj_consume_token(87);
            string_expression();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void trim_specification() throws ParseException {
        if (jj_2_60(2)) {
            MQLTRIMLEADING jjtn001 = new MQLTRIMLEADING(this, JJTTRIMLEADING);
            boolean jjtc001 = true;
            jjtree.openNodeScope(jjtn001);
            try {
                jj_consume_token(LEADING);
            } finally {
                if (jjtc001) {
                    jjtree.closeNodeScope(jjtn001, true);
                }
            }
        } else {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case TRAILING:
                    MQLTRIMTRAILING jjtn002 = new MQLTRIMTRAILING(this, JJTTRIMTRAILING);
                    boolean jjtc002 = true;
                    jjtree.openNodeScope(jjtn002);
                    try {
                        jj_consume_token(TRAILING);
                    } finally {
                        if (jjtc002) {
                            jjtree.closeNodeScope(jjtn002, true);
                        }
                    }
                    break;
                case BOTH:
                    MQLTRIMBOTH jjtn003 = new MQLTRIMBOTH(this, JJTTRIMBOTH);
                    boolean jjtc003 = true;
                    jjtree.openNodeScope(jjtn003);
                    try {
                        jj_consume_token(BOTH);
                    } finally {
                        if (jjtc003) {
                            jjtree.closeNodeScope(jjtn003, true);
                        }
                    }
                    break;
                default:
                    jj_la1[111] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    final public void functions_returning_numerics() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case LENGTH:
                length();
                break;
            case LOCATE:
                locate();
                break;
            case ABS:
                abs();
                break;
            case SQRT:
                sqrt();
                break;
            case MOD:
                mod();
                break;
            case SIZE:
                size();
                break;
            default:
                jj_la1[112] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void length() throws ParseException {
        /*@bgen(jjtree) LENGTH */
        MQLLENGTH jjtn000 = new MQLLENGTH(this, JJTLENGTH);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(LENGTH);
            jj_consume_token(87);
            string_expression();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void locate() throws ParseException {
        /*@bgen(jjtree) LOCATE */
        MQLLOCATE jjtn000 = new MQLLOCATE(this, JJTLOCATE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(LOCATE);
            jj_consume_token(87);
            string_expression();
            jj_consume_token(COMMA);
            string_expression();
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case COMMA:
                    jj_consume_token(COMMA);
                    arithmetic_expression();
                    break;
                default:
                    jj_la1[113] = jj_gen;
                    ;
            }
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void abs() throws ParseException {
        /*@bgen(jjtree) ABS */
        MQLABS jjtn000 = new MQLABS(this, JJTABS);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(ABS);
            jj_consume_token(87);
            arithmetic_expression();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void sqrt() throws ParseException {
        /*@bgen(jjtree) SQRT */
        MQLSQRT jjtn000 = new MQLSQRT(this, JJTSQRT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(SQRT);
            jj_consume_token(87);
            arithmetic_expression();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void mod() throws ParseException {
        /*@bgen(jjtree) MOD */
        MQLMOD jjtn000 = new MQLMOD(this, JJTMOD);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(MOD);
            jj_consume_token(87);
            arithmetic_expression();
            jj_consume_token(COMMA);
            arithmetic_expression();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void size() throws ParseException {
        /*@bgen(jjtree) SIZE */
        MQLSIZE jjtn000 = new MQLSIZE(this, JJTSIZE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(SIZE);
            jj_consume_token(87);
            path();
            jj_consume_token(88);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void functions_returning_datetime() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case CURRENT_DATE:
                MQLCURRENTDATE jjtn001 = new MQLCURRENTDATE(this, JJTCURRENTDATE);
                boolean jjtc001 = true;
                jjtree.openNodeScope(jjtn001);
                try {
                    jj_consume_token(CURRENT_DATE);
                } finally {
                    if (jjtc001) {
                        jjtree.closeNodeScope(jjtn001, true);
                    }
                }
                break;
            case CURRENT_TIME:
                MQLCURRENTTIME jjtn002 = new MQLCURRENTTIME(this, JJTCURRENTTIME);
                boolean jjtc002 = true;
                jjtree.openNodeScope(jjtn002);
                try {
                    jj_consume_token(CURRENT_TIME);
                } finally {
                    if (jjtc002) {
                        jjtree.closeNodeScope(jjtn002, true);
                    }
                }
                break;
            case CURRENT_TIMESTAMP:
                MQLCURRENTTIMESTAMP jjtn003 = new MQLCURRENTTIMESTAMP(this, JJTCURRENTTIMESTAMP);
                boolean jjtc003 = true;
                jjtree.openNodeScope(jjtn003);
                try {
                    jj_consume_token(CURRENT_TIMESTAMP);
                } finally {
                    if (jjtc003) {
                        jjtree.closeNodeScope(jjtn003, true);
                    }
                }
                break;
            default:
                jj_la1[114] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void limit_clause() throws ParseException {
        /*@bgen(jjtree) LIMIT */
        MQLLIMIT jjtn000 = new MQLLIMIT(this, JJTLIMIT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(LIMIT);
            integer_literal();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void skip_clause() throws ParseException {
        /*@bgen(jjtree) SKIPPER */
        MQLSKIPPER jjtn000 = new MQLSKIPPER(this, JJTSKIPPER);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(SKIPPER);
            integer_literal();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void orderby_clause() throws ParseException {
        /*@bgen(jjtree) ORDERBY */
        MQLORDERBY jjtn000 = new MQLORDERBY(this, JJTORDERBY);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(ORDER);
            jj_consume_token(BY);
            orderby_item();
            label_16:
            while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case COMMA:
                        ;
                        break;
                    default:
                        jj_la1[115] = jj_gen;
                        break label_16;
                }
                jj_consume_token(COMMA);
                orderby_item();
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void orderby_item() throws ParseException {
        /*@bgen(jjtree) ORDERBYITEM */
        MQLORDERBYITEM jjtn000 = new MQLORDERBYITEM(this, JJTORDERBYITEM);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            if (jj_2_61(2147483647)) {
                path();
            } else {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case AVG:
                    case MIN:
                    case MAX:
                    case SUM:
                    case COUNT:
                        orderby_extension();
                        break;
                    default:
                        jj_la1[116] = jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case ASC:
                case DESC:
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case ASC:
                            MQLASCENDING jjtn001 = new MQLASCENDING(this, JJTASCENDING);
                            boolean jjtc001 = true;
                            jjtree.openNodeScope(jjtn001);
                            try {
                                jj_consume_token(ASC);
                            } finally {
                                if (jjtc001) {
                                    jjtree.closeNodeScope(jjtn001, true);
                                }
                            }
                            break;
                        case DESC:
                            MQLDESCENDING jjtn002 = new MQLDESCENDING(this, JJTDESCENDING);
                            boolean jjtc002 = true;
                            jjtree.openNodeScope(jjtn002);
                            try {
                                jj_consume_token(DESC);
                            } finally {
                                if (jjtc002) {
                                    jjtree.closeNodeScope(jjtn002, true);
                                }
                            }
                            break;
                        default:
                            jj_la1[117] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                    break;
                default:
                    jj_la1[118] = jj_gen;
                    ;
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void orderby_extension() throws ParseException {
        /*@bgen(jjtree) ORDERBYEXTENSION */
        MQLORDERBYEXTENSION jjtn000 = new MQLORDERBYEXTENSION(this, JJTORDERBYEXTENSION);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            aggregate_select_expression();
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void abstract_schema_name() throws ParseException {
        /*@bgen(jjtree) ABSTRACTSCHEMANAME */
        MQLABSTRACTSCHEMANAME jjtn000 = new MQLABSTRACTSCHEMANAME(this, JJTABSTRACTSCHEMANAME);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            path_component();
            label_17:
            while (true) {
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case DOT:
                        ;
                        break;
                    default:
                        jj_la1[119] = jj_gen;
                        break label_17;
                }
                jj_consume_token(DOT);
                path_component();
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void tok() throws ParseException {
        /*@bgen(jjtree) TOK */
        MQLTOK jjtn000 = new MQLTOK(this, JJTTOK);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            t = jj_consume_token(IDENTIFIER);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setToken(t);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void identification_variable() throws ParseException {
        /*@bgen(jjtree) IDENTIFIER */
        MQLIDENTIFIER jjtn000 = new MQLIDENTIFIER(this, JJTIDENTIFIER);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            t = jj_consume_token(IDENTIFIER);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setToken(t);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void path_component() throws ParseException {
        /*@bgen(jjtree) IDENTIFICATIONVARIABLE */
        MQLIDENTIFICATIONVARIABLE jjtn000 = new MQLIDENTIFICATIONVARIABLE(this, JJTIDENTIFICATIONVARIABLE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case NEW:
                    t = jj_consume_token(NEW);
                    break;
                case ALL:
                    t = jj_consume_token(ALL);
                    break;
                case ANY:
                    t = jj_consume_token(ANY);
                    break;
                case EXISTS:
                    t = jj_consume_token(EXISTS);
                    break;
                case SOME:
                    t = jj_consume_token(SOME);
                    break;
                case EMPTY:
                    t = jj_consume_token(EMPTY);
                    break;
                case ASC:
                    t = jj_consume_token(ASC);
                    break;
                case DESC:
                    t = jj_consume_token(DESC);
                    break;
                case ORDER:
                    t = jj_consume_token(ORDER);
                    break;
                case IS:
                    t = jj_consume_token(IS);
                    break;
                case MEMBER:
                    t = jj_consume_token(MEMBER);
                    break;
                case OF:
                    t = jj_consume_token(OF);
                    break;
                case LIKE:
                    t = jj_consume_token(LIKE);
                    break;
                case ESCAPE:
                    t = jj_consume_token(ESCAPE);
                    break;
                case BETWEEN:
                    t = jj_consume_token(BETWEEN);
                    break;
                case NULL:
                    t = jj_consume_token(NULL);
                    break;
                case AVG:
                    t = jj_consume_token(AVG);
                    break;
                case MIN:
                    t = jj_consume_token(MIN);
                    break;
                case MAX:
                    t = jj_consume_token(MAX);
                    break;
                case SUM:
                    t = jj_consume_token(SUM);
                    break;
                case COUNT:
                    t = jj_consume_token(COUNT);
                    break;
                case OR:
                    t = jj_consume_token(OR);
                    break;
                case AND:
                    t = jj_consume_token(AND);
                    break;
                case NOT:
                    t = jj_consume_token(NOT);
                    break;
                case CONCAT:
                    t = jj_consume_token(CONCAT);
                    break;
                case SUBSTRING:
                    t = jj_consume_token(SUBSTRING);
                    break;
                case TRIM:
                    t = jj_consume_token(TRIM);
                    break;
                case LOWER:
                    t = jj_consume_token(LOWER);
                    break;
                case UPPER:
                    t = jj_consume_token(UPPER);
                    break;
                case LEADING:
                    t = jj_consume_token(LEADING);
                    break;
                case TRAILING:
                    t = jj_consume_token(TRAILING);
                    break;
                case BOTH:
                    t = jj_consume_token(BOTH);
                    break;
                case LENGTH:
                    t = jj_consume_token(LENGTH);
                    break;
                case LOCATE:
                    t = jj_consume_token(LOCATE);
                    break;
                case ABS:
                    t = jj_consume_token(ABS);
                    break;
                case SQRT:
                    t = jj_consume_token(SQRT);
                    break;
                case MOD:
                    t = jj_consume_token(MOD);
                    break;
                case SIZE:
                    t = jj_consume_token(SIZE);
                    break;
                case CURRENT_DATE:
                    t = jj_consume_token(CURRENT_DATE);
                    break;
                case CURRENT_TIME:
                    t = jj_consume_token(CURRENT_TIME);
                    break;
                case CURRENT_TIMESTAMP:
                    t = jj_consume_token(CURRENT_TIMESTAMP);
                    break;
                case SELECT:
                    t = jj_consume_token(SELECT);
                    break;
                case DISTINCT:
                    t = jj_consume_token(DISTINCT);
                    break;
                case FROM:
                    t = jj_consume_token(FROM);
                    break;
                case UPDATE:
                    t = jj_consume_token(UPDATE);
                    break;
                case DELETE:
                    t = jj_consume_token(DELETE);
                    break;
                case WHERE:
                    t = jj_consume_token(WHERE);
                    break;
                case GROUP:
                    t = jj_consume_token(GROUP);
                    break;
                case BY:
                    t = jj_consume_token(BY);
                    break;
                case HAVING:
                    t = jj_consume_token(HAVING);
                    break;
                case AS:
                    t = jj_consume_token(AS);
                    break;
                case LEFT:
                    t = jj_consume_token(LEFT);
                    break;
                case OUTER:
                    t = jj_consume_token(OUTER);
                    break;
                case INNER:
                    t = jj_consume_token(INNER);
                    break;
                case JOIN:
                    t = jj_consume_token(JOIN);
                    break;
                case FETCH:
                    t = jj_consume_token(FETCH);
                    break;
                case IN:
                    t = jj_consume_token(IN);
                    break;
                case SET:
                    t = jj_consume_token(SET);
                    break;
                case OBJECT:
                    t = jj_consume_token(OBJECT);
                    break;
                case IDENTIFIER:
                    t = jj_consume_token(IDENTIFIER);
                    break;
                default:
                    jj_la1[120] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setToken(t);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void numeric_literal() throws ParseException {
        if (jj_2_62(2147483647)) {
            decimal_literal();
        } else {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case PLUS:
                case MINUS:
                case INTEGER_LITERAL:
                    integer_literal();
                    break;
                default:
                    jj_la1[121] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    final public void integer_literal() throws ParseException {
        /*@bgen(jjtree) INTEGERLITERAL */
        MQLINTEGERLITERAL jjtn000 = new MQLINTEGERLITERAL(this, JJTINTEGERLITERAL);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case PLUS:
                case MINUS:
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case PLUS:
                            jj_consume_token(PLUS);
                            break;
                        case MINUS:
                            negative();
                            break;
                        default:
                            jj_la1[122] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                    break;
                default:
                    jj_la1[123] = jj_gen;
                    ;
            }
            t = jj_consume_token(INTEGER_LITERAL);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setToken(t);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void decimal_literal() throws ParseException {
        /*@bgen(jjtree) DECIMALLITERAL */
        MQLDECIMALLITERAL jjtn000 = new MQLDECIMALLITERAL(this, JJTDECIMALLITERAL);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case PLUS:
                case MINUS:
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case PLUS:
                            jj_consume_token(PLUS);
                            break;
                        case MINUS:
                            negative();
                            break;
                        default:
                            jj_la1[124] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                    break;
                default:
                    jj_la1[125] = jj_gen;
                    ;
            }
            t = jj_consume_token(DECIMAL_LITERAL);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setToken(t);
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void boolean_literal() throws ParseException {
        /*@bgen(jjtree) BOOLEANLITERAL */
        MQLBOOLEANLITERAL jjtn000 = new MQLBOOLEANLITERAL(this, JJTBOOLEANLITERAL);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            t = jj_consume_token(BOOLEAN_LITERAL);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setToken(t);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void string_literal() throws ParseException {
        /*@bgen(jjtree) STRINGLITERAL */
        MQLSTRINGLITERAL jjtn000 = new MQLSTRINGLITERAL(this, JJTSTRINGLITERAL);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            t = jj_consume_token(STRING_LITERAL);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setToken(t);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void input_parameter() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case 89:
                named_input_parameter();
                break;
            case 90:
                positional_input_parameter();
                break;
            default:
                jj_la1[126] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void named_input_parameter() throws ParseException {
        /*@bgen(jjtree) NAMEDINPUTPARAMETER */
        MQLNAMEDINPUTPARAMETER jjtn000 = new MQLNAMEDINPUTPARAMETER(this, JJTNAMEDINPUTPARAMETER);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            jj_consume_token(89);
            t = jj_consume_token(IDENTIFIER);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setToken(t);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void positional_input_parameter() throws ParseException {
        /*@bgen(jjtree) POSITIONALINPUTPARAMETER */
        MQLPOSITIONALINPUTPARAMETER jjtn000 = new MQLPOSITIONALINPUTPARAMETER(this, JJTPOSITIONALINPUTPARAMETER);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            jj_consume_token(90);
            t = jj_consume_token(INTEGER_LITERAL);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setToken(t);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void pattern_value() throws ParseException {
        /*@bgen(jjtree) PATTERNVALUE */
        MQLPATTERNVALUE jjtn000 = new MQLPATTERNVALUE(this, JJTPATTERNVALUE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case 89:
                case 90:
                    input_parameter();
                    break;
                case STRING_LITERAL:
                    string_literal();
                    break;
                default:
                    jj_la1[127] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case ESCAPE:
                    jj_consume_token(ESCAPE);
                    MQLESCAPECHARACTER jjtn001 = new MQLESCAPECHARACTER(this, JJTESCAPECHARACTER);
                    boolean jjtc001 = true;
                    jjtree.openNodeScope(jjtn001);
                    try {
                        escape_character();
                    } catch (Throwable jjte001) {
                        if (jjtc001) {
                            jjtree.clearNodeScope(jjtn001);
                            jjtc001 = false;
                        } else {
                            jjtree.popNode();
                        }
                        if (jjte001 instanceof RuntimeException) {
                            {
                                if (true) throw (RuntimeException) jjte001;
                            }
                        }
                        if (jjte001 instanceof ParseException) {
                            {
                                if (true) throw (ParseException) jjte001;
                            }
                        }
                        {
                            if (true) throw (Error) jjte001;
                        }
                    } finally {
                        if (jjtc001) {
                            jjtree.closeNodeScope(jjtn001, true);
                        }
                    }
                    break;
                default:
                    jj_la1[128] = jj_gen;
                    ;
            }
        } catch (Throwable jjte000) {
            if (jjtc000) {
                jjtree.clearNodeScope(jjtn000);
                jjtc000 = false;
            } else {
                jjtree.popNode();
            }
            if (jjte000 instanceof RuntimeException) {
                {
                    if (true) throw (RuntimeException) jjte000;
                }
            }
            if (jjte000 instanceof ParseException) {
                {
                    if (true) throw (ParseException) jjte000;
                }
            }
            {
                if (true) throw (Error) jjte000;
            }
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void escape_character() throws ParseException {
        /*@bgen(jjtree) ESCAPECHARACTER */
        MQLESCAPECHARACTER jjtn000 = new MQLESCAPECHARACTER(this, JJTESCAPECHARACTER);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            t = jj_consume_token(STRING_LITERAL);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setToken(t);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void trim_character() throws ParseException {
        /*@bgen(jjtree) TRIMCHARACTER */
        MQLTRIMCHARACTER jjtn000 = new MQLTRIMCHARACTER(this, JJTTRIMCHARACTER);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        Token t;
        try {
            t = jj_consume_token(STRING_LITERAL);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setToken(t);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void EQ() throws ParseException {
        /*@bgen(jjtree) EQUALS */
        MQLEQUALS jjtn000 = new MQLEQUALS(this, JJTEQUALS);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(EQ);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void NE() throws ParseException {
        /*@bgen(jjtree) NOTEQUALS */
        MQLNOTEQUALS jjtn000 = new MQLNOTEQUALS(this, JJTNOTEQUALS);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(NE);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void GT() throws ParseException {
        /*@bgen(jjtree) GREATERTHAN */
        MQLGREATERTHAN jjtn000 = new MQLGREATERTHAN(this, JJTGREATERTHAN);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(GT);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void GE() throws ParseException {
        /*@bgen(jjtree) GREATEROREQUAL */
        MQLGREATEROREQUAL jjtn000 = new MQLGREATEROREQUAL(this, JJTGREATEROREQUAL);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(GE);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void LT() throws ParseException {
        /*@bgen(jjtree) LESSTHAN */
        MQLLESSTHAN jjtn000 = new MQLLESSTHAN(this, JJTLESSTHAN);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(LT);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    final public void LE() throws ParseException {
        /*@bgen(jjtree) LESSOREQUAL */
        MQLLESSOREQUAL jjtn000 = new MQLLESSOREQUAL(this, JJTLESSOREQUAL);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        try {
            jj_consume_token(LE);
        } finally {
            if (jjtc000) {
                jjtree.closeNodeScope(jjtn000, true);
            }
        }
    }

    private boolean jj_2_1(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_1();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(0, xla);
        }
    }

    private boolean jj_2_2(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_2();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(1, xla);
        }
    }

    private boolean jj_2_3(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_3();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(2, xla);
        }
    }

    private boolean jj_2_4(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_4();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(3, xla);
        }
    }

    private boolean jj_2_5(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_5();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(4, xla);
        }
    }

    private boolean jj_2_6(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_6();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(5, xla);
        }
    }

    private boolean jj_2_7(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_7();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(6, xla);
        }
    }

    private boolean jj_2_8(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_8();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(7, xla);
        }
    }

    private boolean jj_2_9(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_9();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(8, xla);
        }
    }

    private boolean jj_2_10(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_10();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(9, xla);
        }
    }

    private boolean jj_2_11(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_11();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(10, xla);
        }
    }

    private boolean jj_2_12(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_12();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(11, xla);
        }
    }

    private boolean jj_2_13(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_13();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(12, xla);
        }
    }

    private boolean jj_2_14(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_14();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(13, xla);
        }
    }

    private boolean jj_2_15(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_15();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(14, xla);
        }
    }

    private boolean jj_2_16(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_16();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(15, xla);
        }
    }

    private boolean jj_2_17(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_17();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(16, xla);
        }
    }

    private boolean jj_2_18(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_18();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(17, xla);
        }
    }

    private boolean jj_2_19(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_19();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(18, xla);
        }
    }

    private boolean jj_2_20(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_20();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(19, xla);
        }
    }

    private boolean jj_2_21(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_21();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(20, xla);
        }
    }

    private boolean jj_2_22(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_22();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(21, xla);
        }
    }

    private boolean jj_2_23(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_23();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(22, xla);
        }
    }

    private boolean jj_2_24(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_24();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(23, xla);
        }
    }

    private boolean jj_2_25(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_25();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(24, xla);
        }
    }

    private boolean jj_2_26(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_26();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(25, xla);
        }
    }

    private boolean jj_2_27(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_27();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(26, xla);
        }
    }

    private boolean jj_2_28(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_28();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(27, xla);
        }
    }

    private boolean jj_2_29(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_29();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(28, xla);
        }
    }

    private boolean jj_2_30(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_30();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(29, xla);
        }
    }

    private boolean jj_2_31(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_31();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(30, xla);
        }
    }

    private boolean jj_2_32(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_32();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(31, xla);
        }
    }

    private boolean jj_2_33(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_33();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(32, xla);
        }
    }

    private boolean jj_2_34(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_34();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(33, xla);
        }
    }

    private boolean jj_2_35(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_35();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(34, xla);
        }
    }

    private boolean jj_2_36(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_36();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(35, xla);
        }
    }

    private boolean jj_2_37(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_37();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(36, xla);
        }
    }

    private boolean jj_2_38(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_38();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(37, xla);
        }
    }

    private boolean jj_2_39(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_39();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(38, xla);
        }
    }

    private boolean jj_2_40(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_40();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(39, xla);
        }
    }

    private boolean jj_2_41(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_41();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(40, xla);
        }
    }

    private boolean jj_2_42(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_42();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(41, xla);
        }
    }

    private boolean jj_2_43(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_43();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(42, xla);
        }
    }

    private boolean jj_2_44(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_44();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(43, xla);
        }
    }

    private boolean jj_2_45(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_45();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(44, xla);
        }
    }

    private boolean jj_2_46(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_46();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(45, xla);
        }
    }

    private boolean jj_2_47(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_47();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(46, xla);
        }
    }

    private boolean jj_2_48(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_48();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(47, xla);
        }
    }

    private boolean jj_2_49(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_49();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(48, xla);
        }
    }

    private boolean jj_2_50(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_50();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(49, xla);
        }
    }

    private boolean jj_2_51(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_51();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(50, xla);
        }
    }

    private boolean jj_2_52(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_52();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(51, xla);
        }
    }

    private boolean jj_2_53(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_53();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(52, xla);
        }
    }

    private boolean jj_2_54(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_54();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(53, xla);
        }
    }

    private boolean jj_2_55(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_55();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(54, xla);
        }
    }

    private boolean jj_2_56(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_56();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(55, xla);
        }
    }

    private boolean jj_2_57(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_57();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(56, xla);
        }
    }

    private boolean jj_2_58(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_58();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(57, xla);
        }
    }

    private boolean jj_2_59(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_59();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(58, xla);
        }
    }

    private boolean jj_2_60(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_60();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(59, xla);
        }
    }

    private boolean jj_2_61(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_61();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(60, xla);
        }
    }

    private boolean jj_2_62(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_62();
        }
        catch (LookaheadSuccess ls) {
            return true;
        }
        finally {
            jj_save(61, xla);
        }
    }

    private boolean jj_3R_59() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_152()) {
            jj_scanpos = xsp;
            if (jj_3R_153()) {
                jj_scanpos = xsp;
                if (jj_3R_154()) return true;
            }
        }
        return false;
    }

    private boolean jj_3R_152() {
        if (jj_3R_243()) return true;
        return false;
    }

    private boolean jj_3_42() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_101() {
        if (jj_scan_token(NOT)) return true;
        return false;
    }

    private boolean jj_3R_114() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_40() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_101()) jj_scanpos = xsp;
        if (jj_scan_token(EXISTS)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_60()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_116() {
        if (jj_scan_token(NOT)) return true;
        return false;
    }

    private boolean jj_3R_108() {
        if (jj_scan_token(NOT)) return true;
        return false;
    }

    private boolean jj_3R_120() {
        if (jj_scan_token(NOT)) return true;
        return false;
    }

    private boolean jj_3R_117() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_47() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_117()) {
            jj_scanpos = xsp;
            if (jj_3R_118()) {
                jj_scanpos = xsp;
                if (jj_3R_119()) return true;
            }
        }
        xsp = jj_scanpos;
        if (jj_3R_120()) jj_scanpos = xsp;
        if (jj_scan_token(MEMBER)) return true;
        xsp = jj_scanpos;
        if (jj_scan_token(31)) jj_scanpos = xsp;
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_46() {
        if (jj_3R_30()) return true;
        if (jj_scan_token(IS)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_116()) jj_scanpos = xsp;
        if (jj_scan_token(EMPTY)) return true;
        return false;
    }

    private boolean jj_3R_115() {
        if (jj_scan_token(NOT)) return true;
        return false;
    }

    private boolean jj_3R_113() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3R_45() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_113()) {
            jj_scanpos = xsp;
            if (jj_3R_114()) return true;
        }
        if (jj_scan_token(IS)) return true;
        xsp = jj_scanpos;
        if (jj_3R_115()) jj_scanpos = xsp;
        if (jj_scan_token(NULL)) return true;
        return false;
    }

    private boolean jj_3R_188() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_187()) return true;
        return false;
    }

    private boolean jj_3R_43() {
        if (jj_3R_49()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_108()) jj_scanpos = xsp;
        if (jj_scan_token(LIKE)) return true;
        if (jj_3R_109()) return true;
        return false;
    }

    private boolean jj_3R_277() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3R_111() {
        if (jj_3R_187()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3R_188()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3R_276() {
        if (jj_3R_175()) return true;
        return false;
    }

    private boolean jj_3R_275() {
        if (jj_3R_172()) return true;
        return false;
    }

    private boolean jj_3R_274() {
        if (jj_3R_280()) return true;
        return false;
    }

    private boolean jj_3R_110() {
        if (jj_scan_token(NOT)) return true;
        return false;
    }

    private boolean jj_3R_187() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_274()) {
            jj_scanpos = xsp;
            if (jj_3R_275()) {
                jj_scanpos = xsp;
                if (jj_3R_276()) {
                    jj_scanpos = xsp;
                    if (jj_3R_277()) return true;
                }
            }
        }
        return false;
    }

    private boolean jj_3R_52() {
        if (jj_scan_token(NOT)) return true;
        return false;
    }

    private boolean jj_3R_50() {
        if (jj_scan_token(NOT)) return true;
        return false;
    }

    private boolean jj_3R_44() {
        if (jj_3R_30()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_110()) jj_scanpos = xsp;
        if (jj_scan_token(IN)) return true;
        if (jj_scan_token(87)) return true;
        xsp = jj_scanpos;
        if (jj_3R_111()) {
            jj_scanpos = xsp;
            if (jj_3R_112()) return true;
        }
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_48() {
        if (jj_scan_token(NOT)) return true;
        return false;
    }

    private boolean jj_3R_179() {
        if (jj_3R_38()) return true;
        return false;
    }

    private boolean jj_3R_92() {
        if (jj_scan_token(87)) return true;
        if (jj_3R_36()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3_41() {
        if (jj_3R_51()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_52()) jj_scanpos = xsp;
        if (jj_scan_token(BETWEEN)) return true;
        if (jj_3R_51()) return true;
        if (jj_scan_token(AND)) return true;
        if (jj_3R_51()) return true;
        return false;
    }

    private boolean jj_3_40() {
        if (jj_3R_49()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_50()) jj_scanpos = xsp;
        if (jj_scan_token(BETWEEN)) return true;
        if (jj_3R_49()) return true;
        if (jj_scan_token(AND)) return true;
        if (jj_3R_49()) return true;
        return false;
    }

    private boolean jj_3_38() {
        if (jj_3R_47()) return true;
        return false;
    }

    private boolean jj_3_37() {
        if (jj_3R_46()) return true;
        return false;
    }

    private boolean jj_3_36() {
        if (jj_3R_45()) return true;
        return false;
    }

    private boolean jj_3_35() {
        if (jj_3R_44()) return true;
        return false;
    }

    private boolean jj_3R_42() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_39()) {
            jj_scanpos = xsp;
            if (jj_3_40()) {
                jj_scanpos = xsp;
                if (jj_3_41()) return true;
            }
        }
        return false;
    }

    private boolean jj_3_34() {
        if (jj_3R_43()) return true;
        return false;
    }

    private boolean jj_3_39() {
        if (jj_3R_24()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_48()) jj_scanpos = xsp;
        if (jj_scan_token(BETWEEN)) return true;
        if (jj_3R_24()) return true;
        if (jj_scan_token(AND)) return true;
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3_33() {
        if (jj_3R_42()) return true;
        return false;
    }

    private boolean jj_3_32() {
        if (jj_3R_41()) return true;
        return false;
    }

    private boolean jj_3_31() {
        if (jj_3R_40()) return true;
        return false;
    }

    private boolean jj_3R_100() {
        if (jj_3R_47()) return true;
        return false;
    }

    private boolean jj_3R_99() {
        if (jj_3R_46()) return true;
        return false;
    }

    private boolean jj_3R_98() {
        if (jj_3R_45()) return true;
        return false;
    }

    private boolean jj_3R_97() {
        if (jj_3R_44()) return true;
        return false;
    }

    private boolean jj_3R_96() {
        if (jj_3R_43()) return true;
        return false;
    }

    private boolean jj_3R_95() {
        if (jj_3R_42()) return true;
        return false;
    }

    private boolean jj_3_30() {
        if (jj_3R_39()) return true;
        return false;
    }

    private boolean jj_3R_94() {
        if (jj_3R_41()) return true;
        return false;
    }

    private boolean jj_3_28() {
        if (jj_scan_token(AND)) return true;
        if (jj_3R_37()) return true;
        return false;
    }

    private boolean jj_3R_93() {
        if (jj_3R_40()) return true;
        return false;
    }

    private boolean jj_3R_39() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_93()) {
            jj_scanpos = xsp;
            if (jj_3R_94()) {
                jj_scanpos = xsp;
                if (jj_3R_95()) {
                    jj_scanpos = xsp;
                    if (jj_3R_96()) {
                        jj_scanpos = xsp;
                        if (jj_3R_97()) {
                            jj_scanpos = xsp;
                            if (jj_3R_98()) {
                                jj_scanpos = xsp;
                                if (jj_3R_99()) {
                                    jj_scanpos = xsp;
                                    if (jj_3R_100()) return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3R_89() {
        if (jj_3R_177()) return true;
        return false;
    }

    private boolean jj_3_29() {
        if (jj_scan_token(NOT)) return true;
        if (jj_3R_38()) return true;
        return false;
    }

    private boolean jj_3R_91() {
        if (jj_3R_39()) return true;
        return false;
    }

    private boolean jj_3R_38() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_91()) {
            jj_scanpos = xsp;
            if (jj_3R_92()) return true;
        }
        return false;
    }

    private boolean jj_3_27() {
        if (jj_scan_token(OR)) return true;
        if (jj_3R_36()) return true;
        return false;
    }

    private boolean jj_3R_90() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_178()) {
            jj_scanpos = xsp;
            if (jj_3R_179()) return true;
        }
        return false;
    }

    private boolean jj_3R_178() {
        if (jj_scan_token(NOT)) return true;
        if (jj_3R_38()) return true;
        return false;
    }

    private boolean jj_3_26() {
        if (jj_3R_35()) return true;
        return false;
    }

    private boolean jj_3_25() {
        if (jj_3R_34()) return true;
        return false;
    }

    private boolean jj_3_24() {
        if (jj_3R_33()) return true;
        return false;
    }

    private boolean jj_3R_37() {
        if (jj_3R_90()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3_28()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3R_183() {
        if (jj_3R_35()) return true;
        return false;
    }

    private boolean jj_3R_182() {
        if (jj_3R_34()) return true;
        return false;
    }

    private boolean jj_3R_36() {
        if (jj_3R_37()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3_27()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3R_181() {
        if (jj_3R_33()) return true;
        return false;
    }

    private boolean jj_3R_88() {
        if (jj_3R_23()) return true;
        return false;
    }

    private boolean jj_3R_60() {
        if (jj_3R_155()) return true;
        if (jj_3R_180()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_181()) jj_scanpos = xsp;
        xsp = jj_scanpos;
        if (jj_3R_182()) jj_scanpos = xsp;
        xsp = jj_scanpos;
        if (jj_3R_183()) jj_scanpos = xsp;
        return false;
    }

    private boolean jj_3R_35() {
        if (jj_scan_token(HAVING)) return true;
        if (jj_3R_36()) return true;
        return false;
    }

    private boolean jj_3_23() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3_22() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_32()) return true;
        return false;
    }

    private boolean jj_3R_177() {
        if (jj_3R_268()) return true;
        return false;
    }

    private boolean jj_3R_87() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_32() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_87()) {
            jj_scanpos = xsp;
            if (jj_3R_88()) {
                jj_scanpos = xsp;
                if (jj_3R_89()) return true;
            }
        }
        return false;
    }

    private boolean jj_3R_34() {
        if (jj_scan_token(GROUP)) return true;
        if (jj_scan_token(BY)) return true;
        if (jj_3R_32()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3_22()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3R_86() {
        if (jj_3R_23()) return true;
        return false;
    }

    private boolean jj_3R_33() {
        if (jj_scan_token(WHERE)) return true;
        if (jj_3R_36()) return true;
        return false;
    }

    private boolean jj_3R_324() {
        if (jj_scan_token(SUM)) return true;
        if (jj_3R_328()) return true;
        return false;
    }

    private boolean jj_3R_323() {
        if (jj_scan_token(MIN)) return true;
        if (jj_3R_328()) return true;
        return false;
    }

    private boolean jj_3_21() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_322() {
        if (jj_scan_token(MAX)) return true;
        if (jj_3R_328()) return true;
        return false;
    }

    private boolean jj_3R_321() {
        if (jj_scan_token(AVG)) return true;
        if (jj_3R_328()) return true;
        return false;
    }

    private boolean jj_3R_85() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3_20() {
        if (jj_3R_23()) return true;
        return false;
    }

    private boolean jj_3R_310() {
        if (jj_3R_325()) return true;
        return false;
    }

    private boolean jj_3_19() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3_18() {
        if (jj_3R_31()) return true;
        return false;
    }

    private boolean jj_3_17() {
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_325() {
        if (jj_scan_token(COUNT)) return true;
        if (jj_scan_token(87)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_scan_token(15)) jj_scanpos = xsp;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_309() {
        if (jj_3R_324()) return true;
        return false;
    }

    private boolean jj_3R_333() {
        if (jj_3R_23()) return true;
        return false;
    }

    private boolean jj_3R_332() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_31() {
        if (jj_scan_token(DISTINCT)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_85()) {
            jj_scanpos = xsp;
            if (jj_3R_86()) return true;
        }
        return false;
    }

    private boolean jj_3R_331() {
        if (jj_3R_31()) return true;
        return false;
    }

    private boolean jj_3R_330() {
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_308() {
        if (jj_3R_323()) return true;
        return false;
    }

    private boolean jj_3R_328() {
        if (jj_scan_token(87)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_330()) {
            jj_scanpos = xsp;
            if (jj_3R_331()) {
                jj_scanpos = xsp;
                if (jj_3R_332()) {
                    jj_scanpos = xsp;
                    if (jj_3R_333()) return true;
                }
            }
        }
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_307() {
        if (jj_3R_322()) return true;
        return false;
    }

    private boolean jj_3R_291() {
        if (jj_scan_token(DISTINCT)) return true;
        return false;
    }

    private boolean jj_3R_306() {
        if (jj_3R_321()) return true;
        return false;
    }

    private boolean jj_3R_282() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_306()) {
            jj_scanpos = xsp;
            if (jj_3R_307()) {
                jj_scanpos = xsp;
                if (jj_3R_308()) {
                    jj_scanpos = xsp;
                    if (jj_3R_309()) {
                        jj_scanpos = xsp;
                        if (jj_3R_310()) return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3R_293() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_292()) return true;
        return false;
    }

    private boolean jj_3R_313() {
        if (jj_3R_23()) return true;
        return false;
    }

    private boolean jj_3R_312() {
        if (jj_3R_282()) return true;
        return false;
    }

    private boolean jj_3_16() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_185() {
        if (jj_3R_172()) return true;
        return false;
    }

    private boolean jj_3R_311() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_292() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_311()) {
            jj_scanpos = xsp;
            if (jj_3R_312()) {
                jj_scanpos = xsp;
                if (jj_3R_313()) return true;
            }
        }
        return false;
    }

    private boolean jj_3_15() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_159() {
        if (jj_scan_token(STRING_LITERAL)) return true;
        return false;
    }

    private boolean jj_3R_270() {
        if (jj_3R_292()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3R_293()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3R_273() {
        if (jj_scan_token(STRING_LITERAL)) return true;
        return false;
    }

    private boolean jj_3R_157() {
        if (jj_3R_247()) return true;
        return false;
    }

    private boolean jj_3R_186() {
        if (jj_scan_token(ESCAPE)) return true;
        if (jj_3R_273()) return true;
        return false;
    }

    private boolean jj_3R_184() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3R_109() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_184()) {
            jj_scanpos = xsp;
            if (jj_3R_185()) return true;
        }
        xsp = jj_scanpos;
        if (jj_3R_186()) jj_scanpos = xsp;
        return false;
    }

    private boolean jj_3R_83() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3R_299() {
        if (jj_3R_314()) return true;
        return false;
    }

    private boolean jj_3R_247() {
        if (jj_scan_token(90)) return true;
        if (jj_scan_token(INTEGER_LITERAL)) return true;
        return false;
    }

    private boolean jj_3R_269() {
        if (jj_3R_291()) return true;
        return false;
    }

    private boolean jj_3R_246() {
        if (jj_scan_token(89)) return true;
        if (jj_scan_token(IDENTIFIER)) return true;
        return false;
    }

    private boolean jj_3R_155() {
        if (jj_scan_token(SELECT)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_269()) jj_scanpos = xsp;
        if (jj_3R_270()) return true;
        return false;
    }

    private boolean jj_3R_62() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_156()) {
            jj_scanpos = xsp;
            if (jj_3R_157()) return true;
        }
        return false;
    }

    private boolean jj_3R_156() {
        if (jj_3R_246()) return true;
        return false;
    }

    private boolean jj_3_2() {
        if (jj_3R_19()) return true;
        return false;
    }

    private boolean jj_3_5() {
        if (jj_3R_22()) return true;
        return false;
    }

    private boolean jj_3_14() {
        if (jj_3R_29()) return true;
        return false;
    }

    private boolean jj_3R_172() {
        if (jj_scan_token(STRING_LITERAL)) return true;
        return false;
    }

    private boolean jj_3_13() {
        if (jj_3R_28()) return true;
        return false;
    }

    private boolean jj_3_12() {
        if (jj_3R_27()) return true;
        return false;
    }

    private boolean jj_3R_250() {
        if (jj_3R_279()) return true;
        return false;
    }

    private boolean jj_3R_82() {
        if (jj_3R_23()) return true;
        return false;
    }

    private boolean jj_3R_29() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_82()) {
            jj_scanpos = xsp;
            if (jj_3R_83()) return true;
        }
        return false;
    }

    private boolean jj_3_11() {
        if (jj_3R_26()) return true;
        return false;
    }

    private boolean jj_3_10() {
        if (jj_3R_25()) return true;
        return false;
    }

    private boolean jj_3_9() {
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_175() {
        if (jj_scan_token(BOOLEAN_LITERAL)) return true;
        return false;
    }

    private boolean jj_3R_165() {
        if (jj_3R_22()) return true;
        return false;
    }

    private boolean jj_3R_329() {
        if (jj_3R_279()) return true;
        return false;
    }

    private boolean jj_3R_84() {
        if (jj_scan_token(DOT)) return true;
        if (jj_3R_176()) return true;
        return false;
    }

    private boolean jj_3R_160() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_scan_token(13)) {
            jj_scanpos = xsp;
            if (jj_3R_250()) return true;
        }
        return false;
    }

    private boolean jj_3R_65() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_160()) jj_scanpos = xsp;
        if (jj_scan_token(DECIMAL_LITERAL)) return true;
        return false;
    }

    private boolean jj_3_62() {
        if (jj_3R_65()) return true;
        return false;
    }

    private boolean jj_3R_326() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_scan_token(13)) {
            jj_scanpos = xsp;
            if (jj_3R_329()) return true;
        }
        return false;
    }

    private boolean jj_3R_314() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_326()) jj_scanpos = xsp;
        if (jj_scan_token(INTEGER_LITERAL)) return true;
        return false;
    }

    private boolean jj_3R_298() {
        if (jj_3R_65()) return true;
        return false;
    }

    private boolean jj_3R_280() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_298()) {
            jj_scanpos = xsp;
            if (jj_3R_299()) return true;
        }
        return false;
    }

    private boolean jj_3R_69() {
        if (jj_3R_167()) return true;
        return false;
    }

    private boolean jj_3_4() {
        if (jj_3R_21()) return true;
        return false;
    }

    private boolean jj_3R_30() {
        if (jj_3R_23()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3R_84()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3_6() {
        if (jj_3R_23()) return true;
        return false;
    }

    private boolean jj_3R_167() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_scan_token(72)) jj_scanpos = xsp;
        if (jj_scan_token(JOIN)) return true;
        if (jj_scan_token(FETCH)) return true;
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_164() {
        if (jj_3R_21()) return true;
        return false;
    }

    private boolean jj_3R_162() {
        if (jj_3R_23()) return true;
        return false;
    }

    private boolean jj_3R_166() {
        if (jj_scan_token(LEFT)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_scan_token(71)) jj_scanpos = xsp;
        if (jj_scan_token(JOIN)) return true;
        if (jj_scan_token(FETCH)) return true;
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_68() {
        if (jj_3R_166()) return true;
        return false;
    }

    private boolean jj_3R_20() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_68()) {
            jj_scanpos = xsp;
            if (jj_3R_69()) return true;
        }
        return false;
    }

    private boolean jj_3R_22() {
        if (jj_scan_token(LEFT)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_scan_token(71)) jj_scanpos = xsp;
        if (jj_scan_token(JOIN)) return true;
        if (jj_3R_30()) return true;
        xsp = jj_scanpos;
        if (jj_scan_token(69)) jj_scanpos = xsp;
        if (jj_3R_23()) return true;
        return false;
    }

    private boolean jj_3_8() {
        if (jj_3R_19()) return true;
        return false;
    }

    private boolean jj_3R_18() {
        if (jj_scan_token(IN)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_30()) return true;
        if (jj_scan_token(88)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_scan_token(69)) jj_scanpos = xsp;
        if (jj_3R_23()) return true;
        return false;
    }

    private boolean jj_3_7() {
        if (jj_3R_18()) return true;
        return false;
    }

    private boolean jj_3_1() {
        if (jj_3R_18()) return true;
        return false;
    }

    private boolean jj_3R_21() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_scan_token(72)) jj_scanpos = xsp;
        if (jj_scan_token(JOIN)) return true;
        if (jj_3R_30()) return true;
        xsp = jj_scanpos;
        if (jj_scan_token(69)) jj_scanpos = xsp;
        if (jj_3R_23()) return true;
        return false;
    }

    private boolean jj_3R_272() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_271()) return true;
        return false;
    }

    private boolean jj_3_3() {
        if (jj_3R_20()) return true;
        return false;
    }

    private boolean jj_3R_295() {
        if (jj_3R_19()) return true;
        return false;
    }

    private boolean jj_3R_294() {
        if (jj_3R_18()) return true;
        return false;
    }

    private boolean jj_3R_271() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_294()) {
            jj_scanpos = xsp;
            if (jj_3R_295()) return true;
        }
        return false;
    }

    private boolean jj_3R_67() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_163()) {
            jj_scanpos = xsp;
            if (jj_3R_164()) {
                jj_scanpos = xsp;
                if (jj_3R_165()) return true;
            }
        }
        return false;
    }

    private boolean jj_3R_163() {
        if (jj_3R_20()) return true;
        return false;
    }

    private boolean jj_3R_180() {
        if (jj_scan_token(FROM)) return true;
        if (jj_3R_271()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3R_272()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3R_66() {
        if (jj_3R_161()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_scan_token(69)) jj_scanpos = xsp;
        xsp = jj_scanpos;
        if (jj_3R_162()) jj_scanpos = xsp;
        return false;
    }

    private boolean jj_3R_176() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_scan_token(17)) {
            jj_scanpos = xsp;
            if (jj_scan_token(18)) {
                jj_scanpos = xsp;
                if (jj_scan_token(19)) {
                    jj_scanpos = xsp;
                    if (jj_scan_token(20)) {
                        jj_scanpos = xsp;
                        if (jj_scan_token(21)) {
                            jj_scanpos = xsp;
                            if (jj_scan_token(22)) {
                                jj_scanpos = xsp;
                                if (jj_scan_token(23)) {
                                    jj_scanpos = xsp;
                                    if (jj_scan_token(24)) {
                                        jj_scanpos = xsp;
                                        if (jj_scan_token(25)) {
                                            jj_scanpos = xsp;
                                            if (jj_scan_token(29)) {
                                                jj_scanpos = xsp;
                                                if (jj_scan_token(30)) {
                                                    jj_scanpos = xsp;
                                                    if (jj_scan_token(31)) {
                                                        jj_scanpos = xsp;
                                                        if (jj_scan_token(32)) {
                                                            jj_scanpos = xsp;
                                                            if (jj_scan_token(33)) {
                                                                jj_scanpos = xsp;
                                                                if (jj_scan_token(34)) {
                                                                    jj_scanpos = xsp;
                                                                    if (jj_scan_token(35)) {
                                                                        jj_scanpos = xsp;
                                                                        if (jj_scan_token(36)) {
                                                                            jj_scanpos = xsp;
                                                                            if (jj_scan_token(37)) {
                                                                                jj_scanpos = xsp;
                                                                                if (jj_scan_token(38)) {
                                                                                    jj_scanpos = xsp;
                                                                                    if (jj_scan_token(39)) {
                                                                                        jj_scanpos = xsp;
                                                                                        if (jj_scan_token(40)) {
                                                                                            jj_scanpos = xsp;
                                                                                            if (jj_scan_token(41)) {
                                                                                                jj_scanpos = xsp;
                                                                                                if (jj_scan_token(42)) {
                                                                                                    jj_scanpos = xsp;
                                                                                                    if (jj_scan_token(43)) {
                                                                                                        jj_scanpos = xsp;
                                                                                                        if (jj_scan_token(44)) {
                                                                                                            jj_scanpos = xsp;
                                                                                                            if (jj_scan_token(45)) {
                                                                                                                jj_scanpos = xsp;
                                                                                                                if (jj_scan_token(46)) {
                                                                                                                    jj_scanpos = xsp;
                                                                                                                    if (jj_scan_token(47)) {
                                                                                                                        jj_scanpos = xsp;
                                                                                                                        if (jj_scan_token(48)) {
                                                                                                                            jj_scanpos = xsp;
                                                                                                                            if (jj_scan_token(49)) {
                                                                                                                                jj_scanpos = xsp;
                                                                                                                                if (jj_scan_token(50)) {
                                                                                                                                    jj_scanpos = xsp;
                                                                                                                                    if (jj_scan_token(51)) {
                                                                                                                                        jj_scanpos = xsp;
                                                                                                                                        if (jj_scan_token(52)) {
                                                                                                                                            jj_scanpos = xsp;
                                                                                                                                            if (jj_scan_token(53)) {
                                                                                                                                                jj_scanpos = xsp;
                                                                                                                                                if (jj_scan_token(54)) {
                                                                                                                                                    jj_scanpos = xsp;
                                                                                                                                                    if (jj_scan_token(55)) {
                                                                                                                                                        jj_scanpos = xsp;
                                                                                                                                                        if (jj_scan_token(56)) {
                                                                                                                                                            jj_scanpos = xsp;
                                                                                                                                                            if (jj_scan_token(57)) {
                                                                                                                                                                jj_scanpos = xsp;
                                                                                                                                                                if (jj_scan_token(58)) {
                                                                                                                                                                    jj_scanpos = xsp;
                                                                                                                                                                    if (jj_scan_token(59)) {
                                                                                                                                                                        jj_scanpos = xsp;
                                                                                                                                                                        if (jj_scan_token(60)) {
                                                                                                                                                                            jj_scanpos = xsp;
                                                                                                                                                                            if (jj_scan_token(61)) {
                                                                                                                                                                                jj_scanpos = xsp;
                                                                                                                                                                                if (jj_scan_token(62)) {
                                                                                                                                                                                    jj_scanpos = xsp;
                                                                                                                                                                                    if (jj_scan_token(63)) {
                                                                                                                                                                                        jj_scanpos = xsp;
                                                                                                                                                                                        if (jj_scan_token(64)) {
                                                                                                                                                                                            jj_scanpos = xsp;
                                                                                                                                                                                            if (jj_scan_token(65)) {
                                                                                                                                                                                                jj_scanpos = xsp;
                                                                                                                                                                                                if (jj_scan_token(66)) {
                                                                                                                                                                                                    jj_scanpos = xsp;
                                                                                                                                                                                                    if (jj_scan_token(67)) {
                                                                                                                                                                                                        jj_scanpos = xsp;
                                                                                                                                                                                                        if (jj_scan_token(26)) {
                                                                                                                                                                                                            jj_scanpos = xsp;
                                                                                                                                                                                                            if (jj_scan_token(68)) {
                                                                                                                                                                                                                jj_scanpos = xsp;
                                                                                                                                                                                                                if (jj_scan_token(69)) {
                                                                                                                                                                                                                    jj_scanpos = xsp;
                                                                                                                                                                                                                    if (jj_scan_token(70)) {
                                                                                                                                                                                                                        jj_scanpos = xsp;
                                                                                                                                                                                                                        if (jj_scan_token(71)) {
                                                                                                                                                                                                                            jj_scanpos = xsp;
                                                                                                                                                                                                                            if (jj_scan_token(72)) {
                                                                                                                                                                                                                                jj_scanpos = xsp;
                                                                                                                                                                                                                                if (jj_scan_token(73)) {
                                                                                                                                                                                                                                    jj_scanpos = xsp;
                                                                                                                                                                                                                                    if (jj_scan_token(74)) {
                                                                                                                                                                                                                                        jj_scanpos = xsp;
                                                                                                                                                                                                                                        if (jj_scan_token(75)) {
                                                                                                                                                                                                                                            jj_scanpos = xsp;
                                                                                                                                                                                                                                            if (jj_scan_token(76)) {
                                                                                                                                                                                                                                                jj_scanpos = xsp;
                                                                                                                                                                                                                                                if (jj_scan_token(77)) {
                                                                                                                                                                                                                                                    jj_scanpos = xsp;
                                                                                                                                                                                                                                                    if (jj_scan_token(84))
                                                                                                                                                                                                                                                        return true;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3R_251() {
        if (jj_scan_token(DOT)) return true;
        if (jj_3R_176()) return true;
        return false;
    }

    private boolean jj_3R_19() {
        if (jj_3R_66()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3R_67()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3R_23() {
        if (jj_scan_token(IDENTIFIER)) return true;
        return false;
    }

    private boolean jj_3R_161() {
        if (jj_3R_176()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3R_251()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3_61() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_249() {
        if (jj_scan_token(BOTH)) return true;
        return false;
    }

    private boolean jj_3R_267() {
        if (jj_scan_token(CURRENT_TIMESTAMP)) return true;
        return false;
    }

    private boolean jj_3R_266() {
        if (jj_scan_token(CURRENT_TIME)) return true;
        return false;
    }

    private boolean jj_3R_265() {
        if (jj_scan_token(CURRENT_DATE)) return true;
        return false;
    }

    private boolean jj_3R_174() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_265()) {
            jj_scanpos = xsp;
            if (jj_3R_266()) {
                jj_scanpos = xsp;
                if (jj_3R_267()) return true;
            }
        }
        return false;
    }

    private boolean jj_3R_305() {
        if (jj_3R_320()) return true;
        return false;
    }

    private boolean jj_3R_320() {
        if (jj_scan_token(SIZE)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_30()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_304() {
        if (jj_3R_319()) return true;
        return false;
    }

    private boolean jj_3R_319() {
        if (jj_scan_token(MOD)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_24()) return true;
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_24()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_248() {
        if (jj_scan_token(TRAILING)) return true;
        return false;
    }

    private boolean jj_3R_303() {
        if (jj_3R_318()) return true;
        return false;
    }

    private boolean jj_3R_318() {
        if (jj_scan_token(SQRT)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_24()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_327() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_302() {
        if (jj_3R_317()) return true;
        return false;
    }

    private boolean jj_3R_64() {
        if (jj_3R_159()) return true;
        return false;
    }

    private boolean jj_3R_317() {
        if (jj_scan_token(ABS)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_24()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_316() {
        if (jj_scan_token(LOCATE)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_49()) return true;
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_49()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_327()) jj_scanpos = xsp;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_301() {
        if (jj_3R_316()) return true;
        return false;
    }

    private boolean jj_3R_315() {
        if (jj_scan_token(LENGTH)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_49()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_300() {
        if (jj_3R_315()) return true;
        return false;
    }

    private boolean jj_3R_281() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_300()) {
            jj_scanpos = xsp;
            if (jj_3R_301()) {
                jj_scanpos = xsp;
                if (jj_3R_302()) {
                    jj_scanpos = xsp;
                    if (jj_3R_303()) {
                        jj_scanpos = xsp;
                        if (jj_3R_304()) {
                            jj_scanpos = xsp;
                            if (jj_3R_305()) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3R_264() {
        if (jj_3R_287()) return true;
        return false;
    }

    private boolean jj_3R_63() {
        if (jj_3R_158()) return true;
        return false;
    }

    private boolean jj_3_60() {
        if (jj_scan_token(LEADING)) return true;
        return false;
    }

    private boolean jj_3R_158() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_60()) {
            jj_scanpos = xsp;
            if (jj_3R_248()) {
                jj_scanpos = xsp;
                if (jj_3R_249()) return true;
            }
        }
        return false;
    }

    private boolean jj_3R_263() {
        if (jj_3R_286()) return true;
        return false;
    }

    private boolean jj_3R_287() {
        if (jj_scan_token(UPPER)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_49()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3_59() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_63()) jj_scanpos = xsp;
        xsp = jj_scanpos;
        if (jj_3R_64()) jj_scanpos = xsp;
        if (jj_scan_token(FROM)) return true;
        return false;
    }

    private boolean jj_3R_286() {
        if (jj_scan_token(LOWER)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_49()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_262() {
        if (jj_3R_285()) return true;
        return false;
    }

    private boolean jj_3R_285() {
        if (jj_scan_token(TRIM)) return true;
        if (jj_scan_token(87)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_59()) jj_scanpos = xsp;
        if (jj_3R_49()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_297() {
        if (jj_3R_176()) return true;
        return false;
    }

    private boolean jj_3R_238() {
        if (jj_3R_278()) return true;
        return false;
    }

    private boolean jj_3R_284() {
        if (jj_scan_token(SUBSTRING)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_49()) return true;
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_24()) return true;
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_24()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_261() {
        if (jj_3R_284()) return true;
        return false;
    }

    private boolean jj_3R_283() {
        if (jj_scan_token(CONCAT)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_49()) return true;
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_49()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_79() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3R_260() {
        if (jj_3R_283()) return true;
        return false;
    }

    private boolean jj_3R_173() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_260()) {
            jj_scanpos = xsp;
            if (jj_3R_261()) {
                jj_scanpos = xsp;
                if (jj_3R_262()) {
                    jj_scanpos = xsp;
                    if (jj_3R_263()) {
                        jj_scanpos = xsp;
                        if (jj_3R_264()) return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3_58() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_149() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_237()) {
            jj_scanpos = xsp;
            if (jj_3R_238()) return true;
        }
        return false;
    }

    private boolean jj_3R_237() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3R_296() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_278() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_296()) {
            jj_scanpos = xsp;
            if (jj_3R_297()) return true;
        }
        return false;
    }

    private boolean jj_3_57() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3_56() {
        if (jj_3R_61()) return true;
        return false;
    }

    private boolean jj_3R_77() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3R_220() {
        if (jj_scan_token(87)) return true;
        if (jj_3R_60()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_78() {
        if (jj_3R_175()) return true;
        return false;
    }

    private boolean jj_3R_61() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_81() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3R_80() {
        if (jj_3R_61()) return true;
        return false;
    }

    private boolean jj_3R_214() {
        if (jj_scan_token(87)) return true;
        if (jj_3R_60()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_28() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_55()) {
            jj_scanpos = xsp;
            if (jj_3R_80()) {
                jj_scanpos = xsp;
                if (jj_3R_81()) return true;
            }
        }
        return false;
    }

    private boolean jj_3_55() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_140() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_219()) {
            jj_scanpos = xsp;
            if (jj_3R_220()) return true;
        }
        return false;
    }

    private boolean jj_3R_219() {
        if (jj_3R_28()) return true;
        return false;
    }

    private boolean jj_3_53() {
        if (jj_scan_token(87)) return true;
        if (jj_3R_60()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_27() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_54()) {
            jj_scanpos = xsp;
            if (jj_3R_78()) {
                jj_scanpos = xsp;
                if (jj_3R_79()) return true;
            }
        }
        return false;
    }

    private boolean jj_3_54() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3_52() {
        if (jj_scan_token(87)) return true;
        if (jj_3R_49()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_124() {
        if (jj_scan_token(87)) return true;
        if (jj_3R_60()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_137() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_213()) {
            jj_scanpos = xsp;
            if (jj_3R_214()) return true;
        }
        return false;
    }

    private boolean jj_3R_213() {
        if (jj_3R_27()) return true;
        return false;
    }

    private boolean jj_3R_76() {
        if (jj_3R_174()) return true;
        return false;
    }

    private boolean jj_3R_73() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_122() {
        if (jj_3R_25()) return true;
        return false;
    }

    private boolean jj_3R_75() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_26() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_75()) {
            jj_scanpos = xsp;
            if (jj_3R_76()) {
                jj_scanpos = xsp;
                if (jj_3R_77()) return true;
            }
        }
        return false;
    }

    private boolean jj_3R_51() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_123()) {
            jj_scanpos = xsp;
            if (jj_3R_124()) return true;
        }
        return false;
    }

    private boolean jj_3R_123() {
        if (jj_3R_26()) return true;
        return false;
    }

    private boolean jj_3R_74() {
        if (jj_3R_173()) return true;
        return false;
    }

    private boolean jj_3R_72() {
        if (jj_3R_172()) return true;
        return false;
    }

    private boolean jj_3R_25() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_72()) {
            jj_scanpos = xsp;
            if (jj_3R_73()) {
                jj_scanpos = xsp;
                if (jj_3_52()) {
                    jj_scanpos = xsp;
                    if (jj_3R_74()) {
                        jj_scanpos = xsp;
                        if (jj_3_53()) return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3R_49() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_121()) {
            jj_scanpos = xsp;
            if (jj_3R_122()) return true;
        }
        return false;
    }

    private boolean jj_3R_121() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3R_279() {
        if (jj_scan_token(MINUS)) return true;
        return false;
    }

    private boolean jj_3R_242() {
        if (jj_3R_149()) return true;
        return false;
    }

    private boolean jj_3R_257() {
        if (jj_3R_60()) return true;
        return false;
    }

    private boolean jj_3R_256() {
        if (jj_3R_282()) return true;
        return false;
    }

    private boolean jj_3R_259() {
        if (jj_scan_token(DIV)) return true;
        if (jj_3R_70()) return true;
        return false;
    }

    private boolean jj_3R_255() {
        if (jj_3R_281()) return true;
        return false;
    }

    private boolean jj_3R_240() {
        if (jj_3R_149()) return true;
        return false;
    }

    private boolean jj_3_51() {
        if (jj_scan_token(87)) return true;
        if (jj_3R_24()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_258() {
        if (jj_scan_token(TIMES)) return true;
        if (jj_3R_70()) return true;
        return false;
    }

    private boolean jj_3R_254() {
        if (jj_3R_30()) return true;
        return false;
    }

    private boolean jj_3R_169() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_258()) {
            jj_scanpos = xsp;
            if (jj_3R_259()) return true;
        }
        return false;
    }

    private boolean jj_3R_253() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3R_252() {
        if (jj_3R_280()) return true;
        return false;
    }

    private boolean jj_3R_168() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_252()) {
            jj_scanpos = xsp;
            if (jj_3R_253()) {
                jj_scanpos = xsp;
                if (jj_3R_254()) {
                    jj_scanpos = xsp;
                    if (jj_3_51()) {
                        jj_scanpos = xsp;
                        if (jj_3R_255()) {
                            jj_scanpos = xsp;
                            if (jj_3R_256()) {
                                jj_scanpos = xsp;
                                if (jj_3R_257()) return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3R_236() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_171() {
        if (jj_scan_token(MINUS)) return true;
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_234() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_232() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_71() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_170()) {
            jj_scanpos = xsp;
            if (jj_3R_171()) return true;
        }
        return false;
    }

    private boolean jj_3R_170() {
        if (jj_scan_token(PLUS)) return true;
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_230() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_70() {
        if (jj_3R_168()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3R_169()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3R_228() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_226() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_200() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_198() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_24() {
        if (jj_3R_70()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3R_71()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    private boolean jj_3R_196() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_194() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_192() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_190() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_290() {
        if (jj_3R_173()) return true;
        return false;
    }

    private boolean jj_3R_289() {
        if (jj_3R_174()) return true;
        return false;
    }

    private boolean jj_3R_235() {
        if (jj_3R_51()) return true;
        return false;
    }

    private boolean jj_3R_233() {
        if (jj_3R_51()) return true;
        return false;
    }

    private boolean jj_3R_231() {
        if (jj_3R_51()) return true;
        return false;
    }

    private boolean jj_3R_229() {
        if (jj_3R_51()) return true;
        return false;
    }

    private boolean jj_3R_227() {
        if (jj_3R_51()) return true;
        return false;
    }

    private boolean jj_3R_288() {
        if (jj_3R_281()) return true;
        return false;
    }

    private boolean jj_3R_268() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_288()) {
            jj_scanpos = xsp;
            if (jj_3R_289()) {
                jj_scanpos = xsp;
                if (jj_3R_290()) return true;
            }
        }
        return false;
    }

    private boolean jj_3R_148() {
        if (jj_scan_token(NE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_235()) {
            jj_scanpos = xsp;
            if (jj_3R_236()) return true;
        }
        return false;
    }

    private boolean jj_3R_225() {
        if (jj_3R_51()) return true;
        return false;
    }

    private boolean jj_3R_147() {
        if (jj_scan_token(LE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_233()) {
            jj_scanpos = xsp;
            if (jj_3R_234()) return true;
        }
        return false;
    }

    private boolean jj_3R_146() {
        if (jj_scan_token(LT)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_231()) {
            jj_scanpos = xsp;
            if (jj_3R_232()) return true;
        }
        return false;
    }

    private boolean jj_3R_145() {
        if (jj_scan_token(GE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_229()) {
            jj_scanpos = xsp;
            if (jj_3R_230()) return true;
        }
        return false;
    }

    private boolean jj_3R_144() {
        if (jj_scan_token(GT)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_227()) {
            jj_scanpos = xsp;
            if (jj_3R_228()) return true;
        }
        return false;
    }

    private boolean jj_3R_199() {
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_143() {
        if (jj_scan_token(EQ)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_225()) {
            jj_scanpos = xsp;
            if (jj_3R_226()) return true;
        }
        return false;
    }

    private boolean jj_3R_197() {
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_57() {
        if (jj_3R_51()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_143()) {
            jj_scanpos = xsp;
            if (jj_3R_144()) {
                jj_scanpos = xsp;
                if (jj_3R_145()) {
                    jj_scanpos = xsp;
                    if (jj_3R_146()) {
                        jj_scanpos = xsp;
                        if (jj_3R_147()) {
                            jj_scanpos = xsp;
                            if (jj_3R_148()) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3R_195() {
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_224() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3_50() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_193() {
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_191() {
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_222() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3_49() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_130() {
        if (jj_scan_token(NE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_199()) {
            jj_scanpos = xsp;
            if (jj_3R_200()) return true;
        }
        return false;
    }

    private boolean jj_3R_189() {
        if (jj_3R_24()) return true;
        return false;
    }

    private boolean jj_3R_218() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_129() {
        if (jj_scan_token(LE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_197()) {
            jj_scanpos = xsp;
            if (jj_3R_198()) return true;
        }
        return false;
    }

    private boolean jj_3R_128() {
        if (jj_scan_token(LT)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_195()) {
            jj_scanpos = xsp;
            if (jj_3R_196()) return true;
        }
        return false;
    }

    private boolean jj_3R_212() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_127() {
        if (jj_scan_token(GE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_193()) {
            jj_scanpos = xsp;
            if (jj_3R_194()) return true;
        }
        return false;
    }

    private boolean jj_3R_210() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_216() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_126() {
        if (jj_scan_token(GT)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_191()) {
            jj_scanpos = xsp;
            if (jj_3R_192()) return true;
        }
        return false;
    }

    private boolean jj_3R_208() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_206() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_241() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_125() {
        if (jj_scan_token(EQ)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_189()) {
            jj_scanpos = xsp;
            if (jj_3R_190()) return true;
        }
        return false;
    }

    private boolean jj_3R_53() {
        if (jj_3R_24()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_125()) {
            jj_scanpos = xsp;
            if (jj_3R_126()) {
                jj_scanpos = xsp;
                if (jj_3R_127()) {
                    jj_scanpos = xsp;
                    if (jj_3R_128()) {
                        jj_scanpos = xsp;
                        if (jj_3R_129()) {
                            jj_scanpos = xsp;
                            if (jj_3R_130()) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3R_204() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_239() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_202() {
        if (jj_3R_59()) return true;
        return false;
    }

    private boolean jj_3R_151() {
        if (jj_scan_token(NE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_241()) {
            jj_scanpos = xsp;
            if (jj_3R_242()) return true;
        }
        return false;
    }

    private boolean jj_3R_223() {
        if (jj_3R_140()) return true;
        return false;
    }

    private boolean jj_3R_150() {
        if (jj_scan_token(EQ)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_239()) {
            jj_scanpos = xsp;
            if (jj_3R_240()) return true;
        }
        return false;
    }

    private boolean jj_3R_58() {
        if (jj_3R_149()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_150()) {
            jj_scanpos = xsp;
            if (jj_3R_151()) return true;
        }
        return false;
    }

    private boolean jj_3R_221() {
        if (jj_3R_140()) return true;
        return false;
    }

    private boolean jj_3R_142() {
        if (jj_scan_token(NE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_223()) {
            jj_scanpos = xsp;
            if (jj_3R_224()) return true;
        }
        return false;
    }

    private boolean jj_3R_217() {
        if (jj_3R_137()) return true;
        return false;
    }

    private boolean jj_3R_211() {
        if (jj_3R_49()) return true;
        return false;
    }

    private boolean jj_3R_141() {
        if (jj_scan_token(EQ)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_221()) {
            jj_scanpos = xsp;
            if (jj_3R_222()) return true;
        }
        return false;
    }

    private boolean jj_3R_209() {
        if (jj_3R_49()) return true;
        return false;
    }

    private boolean jj_3R_56() {
        if (jj_3R_140()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_141()) {
            jj_scanpos = xsp;
            if (jj_3R_142()) return true;
        }
        return false;
    }

    private boolean jj_3R_207() {
        if (jj_3R_49()) return true;
        return false;
    }

    private boolean jj_3R_215() {
        if (jj_3R_137()) return true;
        return false;
    }

    private boolean jj_3R_205() {
        if (jj_3R_49()) return true;
        return false;
    }

    private boolean jj_3R_203() {
        if (jj_3R_49()) return true;
        return false;
    }

    private boolean jj_3R_139() {
        if (jj_scan_token(NE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_217()) {
            jj_scanpos = xsp;
            if (jj_3R_218()) return true;
        }
        return false;
    }

    private boolean jj_3R_136() {
        if (jj_scan_token(LE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_211()) {
            jj_scanpos = xsp;
            if (jj_3R_212()) return true;
        }
        return false;
    }

    private boolean jj_3R_201() {
        if (jj_3R_49()) return true;
        return false;
    }

    private boolean jj_3R_135() {
        if (jj_scan_token(LT)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_209()) {
            jj_scanpos = xsp;
            if (jj_3R_210()) return true;
        }
        return false;
    }

    private boolean jj_3R_134() {
        if (jj_scan_token(GE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_207()) {
            jj_scanpos = xsp;
            if (jj_3R_208()) return true;
        }
        return false;
    }

    private boolean jj_3R_138() {
        if (jj_scan_token(EQ)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_215()) {
            jj_scanpos = xsp;
            if (jj_3R_216()) return true;
        }
        return false;
    }

    private boolean jj_3R_55() {
        if (jj_3R_137()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_138()) {
            jj_scanpos = xsp;
            if (jj_3R_139()) return true;
        }
        return false;
    }

    private boolean jj_3R_133() {
        if (jj_scan_token(GT)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_205()) {
            jj_scanpos = xsp;
            if (jj_3R_206()) return true;
        }
        return false;
    }

    private boolean jj_3R_132() {
        if (jj_scan_token(NE)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_203()) {
            jj_scanpos = xsp;
            if (jj_3R_204()) return true;
        }
        return false;
    }

    private boolean jj_3R_131() {
        if (jj_scan_token(EQ)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_201()) {
            jj_scanpos = xsp;
            if (jj_3R_202()) return true;
        }
        return false;
    }

    private boolean jj_3_48() {
        if (jj_3R_58()) return true;
        return false;
    }

    private boolean jj_3_47() {
        if (jj_3R_57()) return true;
        return false;
    }

    private boolean jj_3_46() {
        if (jj_3R_56()) return true;
        return false;
    }

    private boolean jj_3_45() {
        if (jj_3R_55()) return true;
        return false;
    }

    private boolean jj_3R_154() {
        if (jj_3R_245()) return true;
        return false;
    }

    private boolean jj_3R_54() {
        if (jj_3R_49()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_131()) {
            jj_scanpos = xsp;
            if (jj_3R_132()) {
                jj_scanpos = xsp;
                if (jj_3R_133()) {
                    jj_scanpos = xsp;
                    if (jj_3R_134()) {
                        jj_scanpos = xsp;
                        if (jj_3R_135()) {
                            jj_scanpos = xsp;
                            if (jj_3R_136()) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3_44() {
        if (jj_3R_54()) return true;
        return false;
    }

    private boolean jj_3_43() {
        if (jj_3R_53()) return true;
        return false;
    }

    private boolean jj_3R_119() {
        if (jj_3R_176()) return true;
        return false;
    }

    private boolean jj_3R_107() {
        if (jj_3R_58()) return true;
        return false;
    }

    private boolean jj_3R_106() {
        if (jj_3R_57()) return true;
        return false;
    }

    private boolean jj_3R_105() {
        if (jj_3R_56()) return true;
        return false;
    }

    private boolean jj_3R_104() {
        if (jj_3R_55()) return true;
        return false;
    }

    private boolean jj_3R_103() {
        if (jj_3R_54()) return true;
        return false;
    }

    private boolean jj_3R_41() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_102()) {
            jj_scanpos = xsp;
            if (jj_3R_103()) {
                jj_scanpos = xsp;
                if (jj_3R_104()) {
                    jj_scanpos = xsp;
                    if (jj_3R_105()) {
                        jj_scanpos = xsp;
                        if (jj_3R_106()) {
                            jj_scanpos = xsp;
                            if (jj_3R_107()) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3R_102() {
        if (jj_3R_53()) return true;
        return false;
    }

    private boolean jj_3R_245() {
        if (jj_scan_token(ALL)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_60()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_153() {
        if (jj_3R_244()) return true;
        return false;
    }

    private boolean jj_3R_118() {
        if (jj_3R_62()) return true;
        return false;
    }

    private boolean jj_3R_244() {
        if (jj_scan_token(SOME)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_60()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_243() {
        if (jj_scan_token(ANY)) return true;
        if (jj_scan_token(87)) return true;
        if (jj_3R_60()) return true;
        if (jj_scan_token(88)) return true;
        return false;
    }

    private boolean jj_3R_112() {
        if (jj_3R_60()) return true;
        return false;
    }

    /**
     * Generated Token Manager.
     */
    public MQLTokenManager token_source;
    JavaCharStream jj_input_stream;
    /**
     * Current token.
     */
    public Token token;
    /**
     * Next token.
     */
    public Token jj_nt;
    private int jj_ntk;
    private Token jj_scanpos, jj_lastpos;
    private int jj_la;
    private int jj_gen;
    final private int[] jj_la1 = new int[129];
    static private int[] jj_la1_0;
    static private int[] jj_la1_1;
    static private int[] jj_la1_2;

    static {
        jj_la1_init_0();
        jj_la1_init_1();
        jj_la1_init_2();
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{0x0, 0x0, 0x0, 0x0, 0x2000000, 0x10000000, 0x8000000, 0x0, 0x0, 0x20, 0x0, 0x0, 0x20, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x40, 0x20, 0x0, 0x0, 0x0, 0x20000, 0x0, 0x20, 0x0, 0x20000, 0x20, 0x0, 0x40, 0x20, 0x0, 0x0, 0x0, 0x8000, 0x0, 0xe7fe6000, 0x0, 0x0, 0x0, 0x0, 0x0, 0x20, 0x6000, 0x6000, 0x0, 0x0, 0x0, 0x0, 0xe7fe0000, 0x0, 0x80000000, 0x0, 0x2c0000, 0x2c0000, 0x2c0000, 0x2c0000, 0x2c0000, 0x2c0000, 0x2c0000, 0x1f80, 0x2c0000, 0x2c0000, 0x180, 0x2c0000, 0x2c0000, 0x180, 0xe7fe0000, 0xe7fe0000, 0x180, 0x2c6000, 0x2c6000, 0x2c6000, 0x2c6000, 0x2c6000, 0x2c6000, 0x1f80, 0x2c0000, 0x2c0000, 0x2c0000, 0x2c0000, 0x2c0000, 0x2c0000, 0x1f80, 0x0, 0x0, 0x6000, 0x6000, 0x18000, 0x18000, 0x6000, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0xe7fe0000, 0xe7fe0000, 0x0, 0x0, 0x0, 0x0, 0x0, 0x20, 0x0, 0x20, 0x0, 0x1800000, 0x1800000, 0x40, 0xe7fe0000, 0x6000, 0x6000, 0x6000, 0x6000, 0x6000, 0x0, 0x0, 0x0,};
    }

    private static void jj_la1_init_1() {
        jj_la1_1 = new int[]{0x20000000, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x8, 0x0, 0x40000000, 0x1ff1f1f0, 0x40000000, 0x0, 0x1f0, 0x1ff1f000, 0x0, 0x1f0, 0x0, 0x0, 0x1f0, 0x1f0, 0x0, 0x0, 0x1ff1f000, 0xffffffff, 0x0, 0x800, 0x800, 0x800, 0x800, 0x0, 0x20000000, 0x0, 0x800, 0x0, 0x800, 0x800, 0xffffffff, 0x800, 0x0, 0x800, 0x0, 0x1f000, 0x1f000, 0x1f000, 0x1f000, 0x1f000, 0x1f000, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0xffffffff, 0xffffffff, 0x0, 0x23f001f0, 0x23f001f0, 0x23f001f0, 0x23f001f0, 0x23f001f0, 0x23f001f0, 0x0, 0x1c000000, 0x1c000000, 0x1c000000, 0x1c000000, 0x1c000000, 0x1c000000, 0x0, 0x1ff1f000, 0x3f00000, 0x0, 0x0, 0x0, 0x0, 0x0, 0x23f001f0, 0x1f000, 0x1f000, 0x0, 0x1f000, 0x1c000000, 0x1c000000, 0x0, 0x0, 0x0, 0x0, 0xffffffff, 0xffffffff, 0x1f000, 0xe0000, 0x0, 0xc0000, 0x3f00000, 0x0, 0x1c000000, 0x0, 0x1f0, 0x0, 0x0, 0x0, 0xffffffff, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x2,};
    }

    private static void jj_la1_init_2() {
        jj_la1_2 = new int[]{0x3, 0x4, 0x8, 0x10, 0x0, 0x0, 0x0, 0x4, 0x4, 0x0, 0x340, 0x20, 0x0, 0x100, 0x20, 0x20, 0x80, 0x20, 0x340, 0x80, 0x100, 0x0, 0x0, 0x0, 0x6100000, 0x0, 0x102000, 0x0, 0x0, 0x0, 0x102000, 0x0, 0x100000, 0x0, 0x0, 0x100000, 0x0, 0x100000, 0x0, 0x100000, 0x69affff, 0x800000, 0x0, 0x0, 0x0, 0x0, 0x0, 0x60ac000, 0x60ac000, 0x0, 0x6100000, 0x0, 0x0, 0x6103fff, 0x0, 0x0, 0x0, 0x0, 0x6920000, 0x6920000, 0x6920000, 0x6920000, 0x6920000, 0x6920000, 0x0, 0x6980000, 0x6980000, 0x0, 0x6900000, 0x6900000, 0x0, 0x6103fff, 0x6103fff, 0x0, 0x690c000, 0x690c000, 0x690c000, 0x690c000, 0x690c000, 0x690c000, 0x0, 0x6900000, 0x6900000, 0x6900000, 0x6900000, 0x6900000, 0x6900000, 0x0, 0x0, 0x900000, 0x0, 0x0, 0x0, 0x0, 0x610c000, 0x0, 0x900000, 0x6920000, 0x120000, 0x0, 0x6900000, 0x6100000, 0x900000, 0x6980000, 0x6080000, 0x6900000, 0x103fff, 0x6103fff, 0x0, 0x0, 0x20000, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x103fff, 0x4000, 0x0, 0x0, 0x0, 0x0, 0x6000000, 0x6020000, 0x0,};
    }

    final private JJCalls[] jj_2_rtns = new JJCalls[62];
    private boolean jj_rescan = false;
    private int jj_gc = 0;

    /**
     * Constructor with InputStream.
     */
    public MQL(java.io.InputStream stream) {
        this(stream, null);
    }

    /**
     * Constructor with InputStream and supplied encoding
     */
    public MQL(java.io.InputStream stream, String encoding) {
        try {
            jj_input_stream = new JavaCharStream(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source = new MQLTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 129; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.InputStream stream) {
        ReInit(stream, null);
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.InputStream stream, String encoding) {
        try {
            jj_input_stream.ReInit(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jjtree.reset();
        jj_gen = 0;
        for (int i = 0; i < 129; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /**
     * Constructor.
     */
    public MQL(java.io.Reader stream) {
        jj_input_stream = new JavaCharStream(stream, 1, 1);
        token_source = new MQLTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 129; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.Reader stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jjtree.reset();
        jj_gen = 0;
        for (int i = 0; i < 129; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /**
     * Constructor with generated Token Manager.
     */
    public MQL(MQLTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 129; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /**
     * Reinitialise.
     */
    public void ReInit(MQLTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jjtree.reset();
        jj_gen = 0;
        for (int i = 0; i < 129; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    private Token jj_consume_token(int kind) throws ParseException {
        Token oldToken;
        if ((oldToken = token).next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        if (token.kind == kind) {
            jj_gen++;
            if (++jj_gc > 100) {
                jj_gc = 0;
                for (int i = 0; i < jj_2_rtns.length; i++) {
                    JJCalls c = jj_2_rtns[i];
                    while (c != null) {
                        if (c.gen < jj_gen) c.first = null;
                        c = c.next;
                    }
                }
            }
            return token;
        }
        token = oldToken;
        jj_kind = kind;
        throw generateParseException();
    }

    static private final class LookaheadSuccess extends java.lang.Error {
    }

    final private LookaheadSuccess jj_ls = new LookaheadSuccess();

    private boolean jj_scan_token(int kind) {
        if (jj_scanpos == jj_lastpos) {
            jj_la--;
            if (jj_scanpos.next == null) {
                jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
            } else {
                jj_lastpos = jj_scanpos = jj_scanpos.next;
            }
        } else {
            jj_scanpos = jj_scanpos.next;
        }
        if (jj_rescan) {
            int i = 0;
            Token tok = token;
            while (tok != null && tok != jj_scanpos) {
                i++;
                tok = tok.next;
            }
            if (tok != null) jj_add_error_token(kind, i);
        }
        if (jj_scanpos.kind != kind) return true;
        if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
        return false;
    }


    /**
     * Get the next Token.
     */
    final public Token getNextToken() {
        if (token.next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

    /**
     * Get the specific Token.
     */
    final public Token getToken(int index) {
        Token t = token;
        for (int i = 0; i < index; i++) {
            if (t.next != null) t = t.next;
            else t = t.next = token_source.getNextToken();
        }
        return t;
    }

    private int jj_ntk() {
        if ((jj_nt = token.next) == null)
            return (jj_ntk = (token.next = token_source.getNextToken()).kind);
        else
            return (jj_ntk = jj_nt.kind);
    }

    private java.util.List jj_expentries = new java.util.ArrayList();
    private int[] jj_expentry;
    private int jj_kind = -1;
    private int[] jj_lasttokens = new int[100];
    private int jj_endpos;

    private void jj_add_error_token(int kind, int pos) {
        if (pos >= 100) return;
        if (pos == jj_endpos + 1) {
            jj_lasttokens[jj_endpos++] = kind;
        } else if (jj_endpos != 0) {
            jj_expentry = new int[jj_endpos];
            for (int i = 0; i < jj_endpos; i++) {
                jj_expentry[i] = jj_lasttokens[i];
            }
            jj_entries_loop:
            for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
                int[] oldentry = (int[]) (it.next());
                if (oldentry.length == jj_expentry.length) {
                    for (int i = 0; i < jj_expentry.length; i++) {
                        if (oldentry[i] != jj_expentry[i]) {
                            continue jj_entries_loop;
                        }
                    }
                    jj_expentries.add(jj_expentry);
                    break jj_entries_loop;
                }
            }
            if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
        }
    }

    /**
     * Generate ParseException.
     */
    public ParseException generateParseException() {
        jj_expentries.clear();
        boolean[] la1tokens = new boolean[91];
        if (jj_kind >= 0) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for (int i = 0; i < 129; i++) {
            if (jj_la1[i] == jj_gen) {
                for (int j = 0; j < 32; j++) {
                    if ((jj_la1_0[i] & (1 << j)) != 0) {
                        la1tokens[j] = true;
                    }
                    if ((jj_la1_1[i] & (1 << j)) != 0) {
                        la1tokens[32 + j] = true;
                    }
                    if ((jj_la1_2[i] & (1 << j)) != 0) {
                        la1tokens[64 + j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 91; i++) {
            if (la1tokens[i]) {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.add(jj_expentry);
            }
        }
        jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] exptokseq = new int[jj_expentries.size()][];
        for (int i = 0; i < jj_expentries.size(); i++) {
            exptokseq[i] = (int[]) jj_expentries.get(i);
        }
        return new ParseException(token, exptokseq, tokenImage);
    }

    /**
     * Enable tracing.
     */
    final public void enable_tracing() {
    }

    /**
     * Disable tracing.
     */
    final public void disable_tracing() {
    }

    private void jj_rescan_token() {
        jj_rescan = true;
        for (int i = 0; i < 62; i++) {
            try {
                JJCalls p = jj_2_rtns[i];
                do {
                    if (p.gen > jj_gen) {
                        jj_la = p.arg;
                        jj_lastpos = jj_scanpos = p.first;
                        switch (i) {
                            case 0:
                                jj_3_1();
                                break;
                            case 1:
                                jj_3_2();
                                break;
                            case 2:
                                jj_3_3();
                                break;
                            case 3:
                                jj_3_4();
                                break;
                            case 4:
                                jj_3_5();
                                break;
                            case 5:
                                jj_3_6();
                                break;
                            case 6:
                                jj_3_7();
                                break;
                            case 7:
                                jj_3_8();
                                break;
                            case 8:
                                jj_3_9();
                                break;
                            case 9:
                                jj_3_10();
                                break;
                            case 10:
                                jj_3_11();
                                break;
                            case 11:
                                jj_3_12();
                                break;
                            case 12:
                                jj_3_13();
                                break;
                            case 13:
                                jj_3_14();
                                break;
                            case 14:
                                jj_3_15();
                                break;
                            case 15:
                                jj_3_16();
                                break;
                            case 16:
                                jj_3_17();
                                break;
                            case 17:
                                jj_3_18();
                                break;
                            case 18:
                                jj_3_19();
                                break;
                            case 19:
                                jj_3_20();
                                break;
                            case 20:
                                jj_3_21();
                                break;
                            case 21:
                                jj_3_22();
                                break;
                            case 22:
                                jj_3_23();
                                break;
                            case 23:
                                jj_3_24();
                                break;
                            case 24:
                                jj_3_25();
                                break;
                            case 25:
                                jj_3_26();
                                break;
                            case 26:
                                jj_3_27();
                                break;
                            case 27:
                                jj_3_28();
                                break;
                            case 28:
                                jj_3_29();
                                break;
                            case 29:
                                jj_3_30();
                                break;
                            case 30:
                                jj_3_31();
                                break;
                            case 31:
                                jj_3_32();
                                break;
                            case 32:
                                jj_3_33();
                                break;
                            case 33:
                                jj_3_34();
                                break;
                            case 34:
                                jj_3_35();
                                break;
                            case 35:
                                jj_3_36();
                                break;
                            case 36:
                                jj_3_37();
                                break;
                            case 37:
                                jj_3_38();
                                break;
                            case 38:
                                jj_3_39();
                                break;
                            case 39:
                                jj_3_40();
                                break;
                            case 40:
                                jj_3_41();
                                break;
                            case 41:
                                jj_3_42();
                                break;
                            case 42:
                                jj_3_43();
                                break;
                            case 43:
                                jj_3_44();
                                break;
                            case 44:
                                jj_3_45();
                                break;
                            case 45:
                                jj_3_46();
                                break;
                            case 46:
                                jj_3_47();
                                break;
                            case 47:
                                jj_3_48();
                                break;
                            case 48:
                                jj_3_49();
                                break;
                            case 49:
                                jj_3_50();
                                break;
                            case 50:
                                jj_3_51();
                                break;
                            case 51:
                                jj_3_52();
                                break;
                            case 52:
                                jj_3_53();
                                break;
                            case 53:
                                jj_3_54();
                                break;
                            case 54:
                                jj_3_55();
                                break;
                            case 55:
                                jj_3_56();
                                break;
                            case 56:
                                jj_3_57();
                                break;
                            case 57:
                                jj_3_58();
                                break;
                            case 58:
                                jj_3_59();
                                break;
                            case 59:
                                jj_3_60();
                                break;
                            case 60:
                                jj_3_61();
                                break;
                            case 61:
                                jj_3_62();
                                break;
                        }
                    }
                    p = p.next;
                } while (p != null);
            } catch (LookaheadSuccess ls) {
            }
        }
        jj_rescan = false;
    }

    private void jj_save(int index, int xla) {
        JJCalls p = jj_2_rtns[index];
        while (p.gen > jj_gen) {
            if (p.next == null) {
                p = p.next = new JJCalls();
                break;
            }
            p = p.next;
        }
        p.gen = jj_gen + xla - jj_la;
        p.first = token;
        p.arg = xla;
    }

    static final class JJCalls {
        int gen;
        Token first;
        int arg;
        JJCalls next;
    }

}
