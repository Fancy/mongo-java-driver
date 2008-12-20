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
package org.mongodb.mql.nodes;

import org.mongodb.mql.SimpleNode;
import org.mongodb.mql.MQL;

public class MQLSELECTCLAUSE extends SimpleNode {
  public MQLSELECTCLAUSE(int id) {
    super(id);
  }

  public MQLSELECTCLAUSE(MQL p, int id) {
    super(p, id);
  }

}
/* JavaCC - OriginalChecksum=fcec1bff589e001a5ee15715db04dbe0 (do not edit this line) */
