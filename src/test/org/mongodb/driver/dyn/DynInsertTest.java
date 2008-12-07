/**
*      Copyright (C) 2008 Geir Magnusson Jr
*
*    Licensed under the Apache License, Version 2.0 (the "License");
*    you may not use this file except in compliance with the License.
*    You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*    Unless required by applicable law or agreed to in writing, software
*    distributed under the License is distributed on an "AS IS" BASIS,
*    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*    See the License for the specific language governing permissions and
*    limitations under the License.
*/

package org.mongodb.driver.dyn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.mongodb.driver.MongoDBException;

import java.util.Map;
import java.util.HashMap;

public class DynInsertTest extends TestBase {

    DB _db;

    @BeforeClass
    public void setUp() throws Exception{
        _db = new Mongo().getDB("org_mongo_driver_dyn_InsertTest");
        _db.getCollection("test").clear();
        assert(_db.getCollection("test").getCount() == 0);
    }

    @Test
    void testDynInsert() throws MongoDBException {
        Collection testColl = _db.getCollection("test");
        testColl.clear();

        Map doc = newMap("a", 1);
        testColl.insert(doc);
        assert(testColl.getCount() == 1);

        doc.clear();
        doc.put("a", 2);
        testColl.insert(doc);

        assert(testColl.getCount() == 2);

        Map ms = newMap("a", 2);
        assert(testColl.getCount(ms) == 1);
    }

    @Test
    void testDynInsertMulti() throws MongoDBException {
        Collection testColl = _db.getCollection("multi");

        testColl.clear();

        assert(testColl.getCount() == 0);


        Map[] objs = new Map[10];

        for (int i = 0; i < 10; i++) {
            objs[i] = newMap("a", i);
        }

        testColl.insert(objs);
        assert(testColl.getCount() == 10);

        Map ms = newMap("a", 2);

        assert(testColl.getCount(ms) == 1);
    }

    @Test
    void testDynInsertClear() throws MongoDBException {
        Collection testColl = _db.getCollection("clear");

        testColl.clear();

        assert(testColl.getCount() == 0);

        Map[] objs = new Map[10];

        for (int i = 0; i < 10; i++) {
            objs[i] = newMap("a", i);
        }

        testColl.insert(objs);
        assert(testColl.getCount() == 10);

        testColl.clear();

        assert(testColl.getCount() == 0);
    }

    @Test
    void testDynCount() throws MongoDBException {
        _db.dropCollection("clear");

        Collection testColl = _db.getCollection("clear");

        assert(testColl.getCount() == 0);

        Map[] objs = new Map[10];

        for (int i = 0; i < 10; i++) {
            objs[i] = newMap("a", i);
        }

        testColl.insert(objs);
        assert(testColl.getCount() == 10);

        for (int i = 0; i < 10; i++) {
            objs[i] = newMap("a", i);
        }

        testColl.insert(objs);
        assert(testColl.getCount() == 20);

        Map ms = newMap("a", 2);

        assert(testColl.getCount(ms) == 2);
    }

    @Test
    void testDynMapInsert() throws MongoDBException {
        Collection testColl = _db.getCollection("test");

        testColl.clear();

        Map doc = new HashMap();

        doc.put("a", 1);
        testColl.insert(doc);
        assert(testColl.getCount() == 1);

        doc.clear();
        doc.put("a", 2);
        testColl.insert(doc);

        assert(testColl.getCount() == 2);

        Map ms = newMap("a", 2);
        assert(testColl.getCount(ms) == 1);
    }

}