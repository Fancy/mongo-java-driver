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
import org.mongodb.mql.QueryInfo;
import org.mongodb.mql.Node;

public class MQLABSTRACTSCHEMANAME extends SimpleNode {
  public MQLABSTRACTSCHEMANAME(int id) {
    super(id);
  }

  public MQLABSTRACTSCHEMANAME(MQL p, int id) {
    super(p, id);
  }

    public void render(QueryInfo qi) {
        updateQI(qi);
    }

    public void updateQI(QueryInfo qi) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (Node n : children) {

            if (count++ != 0) {
                sb.append(".");
            }

            sb.append(((SimpleNode) n).getFirstToken().image);
        }

        qi.setCollectioName(sb.toString());
    }

}
/* JavaCC - OriginalChecksum=4994a85b8c1ba69051b37242907f8b7e (do not edit this line) */
