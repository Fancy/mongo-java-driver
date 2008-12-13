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

package org.mongodb.driver.impl.msg;

import org.mongodb.driver.MongoDBException;

import java.io.InputStream;
import java.io.IOException;

/**
 *  Message class representing a "get more" message, a message used by a cursor
 *  to fetch another batch of data from a query
 */
public class DBGetMoreMessage extends DBMessage {

    protected final long _cursor;
    protected final String _dbName;
    protected final String _collection;
    
    public DBGetMoreMessage(String dbName, String collection, long cursor) throws MongoDBException
    {
        super(MessageType.OP_GET_MORE);
        _dbName = dbName;
        _collection = collection;
        _cursor = cursor;
        init();
    }

    /**
     *   Writes the query out to the underlying message byte buffer
     *
     * @throws MongoDBException if something wrong w/ mongoDoc
     */
    protected void init() throws MongoDBException
    {
        writeInt(0); // reserved for future use - mongo might call this "options" in the comments.  or it may not.
        writeString(_dbName + "." + _collection);
        writeInt(0); // n toreturn - leave it up to db for now
        writeLong(_cursor);
    }

    /**
     *  Read this kind of message object out of an input stream
     *
     * @param is stream to read from
     */
    public void read(InputStream is ) throws IOException {
    }    
}
