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

package org.mongodb.driver.ts;

import org.mongodb.driver.MongoDBException;

import java.util.Map;

/**
 * Typsafe selector
 */
public class MongoSelector extends Doc {

    public static final String LTE = "$lte";
    public static final String LE = "$le";
    public static final String GTE = "$gte";
    public static final String GE = "$ge";

    
    public MongoSelector() {
        super();
    }

    public Object put(String key, Object val) {

        try {
            checkKey(key);
        }
        catch(MongoDBException e) {
            throw new RuntimeException("Error - invalid key ", e);
        }

        return super.put(key, val);
    }

    public MongoSelector(Doc m) throws MongoDBException {
        super(m);
    }

    public MongoSelector(Map m) throws MongoDBException {
        super(m);
    }
    
    public MongoSelector(String s, Object o) throws MongoDBException {
        super(s, o);
    }

    protected void checkKey(String key) throws MongoDBException {

        if (key == null) {
            throw new MongoDBException("Error : key is null");
        }
    }

}
